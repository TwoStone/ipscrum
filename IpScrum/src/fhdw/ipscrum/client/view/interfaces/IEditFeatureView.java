package fhdw.ipscrum.client.view.interfaces;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.shared.model.interfaces.IFeatureState;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

public interface IEditFeatureView extends ICreateFeatureView {

	/**
	 * Returns the currently entered complexity.
	 * 
	 * @return
	 */
	Integer getComplexity();

	/**
	 * Displays the complexity in the user interface.
	 * 
	 * @param complexity
	 */
	void setComplexity(Integer complexity);

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
	void setState(IFeatureState state);

	/**
	 * Returns the event, that is fired, when the feature state should be
	 * toggled.
	 * 
	 * @return
	 */
	IEvent<EventArgs> toggleFeatureState();

}
