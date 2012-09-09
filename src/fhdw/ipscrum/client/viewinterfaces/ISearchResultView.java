/**
 * 
 */
package fhdw.ipscrum.client.viewinterfaces;

import java.util.List;

import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * Interface for view classes for presenting search results.
 * 
 * @author HE
 * 
 */
public interface ISearchResultView extends IView {

	/**
	 * Sets the ticket that should be displayed.
	 * 
	 * @param results
	 *            are the current searchResults
	 */
	void setSearchResult(List<Ticket> results);

	/**
	 * Represents the Event to handle the move to the detail view.
	 * 
	 * @param handler
	 *            needed to handle the event, which knows the ticket
	 */
	void registerDetailHandler(EventHandler<TypedEventArg<Ticket>> handler);

}
