package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;

/**
 * Represents the search criterion for special PBI relation destinations.
 */
public class PBIRelationDestCriterion extends TextCriterion implements
		PBIRelationCriterion {

	private static final long serialVersionUID = -3448309506611175360L;

	@SuppressWarnings("unused")
	private PBIRelationDestCriterion() {
		super();
	}

	public PBIRelationDestCriterion(final String value) {
		super(value);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		for (final Relation current : pbi.getRelations()) {
			if (this.nonSensitiveContains(current.getTarget().getName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handlePBIRelationDestCriteria(this);
	}

	@Override
	public String toString() {
		return "Relationsziel [" + this.getValue() + "]";
	}

}
