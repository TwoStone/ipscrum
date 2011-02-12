package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

/**
 */
public class PersonArgs extends EventArgs {

	private IPerson person;

	/**
	 * Constructor for PersonArgs.
	 * @param person IPerson
	 */
	public PersonArgs(IPerson person) {
		super();
		this.person = person;
	}
	
	/**
	 * Method getPerson.
	
	 * @return IPerson */
	public IPerson getPerson() {
		return this.person;
	}
}
