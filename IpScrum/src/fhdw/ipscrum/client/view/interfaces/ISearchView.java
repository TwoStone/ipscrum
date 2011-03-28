package fhdw.ipscrum.client.view.interfaces;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.events.args.SearchArgs;

public interface ISearchView extends IView {
	/**
	 * Returns the event fired when the object shell be saved.
	 * 
	 * @return
	 */
	IEvent<EventArgs> getSave();

	/**
	 * Returns the event fired when the workflow shell be aborted.
	 * 
	 * @return
	 */
	IEvent<EventArgs> getAborted();

	/**
	 * Returns the event fired when a new search criterion should be added.
	 * 
	 * @return
	 */
	IEvent<EventArgs> getAddNewSearchCriterion();

	/**
	 * Returns the event fired when a logical operator should be added.
	 * 
	 * @return
	 */
	IEvent<EventArgs> getAddLogicalOperator();

	/**
	 * Returns the event fired when an existing search criterion should be added.
	 * 
	 * @return
	 */
	IEvent<SearchArgs> getAddExistingSearchCriterion();
}
