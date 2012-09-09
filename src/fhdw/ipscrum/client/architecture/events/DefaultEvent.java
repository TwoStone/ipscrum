package fhdw.ipscrum.client.architecture.events;

/**
 * Deafult event with no event arguments.
 */
public class DefaultEvent extends Event<EventArgs> {

	/**
	 * @see Event#fire(Object, EventArgs)
	 * @param sender
	 *            the sender of the event
	 */
	public void fire(final Object sender) {
		this.fire(sender, new EventArgs());
	}
}
