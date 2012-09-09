package fhdw.ipscrum.client.architecture.controller;

import java.util.ArrayList;
import java.util.Stack;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.RootPanel;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.ClientContext.ModelUpdateEvent;
import fhdw.ipscrum.client.architecture.ClientContext.ModelUpdateHandler;
import fhdw.ipscrum.client.architecture.controller.SessionController.LoginEvent;
import fhdw.ipscrum.client.architecture.controller.SessionController.LoginEventHandler;
import fhdw.ipscrum.client.architecture.controller.SessionController.LogoutEvent;
import fhdw.ipscrum.client.architecture.controller.SessionController.LogoutEventHandler;
import fhdw.ipscrum.client.architecture.events.eventbus.EventBus.Event;
import fhdw.ipscrum.client.architecture.events.eventbus.EventBus.Handler;
import fhdw.ipscrum.client.architecture.events.eventbus.EventBus.SingleObjectEvent;
import fhdw.ipscrum.client.architecture.presenter.Presenter;
import fhdw.ipscrum.client.architecture.presenter.Presenter.CloseCallback;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.architecture.widgets.LoadingIndicator;
import fhdw.ipscrum.client.utils.SimpleCallback;
import fhdw.ipscrum.shared.infrastructure.UUID;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.session.User;

/**
 * Controls the application workflow and the lifetime of all active {@link Presenter} objects.
 * 
 * @author Niklas
 * 
 */
public class ApplicationController {

	/**
	 * The duration the resize animation lasts.
	 */
	private static final int RESIZE_ANIMATION_LENGTH = 300;
	/**
	 * Base of the generated presenter id.
	 */
	private static final int ID_BASE = 16;
	/**
	 * Length of the generated presenter id.
	 */
	private static final int ID_LENGTH = 11;

	/**
	 * Event that is fired when the showed presenter in the content panel is changed.
	 */
	public static class PresenterChangedEvent extends SingleObjectEvent<Presenter> {

		/**
		 * Creates a new instance of the event with the specified presenter as argument.
		 * 
		 * @param object
		 *            the Presenter that is shown in the content panel.
		 */
		public PresenterChangedEvent(final Presenter object) {
			super(object);
		}
	}

	/**
	 * Class that handles {@link PresenterChangedEvent}s.
	 */
	public abstract static class PresenterChangedHandler
			implements Handler<ApplicationController.PresenterChangedEvent> {

		@Override
		public void handle(final PresenterChangedEvent event) {
			this.handlePresenterChanged(event);
		}

		/**
		 * @see PresenterChangedHandler#handle(PresenterChangedEvent)
		 * 
		 * @param event
		 *            The event that has been published.
		 */
		public abstract void handlePresenterChanged(PresenterChangedEvent event);
	}

	/**
	 * Event that is fired when the application was started.
	 */
	public static class ApplicationStartedEvent extends Event {
	}

	/**
	 * Class that handles {@link ApplicationStartedEvent}s.
	 */
	public interface ApplicationStartedHandler extends Handler<ApplicationController.ApplicationStartedEvent> {

	}

	/**
	 * The current context.
	 */
	private final ClientContext context;
	/**
	 * The stack of currently loaded presenters.
	 */
	private final Stack<Presenter> presenterStack;
	/**
	 * The first presenter that is loaded after successful login.
	 */
	private final Presenter startPresenter;

	/**
	 * The widget that locks the GUI and indicates that the client is loading data.
	 */
	private LoadingIndicator loadingDialog;

	/**
	 * Handles the login event.
	 */
	private final LoginEventHandler loginHandler = new LoginEventHandler() {

		@Override
		public void handleLogin(final LoginEvent event) {
			ApplicationController.this.start(event.getObject().getUser());
		}
	};
	/**
	 * Handles the logout event.
	 */
	private final LogoutEventHandler logoutHandler = new LogoutEventHandler() {

		@Override
		public void handleLogout(final LogoutEvent event) {
			ApplicationController.this.doLogout();
		}
	};
	/**
	 * Handles the model changend event.
	 */
	private final ModelUpdateHandler modelChangedHandler = new ModelUpdateHandler() {

		@Override
		public void handleModelUpdated(final ModelUpdateEvent event) {
			ApplicationController.this.updatePresenters();
		}
	};

	/**
	 * Creates a new controller.
	 * 
	 * @param context
	 *            the context of the application.
	 * @param startPresenter
	 *            the first presenter that should be shown after a successful login
	 * @param sessionController
	 */
	public ApplicationController(final ClientContext context, final Presenter startPresenter) {
		this.context = context;
		this.startPresenter = startPresenter;
		this.presenterStack = new Stack<Presenter>();

		context.getEventBus().registerHandler(LoginEvent.class, this.loginHandler);

		context.getEventBus().registerHandler(LogoutEvent.class, this.logoutHandler);

		context.getEventBus().registerHandler(ModelUpdateEvent.class, this.modelChangedHandler);
	}

	/**
	 * Does the logout process.
	 */
	private void doLogout() {
		this.newStack(new SimpleCallback() {

			@Override
			public void callback() {
				ApplicationController.this.context.getSessionController().login();
			}
		});

	}

	/**
	 * Flushes the stack of presenters in the content area.
	 * 
	 * @param callback
	 *            Callback that is called after successful execution.
	 * 
	 */
	public void newStack(final SimpleCallback callback) {
		this.closeStack(new SimpleCallback() {

			@Override
			public void callback() {
				ApplicationController.this.getContentPanel().clear();
				callback.callback();
			}
		});

	}

	/**
	 * Closes all presenters in the current stack.
	 * 
	 * @param simpleCallback
	 *            Callback that is called after successful execution.
	 */
	private void closeStack(final SimpleCallback simpleCallback) {

		if (!this.presenterStack.isEmpty()) {
			this.presenterStack.peek().close(new CloseCallback() {

				@Override
				public void closed() {
					ApplicationController.this.closeStack(simpleCallback);
				}

				@Override
				public void closeAborted() {

				}
			});
		} else {
			simpleCallback.callback();
		}
	}

	/**
	 * Displays the presenter in the content area and adds him to the current stack.
	 * 
	 * @param presenter
	 *            The presenter that show be loaded.
	 */
	public void showPresenter(final Presenter presenter) {
		presenter.setIdentifier(UUID.uuid(ApplicationController.ID_LENGTH, ApplicationController.ID_BASE));
		ApplicationController.this.presenterStack.push(presenter);
		ApplicationController.this.displayPresenterView(presenter);
		presenter.updateView();

	}

	/**
	 * Closes the presenter and removes it from the current stack. Resumes the next presenter in the current stack.
	 * 
	 * @param presenter
	 *            The presenter that should be closed.
	 */
	public void closePresenter(final Presenter presenter) {
		if (!this.presenterStack.isEmpty() && this.presenterStack.peek().equals(presenter)) {
			this.presenterStack.pop();
			if (!this.presenterStack.isEmpty()) {
				final Presenter nextPresenter = this.presenterStack.peek();
				this.displayPresenterView(nextPresenter);
				nextPresenter.resume();
			} else {
				this.displayPresenterView(this.startPresenter);
			}
		}
	}

	/**
	 * Displays the view of the presenter in the content panel.
	 * 
	 * @param presenter
	 *            Presenter thats view should be displayed.
	 */
	private void displayPresenterView(final Presenter presenter) {

		ApplicationController.this.getContentPanel().clear();

		final IView view = presenter.getView();
		ApplicationController.this.getContentPanel().add(view);

		DOM.setElementAttribute(view.asWidget().getElement(), "id", presenter.getIdentifier());
		ApplicationController.this.registerResizeHanlder(view);
		ApplicationController.this.resizeContentPanel(view);
		ApplicationController.this.context.getEventBus().publish(new PresenterChangedEvent(presenter));

	}

	/**
	 * Registers a handler that handles a size change of the view object.
	 * 
	 * @param view
	 *            Target for the resize handler.
	 */
	private void registerResizeHanlder(final IView view) {
		final GQuery element = GQuery.$(view.asWidget());
		element.resize(new Function() {
			@Override
			public void f(final Element e) {
				GWT.log("[ApplicationController] view was resized!");
				ApplicationController.this.resizeContentPanel(view);
			}
		});
	}

	/**
	 * Resizes the content panel.
	 * 
	 * @param view
	 *            the view that is currently displayed in the content panel.
	 */
	private void resizeContentPanel(final IView view) {
		// Wenn die resize Routine direkt nach dem setzen des Views aufgerufen
		// wird, sind unter Umständen noch nicht alle Elemente des Views
		// geladen.
		// Daher wird das Resizen zurück gestellt bis der Browser alle GWT
		// Aufrufe verarbeitet hat.
		Scheduler.get().scheduleFinally(new ScheduledCommand() {

			@Override
			public void execute() {
				final GQuery viewElement = GQuery.$(view.asWidget());
				final int viewHeight = viewElement.height();

				final int viewWidth = viewElement.width();

				view.asWidget().setPixelSize(viewWidth, viewHeight);

				final GQuery contentElement = GQuery.$(ApplicationController.this.getContentPanel());
				viewElement.hide();
				contentElement.animate("width: '" + viewWidth + "px', height: '" + viewHeight + "px'",
						ApplicationController.RESIZE_ANIMATION_LENGTH, new Function() {
							@Override
							public void f(final Element e) {
								viewElement.fadeIn(ApplicationController.RESIZE_ANIMATION_LENGTH);
							}
						});
			}
		});

	}

	/**
	 * Returns the content panel. Marked with <code>id="content"</code> in the host html file.
	 * 
	 * @return The content panel.
	 */
	private RootPanel getContentPanel() {
		return RootPanel.get("content");
	}

	/**
	 * Displays a loading indicator. This will lock all visible elements in the view. Call
	 * {@link ApplicationController#hideLoadingIndicator()} to release the view.
	 */
	public void showLoadingIndicator() {
		this.getLoadingDialog().center();
	}

	/**
	 * Returns the loading indicator dialog for the application.
	 * 
	 * @return The loading indicator.
	 */
	private LoadingIndicator getLoadingDialog() {
		if (this.loadingDialog == null) {
			this.loadingDialog = new LoadingIndicator();

		}
		return this.loadingDialog;
	}

	/**
	 * Hides the loading indicator and releases all view elements of the application. If
	 * {@link ApplicationController#showLoadingIndicator()} was not called previously, nothing will happen.
	 */
	public void hideLoadingIndicator() {
		this.getLoadingDialog().hide();
	}

	/**
	 * Notifies all presenters in the presenter stack about a model update.
	 */
	public void updatePresenters() {
		// Hier muss über eine Kopie der Liste iteriert werden, da es möglich
		// ist, dass sich ein Presenter schließt, wenn sein Modellelement nicht
		// mehr existiert!
		for (final Presenter presenter : new ArrayList<Presenter>(this.presenterStack)) {
			presenter.onModelUpdate();
		}
	}

	/**
	 * Starts the application after a successful login.
	 * 
	 * @param user
	 *            The current logged in user.
	 */
	protected void start(final User user) {
		this.newStack(new SimpleCallback() {

			@Override
			public void callback() {
				ApplicationController.this.context.getToastMessageController().toastMessage("Anmeldung erfolgreich");

				ApplicationController.this.context.updateModel(new AsyncCallback<Model>() {

					@Override
					public void onFailure(final Throwable caught) {
					}

					@Override
					public void onSuccess(final Model result) {
						// Erst nachdem das Modell da ist, wird der
						// initiale
						// Presenter geladen

						ApplicationController.this.showPresenter(ApplicationController.this.startPresenter);
						ApplicationController.this.context.getEventBus().publish(new ApplicationStartedEvent());
					}
				});
			}
		});

	}

	/**
	 * Initiates the application start.
	 */
	public void start() {
		this.context.getSessionController().login();
	}

	/**
	 * Returns the current logged in user.
	 * 
	 * @return The currently logged in user.
	 */
	public User getCurrentUser() {
		return this.context.getSessionController().getCurrentUser();
	}

	/**
	 * Returns the stack of currently loaded presenters.
	 * 
	 * @return The stack of currently loaded presenters
	 */
	protected Stack<Presenter> getPresenterStack() {
		return this.presenterStack;
	}

	/**
	 * Tries to jump to a presenter in the current presenter stack.
	 * 
	 * @param presenter
	 *            the presenter we want to jump to
	 */
	public void gotoPresenter(final Presenter presenter) {
		if (this.getPresenterStack().contains(presenter)) {
			if (!this.getPresenterStack().peek().equals(presenter)) {
				this.getPresenterStack().peek().close(new CloseCallback() {

					@Override
					public void closed() {
						ApplicationController.this.gotoPresenter(presenter);
					}

					@Override
					public void closeAborted() {

					}
				});
			}
		}
	}
}
