package fhdw.ipscrum.client.view.interfaces;

import java.util.Collection;

import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.DoScruumleSearchEventArgs;
import fhdw.ipscrum.client.events.args.DoSearchEventArgs;
import fhdw.ipscrum.shared.model.search.Search;

public interface ISearchAllView extends IView {

	/**
	 * Register handler to get notified if the user wants to execute a saved
	 * search.
	 * 
	 * @param handler
	 */
	void registerDoSavedSearch(EventHandler<DoSearchEventArgs> handler);

	/**
	 * Register handler to get notified if the user wants to execute a
	 * "scruumle" search.
	 * 
	 * @param handler
	 */
	void registerDoScruumleSearch(EventHandler<DoScruumleSearchEventArgs> handler);

	/**
	 * Set the saved searches, that should be displayed.
	 * 
	 * @param searches
	 */
	void setSavedSeaches(Collection<Search> searches);

	/**
	 * Display the search results.
	 * 
	 * @param view
	 */
	void displaySearchResults(ISearchResultView view);

	/**
	 * Hide the search results.
	 */
	void hideSearchResults();

}
