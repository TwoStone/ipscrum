package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.Task;
import fhdw.ipscrum.shared.model.interfaces.ITask;

public class TaskArgs extends EventArgs {

	private ITask task;

	public TaskArgs(ITask iTask) {
		super();
		this.task = iTask;
	}
	
	public ITask getTask() {
		return task;
	}
}
