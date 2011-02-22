package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITask;
import fhdw.ipscrum.shared.model.interfaces.ITaskState;

public class TaskClosed implements ITaskState {
	
	private Task myTask;
	
	public TaskClosed (Task myTask){
		this.myTask = myTask;
	}

	@Override
	public void setResponsibility(IPerson responsiblePerson) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeResponsibility(IPerson responsiblePerson) {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public IPerson getResponsiblePerson() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISprint getAssignedSprint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBacklogItem(ProductBacklogItem pbi) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeBacklogItem(ProductBacklogItem pbi) {
		// TODO Auto-generated method stub

	}

	@Override
	public Task getMyTask() {
		return this.myTask;
	}

}
