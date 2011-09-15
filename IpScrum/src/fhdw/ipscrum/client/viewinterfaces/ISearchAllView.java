package fhdw.ipscrum.client.viewinterfaces;

import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.eventargs.DoScruumleSearchEventArgs;

/**
 * Interface for the general gui for the "scruumle" search.
 */
public interface ISearchAllView extends IView {

	/**
	 * Registers handler to get notified if the user wants to execute a "scruumle" search.
	 * 
	 * @param handler
	 *            the handler that will get notified if the event occurred
	 */
	void registerDoScruumleSearch(EventHandler<DoScruumleSearchEventArgs> handler);

}
