package fhdw.ipscrum.shared.model;

import java.util.Date;

import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITaskState;

public class TaskUnassigned extends AbstractTaskState implements ITaskState {

	public TaskUnassigned(Task task) {
		super(task);
	}

	@Override
	public void setResponsibility(IPerson responsiblePerson) {
		this.getMyTask().setTaskAssigned(responsiblePerson);
	}

	@Override
	public void setDescription(String description)
			throws ForbiddenStateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finish() throws ForbiddenStateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPBI(ProductBacklogItem pbi) throws ForbiddenStateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePBI(ProductBacklogItem pbi)
			throws ForbiddenStateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasResponsiblePerson() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public IPerson getResponsiblePerson() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getFinishDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
