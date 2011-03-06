package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.model.interfaces.IPerson;

public abstract class TaskAssigned extends AbstractTaskState {

	private static final long serialVersionUID = 2003517415381360893L;
	private IPerson responsiblePerson;
	/**
	 * for serialization
	 */
	protected TaskAssigned() {
		super();
	}
	/**
	 * 
	 * @param task A task has to be passed to represent the 1:1 relation between the task and its state.
	 * @param responsiblePerson An instance of TaskAssigned has always a valid responsiblePerson reference.
	 */
	public TaskAssigned(Task task, IPerson responsiblePerson) {
		super(task);
		this.responsiblePerson = responsiblePerson;
	}

	@Override
	public IPerson getResponsiblePerson() {
		return this.responsiblePerson;
	}
	/**
	 * replaces the actual responsiblePerson attribute with the new person.
	 * Never mix up this method with setResponsibility declared in ITaskStateOperations.
	 * This method is only for internal use.
	 * @param responsiblePerson new person responsible for the task.
	 */
	protected final void setResponsiblePerson(IPerson responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}

}
