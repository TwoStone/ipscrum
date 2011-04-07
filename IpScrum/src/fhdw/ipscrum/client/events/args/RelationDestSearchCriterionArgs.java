package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.SearchExpression;

/**
 */
public class RelationDestSearchCriterionArgs extends EventArgs {
	private final SearchExpression se;
	private final ProductBacklogItem relationDest;

	public RelationDestSearchCriterionArgs(SearchExpression se, ProductBacklogItem relationDest) {
		super();
		this.se = se;
		this.relationDest = relationDest;
	}

	public SearchExpression getSe() {
		return se;
	}

	public ProductBacklogItem getRelationDest() {
		return relationDest;
	}

}
