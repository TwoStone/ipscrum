package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.SearchCriteria;

public class PBINameCriteria extends TextCriteria implements SearchCriteria {

	public PBINameCriteria(final String name) {
		super(name);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		return pbi.getName().contains(this.getValue());
	}

}
