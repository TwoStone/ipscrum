package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.search.SearchExpression;

public class ReleaseSearchCriterionArgs extends EventArgs {
	private SearchExpression se;

	private IRelease release;

	public ReleaseSearchCriterionArgs(SearchExpression se, IRelease release) {
		super();
		this.se = se;
		this.release = release;
	}

	public SearchExpression getSe() {
		return se;
	}

	public IRelease getRelease() {
		return release;
	}

}
