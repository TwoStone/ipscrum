package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.SearchCriteria;

public class PBIDescriptionCriteria extends TextCriteria implements
		SearchCriteria {

	public PBIDescriptionCriteria(final String value) {
		super(value);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		if (pbi.getDescription() != null) {
			return pbi.getDescription().contains(this.getValue());
		} else {
			return false;
		}
	}
}
