package fhdw.ipscrum.shared.model.interfaces;


/**
 * A Task represents an activity which realizes
 * one or more Product Backlog Items. A Task has a state of Type ITaskState.
 */
public interface ITask extends ITaskStateOperations {
	/**
	 * @return name of the task
	 */
	public String getName();
	/** 
	 * @return further detailed description of the tasks
	 */
	public String getDescription();
	/**
	 * @return estimated plan effort of the task. The value
	 * may be 0, if no estimation has been done.
	 */
	public Integer getPlanEffort();
	
	/**
	 * HINT: Only for usage in the task board user interface!
	 * @return actual state of the task. 
	 */
	public ITaskState getState();

}