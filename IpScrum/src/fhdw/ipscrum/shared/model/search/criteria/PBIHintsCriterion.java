package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.Hint;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;

/**
 * Represent the criterion for PBI hints.
 */
public class PBIHintsCriterion extends TextCriterion {

	private static final long serialVersionUID = -4043249402031393640L;

	public PBIHintsCriterion(final String value) {
		super(value);
	}

	@SuppressWarnings("unused")
	private PBIHintsCriterion() {
		super();
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		for (final Hint current : pbi.getHints()) {
			if (current.getContent().contains(this.getValue())) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handlePBIHintsCritera(this);
	}

	@Override
	public String toString() {
		return "PBI Hinweis [" + this.getValue() + "]";
	}

}
