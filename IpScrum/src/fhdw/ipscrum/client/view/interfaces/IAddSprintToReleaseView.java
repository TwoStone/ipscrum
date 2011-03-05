package fhdw.ipscrum.client.view.interfaces;

import java.util.List;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

/**
 * @author Phase II / Gruppe I
 * 
 */
public interface IAddSprintToReleaseView extends IView {

	/**
	 * Method addCancelAddSprintEventHandler Use this to register a handler for
	 * an event which cancels the addition of a {@Sprint}
	 * 
	 * @param args
	 *            from Type {@link EventHandler<EventArgs>}
	 */
	public abstract void addCancelAddSprintViewEventHandler(
			EventHandler<EventArgs> arg);

	/**
	 * Method addSaveSprintsEventHandler Use this to register a handler for an
	 * event which saves sprints
	 * 
	 * @param args
	 *            from Type {@link EventHandler<SprintArgs>}
	 */
	public abstract void addSaveSprintsEventHandler(EventHandler<SprintArgs> arg);

	/**
	 * Method getBtnAbort Returns AbortButton
	 * 
	 * @return Button
	 */
	public abstract Button getBtnAbort();

	/**
	 * Method getBtnSave Returns SaveButton
	 * 
	 * @return Button
	 */
	public abstract Button getBtnSave();

	/**
	 * Method getLblRelease Returns ReleaseLabel
	 * 
	 * @return Label
	 */
	public abstract Label getLblRelease();

	/**
	 * Method refreshSprints Use this to register a handler for an event which
	 * refreshes sprints
	 * 
	 * @param args
	 *            from Type {@link Vector<ISprint>}
	 */
	public abstract void refreshSprints(List<ISprint> sprints);

}