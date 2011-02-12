package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;

/**
 */
public class OneStringArgs extends EventArgs {

	private String string;

	
	/**
	 * Constructor for OneStringArgs.
	 * @param string String
	 */
	public OneStringArgs(String string) {
		super();
		this.string = string;
	}
	
	/**
	 * Method getString.
	 * @return String
	 */
	public String getString() {
		return this.string;
	}
	
	
	
}
