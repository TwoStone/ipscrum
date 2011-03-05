package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.MultiplePBIArgs;
import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Task;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITask;

/**
 * @author Phase III / Group I
 */
public interface ITaskDetailView extends IView {

	/**
	 * @returns String with the inputted name for a {@link TTask}
	 */
	public String getName();
	
	/**
	 * @return String with the inputted description for a {@link Task}
	 */
	public String getDescription();
	
	/**
	 * @return the selected responsible {@link Person} for a task
	 */
	public IPerson getPerson();
	
	/**
	 * @return Integer with plan-effort for a {@link Task}
	 */
	public Integer getEffort();
	
	/**
	 * @return Boolean if the task is finished
	 */
	public Boolean isFinished();
	
	/**
	 * Refreshs the related PBIs to a {@link Task} on the view class
	 * @param Vector<ProductBacklogItem> pbis
	 */
	public void refreshPBIs(Vector<ProductBacklogItem> pbis);
	
	/**
	 * Refreshs the Persons of the tasks sprint on the view class
	 * @param pbis
	 */
	public void refreshPersons(Vector<IPerson> pbis);

	/**
	 * Sets the name of a task on the view
	 * @param String name
	 */
	public void setName(String name);
	
	/**
	 * Sets the description of a task on the view
	 * @param String description
	 */
	public void setDescription(String description);
	
	/**
	 * Sets the responsible Person of a task on the view
	 * @param Person person
	 */
	public void setPerson(IPerson person);
	
	/**
	 * Sets the effort of a task on the view
	 * @param Integer effort
	 */
	public void setEffort(Integer effort);
	
	/**
	 * Sets a task finish or not on the view
	 * @param Boolean finish
	 */
	public void setFinished(Boolean finish);
	
	/**
	 * Initializes the view with the general attributes of task.
	 * Independent by the tasks state
	 * @param ITask task
	 */
	public void initTaskView(ITask task);
	
	/**
	 * Initializes specific elements of the view with attributes of the task 
	 * Depending of the tasks state
	 * @param ITask task
	 */
	public abstract void initSpecificTaskView(ITask task);

	/**
	 * Use this to add a handler for the 'OkayEvent'.
	 * @param EventHandler<EventArgs> arg
	 */
	public void addOkayEventHandler(EventHandler<EventArgs> arg);
	
	/**
	 * Use this to add a handler for the 'CancelEvent'.
	 * @param EventHandler<EventArgs> arg
	 */
	public void addCancelEventHandler(EventHandler<EventArgs> arg);
	
	/**
	 * Use this to add a handler for the 'AddPBIsEvent'
	 * @param EventHandler<EventArgs> arg
	 */
	public void addAddPBIsEventHandler(EventHandler<EventArgs> arg);
	
	/**
	 * Use this to add a handler for 'RemovePBIsEvent'
	 * @param EventHandler<MultiplePBIArgs> arg
	 */
	public void addRemovePBIsEventHandler(EventHandler<MultiplePBIArgs> arg);

}
