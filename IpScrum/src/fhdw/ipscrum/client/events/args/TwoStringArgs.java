package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;

/**
 */
public class TwoStringArgs extends EventArgs {

	private String string1;
	private String string2;
	
	/**
	 * Constructor for TwoStringArgs.
	 * @param string1 String
	 * @param string2 String
	 */
	public TwoStringArgs(String string1, String string2) {
		super();
		this.string1 = string1;
		this.string2 = string2;
	}
	
	/**
	 * Method getString1.
	
	 * @return String */
	public String getString1() {
		return this.string1;
	}
	/**
	 * Method getString2.
	
	 * @return String */
	public String getString2() {
		return this.string2;
	}
	
	
	
}
