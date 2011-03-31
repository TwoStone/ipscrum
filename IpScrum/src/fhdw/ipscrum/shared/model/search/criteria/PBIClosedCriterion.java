package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.PBIClosedState;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;

/**
 * Represents the criterion for PBI Closed-State
 */
public class PBIClosedCriterion extends PBIStateCriterion {

	private static final long serialVersionUID = -5970024465646595600L;

	public PBIClosedCriterion() {
		super();
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		return (pbi.getState() instanceof PBIClosedState);
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handlePBIClosedCriteria(this);
	}

	@Override
	public String toString() {
		return "PBI Closed";
	}
}
