package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.MultiplePBIArgs;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.events.args.TaskArgs;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.interfaces.ITask;

public interface ITaskboardView extends IView {

	/**
	 * Refreshs the view with all PBIs from the vector
	 * 
	 * @param Vector
	 *            <ProductBacklogItem> pbis
	 */
	void refreshPBIs(Vector<ProductBacklogItem> pbis);

	/**
	 * Refreshs the 'ToDOTasks' in the view with all tasks from the vector
	 * 
	 * @param Vector
	 *            <ITask> tasks
	 */
	void refreshTodoTasks(Vector<ITask> tasks);

	/**
	 * Refreshs the 'InProgressTasks' in the view with all tasks from the vector
	 * 
	 * @param Vector
	 *            <ITask> tasks
	 */
	void refreshInProgressTasks(Vector<ITask> tasks);

	/**
	 * Refreshs the 'DoneTasks' in the view with all tasks from the vector
	 * 
	 * @param Vector
	 *            <ITask> tasks
	 */
	void refreshDoneTasks(Vector<ITask> tasks);

	/**
	 * Makes the taskboard visible or not
	 * 
	 * @param Boolean
	 *            visible
	 */
	public void setTaskboardVisibility(Boolean visible);

	/**
	 * Use this method to add a handler for the newTaskEvent
	 * 
	 * @param EventHandler
	 *            <MultiplePBIArgs> arg
	 */
	void addNewTaskEventHandler(EventHandler<MultiplePBIArgs> arg);

	/**
	 * Use this method to add a handler for deleteTaskEvent
	 * 
	 * @param EventHandler
	 *            <TaskArgs> arg
	 */
	void addDeleteTaskEventHandler(EventHandler<TaskArgs> arg);

	/**
	 * Use this method to add a handler for the editToDoTaskEvent
	 * 
	 * @param EventHandler
	 *            <TaskArgs> arg
	 */
	void addEditToDoTaskEventHandler(EventHandler<TaskArgs> arg);

	/**
	 * Use this method to add a handler for the selectSprintEvent
	 * 
	 * @param EventHandler
	 *            <SprintArgs> arg
	 */
	void addSelectSprintEventHandler(EventHandler<SprintArgs> arg);

	/**
	 * Use this method to add a handler for the editInProgressTaskEvent
	 * 
	 * @param EventHandler
	 *            <TaskArgs> arg
	 */
	void addEditInProgressTaskEventHandler(EventHandler<TaskArgs> arg);

	/**
	 * Use this method to add a handler for the detailsFinishTaskEvent
	 * 
	 * @param EventHandler
	 *            <TaskArgs> arg
	 */
	void addDetailsFinishTaskEventHandler(EventHandler<TaskArgs> arg);

}