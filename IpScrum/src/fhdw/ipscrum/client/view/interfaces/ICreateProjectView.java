package fhdw.ipscrum.client.view.interfaces;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;

/**
 * @author Manu
 *
 */
public interface ICreateProjectView extends IView{

	
	/**
	 * Method addSaveProjectHandler
	 * Use this to register a handler for a new project event
	 * @param args from Type {@link EventHandler<EventArgs>}
	 */
	public abstract void addSaveProjectHandler(EventHandler<EventArgs> args);
	
	/**
	 * Method getProjectName
	 * Returns the name of the project
	 * @return String
	 */
	public abstract String getProjectName();
	
	
	/**
	 * Method setProjectName
	 * @param name String
	 */
	public abstract void setProjectName(String name);
	
	
	/**
	 * Method addCancelCreateProjectHandler
	 * @param args EventHandler<EventArgs>
	 */
	public abstract void addCancelCreateProjectHandler(EventHandler<EventArgs> args);
	
}