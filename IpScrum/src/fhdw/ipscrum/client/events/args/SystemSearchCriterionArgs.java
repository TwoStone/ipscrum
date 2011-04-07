package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.search.ISearchExpression;

/**
 */
public class SystemSearchCriterionArgs extends EventArgs {
	private ISearchExpression se;
	private System system;

	public SystemSearchCriterionArgs(ISearchExpression se, System system) {
		super();
		this.se = se;
		this.system = system;
	}

	public ISearchExpression getSe() {
		return se;
	}

	public System getSystem() {
		return system;
	}

}
