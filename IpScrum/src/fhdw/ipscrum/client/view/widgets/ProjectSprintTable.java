package fhdw.ipscrum.client.view.widgets;

import com.google.gwt.user.client.ui.Composite;

import fhdw.ipscrum.shared.model.nonMeta.Project;

public class ProjectSprintTable extends Composite {

	private Project project;

	public ProjectSprintTable() {
	}

	public void setProject(final Project project) {
		this.project = project;
	}

	public Project getProject() {
		return this.project;
	}

}
