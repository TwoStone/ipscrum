/**
 * 
 */
package fhdw.ipscrum.shared.commands.project;

import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.messages.ModelTestBase;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * 
 */
public class ProjectTestBase extends ModelTestBase {

	/**
	 * Project for tests.
	 */
	private Project project;

	/**
	 * Team for tests.
	 */
	private Team team;

	@Override
	public void setUp() throws IPScrumGeneralException {
		super.setUp();
		this.project = new Project(this.getModel(), "Stargate SG1");
		this.team = new Team(this.getModel(), "SG1");
		this.team.addProject(this.project);
	}

	/**
	 * 
	 * @return project for tests
	 */
	public Project getProject() {
		return this.project;
	}

	/**
	 * 
	 * @return project for tests
	 */
	public Team getTeam() {
		return this.team;
	}
}
