package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.DoScruumleSearchEventArgs;

public interface ISearchAllView extends IView {

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

	void registerShowSearches(EventHandler<EventArgs> handler);

	/**
	 * Returns the panel, where subordinated view will be displayed.
	 * 
	 * @return
	 */
	Panel getDisplayPanel();

}
