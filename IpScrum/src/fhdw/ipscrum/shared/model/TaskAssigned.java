package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITask;
import fhdw.ipscrum.shared.model.interfaces.ITaskState;

public abstract class TaskAssigned extends AbstractTaskState {
	public TaskAssigned(Task task) {
		super(task);
		// TODO Auto-generated constructor stub
	}
	private IPerson responsiblePerson;
	private Integer planEffort;
	private Integer actualEffort;
}
