package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.search.ISearchExpression;

/**
 */
public class StatusSearchCriterionArgs extends EventArgs {
	private ISearchExpression se;
	private int value;

	/**
	 * Constructor for TextSearchCriteriaArgs.
	 * 
	 * @param string String
	 * @param value int
	 */
	public StatusSearchCriterionArgs(ISearchExpression se, int value) {
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
	public ISearchExpression getSearchExpression() {
		return se;
	}
}
