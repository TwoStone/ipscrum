package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.model.ProductBacklogItem;

public class PBISprintName extends TextCriteria implements PBISprintCriteria {

	public PBISprintName(final String value) {
		super(value);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		if (pbi.getSprint() != null) {
			return pbi.getSprint().getName().contains(this.getValue());
		} else {
			return false;
		}
	}

}
