package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

public class PersonArgs extends EventArgs {

	private IPerson person;

	public PersonArgs(IPerson person) {
		super();
		this.person = person;
	}
	
	public IPerson getPerson() {
		return this.person;
	}
}
