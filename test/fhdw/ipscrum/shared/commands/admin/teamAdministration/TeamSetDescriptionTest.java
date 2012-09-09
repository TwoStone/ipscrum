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

/**
 * 
 */
public class TeamSetDescriptionTest extends TeamTestBase {

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamSetDescriptionCommand#TeamSetDescriptionCommand(fhdw.ipscrum.shared.model.nonMeta.Team, java.lang.String)}
	 * .
	 */
	@Test
	public final void testTeamSetDescriptionCommand() {
		final TeamSetDescriptionCommand command = new TeamSetDescriptionCommand(this.getTeam(), "New Description");
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamSetDescriptionCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 */
	@Test
	public final void testOnExecuteModel() {
		final TeamSetDescriptionCommand command = new TeamSetDescriptionCommand(this.getTeam(), "New Description");
		Assert.assertNotSame("New Description", this.getTeam().getDescription());
		try {
			command.onExecute(this.getModel());
		} catch (final IPScrumGeneralException e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals(this.getTeam().getDescription(), "New Description");
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamSetDescriptionCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final TeamSetDescriptionCommand command = new TeamSetDescriptionCommand(this.getTeam(), "New Description");
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handleTeamSetDescriptionCommand(final TeamSetDescriptionCommand teamSetDescriptionCommand) {

			}

			@Override
			public void standardHandling(final ICommand cmd) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamSetDescriptionCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final TeamSetDescriptionCommand command = new TeamSetDescriptionCommand(this.getTeam(), "New Description");
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamSetDescriptionCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 */
	@Test
	public final void testGetDependingProject() {
		final TeamSetDescriptionCommand command = new TeamSetDescriptionCommand(this.getTeam(), "New Description");
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
		final TeamSetDescriptionCommand command = new TeamSetDescriptionCommand(this.getTeam(), "New Description");
		Assert.assertNotSame("New Description", this.getTeam().getDescription());
		try {
			command.execute(this.getModel());
		} catch (final IPScrumGeneralException e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertEquals(this.getTeam().getDescription(), "New Description");
	}

}
