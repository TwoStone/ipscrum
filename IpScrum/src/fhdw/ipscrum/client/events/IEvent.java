package fhdw.ipscrum.client.events;

public interface IEvent<T extends EventArgs> {

	/**
	 * Adds the specific handler to the events handler list.
	 */
	public EventRegistration add(EventHandler<T> handler);
}