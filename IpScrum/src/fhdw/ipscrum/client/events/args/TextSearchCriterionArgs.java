package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.search.ISearchExpression;

/**
 */
public class TextSearchCriterionArgs extends EventArgs {
	private ISearchExpression se;
	private String string;
	private int value;

	/**
	 * Constructor for TextSearchCriteriaArgs.
	 * 
	 * @param string String
	 * @param value int
	 */
	public TextSearchCriterionArgs(String string, ISearchExpression se, int value) {
		super();
		this.string = string;
		this.value = value;
		this.se = se;
	}

	/**
	 * Method getString.
	 * 
	 * @return String
	 */
	public String getString() {
		return this.string;
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
