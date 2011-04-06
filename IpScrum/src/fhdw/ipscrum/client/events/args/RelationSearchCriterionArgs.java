package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.RelationType;
import fhdw.ipscrum.shared.model.search.SearchExpression;

/**
 */
public class RelationSearchCriterionArgs extends EventArgs {
	private SearchExpression se;
	private RelationType relationType;
	private String relationDesc;

	public RelationSearchCriterionArgs(SearchExpression se, RelationType relationType, String relationDesc) {
		super();
		this.se = se;
		this.relationType = relationType;
		this.relationDesc = relationDesc;
	}

	public SearchExpression getSe() {
		return se;
	}

	public RelationType getRelationType() {
		return relationType;
	}

	public String getRelationDesc() {
		return relationDesc;
	}

}
