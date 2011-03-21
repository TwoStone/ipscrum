package fhdw.ipscrum.shared.model.incidents;

import java.util.Iterator;
import java.util.Vector;

import fhdw.ipscrum.shared.model.interfaces.IPerson;


public class Illness extends PredefinedIssue {
	private static final long serialVersionUID = 5986593699998412800L;
	
	private IPerson participant;
	
	protected Illness(IPerson participant){
		super();
		this.participant = participant;
		this.setGlobal(true);
	}
	@SuppressWarnings("unused")
	private Illness(){}
	
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
