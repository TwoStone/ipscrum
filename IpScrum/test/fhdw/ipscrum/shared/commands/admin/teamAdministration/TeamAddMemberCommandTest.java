/**
 * 
 */
package fhdw.ipscrum.shared.commands.admin.teamAdministration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.commands.interfaces.ICommand;
import fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.nonMeta.Person;

/**
 * 
 */
public class TeamAddMemberCommandTest extends TeamTestBase {

	/**
	 * Person for testing.
	 */
	private Person person;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.person = new Person(this.getModel(), "Max", "Mustermann");
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamAddMemberCommand#TeamAddMemberCommand(fhdw.ipscrum.shared.model.nonMeta.Team, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * .
	 */
	@Test
	public final void testTeamAddMemberCommand() {
		final TeamAddMemberCommand command = new TeamAddMemberCommand(this.getTeam(), this.person);
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamAddMemberCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 */
	@Test
	public final void testOnExecuteModel() {
		final TeamAddMemberCommand command = new TeamAddMemberCommand(this.getTeam(), this.person);
		try {
			command.onExecute(this.getModel());
			Assert.assertTrue(this.getTeam().getMembers().contains(this.person));
		} catch (final IPScrumGeneralException e) {
			Assert.fail(e.getMessage());
		}
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamAddMemberCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final TeamAddMemberCommand command = new TeamAddMemberCommand(this.getTeam(), this.person);
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handleTeamAddMemberCommand(final TeamAddMemberCommand teamAddMemberCommand) {

			}

			@Override
			public void standardHandling(final ICommand command) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamAddMemberCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final TeamAddMemberCommand command = new TeamAddMemberCommand(this.getTeam(), this.person);
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamAddMemberCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             error if object can not be found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final TeamAddMemberCommand command = new TeamAddMemberCommand(this.getTeam(), this.person);
		Assert.assertNull(command.getDependingProject(this.getModel()));
	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.infrastructure.Command#execute(fhdw.ipscrum.shared.model.Model)}.
	 */
	@Test
	public final void testExecuteModel() {
		final TeamAddMemberCommand command = new TeamAddMemberCommand(this.getTeam(), this.person);
		try {
			command.execute(this.getModel());
			Assert.assertTrue(this.getTeam().getMembers().contains(this.person));
		} catch (final IPScrumGeneralException e) {
			Assert.fail();
		}

	}

}
