package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.search.SearchExpression;

/**
 */
public class RelationSearchCriterionArgs extends EventArgs {
	private SearchExpression se;
	private Relation relation;

	public RelationSearchCriterionArgs(SearchExpression se, Relation relation) {
		super();
		this.se = se;
		this.relation = relation;
	}

	public SearchExpression getSe() {
		return se;
	}

	public Relation getRelation() {
		return relation;
	}

}
