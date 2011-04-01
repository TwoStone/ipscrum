package fhdw.ipscrum.client.presenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.EventRegistration;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.view.interfaces.IView;
import fhdw.ipscrum.shared.SessionManager;

/**
 * Base class for presenters. Encapsulates the process of adding the new view to
 * user interface.
 * 
 * @param <T>
 *            Type of the ViewInterface, has to extend {@link IView}
 */
public abstract class Presenter<T extends IView> {

	private final Panel parent;

	private final T myView;
	private final SessionManager manager;
	private final Presenter<?> parentPresenter;

	/**
	 * Returns the parental presenter.
	 * 
	 * @return
	 */
	public Presenter<?> getParentPresenter() {
		return this.parentPresenter;
	}

	private final Map<Presenter<?>, Collection<EventRegistration>> children;

	private final Event<EventArgs> finished = new Event<EventArgs>();
	private final Event<EventArgs> aborted = new Event<EventArgs>();

	/**
	 * Creates a new instance {@link Presenter}. Must be called in derived
	 * classes to add the view to its parent panel. Due to MVP pattern, better
	 * use {@link Presenter#Presenter(Presenter)}
	 * 
	 * @param parent
	 *            GUI-Panel where the presenters view should be added. The view
	 *            will be automatically added to this panel.
	 * 
	 * @param parentPresenter
	 *            Presenter that calls this presenter. Used to enable the
	 *            possibility of building presenter-hierarchies. Can be null.
	 */
	public Presenter(final Panel parent, final Presenter<?> parentPresenter) {
		super();
		this.children = new HashMap<Presenter<?>, Collection<EventRegistration>>();
		this.manager = SessionManager.getInstance();
		this.parentPresenter = parentPresenter;
		if (this.parentPresenter != null) {
			this.parentPresenter.addChildren(this);
		}
		this.myView = this.createView();
		this.parent = parent;
		if (parent != null) {
			this.parent.add(this.myView);
		}
	}

	/**
	 * Aborts the workflow of the presenter. Has to be called to rise the
	 * aborted event.
	 */
	public final void abort() {
		if (this.onAbort()) {
			this.abortChildren();
			this.aborted.fire(this, new EventArgs());
		}
	}

	private void abortChildren() {
		for (final Entry<Presenter<?>, Collection<EventRegistration>> current : this.children
				.entrySet()) {
			for (final EventRegistration eventRegistration : current.getValue()) {
				eventRegistration.removeHandler();
			}
			current.getKey().abort();
		}
	}

	private void addChildren(final Presenter<?> presenter) {

		final List<EventRegistration> registrations = new ArrayList<EventRegistration>();

		class Handler implements EventHandler<EventArgs> {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				Presenter.this.children.remove(presenter);

			}

		}

		registrations.add(presenter.getFinished().add(new Handler()));
		registrations.add(presenter.getAborted().add(new Handler()));

	}

	/**
	 * Creates the view of the presenter. <br>
	 * <b>Note:</b> This method will be called while constructing the Presenter,
	 * at this time the {@link Presenter#myView} field will be not instantiated.
	 * It will be instantiate with the return value of this operation.
	 * 
	 * @return The view affiliating with this presenter.
	 */
	protected abstract T createView();

	/**
	 * Finishes the workflow of the presenter. Has to be called to rise the
	 * finished event.
	 */
	public final void finish() {
		if (this.onFinish()) {
			this.finished.fire(this, new EventArgs());
		}
	}

	/**
	 * Returns the aborted event. The event is raised when the workflow was
	 * aborted.
	 */
	public IEvent<EventArgs> getAborted() {
		return this.aborted;
	}

	/**
	 * Returns the event that is fire when the finish method was called.
	 */
	public IEvent<EventArgs> getFinished() {
		return this.finished;
	}

	/**
	 * Returns the manager for the current session.
	 */
	public SessionManager getSessionManager() {
		return this.manager;
	}

	/**
	 * Returns the view object of the presenter.
	 */
	public T getView() {
		return this.myView;
	}

	/**
	 * Template method. Can be overridden to do own stuff before aborted event
	 * is fired. Return false, to cancel finish process.
	 * 
	 * @return Indicates if the abort process should be finished.
	 */
	protected boolean onAbort() {
		return true;
	}

	/**
	 * Template method. Can be overridden to do own stuff before finished event
	 * is fired. Return false, to cancel finish process.
	 * 
	 * @return Indicates if the finish process should be finished.
	 */
	protected boolean onFinish() {
		return true;
	}

	/**
	 * Returns the parent of the presenter. <b>Attention:</b> can be a null
	 * value!
	 * 
	 * @return my parent
	 */
	public Panel getParent() {
		return this.parent;
	}

}
