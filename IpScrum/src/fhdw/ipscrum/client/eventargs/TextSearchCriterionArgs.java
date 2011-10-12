package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.metamodel.search.ISearchExpression;

/**
 * represents an event argument which knows a text criterion.
 */
public class TextSearchCriterionArgs extends EventArgs {
	/**
	 * represents search expression attached to the event argument.
	 */
	private final ISearchExpression se;
	/**
	 * represents a string attached to the event argument.
	 */
	private final String string;
	/**
	 * represents a value attached to the event argument.
	 */
	private final int value;

	/**
	 * Constructor for TextSearchCriteriaArgs.
	 * 
	 * @param string
	 *            String
	 * @param se
	 *            is the related search expression
	 * @param value
	 *            int
	 */
	public TextSearchCriterionArgs(final String string, final ISearchExpression se, final int value) {
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
		return this.se;
	}
}
