package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITask;
import fhdw.ipscrum.shared.model.interfaces.ITaskState;

public class TaskUnassigned extends AbstractTaskState implements ITaskState {

	public TaskUnassigned(Task task) {
		super(task);
	}

	@Override
	public void setResponsibility(IPerson responsiblePerson) {
		this.getMyTask().setTaskAssigned(responsiblePerson);
	}
	
	
	
}
