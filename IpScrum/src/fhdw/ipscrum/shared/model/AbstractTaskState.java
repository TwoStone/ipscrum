package fhdw.ipscrum.shared.model;

import java.io.Serializable;

import fhdw.ipscrum.shared.model.interfaces.ITaskState;

public abstract class AbstractTaskState implements ITaskState, Serializable {
	
	private static final long serialVersionUID = 191308404327461283L;
	private Task myTask; //Konkrete Referenz, da Zugriff auf protected-Methoden

	public AbstractTaskState(Task task){
		super();
		this.myTask = task;
	}
	protected AbstractTaskState(){
	}

	@Override
	public Task getMyTask() {
		return this.myTask;
	}

}
