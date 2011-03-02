package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.model.interfaces.IPerson;



public class TaskFinished extends TaskAssigned {

	public TaskFinished(Task task, IPerson responsiblePerson) {
		super(task, responsiblePerson);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setResponsibility(IPerson responsiblePerson) {
		// TODO Exception werfen!!
		
	}


}
