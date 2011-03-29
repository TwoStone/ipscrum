package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.model.ProductBacklogItem;

public class PBISprintDescCriteria extends TextCriteria implements
		PBISprintCriteria {

	public PBISprintDescCriteria(final String value) {
		super(value);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		if (pbi.getSprint() != null) {
			return pbi.getSprint().getDescription().contains(this.getValue());
		} else {
			return false;
		}
	}

}
