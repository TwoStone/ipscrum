package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.model.PBIClosedState;
import fhdw.ipscrum.shared.model.ProductBacklogItem;

public class PBIOpenCriteria extends PBIStateCriteria {

	private static final long serialVersionUID = 6471312251190645567L;

	public PBIOpenCriteria() {
		super();
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		return (pbi.getState() instanceof PBIClosedState);
	}
}
