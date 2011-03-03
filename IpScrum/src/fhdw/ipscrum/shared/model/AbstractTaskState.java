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

}
