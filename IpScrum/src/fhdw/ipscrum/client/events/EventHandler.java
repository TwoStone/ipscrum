package fhdw.ipscrum.client.events;

/**
 * Interface for Classes that can register to an event of type {@link Event}.
 * 
 * @author Niklas
 * 
 * @param <T>
 *            Type of event arguments.
 */
public interface EventHandler<T extends EventArgs> {
	public void onUpdate(Object sender, T eventArgs);
}
