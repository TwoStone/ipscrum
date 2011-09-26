package fhdw.ipscrum.shared.commands.admin.teamAdministration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.commands.interfaces.ICommand;
import fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.nonMeta.Project;

/**
 * Class for testing {@link TeamAddProjectCommand}.
 */
public class TeamAddProjectCommandTest extends TeamTestBase {

	/**
	 * Project for testing.
	 */
	private Project project;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.project = new Project(this.getModel(), "Test Project");
	}

	/**
	 * Testing {@link TeamAddProjectCommand#TeamAddProjectCommand(fhdw.ipscrum.shared.model.nonMeta.Team, Project)}.
	 */
	@Test
	public final void testTeamAddProjectCommandTeamProject() {
		final TeamAddProjectCommand command = new TeamAddProjectCommand(this.getTeam(), this.project);
		Assert.assertNotNull(command);
	}

	/**
	 * Testing method {@link TeamAddProjectCommand#onExecute(fhdw.ipscrum.shared.model.Model)}.
	 */
	@Test
	public final void testOnExecuteModel() {
		final TeamAddProjectCommand command = new TeamAddProjectCommand(this.getTeam(), this.project);
		Assert.assertFalse(this.getTeam().getProjects().contains(this.project));
		try {
			command.onExecute(this.getModel());
		} catch (final IPScrumGeneralException e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertTrue(this.getTeam().getProjects().contains(this.project));
	}

	/**
	 * Testing method {@link TeamAddProjectCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}.
	 */
	@Test
	public final void testAccept() {
		final TeamAddProjectCommand command = new TeamAddProjectCommand(this.getTeam(), this.project);
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handleTeamAddProjectCommand(final TeamAddProjectCommand teamAddProjectCommand) {

			}

			@Override
			public void standardHandling(final ICommand command) {
				Assert.fail();
			}
		});
	}

	/**
	 * Testing method {@link TeamAddProjectCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final TeamAddProjectCommand command = new TeamAddProjectCommand(this.getTeam(), this.project);
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Testing method {@link TeamAddProjectCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}.
	 */
	@Test
	public final void testGetDependingProject() {
		final TeamAddProjectCommand command = new TeamAddProjectCommand(this.getTeam(), this.project);
		try {
			Assert.assertNull(command.getDependingProject(this.getModel()));
		} catch (final NoObjectFindException e) {
			Assert.fail(e.getMessage());
		}
	}

	/**
	 * Testing method {@link TeamAddProjectCommand#execute(fhdw.ipscrum.shared.model.Model)}.
	 */
	@Test
	public final void testExecuteModel() {
		final TeamAddProjectCommand command = new TeamAddProjectCommand(this.getTeam(), this.project);
		Assert.assertFalse(this.getTeam().getProjects().contains(this.project));
		try {
			command.execute(this.getModel());
		} catch (final IPScrumGeneralException e) {
			Assert.fail(e.getMessage());
		}
		Assert.assertTrue(this.getTeam().getProjects().contains(this.project));
	}

}
