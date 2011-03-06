package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.model.interfaces.ITaskState;

public abstract class AbstractTaskState implements ITaskState {

	private static final long serialVersionUID = 191308404327461283L;
	private Task myTask; // Konkrete Referenz, da Zugriff auf protected-Methoden
	
	/**
	 * for serialization
	 */
	protected AbstractTaskState() {
	}
	/**
	 * @param task A task has to be passed to represent the 1:1 relation between the task and its state.
	 */
	public AbstractTaskState(Task task) {
		super();
		this.myTask = task;
	}

	@Override
	public Task getMyTask() {
		return this.myTask;
	}
	/*
	 * simple identity check, no further attributes needed, 
	 * because a task always has one state.	
	 */
	@Override
	public boolean equals(Object obj) {
		return this == (AbstractTaskState)obj;
	}
	/*
	 *  no attributes to generate hashcode, state already checked in 
     *  indirectHashCode of class Task.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result;
		return result;
	}
	
	
	
	

}
