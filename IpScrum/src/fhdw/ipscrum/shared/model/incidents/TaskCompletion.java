package fhdw.ipscrum.shared.model.incidents;

import java.util.Iterator;
import java.util.Vector;

import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITask;

public class TaskCompletion extends PredefinedIssue {
	private static final long serialVersionUID = 1989209326610038825L;
	private ITask task;
	public TaskCompletion(ITask task){
		super();
		this.task = task;
		this.setGlobal(false);
	}
	public final ITask getTask(){
		return this.task;
	}
	public final IPerson getParticipant(){
		return this.task.getResponsiblePerson();
	}
	@Override
	public Iterator<IPerson> getParticipants() {
		Vector<IPerson> result = new Vector<IPerson>();
		result.add(this.getParticipant());
		return result.iterator();
	}
}
