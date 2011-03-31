package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;

public class PBISprintDescCriterion extends TextCriterion implements
		PBISprintCriterion {

	private static final long serialVersionUID = -4074891238354808621L;

	@SuppressWarnings("unused")
	private PBISprintDescCriterion() {
		super();
	}

	public PBISprintDescCriterion(final String value) {
		super(value);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		if (pbi.getSprint() != null) {
			return pbi.getSprint().getDescription().contains(this.getValue());
		} else {
			return false;
		}
	}

	@Override
	public void accept(ISearchExpressionVisitor visitor) {
		visitor.handlePBISprintDescCriteria(this);
	}

}
