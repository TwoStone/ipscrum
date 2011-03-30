package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.RelationType;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;
import fhdw.ipscrum.shared.model.search.SearchCriteria;

public class PBIRelationTypeCriteria extends SearchCriteria implements
		PBIRelationCriteria {

	private static final long serialVersionUID = -5912511074023370924L;
	private RelationType value;

	@SuppressWarnings("unused")
	private PBIRelationTypeCriteria() {
		super();
	}

	public PBIRelationTypeCriteria(final RelationType value) {
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
