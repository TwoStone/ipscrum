package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.search.SearchExpression;

public class ReleaseSearchCriterionArgs extends EventArgs {
	private SearchExpression se;

	private Release release;

	public ReleaseSearchCriterionArgs(SearchExpression se, Release release) {
		super();
		this.se = se;
		this.release = release;
	}

	public SearchExpression getSe() {
		return se;
	}

	public Release getRelease() {
		return release;
	}

}
