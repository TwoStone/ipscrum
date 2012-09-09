package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.nonMeta.Task;

/**
 * represents an event argument which knows a task.
 */
public class TaskArgs extends EventArgs {

	/**
	 * represents the task attached to the event argument.
	 */
	private final Task task;

	/**
	 * constructor of the TaskArgs.
	 * 
	 * @param task
	 *            related to the argument
	 */
	public TaskArgs(final Task task) {
		super();
		this.task = task;
	}

	/**
	 * getter of the task.
	 * 
	 * @return the task
	 */
	public Task getTask() {
		return this.task;
	}
}
