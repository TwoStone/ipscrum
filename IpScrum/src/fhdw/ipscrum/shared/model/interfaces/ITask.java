package fhdw.ipscrum.shared.model.interfaces;

import java.util.List;

import fhdw.ipscrum.shared.model.ProductBacklogItem;

/**
 * A Task represents an activity which realizes
 * one or more Product Backlog Items. A Task has a state of Type ITaskState.
 */
public interface ITask extends ITaskStateOperations {
	public Integer getPlanEffort();
	public Integer getActualEffort();
}
