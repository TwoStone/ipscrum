package fhdw.ipscrum.client.viewinterfaces;

import java.util.List;

import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.shared.model.nonMeta.Task;

/**
 * Represents the Interface of the View which is related to this presenter. It's the
 * interface to the ({@link} fhdw.ipscrum.client.view.ReleaseEditView).
 */
public interface ITaskboardView extends IView {

	/**
	 * getter of the selected element.
	 * 
	 * @return the currently selected task
	 */
	Task getSelectedElement();

	/**
	 * Represents the Event to handle the create of a new task.
	 * 
	 * @param handler
	 *            needed to handle the event
	 * @return the event which handles the create of the new task
	 */
	EventRegistration registerNewTaskEventHandler(DefaultEventHandler handler);

	/**
	 * Represents the Event to handle the edit of a task.
	 * 
	 * @param handler
	 *            needed to handle the event, which also knows the task
	 * @return the event which handles the edit of a task
	 */
	EventRegistration registerDetailsEventHandler(
			EventHandler<TypedEventArg<Task>> handler);

	/**
	 * displays the list of open tasks.
	 * 
	 * @param tasklist
	 *            are all open tasks
	 */
	void fillOpenTaskTable(List<Task> tasklist);

	/**
	 * displays the list of in progress tasks.
	 * 
	 * @param tasklist
	 *            are all in progress tasks
	 */
	void fillInProgressTaskTable(List<Task> tasklist);

	/**
	 * displays the list of done tasks.
	 * 
	 * @param tasklist
	 *            are all done tasks
	 */
	void fillDoneTaskTable(List<Task> tasklist);

}
