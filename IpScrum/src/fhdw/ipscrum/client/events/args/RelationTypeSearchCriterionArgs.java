package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.RelationType;
import fhdw.ipscrum.shared.model.search.SearchExpression;

/**
 */
public class RelationTypeSearchCriterionArgs extends EventArgs {
	private final SearchExpression se;
	private final RelationType relationType;

	public RelationTypeSearchCriterionArgs(SearchExpression se, RelationType relationType) {
		super();
		this.se = se;
		this.relationType = relationType;
	}

	public SearchExpression getSe() {
		return se;
	}

	public RelationType getRelationType() {
		return relationType;
	}
}
