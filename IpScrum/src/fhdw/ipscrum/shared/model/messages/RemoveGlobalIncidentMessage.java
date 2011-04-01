package fhdw.ipscrum.shared.model.messages;

import fhdw.ipscrum.shared.model.incidents.Incident;

public class RemoveGlobalIncidentMessage implements Message {
	
	/**
	 * incident to remove
	 */
	private final Incident incident;
	
	public RemoveGlobalIncidentMessage(final Incident incident){
		this.incident = incident;
	}
	
	public final Incident getIncident(){
		return this.incident;
	}
	
	
	@Override
	public void accept(MessageVisitor v) {
		// TODO Auto-generated method stub

	}

	@Override
	public void accept(MessageStandardVisitor v) {
		// TODO Auto-generated method stub

	}

}
