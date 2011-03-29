package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.SearchCriteria;

public class PBIReleaseCriteria extends TextCriteria implements SearchCriteria {

	public PBIReleaseCriteria(final String value) {
		super(value);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		if (pbi.getSprint() != null && pbi.getSprint().getRelease() != null) {
			return pbi.getSprint().getRelease().getVersion().contains(
					this.getValue());
		} else {
			return false;
		}
	}

}
