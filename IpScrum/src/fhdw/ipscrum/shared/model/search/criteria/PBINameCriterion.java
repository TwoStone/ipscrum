package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;

public class PBINameCriterion extends TextCriterion {

	private static final long serialVersionUID = -8960703187309223147L;

	@SuppressWarnings("unused")
	private PBINameCriterion() {
		super();
	}

	public PBINameCriterion(final String name) {
		super(name);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		return pbi.getName().contains(this.getValue());
	}

	@Override
	public String toString() {
		return "PBIName ='" + this.getValue() + "'";
	}

	@Override
	public void accept(ISearchExpressionVisitor visitor) {
		visitor.handlePBINameCriteria(this);
	}
}
