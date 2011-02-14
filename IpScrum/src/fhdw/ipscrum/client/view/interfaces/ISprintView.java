package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

/**
 * @author Phase II / Gruppe I
 *
 */
public interface ISprintView extends IView {

	//wird hier nicht benötigt! (siehe IReleaseView) Wird doch benötigt!!!!!
	public abstract void addNewSprintEventHandler(EventHandler<EventArgs> arg);

	/**
	 * Method addSprintDetailsEventHandler
	 * Use this to register a handler for an event 
	 * which shows the details of a {@link Sprint} 
	 * @param args from Type {@link EventHandler<SprintArgs>}
	 */
	void addSprintDetailsEventHandler(EventHandler<SprintArgs> arg);

	//wird hier nicht benötigt! (siehe IReleaseView) Wird auch benötigt!!!!!
	void addDeleteSprintEventHandler(
			EventHandler<SprintArgs> arg);

	/**
	 * Method refreshSprints
	 * Refreshes Sprints
	 * @param args from Type {@link Vector<ISprint>}
	 */
	void refreshSprints(Vector<ISprint> sprints);
	
}
