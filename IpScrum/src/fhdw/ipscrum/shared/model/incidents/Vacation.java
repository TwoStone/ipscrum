package fhdw.ipscrum.shared.model.incidents;

import java.util.Iterator;
import java.util.Vector;

import fhdw.ipscrum.shared.model.interfaces.IPerson;

public class Vacation extends PredefinedIssue {
	private static final long serialVersionUID = -1898852938570702145L;
	
	private IPerson participant;
	
	protected Vacation(IPerson participant) {
		super();
		this.participant = participant;
		this.setGlobal(true);
	}
	@SuppressWarnings("unused")
	private Vacation(){}
	public final IPerson getParticipant(){
		return this.participant;
	}
	@Override
	public Iterator<IPerson> getParticipants() {
		Vector<IPerson> result = new Vector<IPerson>();
		result.add(this.getParticipant());
		return result.iterator();
	}
}
