package fhdw.ipscrum.shared.model.nonMeta.incidents;

/**
 * represent the visitor needed for handling incidents.
 */
public interface IncidentVisitor {

	/**
	 * needed for handling oneParticipantIncidents.
	 * 
	 * @param incident
	 *            to handle
	 */
	void handleOneParticipantIncident(OneParticipantIncident incident);

	/**
	 * needed for handling multiParticipantIncidents.
	 * 
	 * @param incident
	 *            to handle
	 */
	void handleMultipleParticipantIncident(MultipleParticipantIncident incident);
}
