package fhdw.ipscrum.client.events;

import java.util.Vector;

/**
 * Implementation of the event pattern. Representing an event that can be fired.
 * 
 * @author Niklas
 * 
 * @param <T>
 *            Type the event arguments.
 */
public class Event<T extends EventArgs> implements IEvent<T> {

	private final Vector<EventHandler<T>> handlers;

	/**
	 * Creates a new {@link Event} instance.
	 */
	public Event() {
		this.handlers = new Vector<EventHandler<T>>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.client.events.IEvent#add(fhdw.ipscrum.client.events.EventHandler
	 * )
	 */
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
		for (final EventHandler<T> current : this.handlers) {
			current.onUpdate(sender, e);
		}
	}

	/**
	 * Removes the specific {@link EventHandler} from the events handler list.
	 * 
	 * @param handler
	 */
	protected void remove(final EventHandler<?> handler) {
		this.handlers.remove(handler);
	}
}
