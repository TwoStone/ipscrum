package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.search.SearchExpression;

/**
 */
public class EffortSearchCriterionArgs extends EventArgs {
	private SearchExpression se;
	private int valueFrom;
	private int valueTo;

	public EffortSearchCriterionArgs(SearchExpression se, int valueFrom, int valueTo) {
		super();
		this.se = se;
		this.valueFrom = valueFrom;
		this.valueTo = valueTo;
	}

	public SearchExpression getSe() {
		return se;
	}

	public int getValueFrom() {
		return valueFrom;
	}

	public int getValueTo() {
		return valueTo;
	}

}
