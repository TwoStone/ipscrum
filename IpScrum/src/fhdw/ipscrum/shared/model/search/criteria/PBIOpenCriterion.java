package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.PBIClosedState;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;

public class PBIOpenCriterion extends PBIStateCriterion {

	private static final long serialVersionUID = 6471312251190645567L;

	public PBIOpenCriterion() {
		super();
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		return (pbi.getState() instanceof PBIClosedState);
	}

	@Override
	public void accept(ISearchExpressionVisitor visitor) {
		visitor.handlePBIOpenCriteria(this);
	}
}
