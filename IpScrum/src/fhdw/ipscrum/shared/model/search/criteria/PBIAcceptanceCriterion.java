package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.AcceptanceCriterion;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;
import fhdw.ipscrum.shared.model.search.Operator;

/**
 * Represents the criterion for a acceptance criterion
 */
public class PBIAcceptanceCriterion extends TextCriterion {

	@Override
	public String toString() {
		return "Akzeptanzkriterium [" + this.getValue() + "]";
	}

	private static final long serialVersionUID = -2292898956935498177L;

	@SuppressWarnings("unused")
	/**
	 * Constructor used by GWT Serialization.
	 */
	private PBIAcceptanceCriterion() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param value
	 *            AcceptanceCriterion search content
	 */
	public PBIAcceptanceCriterion(final String value, final Operator parent) {
		super(value, parent);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		for (final AcceptanceCriterion current : pbi.getAcceptanceCriteria()) {
			if (this.nonSensitiveContains(current.getContent())) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handlePBIAcceptanceCriteria(this);
	}

}
