package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.search.SearchExpression;

public class CreateLogicalOperatorArgs extends EventArgs {
	private int value;
	private SearchExpression se;

	/**
	 * Constructor for SearchArgs.
	 * 
	 * @param search Search
	 */
	public CreateLogicalOperatorArgs(int value, SearchExpression se) {
		super();
		this.value = value;
		this.se = se;
	}

	/**
	 * Method getSearch.
	 * 
	 * @return Search
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * @return the se
	 */
	public SearchExpression getSearchExpression() {
		return se;
	}
}
