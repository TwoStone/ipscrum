package fhdw.ipscrum.shared.model.messages;

import fhdw.ipscrum.shared.model.incidents.Incident;

public class AddGLobalIncidentMessage implements Message{
	private final Incident incident;
	
	public AddGLobalIncidentMessage(final Incident incident){
		this.incident = incident;
	}
	
	public final Incident getIncident(){
		return this.incident;
	}

	@Override
	public void accept(MessageVisitor v) {
		v.handleAddGlobalIncidentMessage(this);		
	}

	@Override
	public void accept(MessageStandardVisitor v) {
		v.handleAddGlobalIncidentMessage(this);
	}
}
