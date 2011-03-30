package fhdw.ipscrum.shared.model.incidents;

import java.util.Iterator;
import java.util.Vector;

import fhdw.ipscrum.shared.model.interfaces.IPerson;

public class Vacation extends PredefinedIssue {
	private static final long serialVersionUID = -1898852938570702145L;
	
	private IPerson participant;
	
	protected Vacation(String name, String description,IPerson participant) {
		super(name, description);
		this.participant = participant;
		this.setGlobal(true);
	}
	public final IPerson getParticipant(){
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
