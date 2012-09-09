package fhdw.ipscrum.shared.model.messages;

import fhdw.ipscrum.shared.model.nonMeta.incidents.Incident;

/**
 * represents the RemoveGlobalIncidentMessage.
 */
public class RemoveGlobalIncidentMessage implements Message {

	/**
	 * incident to remove.
	 */
	private final Incident incident;

	/**
	 * Constructor of the RemoveGlobalIncidentMessage.
	 * 
	 * @param incident
	 *            to remove
	 */
	public RemoveGlobalIncidentMessage(final Incident incident) {
		this.incident = incident;
	}

	/**
	 * Getter of the affected incident.
	 * 
	 * @return the incident to remove
	 */
	public final Incident getIncident() {
		return this.incident;
	}

	@Override
	public void accept(final MessageVisitor v) {
	}

}
