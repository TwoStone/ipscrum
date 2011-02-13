package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.view.ReleaseDetailView;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

/**
 * @author Phase II / Gruppe I
 *
 */
public interface IReleaseDetailView extends IView{

	/**
	 * Method addAddSprintEventHandler
	 * Use this to register a handler for an event 
	 * which add a new {@link Sprint} 
	 * @param args from Type {@link EventHandler<EventArgs>}
	 */
	public abstract void addAddSprintEventHandler(EventHandler<EventArgs> arg);

	/**
	 * Method refreshSprints
	 * Refreshes Sprints 
	 * @param args from Type {@link Vector<ISprint>}
	 */
	public abstract void refreshSprints(Vector<ISprint> sprints);
	
	/**
	 * Method addDeleteSprintEventHandler
	 * Use this to register a handler for an event 
	 * which deletes a {@link Sprint} 
	 * @param args from Type {@link EventHandler<SprintArgs>}
	 */
	public void addDeleteSprintEventHandler(EventHandler<SprintArgs> arg);

	/**
	 * Method addCancelReleaseDetailViewHandler
	 * Use this to register a handler for an event 
	 * which cancels a {@link ReleaseDetailView} 
	 * @param args from Type {@link EventHandler<EventArgs>}
	 */
	public void addCancelReleaseDetailViewHandler(EventHandler<EventArgs> arg);

}