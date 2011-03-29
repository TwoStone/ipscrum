package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.model.PBIClosedState;
import fhdw.ipscrum.shared.model.ProductBacklogItem;

public class PBIClosedCriteria extends PBIStateCriteria {

	private static final long serialVersionUID = -5970024465646595600L;

	public PBIClosedCriteria() {
		super();
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		return (pbi.getState() instanceof PBIClosedState);
	}
}
