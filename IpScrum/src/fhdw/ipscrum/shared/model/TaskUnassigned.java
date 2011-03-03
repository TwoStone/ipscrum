package fhdw.ipscrum.shared.model;

import java.util.Date;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITaskState;
import fhdw.ipscrum.shared.model.visitor.ITaskStateVisitor;

public class TaskUnassigned extends AbstractTaskState implements ITaskState {

	public TaskUnassigned(Task task) {
		super(task);
	}

	@Override
	public void setName(String name) throws ForbiddenStateException, NoValidValueException {
		this.getMyTask().doSetName(name);
		
	}

	@Override
	public void setDescription(String description)
			throws ForbiddenStateException, NoValidValueException {
		this.getMyTask().doSetDescription(description);
		
	}

	@Override
	public void setResponsibility(IPerson responsiblePerson)
			throws ForbiddenStateException {
		this.getMyTask().setTaskAssigned(responsiblePerson);
	}

	@Override
	public void finish() throws ForbiddenStateException {
		throw new ForbiddenStateException(ExceptionConstants.FORBIDDEN_STATE_ERROR);
	}

	@Override
	public void addPBI(ProductBacklogItem pbi) throws ForbiddenStateException {
		this.getMyTask().doAddPBI(pbi);
		
	}

	@Override
	public void removePBI(ProductBacklogItem pbi)
			throws ForbiddenStateException {
		this.getMyTask().doRemovePBI(pbi);
		
	}

	@Override
	public boolean hasResponsiblePerson() {
		return false;
	}

	@Override
	public boolean isFinished() {
		return false;
	}

	@Override
	public IPerson getResponsiblePerson() {
		return null;
	}

	@Override
	public Date getFinishDate() {
		return null;
	}

	@Override
	public void accept(ITaskStateVisitor iTaskStateVisitor) {
		iTaskStateVisitor.handleTaskUnassigned(this);
	}
	
}
