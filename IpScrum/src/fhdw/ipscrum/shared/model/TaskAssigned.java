package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITask;
import fhdw.ipscrum.shared.model.interfaces.ITaskState;

public abstract class TaskAssigned extends AbstractTaskState {
	private IPerson responsiblePerson;
	private Integer planEffort;
	private Integer actualEffort;

	public TaskAssigned(Task task, IPerson responsiblePerson){
		super(task);
		this.responsiblePerson = responsiblePerson;
		this.planEffort = 0;
		this.actualEffort = 0;
	}
	
	protected final void setResponsiblePerson(IPerson responsiblePerson){
		this.responsiblePerson = responsiblePerson;
	}
	
}
