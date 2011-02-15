package fhdw.ipscrum.client.view.interfaces;

import java.util.List;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.shared.exceptions.NothingSelectedException;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.RelationType;

public interface ICreateRelationView extends IView {

	/**
	 * Returns the event fired, when the workflow shell be aborted.
	 * 
	 * @return
	 */
	IEvent<EventArgs> getAbort();

	/**
	 * Returns the event fired, when the a new type shell be created.
	 * 
	 * @return
	 */
	IEvent<EventArgs> getCreateNewType();

	/**
	 * Returns the event fired when the current object should be saved.
	 * 
	 * @return
	 */
	IEvent<EventArgs> getSave();

	/**
	 * Returns the selected feature, that should be target of the relation.
	 * 
	 * @return
	 * @throws NothingSelectedException
	 *             Is thrown if nothing is selected.
	 */
	Feature getSelectedTarget() throws NothingSelectedException;

	/**
	 * Returns the currently selected type.
	 * 
	 * @return
	 * @throws NothingSelectedException
	 *             Is thrown if nothing is selected.
	 */
	RelationType getSelectedType() throws NothingSelectedException;

	/**
	 * Displays the feature from where the relation should start.
	 * 
	 * @param feature
	 */
	void setOwningFeature(Feature feature);

	/**
	 * Displays a list of {@link RelationType} objects.
	 * 
	 * @param types
	 */
	void setRelationTypes(List<RelationType> types);

	/**
	 * Displays a list of {@link Feature} objects, that can be targets of the
	 * relation.
	 * 
	 * @param features
	 */
	void setTargetFeatures(List<Feature> features);
}
