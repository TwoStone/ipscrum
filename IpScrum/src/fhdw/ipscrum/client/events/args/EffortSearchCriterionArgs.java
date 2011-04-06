package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.search.SearchExpression;

/**
 */
public class EffortSearchCriterionArgs extends EventArgs {
	private SearchExpression se;
	private Integer valueFrom;
	private Integer valueTo;

	public EffortSearchCriterionArgs(SearchExpression se, Integer valueFrom, Integer valueTo) {
		super();
		this.se = se;
		this.valueFrom = valueFrom;
		this.valueTo = valueTo;
	}

	public SearchExpression getSe() {
		return se;
	}

	public Integer getValueFrom() {
		return valueFrom;
	}

	public Integer getValueTo() {
		return valueTo;
	}

}
