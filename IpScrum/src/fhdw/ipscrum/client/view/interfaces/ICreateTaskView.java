package fhdw.ipscrum.client.view.interfaces;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;

public interface ICreateTaskView extends IView{


	/**
	 * @return a String with the name of a new task.
	 */
	public String getName();

	/**
	 * @return a String with the description of a new task.
	 */
	public String getDescription();

	/**
	 * @return a Integer with the plan effort (man-hours) of a new task.
	 */
	public Integer getEffortInput();

	/**
	 * Use this method to add a handler for saveNewTaskEvent
	 * @param EventHandler<EvenArgs> arg
	 */
	void addSaveNewTaskEventHandler(EventHandler<EventArgs> arg);

	/**
	 * Use this method to add a handler for cancelNewTaskEvent
	 * @param EventHandler<EventArgs> arg
	 */
	void addCancelNewTaskEventHandler(EventHandler<EventArgs> arg);

}