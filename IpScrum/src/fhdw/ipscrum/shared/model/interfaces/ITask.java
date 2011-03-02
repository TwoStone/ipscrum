package fhdw.ipscrum.shared.model.interfaces;


/**
 * A Task represents an activity which realizes
 * one or more Product Backlog Items. A Task has a state of Type ITaskState.
 */
public interface ITask extends ITaskStateOperations {
	public String getName();
	public String getDescription();
	public Integer getPlanEffort();
	public ITaskState getState();

}
