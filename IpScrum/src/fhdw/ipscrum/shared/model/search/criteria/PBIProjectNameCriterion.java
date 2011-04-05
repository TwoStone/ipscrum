package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;

/**
 * Represents the search criterion for PBI project.
 */
public class PBIProjectNameCriterion extends TextCriterion implements
		ProjectCriterion {

	private static final long serialVersionUID = 8805887457507103227L;

	@SuppressWarnings("unused")
	private PBIProjectNameCriterion() {
		super();
	}

	public PBIProjectNameCriterion(final String name) {
		super(name);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		return this.nonSensitiveContains(pbi.getBacklog().getProject()
				.getName());
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handlePBIProjectNameCriteria(this);
	}

	@Override
	public String toString() {
		return "Project [" + this.getValue() + "]";
	}

}
