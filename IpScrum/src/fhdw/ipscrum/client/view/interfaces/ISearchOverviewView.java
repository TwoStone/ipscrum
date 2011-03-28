package fhdw.ipscrum.client.view.interfaces;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.events.args.SearchArgs;

public interface ISearchOverviewView extends IView {

	/**
	 * Returns the event fired when a free text search should be done.
	 * 
	 * @return
	 */
	IEvent<EventArgs> getFreeTextSearch();

	/**
	 * Returns the event fired when a new search should be created.
	 * 
	 * @return
	 */
	IEvent<EventArgs> getCreateSearch();

	/**
	 * Returns the event fired when a search should be edited.
	 * 
	 * @return
	 */
	IEvent<SearchArgs> getEditSearch();

	/**
	 * Returns the event fired when a search should be deleted.
	 * 
	 * @return
	 */
	IEvent<SearchArgs> getDeleteSearch();
}
