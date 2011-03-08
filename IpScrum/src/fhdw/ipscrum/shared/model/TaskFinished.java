package fhdw.ipscrum.shared.model;

import java.util.Date;

import fhdw.ipscrum.client.utils.CalendarUtils;
import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.SprintAssociationException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.visitor.ITaskStateVisitor;

public class TaskFinished extends TaskAssigned {

	private static final long serialVersionUID = -1803966279393362821L;
	/**
	 * the finishDate is the date when the state of the task switched to Finished.
	 */
	private Date finishDate;
	/**
	 * for serialization
	 */
	@SuppressWarnings("unused")
	private TaskFinished() {
		super();
	}
	/**
	 * Creates a new TaskFinished instance.
	 * 
	 * @param task  A task has to be passed to represent the 1:1 relation between the task and its state.
	 * @param responsiblePerson
	 * responsible person which has to be the same as the one in the preceding state.
	 * @throws SprintAssociationException
	 */
	public TaskFinished(Task task, IPerson responsiblePerson) {
		this.setMyTask(task);
		this.doSetResponsiblePerson(responsiblePerson);
		this.finishDate = new Date();
		CalendarUtils.resetTime(this.finishDate);
	}

	public TaskFinished(Task task, IPerson responsiblePerson, Date finishDate) {
		this.setMyTask(task);
		this.doSetResponsiblePerson(responsiblePerson);
		this.finishDate = finishDate;
		CalendarUtils.resetTime(this.finishDate);
	}
	@Override
	public void accept(ITaskStateVisitor iTaskStateVisitor) {
		iTaskStateVisitor.handleTaskFinished(this);
	}

	@Override
	public void addPBI(ProductBacklogItem pbi) throws ForbiddenStateException {
		throw new ForbiddenStateException(
				ExceptionConstants.FORBIDDEN_STATE_ERROR);

	}

	@Override
	public void finish() throws ForbiddenStateException {
		throw new ForbiddenStateException(
				ExceptionConstants.FORBIDDEN_STATE_ERROR);
	}


	@Override
	public void finish(Date finishDate) throws ForbiddenStateException {
		throw new ForbiddenStateException(
				ExceptionConstants.FORBIDDEN_STATE_ERROR);
	}
	@Override
	public Date getFinishDate() {
		return this.finishDate;
	}

	@Override
	public IPerson getResponsiblePerson() {
		return super.getResponsiblePerson();
	}

	@Override
	public boolean hasResponsiblePerson() {
		return true;
	}

	@Override
	public boolean isFinished() {
		return true;
	}

	@Override
	public void removePBI(ProductBacklogItem pbi)
	throws ForbiddenStateException {
		throw new ForbiddenStateException(
				ExceptionConstants.FORBIDDEN_STATE_ERROR);
	}

	@Override
	public void setDescription(String description)
	throws ForbiddenStateException {
		throw new ForbiddenStateException(
				ExceptionConstants.FORBIDDEN_STATE_ERROR);

	}

	@Override
	public void setName(String name) throws ForbiddenStateException {
		throw new ForbiddenStateException(
				ExceptionConstants.FORBIDDEN_STATE_ERROR);
	}

	@Override
	public void setResponsibility(IPerson responsiblePerson)
	throws ForbiddenStateException {
		throw new ForbiddenStateException(
				ExceptionConstants.FORBIDDEN_STATE_ERROR);
	}

	@Override
	public void setPlanEffort(Integer planEffort)
	throws ForbiddenStateException {
		throw new ForbiddenStateException(
				ExceptionConstants.FORBIDDEN_STATE_ERROR);
	}
}
