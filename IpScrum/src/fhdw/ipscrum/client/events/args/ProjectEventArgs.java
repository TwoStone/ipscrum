package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.Project;

public class ProjectEventArgs extends EventArgs {

	private final Project project;

	public ProjectEventArgs(Project project) {
		super();
		this.project = project;
	}
	
	public Project getProject() {
		return project;
	}
}
