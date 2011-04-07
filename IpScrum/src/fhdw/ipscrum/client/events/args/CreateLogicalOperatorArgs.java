package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.search.ISearchExpression;

public class CreateLogicalOperatorArgs extends EventArgs {
	private int value;
	private ISearchExpression se;

	/**
	 * Constructor for SearchArgs.
	 * 
	 * @param search Search
	 */
	public CreateLogicalOperatorArgs(int value, ISearchExpression se) {
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
	public ISearchExpression getSearchExpression() {
		return se;
	}
}
