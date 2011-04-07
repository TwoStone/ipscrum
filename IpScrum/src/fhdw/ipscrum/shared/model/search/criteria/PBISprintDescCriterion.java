package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;
import fhdw.ipscrum.shared.model.search.Operator;

/**
 * Represents the search criterion for Sprint Description.
 */
public class PBISprintDescCriterion extends TextCriterion implements
		PBISprintCriterion {

	private static final long serialVersionUID = -4074891238354808621L;

	@SuppressWarnings("unused")
	private PBISprintDescCriterion() {
		super();
	}

	public PBISprintDescCriterion(final String value, final Operator parent) {
		super(value, parent);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		if (pbi.getSprint() != null) {
			return this.nonSensitiveContains(pbi.getSprint().getDescription());
		} else {
			return false;
		}
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handlePBISprintDescCriteria(this);
	}

	@Override
	public String toString() {
		return "Sprintbeschreibung [" + this.getValue() + "]";
	}
}
