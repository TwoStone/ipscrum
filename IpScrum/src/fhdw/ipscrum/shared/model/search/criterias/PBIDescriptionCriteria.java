package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.SearchCriteria;

public class PBIDescriptionCriteria extends TextCriteria implements
		SearchCriteria {

	private static final long serialVersionUID = 1888756291989585658L;

	@SuppressWarnings("unused")
	private PBIDescriptionCriteria() {
		super();
	}

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
