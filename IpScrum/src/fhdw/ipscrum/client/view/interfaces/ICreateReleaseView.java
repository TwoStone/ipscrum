package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.user.datepicker.client.DateBox;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.shared.model.Release;

/**
 * @author Phase II / Gruppe I
 *
 */
public interface ICreateReleaseView extends IView{

	/**
	 * Method addSaveVersionHandler
	 * Use this to register a handler for an event 
	 * which saves a new version 
	 * @param args from Type {@link EventHandler<EventArgs>}
	 */
	public abstract void addSaveVersionHandler(EventHandler<EventArgs> args);

	/**
	 * Method getReleaseVersion
	 * Returns the version of the {@link Release}
	 * @return String
	 */
	public abstract String getReleaseVersion();

	
	/**
	 * Method addCancelCreateReleaseHandler
	 * Use this to register a handler for an event 
	 * which cancels the creation of a new {@link Release}
	 * @param args from Type {@link EventHandler<EventArgs>}
	 */
	public abstract void addCancelCreateReleaseHandler(EventHandler<EventArgs> args);

	/**
	 * Method getDateBox
	 * Returns the DateBox
	 * @return DateBox
	 */
	public abstract DateBox getDateBox();

}