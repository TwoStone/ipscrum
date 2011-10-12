package fhdw.ipscrum.client.architecture.events;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Implementation of the event pattern. Representing an event that can be fired.
 * 
 * @author Niklas
 * 
 * @param <T>
 *            Type of the event arguments.
 */
@SuppressWarnings("deprecation")
public class Event<T extends EventArgs> implements IEvent<T> {

	/**
	 * The currently registered handlers.
	 */
	private final Vector<EventHandler<T>> handlers;

	/**
	 * Creates a new {@link Event} instance.
	 */
	public Event() {
		this.handlers = new Vector<EventHandler<T>>();
	}

	@Override
	public EventRegistration add(final EventHandler<T> handler) {
		this.handlers.add(handler);
		return new EventRegistration(this, handler);
	}

	/**
	 * Fires the event. Notifies all registered {@link EventHandler}s.
	 * 
	 * @param sender
	 *            The object owning the event.
	 * @param e
	 *            The arguments to send with the event notification.
	 */
	public void fire(final Object sender, final T e) {
		for (final EventHandler<T> current : new ArrayList<EventHandler<T>>(this.handlers)) {
			current.onUpdate(sender, e);
		}
	}

	/**
	 * Removes the specific {@link EventHandler} from the events handler list.
	 * 
	 * @param handler
	 *            the handler to remove
	 */
	protected void remove(final EventHandler<?> handler) {
		this.handlers.remove(handler);
	}

	/**
	 * Removes all registered handler from the event.
	 */
	public void removeAllHandler() {
		this.handlers.clear();

	}
}
