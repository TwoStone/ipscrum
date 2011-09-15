package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;

/**
 * represents an event argument which knows the incident details.
 */
public class IncidentDetailArgs extends EventArgs {

	/**
	 * represents the sting representing the type attached to the event argument.
	 */
	private final String typ;

	/**
	 * constructor of the IncidentDetailArgs.
	 * 
	 * @param typ
	 *            is the incident detail
	 */
	public IncidentDetailArgs(final String typ) {
		super();
		this.typ = typ;
	}

	/**
	 * getter of the string representing the typ.
	 * 
	 * @return the typ
	 */
	public String getTyp() {
		return this.typ;
	}

}
