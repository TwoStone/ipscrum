package fhdw.ipscrum.shared.model.incidents;

import java.util.Iterator;
import java.util.Vector;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

public class OtherIssue extends IncidentType {
	private static final long serialVersionUID = -241940543502692695L;
	private Vector<IPerson> participants;
	protected OtherIssue(String name, String description){
		super(name, description);
		this.participants = new Vector<IPerson>();
	}
	@Override
	protected final Iterator<IPerson> getParticipantsIterator() {
		return this.participants.iterator();
	}
	@Override
	protected final Vector<IPerson> getParticipants(){
		return this.participants;
	}
	@Override
	protected void addParticipant(final IPerson participant) throws DoubleDefinitionException{
		if (participant==null) { return; }
		if (!this.participants.contains(participant)) {
			this.participants.add(participant);
		} else {
			throw new DoubleDefinitionException(ExceptionConstants.DOUBLE_DEFINITION_ERROR);
		}
	}
	@Override
	protected void removeParticipant(final IPerson participant){
		if (participant!=null && this.participants.contains(participant)){
			this.participants.remove(participant);
		}
	}
	@Override
	protected void setName(String name) {
		this.setName(name);
		
	}
	@Override
	protected void setDescription(String description) {
		this.setDescription(description);
	}

}
