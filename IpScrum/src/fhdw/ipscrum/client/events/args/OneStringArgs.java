package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;

public class OneStringArgs extends EventArgs {

	private String string;

	
	public OneStringArgs(String string) {
		super();
		this.string = string;
	}
	
	public String getString() {
		return this.string;
	}
	
	
	
}
