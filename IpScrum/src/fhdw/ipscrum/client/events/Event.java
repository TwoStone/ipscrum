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
	public void add(final EventHandler<T> handler) {
		this.handlers.add(handler);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.events.IEvent#remove(fhdw.ipscrum.client.events.
	 * EventHandler)
	 */
	@Override
	public void remove(final EventHandler<T> handler) {
		this.handlers.remove(handler);
	}

}
