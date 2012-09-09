package fhdw.ipscrum.client.architecture.presenter;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.controller.ToastMessageController.DisplayDuration;
import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.events.eventbus.EventBus.Event;
import fhdw.ipscrum.client.architecture.events.eventbus.EventBus.Handler;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.architecture.widgets.Answer;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.userRights.Right;

/**
 * Base class for presenters.
 * 
 */
public abstract class Presenter {

	/**
	 * Event that is fired when the presenter is closed.
	 */
	public static class PresenterCloseEvent extends Event {
		/**
		 * The presenter that was closed.
		 */
		private final Presenter presenter;

		/**
		 * Creates a new instance of the event.
		 * 
		 * @param presenter
		 *            The presenter that was closed.
		 */
		public PresenterCloseEvent(final Presenter presenter) {
			super();
			this.presenter = presenter;
		}

		/**
		 * The presenter that was closed.
		 * 
		 * @return Presenter that was closed
		 */
		public Presenter getPresenter() {
			return this.presenter;
		}
	}

	/**
	 * Class that handles {@link PresenterCloseEvent}s.
	 */
	public abstract static class PresenterCloseHandler implements Handler<Presenter.PresenterCloseEvent> {

		@Override
		public void handle(final PresenterCloseEvent event) {
			this.handlePresenterClose(event);
		}

		/**
		 * Handles {@link PresenterCloseEvent}.
		 * 
		 * @param event
		 *            The event.
		 */
		public abstract void handlePresenterClose(PresenterCloseEvent event);

	}

	/**
	 * The current context.
	 */
	private ClientContext context;

	/**
	 * The close event.
	 */
	private final DefaultEvent closeEvent;

	/**
	 * The identifier of the presenter.
	 */
	private String identifier;

	/**
	 * Creates a new instance.
	 * 
	 * @param context
	 *            The current context.
	 */
	public Presenter(final ClientContext context) {
		super();
		this.context = context;
		this.closeEvent = new DefaultEvent();
	}

	/**
	 * Returns the name of the presenter.
	 * 
	 * @return The name of the presenter
	 */
	public abstract String getName();

	/**
	 * Returns the view object of the presenter.
	 * 
	 * @return the view of the presenter
	 */
	public IView getView() {
		final IView view = this.doGetView();
		view.registerHelpHandler(new DefaultEventHandler() {
			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				Presenter.this.getContext().getHelpController().showHelp(Presenter.this);
			}
		});

		return view;
	}

	/**
	 * Returns the view object of the presenter.
	 * 
	 * @return the view of the presenter
	 */
	public abstract IView doGetView();

	/**
	 * Updates the view of the presenter.
	 */
	public abstract void updateView();

	/**
	 * Tells the presenter that it is resumed after it was send to sleep. This method will be called by the
	 * {@link fhdw.ipscrum.client.architecture.controller.ApplicationController} when resuming a presenter.
	 */
	public void resume() {
		this.onResume();
	}

	/**
	 * Template for the resume method. Deriving presenter can do their own stuff here! Default implementation is to call
	 * {@link Presenter#updateView()}.
	 */
	protected void onResume() {
		this.updateView();
	}

	/**
	 * Closes the presenter. This will fire the close event, removes the view of the presenter from the GUI and removes
	 * the presenter from the current stack. TODO später wieder auf final setzen
	 */
	public void close() {
		this.close(new CloseCallback() {

			@Override
			public void closed() {
			}

			@Override
			public void closeAborted() {
			}
		});
	}

	/**
	 * Closes the presenter. This will fire the close event, removes the view of the presenter from the GUI and removes
	 * the presenter from the current stack.
	 * 
	 * @param callback
	 *            The callback that is called after asynchronous execution. If the close procedure was successful
	 *            {@link CloseCallback#closed()} is called, otherwise {@link CloseCallback#closeAborted()}.
	 */
	public final void close(final CloseCallback callback) {
		this.onClose(new CloseCallback() {

			@Override
			public void closed() {
				Presenter.this.closePresenter();
				Presenter.this.closeEvent.fire(this, new EventArgs());
				Presenter.this.getContext().getEventBus().publish(new PresenterCloseEvent(Presenter.this));
				callback.closed();
			}

			@Override
			public void closeAborted() {
				callback.closeAborted();
			}
		});
	}

	/**
	 * Callback that handles asynchronous execution of the close procedure.
	 */
	public interface CloseCallback {
		/**
		 * Will be called when the close procedure was successful.
		 */
		void closed();

		/**
		 * Will be called when the close procedure was aborted.
		 */
		void closeAborted();
	}

	/**
	 * Template method for doing own stuff onClose. The close procedure can be aborted by returning <code>false</code>.
	 * 
	 * @param callback
	 *            Callback that is called after execution, because the method call is ansychronous.
	 * 
	 * @return
	 * 
	 */
	protected void onClose(final CloseCallback callback) {
		callback.closed();
	}

	/**
	 * Closes the presenter.
	 */
	protected void closePresenter() {
		this.getView().close();
		this.context.getApplicationController().closePresenter(this);
	}

	/**
	 * Registers an external handler to the close event of the presenter. The close event will be raised after close was
	 * called.
	 * 
	 * @param handler
	 *            The handler that should be registered.
	 * @return {@link EventRegistration} object for the registration.
	 */
	public EventRegistration registerCloseHandler(final EventHandler<EventArgs> handler) {
		return this.closeEvent.add(handler);
	}

	/**
	 * Returns the current context of the presenter.
	 * 
	 * @return The current context.
	 */
	public ClientContext getContext() {
		return this.context;
	}

	/**
	 * Starts a new presenter. This will add the presenter to the current presenter stack and displays the view in the
	 * content panel.
	 * 
	 * @param presenter
	 *            The presenter that should be started.
	 */
	protected void startPresenter(final Presenter presenter) {
		this.context.getApplicationController().showPresenter(presenter);
	}

	/**
	 * Shows a notification with a default duration in the GUI.
	 * 
	 * @param message
	 *            Message to be displayed.
	 */
	protected void toastMessage(final String message) {
		this.context.getToastMessageController().toastMessage(message);
	}

	/**
	 * Shows a notification in the GUI.
	 * 
	 * @param message
	 *            Message to be displayed.
	 * @param milliseconds
	 *            Duration in milliseconds after that the message will disappear. Set to 0 for infinite display!
	 */
	protected void toastMessage(final String message, final int milliseconds) {
		this.context.getToastMessageController().toastMessage(message, milliseconds);
	}

	/**
	 * Shows a notification in the GUI.
	 * 
	 * @param message
	 *            Message to be displayed.
	 * @param milliseconds
	 *            Duration in milliseconds after that the message will disappear. Set to 0 for infinite display!
	 */
	protected void toastMessage(final String message, final DisplayDuration milliseconds) {
		this.context.getToastMessageController().toastMessage(message, milliseconds);
	}

	/**
	 * Shows a question to the user.
	 * 
	 * @param question
	 *            The question
	 * @param actions
	 *            Each action will get an own button as a possible answer to the question
	 */
	protected void showQuestion(final String question, final Answer... actions) {
		this.context.getQuestionController().askQuestion(question, actions);
	}

	/**
	 * Locks the view and shows an indicator for the loading process.
	 */
	protected void showLoadingIndicator() {
		this.context.getApplicationController().showLoadingIndicator();
	}

	/**
	 * Releases the view and hides the loading indicator.
	 */
	protected void hideLoadingIndicator() {
		this.context.getApplicationController().hideLoadingIndicator();
	}

	/**
	 * Sets the current context of the presenter.
	 * 
	 * @param context
	 *            The current context.
	 */
	public void setContext(final ClientContext context) {
		this.context = context;
	}

	/**
	 * Method will be called when the underlying model was updated.
	 */
	public abstract void onModelUpdate();

	/**
	 * <b>Do not call this method!</b> <br/>
	 * Sets the identifier of the presenter. The identifier is used for internal tasks.
	 * 
	 * @param identifier
	 *            the id
	 */
	public void setIdentifier(final String identifier) {
		this.identifier = identifier;
	}

	/**
	 * Returns the identifier of the presenter. The identifier is used for internal tasks.
	 * 
	 * @return The id
	 */
	public String getIdentifier() {
		return this.identifier;
	}

	/**
	 * Sets the visibility of view-elements. If the active role don´t contains the need right, the elements for change
	 * operations will be disabled
	 * 
	 * @param right
	 *            the needed right change operations
	 */
	public void setViewRightVisibility(final Right right) {
		this.getView().setRightVisibility(this.getContext().getActiveRole().getRights().contains(right));
	}

	/**
	 * Updates the reference to an model object.
	 * 
	 * @param object
	 *            the object from an old model
	 * @param <T>
	 *            type of the object
	 * @return object with same id from the actual model
	 */
	protected <T extends IdentifiableObject> T updateObject(final T object) {
		try {
			return this.getContext().getModel().getObject(object);
		} catch (final NoObjectFindException e) {
			this.toastMessage("Das dargestellte Objekt existiert nicht mehr!");
			this.close();
			return null;
		}
	}

}
