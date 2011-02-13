package fhdw.ipscrum.client.view.interfaces;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.shared.model.Project;


/**
 * @author Phase II / Gruppe I
 *
 */
public interface ICreateProjectView extends IView{

	
	/**
	 * Method addSaveProjectHandler
	 * Use this to register a handler for an event 
	 * which creates a new {@link Project)
	 * @param args from Type {@link EventHandler<EventArgs>}
	 */
	public abstract void addSaveProjectHandler(EventHandler<EventArgs> args);
	
	/**
	 * Method getProjectName
	 * Returns the name of the {@link Project}
	 * @return String
	 */
	public abstract String getProjectName();
	
	
	/**
	 * Method setProjectName
	 * Sets the name of the {@link Project}
	 * @param name String
	 */
	public abstract void setProjectName(String name);
	
	
	/**
	 * Method addCancelCreateProjectHandler
	 * Use this to register a handler for an event 
	 * which cancels the creation of a new {@link Project}
	 * @param args from Type {@link EventHandler<EventArgs>}
	 */
	public abstract void addCancelCreateProjectHandler(EventHandler<EventArgs> args);
	
}