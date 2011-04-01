package fhdw.ipscrum.client.view.interfaces;

import java.util.Collection;

import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SearchEventArgs;
import fhdw.ipscrum.shared.model.search.Search;

public interface ISearchesView extends IView {

	/**
	 * Registers handler to get notified if the user wants to execute a saved
	 * search.
	 * 
	 * @param handler
	 */
	public void registerDoSavedSearch(EventHandler<SearchEventArgs> handler);

	/**
	 * Registers handler to get notified if the user wants to edit a saved
	 * search.
	 * 
	 * @param handler
	 */
	public void registerDoEditSearch(EventHandler<SearchEventArgs> handler);

	/**
	 * Registers handler to get notified if the user wants to delete a saved
	 * search.
	 * 
	 * @param handler
	 */
	public void registerDoDeleteSearch(EventHandler<SearchEventArgs> handler);

	/**
	 * Sets the saved searches, that should be displayed.
	 * 
	 * @param searches
	 */
	public void setSavedSeaches(Collection<Search> searches);

}