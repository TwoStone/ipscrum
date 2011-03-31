package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;
import fhdw.ipscrum.shared.model.search.SearchCriteria;

public class PBIProjectCriterion extends SearchCriteria {

	private static final long serialVersionUID = 8805887457507103227L;
	private Project project;

	@SuppressWarnings("unused")
	private PBIProjectCriterion() {
		super();
	}

	public PBIProjectCriterion(final Project project) {
		super();
		this.project = project;
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		return pbi.getBacklog().getProject().equals(this.project);
	}

	@Override
	public void accept(ISearchExpressionVisitor visitor) {
		visitor.handlePBIProjectCriteria(this);
	}
}
