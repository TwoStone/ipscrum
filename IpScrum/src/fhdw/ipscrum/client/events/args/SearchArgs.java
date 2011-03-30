package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.search.Search;

public class SearchArgs extends EventArgs {
	private Search search;

	/**
	 * Constructor for SearchArgs.
	 * 
	 * @param search Search
	 */
	public SearchArgs(Search search) {
		super();
		this.search = search;
	}

	/**
	 * Method getSearch.
	 * 
	 * @return Search
	 */
	public Search getSearch() {
		return this.search;
	}
}
