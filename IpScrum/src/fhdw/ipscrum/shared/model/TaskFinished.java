package fhdw.ipscrum.shared.model;

import java.util.Date;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;



public class TaskFinished extends TaskAssigned {
	

	private Date finishDate;
	
	public TaskFinished(Task task, IPerson responsiblePerson) {
		super(task, responsiblePerson);
		this.setResponsiblePerson(responsiblePerson);
		this.finishDate = new Date();
	}

	@Override
	public void setName(String name) throws ForbiddenStateException {
		throw new ForbiddenStateException(ExceptionConstants.FORBIDDEN_STATE_ERROR);	
	}

	@Override
	public void setDescription(String description)
			throws ForbiddenStateException {
		throw new ForbiddenStateException(ExceptionConstants.FORBIDDEN_STATE_ERROR);
		
	}

	@Override
	public void setResponsibility(IPerson responsiblePerson)
			throws ForbiddenStateException {
		throw new ForbiddenStateException(ExceptionConstants.FORBIDDEN_STATE_ERROR);
	}

	@Override
	public void finish() throws ForbiddenStateException {
		throw new ForbiddenStateException(ExceptionConstants.FORBIDDEN_STATE_ERROR);
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
		return true;
	}

	@Override
	public boolean isFinished() {
		return true;
	}

	@Override
	public IPerson getResponsiblePerson() {
		return super.getResponsiblePerson();
	}

	@Override
	public Date getFinishDate() {
		return this.finishDate;
	}
}
