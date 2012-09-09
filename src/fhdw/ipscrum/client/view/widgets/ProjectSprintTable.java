package fhdw.ipscrum.client.view.widgets;

import com.google.gwt.user.client.ui.Composite;

import fhdw.ipscrum.shared.model.nonMeta.Project;

/**
 * Represents the table a project is represented in.
 */
public class ProjectSprintTable extends Composite {

	private Project project;

	/**
	 * Constructor of the ProjectSprintTable.
	 */
	public ProjectSprintTable() {
	}

	/**
	 * Sets the project in the table.
	 * 
	 * @param project
	 *            to set
	 */
	public void setProject(final Project project) {
		this.project = project;
	}

	/**
	 * Getter of the project related to the table.
	 * 
	 * @return the related project
	 */
	public Project getProject() {
		return this.project;
	}

}
