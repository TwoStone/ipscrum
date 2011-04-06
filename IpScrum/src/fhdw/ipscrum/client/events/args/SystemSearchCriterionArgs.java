package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.search.SearchExpression;

/**
 */
public class SystemSearchCriterionArgs extends EventArgs {
	private SearchExpression se;
	private System system;

	public SystemSearchCriterionArgs(SearchExpression se, System system) {
		super();
		this.se = se;
		this.system = system;
	}

	public SearchExpression getSe() {
		return se;
	}

	public System getSystem() {
		return system;
	}

}
