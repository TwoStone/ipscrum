package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITask;
import fhdw.ipscrum.shared.model.interfaces.ITaskState;

public abstract class TaskAssigned extends AbstractTaskState {

	private static final long serialVersionUID = 2003517415381360893L;
	private IPerson responsiblePerson;

	public TaskAssigned(Task task, IPerson responsiblePerson){
		super(task);
		this.responsiblePerson = responsiblePerson;
	}

	protected TaskAssigned(){
		super();
	}
	
	@Override
	public IPerson getResponsiblePerson() {
		return this.responsiblePerson;
	}

	protected final void setResponsiblePerson(IPerson responsiblePerson){
		this.responsiblePerson = responsiblePerson;
	}
	
	
}
