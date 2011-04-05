package fhdw.ipscrum.shared.model.incidents;

import java.util.Date;
import java.util.Vector;

import fhdw.ipscrum.shared.model.interfaces.IPerson;

public class MultipleParticipantIncident extends Incident {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5434093482723105160L;
	private Vector<IPerson> participants;
	
	public MultipleParticipantIncident(Date start, Date end) {
		super(start, end);
		this.participants = new Vector<IPerson>();
	}
	
	public final Vector<IPerson> getParticipants(){
		return this.participants;
	}
	
	public void addParticipant(final IPerson person){
		if(!(this.participants.contains(person))){
			this.participants.add(person);
		}
	}

	@Override
	public void accept(IncidentVisitor visitor) {
		visitor.handleMultipleParticipantIncident(this);
	}
}
