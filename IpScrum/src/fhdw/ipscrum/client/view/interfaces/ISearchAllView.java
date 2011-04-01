package fhdw.ipscrum.client.view.interfaces;

import java.util.Collection;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.DoScruumleSearchEventArgs;
import fhdw.ipscrum.client.events.args.SearchEventArgs;
import fhdw.ipscrum.shared.model.search.Search;

public interface ISearchAllView extends IView {

	/**
	 * Registers handler to get notified if the user wants to execute a saved
	 * search.
	 * 
	 * @param handler
	 */
	void registerDoSavedSearch(EventHandler<SearchEventArgs> handler);

	/**
	 * Registers handler to get notified if the user wants to edit a saved
	 * search.
	 * 
	 * @param handler
	 */
	void registerDoEditSearch(EventHandler<SearchEventArgs> handler);

	/**
	 * Registers handler to get notified if the user wants to delete a saved
	 * search.
	 * 
	 * @param handler
	 */
	void registerDoDeleteSearch(EventHandler<SearchEventArgs> handler);

	/**
	 * Registers handler to get notified if the user wants to do detailed
	 * search.
	 * 
	 * @param handler
	 */
	void registerDetailedSearch(EventHandler<EventArgs> handler);

	/**
	 * Registers handler to get notified if the user wants to execute a
	 * "scruumle" search.
	 * 
	 * @param handler
	 */
	void registerDoScruumleSearch(
			EventHandler<DoScruumleSearchEventArgs> handler);

	/**
	 * Sets the saved searches, that should be displayed.
	 * 
	 * @param searches
	 */
	void setSavedSeaches(Collection<Search> searches);

	/**
	 * Displays the search results.
	 * 
	 * @param view
	 */
	void displaySearchResults(ISearchResultView view);

	/**
	 * Hide the search results.
	 */
	void hideSearchResults();

}
