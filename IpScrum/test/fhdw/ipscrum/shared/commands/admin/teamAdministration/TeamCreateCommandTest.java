/**
 * 
 */
package fhdw.ipscrum.shared.commands.admin.teamAdministration;

import org.junit.Assert;
import org.junit.Test;

import fhdw.ipscrum.shared.commands.interfaces.ICommand;
import fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.messages.ModelTestBase;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * 
 */
public class TeamCreateCommandTest extends ModelTestBase {

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamCreateCommand#TeamCreateCommand(java.lang.String)}
	 * .
	 */
	@Test
	public final void testTeamCreateCommand() {
		final TeamCreateCommand command = new TeamCreateCommand("New Test Team");
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamCreateCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             if an error occurs
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final TeamCreateCommand command = new TeamCreateCommand("New Test Team");
		final Team team = command.onExecute(this.getModel());
		Assert.assertEquals("New Test Team", team.getDescription());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamCreateCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final TeamCreateCommand command = new TeamCreateCommand("New Test Team");
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handleTeamCreateCommand(final TeamCreateCommand teamCreateCommand) {
				Assert.assertEquals(command, teamCreateCommand);
			}

			@Override
			public void standardHandling(final ICommand command) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamCreateCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final TeamCreateCommand command = new TeamCreateCommand("New Test Team");
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamCreateCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             if the object could not be found in the model.
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final TeamCreateCommand command = new TeamCreateCommand("New Test Team");
		Assert.assertNull(command.getDependingProject(this.getModel()));
	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.infrastructure.Command#execute(fhdw.ipscrum.shared.model.Model)}.
	 * 
	 * @throws IPScrumGeneralException
	 *             if an error occurred while execution
	 */
	@Test
	public final void testExecuteModel() throws IPScrumGeneralException {
		final TeamCreateCommand command = new TeamCreateCommand("New Test Team");
		command.execute(this.getModel());
		final Team team = command.getResult();
		Assert.assertEquals("New Test Team", team.getDescription());
	}

}
