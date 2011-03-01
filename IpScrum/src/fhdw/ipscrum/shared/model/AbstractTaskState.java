package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITaskState;

public class AbstractTaskState implements ITaskState {
	
	private Task myTask; //Konkrete Referenz, da Zugriff auf protected-Methoden

	public AbstractTaskState(Task task){
		super();
		this.myTask = task;
	}
	
	@Override
	public void setName(String name) {
		this.getMyTask().doSetName(name);
	}

	@Override
	public void setPBI(ProductBacklogItem pbi) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setResponsibility(IPerson responsiblePerson) {
		// TODO Auto-generated method stub

	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub

	}

	@Override
	public IPerson getResponsiblePerson() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task getMyTask() {
		return this.myTask;
	}

}
