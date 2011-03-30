package fhdw.ipscrum.shared.model.incidents;

import java.util.Iterator;
import java.util.Vector;

import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITask;

public class TaskCompletion extends PredefinedIssue {
	private static final long serialVersionUID = 1989209326610038825L;
	private ITask task;
	public TaskCompletion(String name, String description,ITask task){
		super(name, description);
		this.task = task;
		this.setGlobal(false);
	}
	protected final ITask getTask(){
		return this.task;
	}
	protected final IPerson getParticipant(){
		return this.task.getResponsiblePerson();
	}
	@Override
	protected Iterator<IPerson> getParticipantsIterator() {
		return this.getParticipants().iterator();
	}
	@Override
	protected Vector<IPerson> getParticipants() {
		Vector<IPerson> result = new Vector<IPerson>();
		result.add(this.getParticipant());
		return result;
	}
	
}
