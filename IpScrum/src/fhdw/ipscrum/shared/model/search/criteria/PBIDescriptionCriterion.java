package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;

/**
 * Represents the criterion for PBI description
 */
public class PBIDescriptionCriterion extends TextCriterion {

	private static final long serialVersionUID = 1888756291989585658L;

	@SuppressWarnings("unused")
	private PBIDescriptionCriterion() {
		super();
	}

	public PBIDescriptionCriterion(final String value) {
		super(value);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		if (pbi.getDescription() != null) {
			return this.nonSensitiveContains(pbi.getDescription());
		} else {
			return false;
		}
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handlePBIDescriptionCriteria(this);
	}

	@Override
	public String toString() {
		return "PBI Beschreibung [" + this.getValue() + "]";
	}
}
