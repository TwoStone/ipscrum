package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;
import fhdw.ipscrum.shared.model.search.SearchCriteria;

/**
 * Represents the search criterion for PBI project.
 */
public class PBIProjectCriterion extends SearchCriteria implements
		ProjectCriterion {

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
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handlePBIProjectCriteria(this);
	}

	@Override
	public String toString() {
		return "Projekt [" + this.project + "]";
	}

	public Project getProject() {
		return this.project;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.project == null) ? 0 : this.project.hashCode());
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
		final PBIProjectCriterion other = (PBIProjectCriterion) obj;
		if (this.project == null) {
			if (other.project != null) {
				return false;
			}
		} else if (!this.project.equals(other.project)) {
			return false;
		}
		return true;
	}
}
