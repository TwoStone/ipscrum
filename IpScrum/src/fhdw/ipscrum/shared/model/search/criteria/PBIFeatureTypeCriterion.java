package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;

public class PBIFeatureTypeCriterion extends PBITypeCriterion {

	private static final long serialVersionUID = 4509094401418234017L;

	/**
	 * See {@link PBITypeCriterion}
	 */
	public PBIFeatureTypeCriterion() {
		super();
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handleFeatureTypeCriterion(this);

	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		return (pbi instanceof Feature);
	}

	@Override
	public String toString() {
		return "Typ Feature";
	}
}
