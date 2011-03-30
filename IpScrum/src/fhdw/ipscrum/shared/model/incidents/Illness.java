package fhdw.ipscrum.shared.model.incidents;

import java.util.Iterator;
import java.util.Vector;

import fhdw.ipscrum.shared.model.interfaces.IPerson;


public class Illness extends PredefinedIssue {
	private static final long serialVersionUID = 5986593699998412800L;
	
	private IPerson participant;
	
	protected Illness(String name, String description,IPerson participant){
		super(name, description);
		this.participant = participant;
		this.setGlobal(true);
	}

	
	protected final IPerson getParticipant(){
		return this.participant;
	}

	@Override
	protected Iterator<IPerson> getParticipantsIterator() {
		Vector<IPerson> result = new Vector<IPerson>();
		result.add(this.getParticipant());
		return result.iterator();
	}


	@Override
	protected Vector<IPerson> getParticipants() {
		Vector<IPerson> result = new Vector<IPerson>();
		result.add(this.getParticipant());
		return result;
	}
	
	
}
