package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;

public class PBIReleaseCriteria extends TextCriteria {

	private static final long serialVersionUID = 8640411828423628507L;

	@SuppressWarnings("unused")
	private PBIReleaseCriteria() {
		super();
	}

	public PBIReleaseCriteria(final String value) {
		super(value);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		if (pbi.getSprint() != null && pbi.getSprint().getRelease() != null) {
			return pbi.getSprint().getRelease().getVersion()
					.contains(this.getValue());
		} else {
			return false;
		}
	}

	@Override
	public void accept(ISearchExpressionVisitor visitor) {
		visitor.handlePBIReleaseCriteria(this);
	}

}
