package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.search.ISearchExpression;

/**
 */
public class PBITypSearchCriterionArgs extends EventArgs {
	private final ISearchExpression se;
	private final int value;

	public PBITypSearchCriterionArgs(ISearchExpression se, int value) {
		super();
		this.se = se;
		this.value = value;
	}

	public ISearchExpression getSe() {
		return this.se;
	}

	public int getValue() {
		return this.value;
	}
}
