package fhdw.ipscrum.shared.model;

import java.util.Date;

import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;



public class TaskFinished extends TaskAssigned {
	
	private Date finishDate;
	
	public TaskFinished(Task task, IPerson responsiblePerson) {
		super(task, responsiblePerson);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setResponsibility(IPerson responsiblePerson) {
		// TODO Exception werfen!!
		
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
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
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
