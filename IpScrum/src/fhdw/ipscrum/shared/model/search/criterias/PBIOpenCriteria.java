package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.model.PBIClosedState;
import fhdw.ipscrum.shared.model.ProductBacklogItem;

public class PBIOpenCriteria extends PBIStateCriteria {

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		return (pbi.getState() instanceof PBIClosedState);
	}
}
