package fhdw.ipscrum.client.events.args;


import fhdw.ipscrum.client.events.EventArgs;


public class IncidentDetailArgs extends EventArgs{
	
	private final String typ;
	
	public IncidentDetailArgs(String typ) {
		super();
		this.typ = typ;
	}
	public String getTyp() {
		return this.typ;
	}

}
