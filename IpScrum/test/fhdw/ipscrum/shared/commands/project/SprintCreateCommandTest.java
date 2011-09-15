/**
 * 
 */
package fhdw.ipscrum.shared.commands.project;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import fhdw.ipscrum.shared.commands.interfaces.ICommand;
import fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;

/**
 * 
 */
public class SprintCreateCommandTest extends ReleaseTestBase {

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.SprintCreateCommand#SprintCreateCommand(java.lang.String, java.util.Date, java.util.Date, java.lang.String, fhdw.ipscrum.shared.model.nonMeta.Team, fhdw.ipscrum.shared.model.nonMeta.Project)}
	 * .
	 */
	@Test
	public final void testSprintCreateCommand() {
		new SprintCreateCommand("Test Sprint", new Date(), new Date(
				new Date().getTime() + 50000), "This is a test sprint!",
				this.getTeam(), this.getProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.SprintCreateCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             If an error occurs
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final SprintCreateCommand command =
				new SprintCreateCommand("Test Sprint", new Date(), new Date(
						new Date().getTime() + 50000), "This is a test sprint!",
						this.getTeam(), this.getProject());
		final Sprint sprint = command.onExecute(this.getModel());
		Assert.assertEquals("Test Sprint", sprint.getName());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.SprintCreateCommand#dependsOnProject()}
	 * .
	 */
	@Test
	public final void testDependsOnProject() {
		final SprintCreateCommand command =
				new SprintCreateCommand("Test Sprint", new Date(), new Date(
						new Date().getTime() + 50000), "This is a test sprint!",
						this.getTeam(), this.getProject());
		Assert.assertTrue(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.SprintCreateCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             if an error occurs
	 */
	@Test
	public final void testGetDependingProject() throws IPScrumGeneralException {
		final SprintCreateCommand command =
				new SprintCreateCommand("Test Sprint", new Date(), new Date(
						new Date().getTime() + 50000), "This is a test sprint!",
						this.getTeam(), this.getProject());
		Assert.assertEquals(this.getProject(),
				command.getDependingProject(this.getModel()));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.SprintCreateCommand#execute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             if an error occurs
	 */
	@Test
	public final void testExecute() throws IPScrumGeneralException {
		final SprintCreateCommand command =
				new SprintCreateCommand("Test Sprint", new Date(), new Date(
						new Date().getTime() + 50000), "This is a test sprint!",
						this.getTeam(), this.getProject());
		command.execute(this.getModel());
		final Sprint sprint = command.getResult();
		Assert.assertEquals("Test Sprint", sprint.getName());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.SprintCreateCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             if an error occurs
	 */
	@Test
	public final void testAccept() throws NoObjectFindException {
		final SprintCreateCommand command =
				new SprintCreateCommand("Test Sprint", new Date(), new Date(
						new Date().getTime() + 50000), "This is a test sprint!",
						this.getTeam(), this.getProject());
		command.accept(new CommandStandardVisitor() {

			@Override
			public void standardHandling(final ICommand command) {

			}
		});
	}

}
