package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.search.SearchExpression;

/**
 */
public class LastEditorSearchCriterionArgs extends EventArgs {
	private SearchExpression se;
	private IPerson person;

	public LastEditorSearchCriterionArgs(SearchExpression se, IPerson person) {
		super();
		this.se = se;
		this.person = person;
	}

	public SearchExpression getSe() {
		return se;
	}

	public IPerson getPerson() {
		return person;
	}
}
