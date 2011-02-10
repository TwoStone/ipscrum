package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;

public class TwoStringArgs extends EventArgs {

	private String string1;
	private String string2;
	
	public TwoStringArgs(String string1, String string2) {
		super();
		this.string1 = string1;
		this.string2 = string2;
	}
	
	public String getString1() {
		return this.string1;
	}
	public String getString2() {
		return this.string2;
	}
	
	
	
}
