package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.RelationType;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;
import fhdw.ipscrum.shared.model.search.SearchCriteria;

public class PBIRelationTypeCriterion extends SearchCriteria implements
		PBIRelationCriterion {

	private static final long serialVersionUID = -5912511074023370924L;
	private RelationType value;

	@SuppressWarnings("unused")
	private PBIRelationTypeCriterion() {
		super();
	}

	public PBIRelationTypeCriterion(final RelationType value) {
		super();
		this.value = value;
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		for (final Relation current : pbi.getRelations()) {
			if (current.getType().equals(this.value)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void accept(ISearchExpressionVisitor visitor) {
		visitor.handlePBIRelationTypeCriteria(this);
	}

}
