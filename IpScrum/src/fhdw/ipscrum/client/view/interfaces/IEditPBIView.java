package fhdw.ipscrum.client.view.interfaces;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.shared.model.Effort;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IProductBacklogItemState;

public interface IEditPBIView {

	/**
	 * Returns the currently entered complexity.
	 * 
	 * @return
	 */
	Integer getComplexity();

	/**
	 * Displays the complexity in the user interface.
	 * 
	 * @param effort
	 */
	void setComplexity(Effort effort);

	/**
	 * Displays the last editor in the user interface.
	 * 
	 * @param editor
	 */
	void setLastEditor(IPerson editor);

	/**
	 * Sets the state of the feature.
	 * 
	 * @param state
	 */
	void setState(IProductBacklogItemState state);

	/**
	 * Returns the event, that is fired, when the feature state should be toggled.
	 * 
	 * @return
	 */
	IEvent<EventArgs> toggleFeatureState();

}
