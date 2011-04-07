package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.search.ISearchExpression;

public class ReleaseSearchCriterionArgs extends EventArgs {
	private ISearchExpression se;

	private IRelease release;

	public ReleaseSearchCriterionArgs(ISearchExpression se, IRelease release) {
		super();
		this.se = se;
		this.release = release;
	}

	public ISearchExpression getSe() {
		return se;
	}

	public IRelease getRelease() {
		return release;
	}

}
