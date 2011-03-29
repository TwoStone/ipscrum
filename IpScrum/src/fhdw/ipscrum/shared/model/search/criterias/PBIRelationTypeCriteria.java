package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.RelationType;

public class PBIRelationTypeCriteria implements PBIRelationCriteria {

	private final RelationType value;

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

}
