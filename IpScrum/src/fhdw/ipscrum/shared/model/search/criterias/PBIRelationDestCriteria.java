package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Relation;

public class PBIRelationDestCriteria extends TextCriteria implements
		PBIRelationCriteria {

	private static final long serialVersionUID = -3448309506611175360L;

	@SuppressWarnings("unused")
	private PBIRelationDestCriteria() {
		super();
	}

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
