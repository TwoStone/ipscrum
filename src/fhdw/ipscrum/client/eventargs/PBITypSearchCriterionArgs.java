package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.metamodel.search.ISearchExpression;

/**
 * represents an event argument which knows the PBI type search criterion.
 */
public class PBITypSearchCriterionArgs extends EventArgs {
	/**
	 * represents the search expression attached to the event argument.
	 */
	private final ISearchExpression se;
	/**
	 * represents the value attached to the event argument.
	 */
	private final int value;

	/**
	 * constructor of the PBITypeSearchCriterionArgs.
	 * 
	 * @param se
	 *            is the related search expression
	 * @param value
	 *            is the related value
	 */
	public PBITypSearchCriterionArgs(final ISearchExpression se, final int value) {
		super();
		this.se = se;
		this.value = value;
	}

	/**
	 * getter of the search expression.
	 * 
	 * @return the search expression
	 */
	public ISearchExpression getSe() {
		return this.se;
	}

	/**
	 * getter of the value.
	 * 
	 * @return the value
	 */
	public int getValue() {
		return this.value;
	}
}
