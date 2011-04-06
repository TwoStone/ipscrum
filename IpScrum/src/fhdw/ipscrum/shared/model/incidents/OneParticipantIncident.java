package fhdw.ipscrum.shared.model.incidents;

import java.util.Date;

import fhdw.ipscrum.shared.model.interfaces.IPerson;

public class OneParticipantIncident extends Incident {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4826959493418850283L;
	private IPerson participant;
	
	protected OneParticipantIncident(Date start, Date end, IPerson participant) {
		super(start, end);
		this.participant = participant;
	}
	protected OneParticipantIncident(){
		super();
	}
	
	public IPerson getParticipant(){
		return this.participant;
	}

	@Override
	public void accept(IncidentVisitor visitor) {
		visitor.handleOneParticipantIncident(this);
	}
}
