package fhdw.ipscrum.shared.model.visitor;

import fhdw.ipscrum.shared.model.TaskFinished;
import fhdw.ipscrum.shared.model.TaskInProgress;
import fhdw.ipscrum.shared.model.TaskUnassigned;

/**
 * Visits all concrete ITaskStates
 */
public interface ITaskStateVisitor {
	
	public void handleTaskUnassigned(TaskUnassigned taskUnassigned);
	public void handleTaskInProgress(TaskInProgress taskInProgress);
	public void handleTaskFinished(TaskFinished taskFinished);

}
