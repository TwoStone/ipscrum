package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.search.SearchCriteria;

public class PBIProjectCriteria implements SearchCriteria {

	private static final long serialVersionUID = 8805887457507103227L;
	private Project project;

	@SuppressWarnings("unused")
	private PBIProjectCriteria() {
		super();
	}

	public PBIProjectCriteria(final Project project) {
		super();
		this.project = project;
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		return pbi.getBacklog().getProject().equals(this.project);
	}
}
