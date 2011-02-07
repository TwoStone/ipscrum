package fhdw.ipscrum.client.events;

public interface IEvent<T extends EventArgs> {

	/**
	 * Adds the specific handler to the events handler list.
	 */
	public abstract void add(EventHandler<T> handler);

	/**
	 * Removes the specific {@link EventHandler} from the events handler list.
	 * @param handler
	 */
	public abstract void remove(EventHandler<T> handler);

}