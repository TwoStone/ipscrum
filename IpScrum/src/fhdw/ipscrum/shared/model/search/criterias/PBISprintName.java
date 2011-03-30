package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;

public class PBISprintName extends TextCriteria implements PBISprintCriteria {

	private static final long serialVersionUID = 4728904126758675324L;

	@SuppressWarnings("unused")
	private PBISprintName() {
		super();
	}

	public PBISprintName(final String value) {
		super(value);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		if (pbi.getSprint() != null) {
			return pbi.getSprint().getName().contains(this.getValue());
		} else {
			return false;
		}
	}

	@Override
	public void accept(ISearchExpressionVisitor visitor) {
		visitor.handlePBISprintName(this);
	}

}
