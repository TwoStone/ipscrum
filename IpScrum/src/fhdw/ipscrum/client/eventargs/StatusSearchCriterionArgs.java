package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.metamodel.search.ISearchExpression;

/**
 * represents an event argument which knows a status search criterion.
 */
public class StatusSearchCriterionArgs extends EventArgs {
	/**
	 * represents the search expression related to the event argument.
	 */
	private final ISearchExpression se;
	/**
	 * represents the value related to the event argument.
	 */
	private final int value;

	/**
	 * Constructor for TextSearchCriteriaArgs.
	 * 
	 * @param se
	 *            the related search expression
	 * @param value
	 *            int
	 */
	public StatusSearchCriterionArgs(final ISearchExpression se, final int value) {
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
		return this.se;
	}
}
