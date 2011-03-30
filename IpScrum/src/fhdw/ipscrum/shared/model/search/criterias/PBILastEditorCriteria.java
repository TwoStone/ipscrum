package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;
import fhdw.ipscrum.shared.model.search.SearchCriteria;

public class PBILastEditorCriteria extends SearchCriteria {

	private static final long serialVersionUID = -7842513428666320043L;
	private IPerson person;

	@SuppressWarnings("unused")
	private PBILastEditorCriteria() {
		super();
	}

	public PBILastEditorCriteria(final IPerson person) {
		super();
		this.person = person;
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		return pbi.getLastEditor().equals(this.person);
	}

	@Override
	public void accept(ISearchExpressionVisitor visitor) {
		visitor.handlePBILastEditorCriteria(this);
	}

}
