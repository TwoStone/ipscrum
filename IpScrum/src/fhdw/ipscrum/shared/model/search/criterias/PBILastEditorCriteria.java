package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.search.SearchCriteria;

public class PBILastEditorCriteria implements SearchCriteria {

	private final IPerson person;

	public PBILastEditorCriteria(final IPerson person) {
		super();
		this.person = person;
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		return pbi.getLastEditor().equals(this.person);
	}

}
