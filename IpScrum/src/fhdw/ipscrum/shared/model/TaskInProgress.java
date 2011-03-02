package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.model.interfaces.IPerson;

public class TaskInProgress extends TaskAssigned {

	public TaskInProgress(Task task, IPerson responsiblePerson) {
		super(task, responsiblePerson);
	}

	@Override
	public void setResponsibility(IPerson responsiblePerson){
		this.setResponsiblePerson(responsiblePerson);
	}


}
