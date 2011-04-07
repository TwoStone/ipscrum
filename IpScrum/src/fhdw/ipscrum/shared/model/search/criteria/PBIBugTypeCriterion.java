package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;

public class PBIBugTypeCriterion extends PBITypeCriterion {

	private static final long serialVersionUID = -8941619916073331140L;

	/**
	 * See {@link PBITypeCriterion}
	 */
	public PBIBugTypeCriterion() {
		super();
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handleBugTypeCriterion(this);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		return (pbi instanceof Bug);
	}

	@Override
	public String toString() {
		return "Typ Bug";
	}
}
