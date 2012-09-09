package fhdw.ipscrum.client.viewinterfaces;

import java.util.List;

import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.view.RevisionControlView.RevFilterArgs;
import fhdw.ipscrum.shared.infrastructure.Revision;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Person;

/**
 * Represents the Interface of the View which is related to this presenter. It's the interface to the ({@link}
 * fhdw.ipscrum.client.view.RevisionControlView).
 */
public interface IRevisionControlView extends IView {

	/**
	 * displays the revision table.
	 * 
	 * @param tableData
	 *            are all revisions in the revision table
	 * @param model
	 *            is the related model
	 */
	void updateRevisionTable(List<Revision> tableData, Model model);

	/**
	 * displays the list of editors.
	 * 
	 * @param editors
	 *            are all persons who edited something to create a revision
	 */
	void updateEditorList(List<Person> editors);

	/**
	 * setter of the reset of the filter.
	 * 
	 * @param enabled
	 *            is set true if the data is filtered
	 */
	void setFilterResetButtonStatus(boolean enabled);

	/**
	 * Represents the Event to handle the filter of the revisions.
	 * 
	 * @param handler
	 *            needed to handle the event, which knows the arguments to filter
	 * @return the event which handles the filter of the revisions
	 */
	EventRegistration registerFilterEventHandler(EventHandler<RevFilterArgs> handler);

	/**
	 * Represents the Event to handle the remove of the filter of the revisions.
	 * 
	 * @param handler
	 *            needed to handle the event
	 * @return the event which handles the remove of the filter of the revisions
	 */
	EventRegistration registerRemoveFilterEventHandler(DefaultEventHandler handler);

	/**
	 * Represents the Event to handle the rewind to an old revision.
	 * 
	 * @param handler
	 *            needed to handle the event, which knows the revision to rewind to
	 * @return the event which handles the rewind to an old revision
	 */
	EventRegistration registerRewindEventHandler(EventHandler<TypedEventArg<Revision>> handler);

}
