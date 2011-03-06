package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.exceptions.SprintAssociationException;
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
	 * @throws SprintAssociationException 
	 */
	public TaskAssigned(Task task, IPerson responsiblePerson) throws SprintAssociationException {
		super(task);
		this.setResponsiblePerson(responsiblePerson);
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
	 * @throws SprintAssociationException 
	 */
	protected final void setResponsiblePerson(IPerson responsiblePerson) throws SprintAssociationException {
		if (this.getMyTask().isPersonValid(responsiblePerson)){
			this.doSetResponsiblePerson(responsiblePerson);
		} else{
			throw new SprintAssociationException(ExceptionConstants.PERSON_NOT_IN_SPRINT_TEAM_ERROR);
		}
	}
	protected final void doSetResponsiblePerson(IPerson responsiblePerson){
		this.responsiblePerson = responsiblePerson;
	}

}
