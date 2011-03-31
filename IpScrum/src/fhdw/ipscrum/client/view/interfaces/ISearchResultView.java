/**
 * 
 */
package fhdw.ipscrum.client.view.interfaces;

import java.util.Collection;

import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.ShowTicketEventArgs;
import fhdw.ipscrum.shared.model.ProductBacklogItem;

/**
 * Interface for view classes for presenting search results.
 * @author NW
 *
 */
public interface ISearchResultView extends IView {
	
	/**
	 * Sets the ticket that should be displayed.
	 * @param results
	 */
	void setSearchResult(Collection<ProductBacklogItem> results);
	
	/**
	 * Registers handler to the ShowTicketEvent
	 * Event is raised, when user wants to see details for a ticket.
	 * @param handler
	 */
	void registerShowTicket(EventHandler<ShowTicketEventArgs> handler);
}
