package fhdw.ipscrum.shared.model.messages;

import fhdw.ipscrum.shared.model.nonMeta.incidents.Incident;

/**
 * Represents the message if a global incident occured.
 * 
 */
public class AddGLobalIncidentMessage implements Message {

	/**
	 * Represents the incident the message is related to.
	 */
	private final Incident incident;

	/**
	 * Adds the massage to the project history.
	 * 
	 * @param incident
	 *            related to the added massage
	 */
	public AddGLobalIncidentMessage(final Incident incident) {
		this.incident = incident;
	}

	/**
	 * Gets the incident related to the message.
	 * 
	 * @return the current Incident
	 */
	public final Incident getIncident() {
		return this.incident;
	}

	@Override
	public void accept(final MessageVisitor v) {
		v.handleAddGlobalIncidentMessage(this);
	}

}
