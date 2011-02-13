package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;

/**
 * Used for creating the main navigation bar of the application.
 */
public interface INavigationView extends IView{

	/**
	 * Method addProjectEventHandler.
	 * @param arg empty arguments
	 */
	public abstract void addProjectEventHandler(EventHandler<EventArgs> arg);
	/**
	 * Method addPersonEventHandler.
	 * @param arg empty arguments
	 */
	public abstract void addPersonEventHandler(EventHandler<EventArgs> arg);
	/**
	 * Method addTeamEventHandler.
	 * @param arg empty arguments
	 */
	public abstract void addTeamEventHandler(EventHandler<EventArgs> arg);
	/**
	 * Method addSaveEventHandler.
	 * @param arg empty arguments
	 */
	public abstract void addSaveEventHandler(EventHandler<EventArgs> arg);

	/**
	 * Method getContentPanel.
	 * @return main content panel.
	 */
	public abstract Panel getContentPanel();
}
