package fhdw.ipscrum.shared.model.incidents;

import java.util.Iterator;
import java.util.Vector;

import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

public class SprintCompletion extends PredefinedIssue {
	private static final long serialVersionUID = -3980601087749190976L;
	private ISprint sprint;
	
	protected SprintCompletion(String name, String description, ISprint sprint){
		super(name, description);
		this.sprint = sprint;
		this.setGlobal(false);
	}
	
	protected ISprint getSprint(){
		return this.sprint;
	}

	@Override
	protected Iterator<IPerson> getParticipantsIterator() {
		// empty iterator
		return new Vector<IPerson>().iterator();
	}

	@Override
	protected Vector<IPerson> getParticipants() {
		// empty list
		return new Vector<IPerson>();
	}
	
	
}
