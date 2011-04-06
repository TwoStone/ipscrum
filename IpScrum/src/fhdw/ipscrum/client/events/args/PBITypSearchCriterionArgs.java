package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.search.SearchExpression;

/**
 */
public class PBITypSearchCriterionArgs extends EventArgs {
	private SearchExpression se;
	private int value;

	public PBITypSearchCriterionArgs(SearchExpression se, int value) {
		super();
		this.se = se;
		this.value = value;
	}

	public SearchExpression getSe() {
		return se;
	}

	public int getValue() {
		return value;
	}
}
