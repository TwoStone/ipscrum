package fhdw.ipscrum.shared.model.incidents;

public interface IncidentVisitor {

	public void handleOneParticipantIncident(OneParticipantIncident incident);
	public void handleMultipleParticipantIncident(MultipleParticipantIncident incident);
}
