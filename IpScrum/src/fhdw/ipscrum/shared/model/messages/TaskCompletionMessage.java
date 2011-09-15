package fhdw.ipscrum.shared.model.messages;

import fhdw.ipscrum.shared.model.nonMeta.Task;

/**
 * Represents the message shown in the projecthistory if a task is closed.
 */
public class TaskCompletionMessage implements Message {

	/**
	 * Represents the related task.
	 */
	private final Task task;

	/**
	 * Constructor of the TaskCompletionMessage.
	 * 
	 * @param task
	 *            related to the message
	 */
	public TaskCompletionMessage(final Task task) {
		this.task = task;
	}

	/**
	 * Getter of the related task.
	 * 
	 * @return the related Task
	 */
	public final Task getTask() {
		return this.task;
	}

	@Override
	public void accept(final MessageVisitor v) {
		v.handleTaskCompletionMessage(this);
	}

}
