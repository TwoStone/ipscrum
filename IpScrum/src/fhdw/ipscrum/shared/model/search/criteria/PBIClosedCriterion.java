package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.PBIClosedState;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;
import fhdw.ipscrum.shared.model.search.Operator;

/**
 * Represents the criterion for PBI Closed-State
 */
public class PBIClosedCriterion extends PBIStateCriterion {

	private static final long serialVersionUID = -5970024465646595600L;

	/**
	 * See {@link PBIStateCriterion}
	 */
	@SuppressWarnings("unused")
	private PBIClosedCriterion() {
		super();
	}

	public PBIClosedCriterion(final Operator parent) {
		super(parent);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		return (pbi.getState() instanceof PBIClosedState);
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handlePBIClosedCriteria(this);
	}

	@Override
	public String toString() {
		return "PBI geschlossen";
	}
}
