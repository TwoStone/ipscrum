package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.metamodel.search.ISearchExpression;

/**
 * represents an event argument which knows a value and a search expression.
 */
public class CreateLogicalOperatorArgs extends EventArgs {
	/**
	 * represents the attached value.
	 */
	private final int value;
	/**
	 * represents the attached search expression.
	 */
	private final ISearchExpression se;

	/**
	 * Constructor.
	 * 
	 * @param value
	 *            is the int
	 * @param se
	 *            is the search expression
	 */
	public CreateLogicalOperatorArgs(final int value, final ISearchExpression se) {
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
		return this.se;
	}
}
