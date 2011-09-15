package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;

/**
 * represents an event argument which knows two different strings.
 */
public class TwoStringArgs extends EventArgs {

	/**
	 * represents the first string attached to the event argument.
	 */
	private final String string1;
	/**
	 * represents the second string attached to the event argument.
	 */
	private final String string2;

	/**
	 * Constructor for TwoStringArgs.
	 * 
	 * @param string1
	 *            String
	 * @param string2
	 *            String
	 */
	public TwoStringArgs(final String string1, final String string2) {
		super();
		this.string1 = string1;
		this.string2 = string2;
	}

	/**
	 * Method getString1.
	 * 
	 * @return String
	 */
	public String getString1() {
		return this.string1;
	}

	/**
	 * Method getString2.
	 * 
	 * @return String
	 */
	public String getString2() {
		return this.string2;
	}

}
