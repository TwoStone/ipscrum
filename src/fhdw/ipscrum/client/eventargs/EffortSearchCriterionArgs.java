package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.metamodel.search.ISearchExpression;

/**
 * represents an event argument which knows an effort search criterion.
 */
public class EffortSearchCriterionArgs extends EventArgs {
	/**
	 * represents the search expression attached to the event argument.
	 */
	private final ISearchExpression se;
	/**
	 * represents the from value.
	 */
	private final Integer valueFrom;
	/**
	 * represents the to value.
	 */
	private final Integer valueTo;

	/**
	 * constructor of the EffortSearchCriterionArgs.
	 * 
	 * @param se
	 *            is the search expression
	 * @param valueFrom
	 *            is the value which is less than the effort
	 * @param valueTo
	 *            is the value which is higer than the effort
	 */
	public EffortSearchCriterionArgs(final ISearchExpression se, final Integer valueFrom, final Integer valueTo) {
		super();
		this.se = se;
		this.valueFrom = valueFrom;
		this.valueTo = valueTo;
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
	 * getter of the from value.
	 * 
	 * @return the from value
	 */
	public Integer getValueFrom() {
		return this.valueFrom;
	}

	/**
	 * getter of the to value.
	 * 
	 * @return the to value
	 */
	public Integer getValueTo() {
		return this.valueTo;
	}

}
