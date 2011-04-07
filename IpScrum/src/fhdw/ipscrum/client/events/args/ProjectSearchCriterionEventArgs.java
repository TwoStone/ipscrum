package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.search.ISearchExpression;

public class ProjectSearchCriterionEventArgs extends EventArgs {
	private ISearchExpression se;
	private final Project project;

	public ProjectSearchCriterionEventArgs(ISearchExpression se, Project project) {
		super();
		this.se = se;
		this.project = project;
	}

	public ISearchExpression getSe() {
		return se;
	}

	public Project getProject() {
		return project;
	}
}
