/**
 * 
 */
package fhdw.ipscrum.shared.commands.admin.teamAdministration;

import fhdw.ipscrum.shared.model.messages.ModelTestBase;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * 
 */
public class TeamTestBase extends ModelTestBase {

	/**
	 * Team for testing.
	 */
	private Team team;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		this.team = new Team(this.getModel(), "Test Team");
	}

	/**
	 * 
	 * @return the team for testing
	 */
	public Team getTeam() {
		return this.team;
	}
}
