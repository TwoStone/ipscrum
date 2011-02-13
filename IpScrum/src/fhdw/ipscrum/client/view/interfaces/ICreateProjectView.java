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
	 * 
	 * @param args EventHandler<EventArgs>
	 */
	public abstract void addSaveProjectHandler(EventHandler<EventArgs> args);
	
	/**
	 * Method getProjectName
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