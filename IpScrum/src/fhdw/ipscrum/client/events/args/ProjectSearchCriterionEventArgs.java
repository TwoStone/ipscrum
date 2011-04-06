package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.search.SearchExpression;

public class ProjectSearchCriterionEventArgs extends EventArgs {
	private SearchExpression se;
	private final Project project;

	public ProjectSearchCriterionEventArgs(SearchExpression se, Project project) {
		super();
		this.se = se;
		this.project = project;
	}

	public SearchExpression getSe() {
		return se;
	}

	public Project getProject() {
		return project;
	}
}
