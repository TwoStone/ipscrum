package fhdw.ipscrum.client.viewinterfaces;

import java.util.Collection;

import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.eventargs.SearchEventArgs;
import fhdw.ipscrum.shared.model.metamodel.search.Search;

/**
 * Represents the Interface of the View which is related to this presenter. It's the interface to the ({@link}
 * fhdw.ipscrum.client.view.SearchesView).
 */
public interface ISearchesView extends IView {

	/**
	 * Registers handler to get notified if the user wants to execute a saved search.
	 * 
	 * @param handler
	 *            needed to handle the event, which also knows the Search
	 */
	void registerDoSavedSearch(EventHandler<SearchEventArgs> handler);

	/**
	 * Registers handler to get notified if the user wants to delete a saved search.
	 * 
	 * @param handler
	 *            needed to handle the event, which also knows the search
	 */
	void registerDoDeleteSearch(EventHandler<SearchEventArgs> handler);

	/**
	 * Sets the saved searches, that should be displayed.
	 * 
	 * @param searches
	 *            are all saved searches
	 */
	void setSavedSeaches(Collection<Search> searches);

}
