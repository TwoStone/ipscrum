package fhdw.ipscrum.shared.model;

import java.util.Date;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.visitor.ITaskStateVisitor;


public class TaskInProgress extends TaskAssigned {

	public TaskInProgress(Task task, IPerson responsiblePerson) {
		super(task, responsiblePerson);
	}

	@Override
	public void setResponsibility(IPerson responsiblePerson){
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
		this.getMyTask().doSetName(name);		
	}

	@Override
	public void accept(ITaskStateVisitor iTaskStateVisitor) {
		iTaskStateVisitor.handleTaskInProgress(this);
	}
	

}
