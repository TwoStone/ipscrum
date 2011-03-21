package fhdw.ipscrum.shared.model.incidents;

import java.util.Iterator;
import java.util.Vector;

import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

public class SprintCompletion extends PredefinedIssue {
	private static final long serialVersionUID = -3980601087749190976L;
	private ISprint sprint;
	
	protected SprintCompletion(ISprint sprint){
		super();
		this.sprint = sprint;
		this.setGlobal(false);
	}
	@SuppressWarnings("unused")
	private SprintCompletion(){}
	
	public ISprint getSprint(){
		return this.sprint;
	}
	@Override
	public Iterator<IPerson> getParticipants() {
		Vector<IPerson> result = new Vector<IPerson>();
		Iterator<IPerson> i = this.getSprint().getTeam().getMembers().iterator();
		while (i.hasNext()){
			IPerson current = i.next();
			result.add(current);
		}
		return result.iterator();
	}
}
