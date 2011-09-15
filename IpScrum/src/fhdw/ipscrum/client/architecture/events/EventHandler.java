package fhdw.ipscrum.client.architecture.events;

/**
 * Interface for Classes that can register to an event of type {@link Event}.
 * 
 * @author Niklas
 * 
 * @param <T>
 *            Type of event arguments.
 */
public interface EventHandler<T extends EventArgs> {

	/**
	 * Is called when the event has occurred.
	 * 
	 * @param sender
	 *            the sender of the event
	 * @param eventArgs
	 *            the arguments of the event
	 */
	void onUpdate(Object sender, T eventArgs);
}
