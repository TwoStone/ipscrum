package fhdw.ipscrum.client.view.interfaces;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;

public interface ICreateTaskView extends IView{

	public String getName();

	public String getDescription();
	
	public Integer getEffort();

	void addSaveNewTaskEventHandler(EventHandler<EventArgs> arg);

	void addCancelNewTaskEventHandler(EventHandler<EventArgs> arg);

}