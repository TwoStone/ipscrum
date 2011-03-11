package fhdw.ipscrum.shared.model;

import java.util.Date;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.SprintAssociationException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.visitor.ITaskStateVisitor;


public class TaskInProgress extends TaskAssigned {

	private static final long serialVersionUID = 1765965731350458463L;
	/**
	 * Creates a new TaskInProgress instance
	 * @param task A task has to be passed to represent the 1:1 relation between the task and its state.
	 * @param responsiblePerson person which is responsible for the task.
	 * @throws SprintAssociationException
	 */
	public TaskInProgress(Task task, IPerson responsiblePerson) throws SprintAssociationException {
		super(task, responsiblePerson);
	}
	/**
	 * for serialization
	 */
	@SuppressWarnings("unused")
	private TaskInProgress(){
		super();
	}

	@Override
	public void setResponsibility(IPerson responsiblePerson) throws SprintAssociationException{
		this.setResponsiblePerson(responsiblePerson);
	}

	@Override
	public void setDescription(String description)
	throws ForbiddenStateException, NoValidValueException {
		this.getMyTask().doSetDescription(description);

	}

	@Override
	public void finish() throws ForbiddenStateException {
		this.getMyTask().doSetTaskFinished();
	}

	@Override
	public void finish(Date finishDate) throws ForbiddenStateException {
		this.getMyTask().doSetTaskFinished(finishDate);
	}
	@Override
	public void addPBI(ProductBacklogItem pbi) throws ForbiddenStateException {
		throw new ForbiddenStateException(ExceptionConstants.FORBIDDEN_STATE_ERROR);
	}

	@Override
	public void removePBI(ProductBacklogItem pbi)
	throws ForbiddenStateException {
		throw new ForbiddenStateException(ExceptionConstants.FORBIDDEN_STATE_ERROR);

	}

	@Override
	public boolean hasResponsiblePerson() {
		//state class invariant: responsible person is permanently assigned;
		return true;
	}

	@Override
	public IPerson getResponsiblePerson() {
		return super.getResponsiblePerson();
	}

	@Override
	public Date getFinishDate() {
		return null;
	}

	@Override
	public boolean isFinished() {
		return false;
	}

	@Override
	public void setName(String name) throws ForbiddenStateException, NoValidValueException {
		throw new ForbiddenStateException(ExceptionConstants.FORBIDDEN_STATE_ERROR);
	}

	@Override
	public void accept(ITaskStateVisitor iTaskStateVisitor) {
		iTaskStateVisitor.handleTaskInProgress(this);
	}
	@Override
	public void setPlanEffort(Effort planEffort)
	throws ForbiddenStateException {
		this.getMyTask().doSetPlanEffort(planEffort);
	}


}
