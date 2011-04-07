package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.RelationType;
import fhdw.ipscrum.shared.model.search.ISearchExpression;

/**
 */
public class RelationTypeSearchCriterionArgs extends EventArgs {
	private final ISearchExpression se;
	private final RelationType relationType;

	public RelationTypeSearchCriterionArgs(ISearchExpression se, RelationType relationType) {
		super();
		this.se = se;
		this.relationType = relationType;
	}

	public ISearchExpression getSe() {
		return se;
	}

	public RelationType getRelationType() {
		return relationType;
	}
}
