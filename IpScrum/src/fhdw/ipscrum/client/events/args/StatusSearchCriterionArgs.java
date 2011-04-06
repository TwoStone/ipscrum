package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.search.SearchExpression;

/**
 */
public class StatusSearchCriterionArgs extends EventArgs {
	private SearchExpression se;
	private int value;

	/**
	 * Constructor for TextSearchCriteriaArgs.
	 * 
	 * @param string String
	 * @param value int
	 */
	public StatusSearchCriterionArgs(SearchExpression se, int value) {
		super();
		this.value = value;
		this.se = se;
	}

	/**
	 * Method getValue.
	 * 
	 * @return int
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
