package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.search.ISearchExpression;

/**
 */
public class LastEditorSearchCriterionArgs extends EventArgs {
	private ISearchExpression se;
	private IPerson person;

	public LastEditorSearchCriterionArgs(ISearchExpression se, IPerson person) {
		super();
		this.se = se;
		this.person = person;
	}

	public ISearchExpression getSe() {
		return se;
	}

	public IPerson getPerson() {
		return person;
	}
}
