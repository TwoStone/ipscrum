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
		return pbi.getLastEditor().equals(this.person);
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handlePBILastEditorCriteria(this);
	}

	@Override
	public String toString() {
		return "Letzer Bearbeiter [" + this.person + "]";
	}
}
