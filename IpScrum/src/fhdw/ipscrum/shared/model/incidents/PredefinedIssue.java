package fhdw.ipscrum.shared.model.incidents;

import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

public abstract class PredefinedIssue extends IncidentType {
	private static final long serialVersionUID = -1992373435306438250L;
	
	protected PredefinedIssue(String name, String description){
		super(name, description);
	}
	
	@Override
	protected void addParticipant(IPerson participant)
			throws DoubleDefinitionException {
		// do nothing
	}

	@Override
	protected void removeParticipant(IPerson participant) {
		// do nothing
	}
	
	@Override
	protected void setName(String name){
		// do nothing
	}
	@Override
	protected void setDescription(String description){
		// do nothing
	}
	
}
