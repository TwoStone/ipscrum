package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;
import fhdw.ipscrum.shared.model.search.SearchCriteria;

/**
 * Represents the search criterion for the last editor of a PBI.
 * 
 */
public class PBILastEditorCriterion extends SearchCriteria {

	private static final long serialVersionUID = -7842513428666320043L;
	private IPerson person;

	@SuppressWarnings("unused")
	private PBILastEditorCriterion() {
		super();
	}

	public PBILastEditorCriterion(final IPerson person) {
		super();
		this.person = person;
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		if (pbi.getLastEditor() != null) {
			return pbi.getLastEditor().equals(this.person);
		}
		return false;
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handlePBILastEditorCriteria(this);
	}

	@Override
	public String toString() {
		return "Letzer Bearbeiter [" + this.person + "]";
	}

	public IPerson getPerson() {
		return this.person;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.person == null) ? 0 : this.person.hashCode());
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
		final PBILastEditorCriterion other = (PBILastEditorCriterion) obj;
		if (this.person == null) {
			if (other.person != null) {
				return false;
			}
		} else if (!this.person.equals(other.person)) {
			return false;
		}
		return true;
	}
}
