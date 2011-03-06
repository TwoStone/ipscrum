package fhdw.ipscrum.shared.model.interfaces;

import fhdw.ipscrum.shared.model.Task;
import fhdw.ipscrum.shared.model.visitor.ITaskStateVisitor;

/**
 * This interface represents the state of a task
 */
public interface ITaskState extends ITaskStateOperations{
	/**
	 * Returns the task of the state. The task is always the owner of the state object.
	 * @return
	 */
	public Task getMyTask();
	/**
	 * accept operation according to the visitor-pattern
	 * @param iTaskStateVisitor @see {@link ITaskStateVisitor}
	 */
	public void accept(ITaskStateVisitor iTaskStateVisitor);
}
