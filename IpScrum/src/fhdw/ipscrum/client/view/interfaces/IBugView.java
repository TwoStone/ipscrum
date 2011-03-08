package fhdw.ipscrum.client.view.interfaces;

import java.util.List;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.shared.exceptions.NothingSelectedException;
import fhdw.ipscrum.shared.model.interfaces.IRelease;

public interface IBugView {

	/**
	 * Returns the currently selected {@link IRelease} object.
	 * 
	 * @return
	 * @throws NothingSelectedException Is thrown if nothing is selected.
	 */
	IRelease getSelectedVersion() throws NothingSelectedException;

	/**
	 * Displays a list of {@link IRelease} objects in the gui and selects the defined {@link IRelease} object.
	 * 
	 * @param release {@link IRelease} objects to display.
	 * @param selected {@link IRelease} object to preselect. Object <b>must</b> be included in the sprints list, otherwise it will be added.
	 */
	void setVersion(List<IRelease> releases, IRelease selected);

	/**
	 * Returns the event that is fired, when the selected systems should be change.
	 * 
	 * @return
	 */
	IEvent<EventArgs> getChangeSystems();

}
