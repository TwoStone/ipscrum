package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.PBIOpenState;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;
import fhdw.ipscrum.shared.model.search.Operator;

/**
 * Represents the criterion for PBI Open-State
 */
public class PBIOpenCriterion extends PBIStateCriterion {

	private static final long serialVersionUID = 6471312251190645567L;

	/**
	 * See {@link PBIStateCriterion}
	 */
	@SuppressWarnings("unused")
	private PBIOpenCriterion() {
		super();
	}

	public PBIOpenCriterion(final Operator parent) {
		super(parent);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		return (pbi.getState() instanceof PBIOpenState);
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handlePBIOpenCriteria(this);
	}

	@Override
	public String toString() {
		return "PBI offen";
	}
}
