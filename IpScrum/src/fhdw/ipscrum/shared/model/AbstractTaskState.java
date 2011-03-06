package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.model.interfaces.ITaskState;

public abstract class AbstractTaskState implements ITaskState {

	private static final long serialVersionUID = 191308404327461283L;
	private Task myTask; // Konkrete Referenz, da Zugriff auf protected-Methoden

	protected AbstractTaskState() {
	}

	public AbstractTaskState(Task task) {
		super();
		this.myTask = task;
	}

	@Override
	public Task getMyTask() {
		return this.myTask;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// simple identity check, no further attributes needed, because
		// a task always has one state.	
		return this == (AbstractTaskState)obj;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result;
		return result;
		// no attributes to generate hashcode, state already checked in 
		// indirectHashCode of class Task
	}
	
	
	
	

}
