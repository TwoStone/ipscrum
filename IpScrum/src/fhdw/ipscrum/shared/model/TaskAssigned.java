package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.model.interfaces.IPerson;

public abstract class TaskAssigned extends AbstractTaskState {

	private static final long serialVersionUID = 2003517415381360893L;
	private IPerson responsiblePerson;

	protected TaskAssigned() {
		super();
	}

	public TaskAssigned(Task task, IPerson responsiblePerson) {
		super(task);
		this.responsiblePerson = responsiblePerson;
	}

	@Override
	public IPerson getResponsiblePerson() {
		return this.responsiblePerson;
	}

	protected final void setResponsiblePerson(IPerson responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}

}
