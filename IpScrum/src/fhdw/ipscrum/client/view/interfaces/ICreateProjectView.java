package fhdw.ipscrum.client.view.interfaces;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;

public interface ICreateProjectView extends IView{

	public abstract void addSaveProjectHandler(EventHandler<EventArgs> args);
	public abstract String getProjectName();
	public abstract void setProjectName(String name);

}