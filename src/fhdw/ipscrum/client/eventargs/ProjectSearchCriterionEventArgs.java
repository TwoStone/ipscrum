package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.metamodel.search.ISearchExpression;
import fhdw.ipscrum.shared.model.nonMeta.Project;

/**
 * represents an event argument which knows a project search criterion.
 */
public class ProjectSearchCriterionEventArgs extends EventArgs {
	/**
	 * represents the search expression attached to the event argument.
	 */
	private final ISearchExpression se;
	/**
	 * represents the project attached to the event argument.
	 */
	private final Project project;

	/**
	 * constructor of the ProjectSearchCriteronEventArgs.
	 * 
	 * @param se
	 *            is the related search expression
	 * @param project
	 *            os the related project
	 */
	public ProjectSearchCriterionEventArgs(final ISearchExpression se, final Project project) {
		super();
		this.se = se;
		this.project = project;
	}

	/**
	 * getter of the search expression.
	 * 
	 * @return the search expression
	 */
	public ISearchExpression getSe() {
		return this.se;
	}

	/**
	 * getter of the project.
	 * 
	 * @return the project
	 */
	public Project getProject() {
		return this.project;
	}
}
