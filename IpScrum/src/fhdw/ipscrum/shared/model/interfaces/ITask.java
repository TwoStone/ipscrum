package fhdw.ipscrum.shared.model.interfaces;

import java.util.Iterator;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.ManyToOne;
import fhdw.ipscrum.shared.bdas.OneToMany;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.SprintBacklog;
import fhdw.ipscrum.shared.model.Task;


/**
 * A Task represents an activity which realizes
 * one or more Product Backlog Items. A Task has a state of Type ITaskState.
 */
public interface ITask extends ITaskStateOperations, BDACompare {
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
	/**
	 * @return the sprint backlog which is associated with the task
	 */
	public SprintBacklog getSprintBacklog();
	/**
	 * @return the association object which is owner of the sprint backlog object.
	 */
	public ManyToOne<OneToMany, Task> getSprintBacklogAssoc();
	/**
	 * Checks if the PBI is contained in this.assignedPBIs
	 */
	public boolean hasPBI(ProductBacklogItem pbi);
	/**
	 * Provides Access to the PBIs, which the task is assigned to.
	 * @return iterator for PBIs
	 */
	public Iterator<ProductBacklogItem> getPBIIterator();

}
