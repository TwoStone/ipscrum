package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.model.interfaces.ITaskState;

public abstract class AbstractTaskState implements ITaskState {
	
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
	public Task getMyTask() {
		return this.myTask;
	}

}
