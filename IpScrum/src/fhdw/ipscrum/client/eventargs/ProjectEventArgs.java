package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.nonMeta.Project;

/**
 * represents an event argument which knows a project.
 */
public class ProjectEventArgs extends EventArgs {

	/**
	 * represents the project attached to the event argument.
	 */
	private final Project project;

	/**
	 * constructor of the ProjectEventArgs.
	 * 
	 * @param project
	 *            related to the event argument
	 */
	public ProjectEventArgs(final Project project) {
		super();
		this.project = project;
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
