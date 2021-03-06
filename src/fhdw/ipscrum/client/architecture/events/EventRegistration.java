package fhdw.ipscrum.client.architecture.events;

/**
 * Representing an EventRegistration. Is the result, when a handler is registered on an event. Should be used to remove
 * the handler from the event.
 * 
 */
public class EventRegistration {

	/**
	 * represents the event to register.
	 */
	private final Event<?> event;
	/**
	 * represents the event handler to register.
	 */
	private final EventHandler<?> handler;

	/**
	 * Creates a new instance of {@link EventRegistration}.
	 * 
	 * @param event
	 *            The event where the handler is registered.
	 * @param handler
	 *            The handler that is registered.
	 */

	protected EventRegistration(final Event<?> event, final EventHandler<?> handler) {
		super();
		this.event = event;
		this.handler = handler;
	}

	/**
	 * Removes the handler from the event to whom it was registered in this {@link EventRegistration} object.
	 */
	public void removeHandler() {
		this.event.remove(this.handler);
	}

}
