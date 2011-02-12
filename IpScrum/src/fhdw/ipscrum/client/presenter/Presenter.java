package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.view.interfaces.IView;

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

	private final Event<EventArgs> finished = new Event<EventArgs>();
	private final Event<EventArgs> aborted = new Event<EventArgs>();

	/**
	 * Creates a new instance {@link Presenter}. Must be called in derived
	 * classes to add the view to its parent panel.
	 * 
	 * @param parent
	 *            GUI-Panel where the presenters view should be added.
	 */
	public Presenter(final Panel parent) {
		super();
		this.parent = parent;
		this.myView = this.createView();
		this.parent.add(this.myView);
	}

	/**
	 * Aborts the workflow of the presenter. Has to be called to rise the
	 * aborted event.
	 */
	protected void abort() {
		if (this.onAbort()) {
			this.aborted.fire(this, new EventArgs());
		}
	}

	protected abstract T createView();

	/**
	 * Finished the workflow of the presenter. Has to be called to rise the
	 * finished event.
	 */
	protected void finish() {
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
	 * Returns the view object of the presenter.
	 */
	public T getView() {
		return this.myView;
	}

	/**
	 * Template method. Can be overridden to do own stuff before aborted event
	 * is fired. Return false, to cancel finish process.
	 * 
	 * @return
	 */
	protected boolean onAbort() {
		return true;
	}

	/**
	 * Template method. Can be overridden to do own stuff before finished event
	 * is fired. Return false, to cancel finish process.
	 * 
	 * @return
	 */
	protected boolean onFinish() {
		return true;
	}

}
