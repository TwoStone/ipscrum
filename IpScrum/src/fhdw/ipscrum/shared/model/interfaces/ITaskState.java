package fhdw.ipscrum.shared.model.interfaces;

import fhdw.ipscrum.shared.model.Task;
import fhdw.ipscrum.shared.model.visitor.ITaskStateVisitor;

/**
 * This interface represents the state of a task
 */
public interface ITaskState extends ITaskStateOperations{
	public Task getMyTask();
	public void accept(ITaskStateVisitor iTaskStateVisitor);
}
