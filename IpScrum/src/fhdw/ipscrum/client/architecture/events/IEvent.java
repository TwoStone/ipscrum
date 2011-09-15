package fhdw.ipscrum.client.architecture.events;

/**
 * <b>This class will be deleted at end of phase 7.</b> <br/>
 * Please use an operation
 * <code>addHandler(handler:EventHandler<T>):EventRegistration</code> in the view
 * interface instead!
 * 
 * @author Niklas
 * 
 * @param <T>
 *            is the type of the event
 * @deprecated because it isn't necessary anymore
 */
@Deprecated
public interface IEvent<T extends EventArgs> {

	/**
	 * Adds the specific handler to the events handler list.
	 * 
	 * @param handler
	 *            is the handler to handle the event.
	 * @return the event to handle
	 */
	EventRegistration add(EventHandler<T> handler);
}
