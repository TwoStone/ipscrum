package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;

/**
 */
public interface INavigationView extends IView{

	/**
	 * Method addProjectEventHandler.
	 * @param arg EventHandler<EventArgs>
	 */
	public abstract void addProjectEventHandler(EventHandler<EventArgs> arg);
	/**
	 * Method addPersonEventHandler.
	 * @param arg EventHandler<EventArgs>
	 */
	public abstract void addPersonEventHandler(EventHandler<EventArgs> arg);
	/**
	 * Method addTeamEventHandler.
	 * @param arg EventHandler<EventArgs>
	 */
	public abstract void addTeamEventHandler(EventHandler<EventArgs> arg);
	/**
	 * Method addSaveEventHandler.
	 * @param arg EventHandler<EventArgs>
	 */
	public abstract void addSaveEventHandler(EventHandler<EventArgs> arg);
	
	/**
	 * Method getContentPanel.
	 * @return Panel
	 */
	public abstract Panel getContentPanel();
}
