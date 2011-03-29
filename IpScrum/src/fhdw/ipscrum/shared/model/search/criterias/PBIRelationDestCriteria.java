package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Relation;

public class PBIRelationDestCriteria extends TextCriteria implements
		PBIRelationCriteria {

	public PBIRelationDestCriteria(final String value) {
		super(value);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		for (final Relation current : pbi.getRelations()) {
			if (current.getTarget().getName().contains(this.getValue())) {
				return true;
			}
		}
		return false;
	}
}
