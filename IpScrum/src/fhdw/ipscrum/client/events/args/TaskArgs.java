package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.Task;

public class TaskArgs extends EventArgs {

	private Task task;

	public TaskArgs(Task task) {
		super();
		this.task = task;
	}
	
	public Task getTask() {
		return task;
	}
}
