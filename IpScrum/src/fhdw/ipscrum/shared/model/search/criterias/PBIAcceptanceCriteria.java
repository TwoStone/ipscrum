package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.model.AcceptanceCriterion;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;

public class PBIAcceptanceCriteria extends TextCriteria {

	private static final long serialVersionUID = -2292898956935498177L;

	@SuppressWarnings("unused")
	private PBIAcceptanceCriteria() {
		super();
	}

	public PBIAcceptanceCriteria(final String value) {
		super(value);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		for (final AcceptanceCriterion current : pbi.getAcceptanceCriteria()) {
			if (current.getContent().contains(this.getValue())) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void accept(ISearchExpressionVisitor visitor) {
		visitor.handlePBIAcceptanceCriteria(this);
	}

}
