package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;

/**
 * represents an event argument which knows a string.
 */
public class OneStringArgs extends EventArgs {

	/**
	 * represents the string attached to the event argument.
	 */
	private final String string;

	/**
	 * Constructor for OneStringArgs.
	 * 
	 * @param string
	 *            String
	 */
	public OneStringArgs(final String string) {
		super();
		this.string = string;
	}

	/**
	 * Method getString.
	 * 
	 * @return String
	 */
	public String getString() {
		return this.string;
	}

}
