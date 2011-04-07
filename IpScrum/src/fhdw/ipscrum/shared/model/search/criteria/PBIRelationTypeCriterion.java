package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.RelationType;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;
import fhdw.ipscrum.shared.model.search.SearchCriteria;

/**
 * Represents the search criterion for special PBI relation types.
 */
public class PBIRelationTypeCriterion extends SearchCriteria implements
		PBIRelationCriterion {

	private static final long serialVersionUID = -5912511074023370924L;
	private RelationType value;

	@SuppressWarnings("unused")
	private PBIRelationTypeCriterion() {
		super();
	}

	public PBIRelationTypeCriterion(final RelationType value) {
		super();
		this.value = value;
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		for (final Relation current : pbi.getRelations()) {
			if (current.getType().equals(this.value)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handlePBIRelationTypeCriteria(this);
	}

	@Override
	public String toString() {
		return "Relationstyp [" + this.value + "]";
	}

	public RelationType getValue() {
		return this.value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.value == null) ? 0 : this.value.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final PBIRelationTypeCriterion other = (PBIRelationTypeCriterion) obj;
		if (this.value == null) {
			if (other.value != null) {
				return false;
			}
		} else if (!this.value.equals(other.value)) {
			return false;
		}
		return true;
	}
}
