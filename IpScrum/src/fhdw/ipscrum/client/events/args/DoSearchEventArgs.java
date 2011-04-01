package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.search.Search;

/**
 * Event arguments for notify presenter to execute a search.
 * 
 * @author NW
 * 
 */
public class DoSearchEventArgs extends EventArgs {
	private final Search search;

	public DoSearchEventArgs(Search search) {
		super();
		this.search = search;
	}

	/**
	 * Get the search object to be executed.
	 * 
	 * @return
	 */
	public Search getSearch() {
		return search;
	}

}
