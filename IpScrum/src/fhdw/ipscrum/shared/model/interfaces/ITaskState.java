package fhdw.ipscrum.shared.model.interfaces;

import fhdw.ipscrum.shared.model.Task;

/**
 * This interface represents the state of a task
 */
public interface ITaskState extends ITaskStateOperations{
	public Task getMyTask();
}
