package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.ReleaseArgs;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.interfaces.IRelease;

/**
 * @author Phase II / Gruppe I
 *
 */
public interface IReleaseView extends IView{

	/**
	 * Method addReleaseDetailsEventHandler
	 * Use this to register a handler for an event
	 * which shows the details of a release
	 * @param args from Type {@link EventHandler<ReleaseArgs>}
	 */
	public abstract void addReleaseDetailsEventHandler(EventHandler<ReleaseArgs> arg);

	/**
	 * Method addNewReleaseEventHandler
	 * Use this to register a handler for an event
	 * which creates a new {@link Release}
	 * @param args from Type {@link EventHandler<EventArgs>}
	 */
	public abstract void addNewReleaseEventHandler(EventHandler<EventArgs> arg);

	/**
	 * Method addDeleteReleaseEventHandler
	 * Use this to register a handler for an event
	 * which deletes a new {@link Release}
	 * @param args from Type {@link EventHandler<ReleaseArgs>}
	 */
	public abstract void addDeleteReleaseEventHandler(EventHandler<ReleaseArgs> args);

	/**
	 * Method addReleaseSelectedEventHandler
	 * @param args from Type {@link EventHandler<ReleaseArgs>}
	 */
	public abstract void addReleaseSelectedEventHandler(EventHandler<ReleaseArgs> args);

	/**
	 * Method addShowChartEventHandler
	 * @param args from Type {@link EventHandler<ReleaseArgs>}
	 */
	void addShowChartEventHandler(EventHandler<ReleaseArgs> arg);

	/**
	 * Method refreshReleases
	 * Refreshes releases
	 * @param args from Type {@link Vector<IRelease>}
	 */
	public abstract void refreshReleases(Vector<IRelease> release);




}