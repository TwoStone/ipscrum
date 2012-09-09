package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.metamodel.search.Search;

/**
 * Event arguments for notify presenter to execute a search.
 * 
 * @author NW
 * 
 */
public class SearchEventArgs extends EventArgs {
	/**
	 * represents the search attached to the event argument.
	 */
	private final Search search;

	/**
	 * constructor of the SearchEventArgs.
	 * 
	 * @param search
	 *            related to the argument
	 */
	public SearchEventArgs(final Search search) {
		super();
		this.search = search;
	}

	/**
	 * Get the search object to be executed.
	 * 
	 * @return the search
	 */
	public Search getSearch() {
		return this.search;
	}

}
