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

	/**
	 * Method addNewSprintEventHandler
	 * Use this to register a handler for an event
	 * which creates a new {@link Sprint}
	 * @param args from Type {@link EventHandler<EventArgs>}
	 */
	public abstract void addNewSprintEventHandler(EventHandler<EventArgs> arg);

	/**
	 * Method addSprintDetailsEventHandler
	 * Use this to register a handler for an event
	 * which shows the details of a {@link Sprint}
	 * @param args from Type {@link EventHandler<SprintArgs>}
	 */
	void addSprintDetailsEventHandler(EventHandler<SprintArgs> arg);

	/**
	 * Method addDeleteSprintEventHandler
	 * Use this to register a handler for an event
	 * which deletes sprints
	 * @param args from Type {@link EventHandler<SprintArgs>}
	 */
	void addDeleteSprintEventHandler(
			EventHandler<SprintArgs> arg);

	/**
	 * Method refreshSprints
	 * Refreshes Sprints
	 * @param args from Type {@link Vector<ISprint>}
	 */
	void refreshSprints(Vector<ISprint> sprints);

	/**
	 * Method addShowChartEventHandler
	 * Use this to register a handler for an event which shows sprint-data in form of a burndown-chart.
	 * @param args {@link EventHandler<SprintArgs>}
	 */
	void addShowChartEventHandler(EventHandler<SprintArgs> arg);

}
