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
public class TeamRemoveMemberCommandTest extends TeamTestBase {

	/**
	 * Person for testing.
	 */
	private Person person;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.person = new Person(this.getModel(), "James T.", "Kirk");
		this.getTeam().addMember(this.person);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamRemoveMemberCommand#TeamRemoveMemberCommand(fhdw.ipscrum.shared.model.nonMeta.Team, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * .
	 */
	@Test
	public final void testTeamRemoveMemberCommand() {
		final TeamRemoveMemberCommand command = new TeamRemoveMemberCommand(this.getTeam(), this.person);
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamRemoveMemberCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 */
	@Test
	public final void testOnExecuteModel() {
		final TeamRemoveMemberCommand command = new TeamRemoveMemberCommand(this.getTeam(), this.person);
		Assert.assertTrue(this.getTeam().getMembers().contains(this.person));
		try {
			command.onExecute(this.getModel());
		} catch (final IPScrumGeneralException e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertFalse(this.getTeam().getMembers().contains(this.person));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamRemoveMemberCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final TeamRemoveMemberCommand command = new TeamRemoveMemberCommand(this.getTeam(), this.person);
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handleTeamRemoveMemberCommand(final TeamRemoveMemberCommand teamRemoveMemberCommand) {

			}

			@Override
			public void standardHandling(final ICommand cmd) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamRemoveMemberCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final TeamRemoveMemberCommand command = new TeamRemoveMemberCommand(this.getTeam(), this.person);
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamRemoveMemberCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 */
	@Test
	public final void testGetDependingProject() {
		final TeamRemoveMemberCommand command = new TeamRemoveMemberCommand(this.getTeam(), this.person);
		try {
			Assert.assertNull(command.getDependingProject(this.getModel()));
		} catch (final NoObjectFindException e) {
			Assert.fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.infrastructure.Command#execute(fhdw.ipscrum.shared.model.Model)}.
	 */
	@Test
	public final void testExecuteModel() {
		final TeamRemoveMemberCommand command = new TeamRemoveMemberCommand(this.getTeam(), this.person);
		Assert.assertTrue(this.getTeam().getMembers().contains(this.person));
		try {
			command.execute(this.getModel());
		} catch (final IPScrumGeneralException e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertFalse(this.getTeam().getMembers().contains(this.person));
	}

}
