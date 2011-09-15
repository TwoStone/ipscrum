package fhdw.ipscrum.client.viewinterfaces;

import java.util.List;

import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;

/**
 * Represents the Interface of the View which is related to this presenter. It's the
 * interface to the ({@link} fhdw.ipscrum.client.view.ReleaseEditView).
 */
public interface IReleaseEditView extends IView {

	/**
	 * Represents the Event to handle the addition of sprints.
	 * 
	 * @param handler
	 *            needed to handle the event, which knows the sprint to assign
	 * @return the event which handles the addition of sprints
	 */
	EventRegistration registerAssignEventHandler(
			EventHandler<TypedEventArg<Sprint>> handler);

	/**
	 * Represents the Event to handle the remove of sprints.
	 * 
	 * @param handler
	 *            needed to handle the event, which also knows the sprint
	 * @return the event which handles the remove of the sprint
	 */
	EventRegistration registerRemoveEventHandler(
			EventHandler<TypedEventArg<Sprint>> handler);

	/**
	 * Represents the Event to handle the close.
	 * 
	 * @param handler
	 *            needed to handle the event
	 * @return the event which handles the close
	 */
	EventRegistration registerCloseEventHandler(DefaultEventHandler handler);

	/**
	 * getter of the selected sprint in the list of the assigned sprints.
	 * 
	 * @return the currently selected sprint
	 */
	Sprint getSelectedSprintAssignedSprints();

	/**
	 * getter of the selected sprint in the list of the available sprints.
	 * 
	 * @return the currently selected sprint
	 */
	Sprint getSelectedSprintAvailableSprints();

	/**
	 * displays the list of assigned sprints.
	 * 
	 * @param sprints
	 *            are all assigned sprints related to the release
	 */
	void updateAssignedSprintTable(List<Sprint> sprints);

	/**
	 * displays the list of all available sprints.
	 * 
	 * @param sprints
	 *            are all sprints in the project but not related to the release
	 */
	void updateAvailableSprintsTable(List<Sprint> sprints);

}
