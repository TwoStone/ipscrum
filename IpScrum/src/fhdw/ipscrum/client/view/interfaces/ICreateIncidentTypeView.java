package fhdw.ipscrum.client.view.interfaces;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;

/**
 * 
 * @author Phase IV - Group Reporting II 
 * 
 */
public interface ICreateIncidentTypeView extends IView {

	/**
	 * Returns the name
	 * 
	 * @return String
	 */
	String getName();
	
	/**
	 *
	 * Use this to register a handler for an event 
	 * which creates an {@link IncidentType)
	 * 
	 * @param args from Type {@link EventHandler<EventArgs>}
	 */
	public void addCreateTypeHandler(EventHandler<EventArgs> args);

	/**
	 *
	 * Use this to register a handler for an cancel event 
	 * 
	 * @param args from Type {@link EventHandler<EventArgs>}
	 */
	public void addCancelEventHandler(EventHandler<EventArgs> args);
	
}
