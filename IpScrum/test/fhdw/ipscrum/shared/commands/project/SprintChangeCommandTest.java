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
public class SprintChangeCommandTest extends ReleaseTestBase {

	/**
	 * Sprint to use for tests.
	 */
	private Sprint sprint;

	@Override
	public void setUp() throws IPScrumGeneralException {
		super.setUp();
		this.sprint =
				new Sprint(this.getModel(), "Test Sprint", "This is a test sprint!",
						new Date(), new Date(new Date().getTime() + 50000),
						this.getTeam(), this.getProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.SprintChangeCommand#SprintChangeCommand(fhdw.ipscrum.shared.model.nonMeta.Sprint, java.lang.String, java.lang.String, java.util.Date, java.util.Date, fhdw.ipscrum.shared.model.nonMeta.Team)}
	 * .
	 */
	@Test
	public final void testSprintChangeCommand() {
		new SprintChangeCommand(this.sprint, "new name", "new description", new Date(
				new Date().getTime() + 100000),
				new Date(new Date().getTime() + 200000), this.getTeam());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.SprintChangeCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             if an error occurs
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final SprintChangeCommand command =
				new SprintChangeCommand(this.sprint, "new name", "new description",
						new Date(new Date().getTime() + 100000), new Date(
								new Date().getTime() + 200000), this.getTeam());
		command.onExecute(this.getModel());
		Assert.assertEquals("new name", this.sprint.getName());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.SprintChangeCommand#dependsOnProject()}
	 * .
	 */
	@Test
	public final void testDependsOnProject() {
		final SprintChangeCommand command =
				new SprintChangeCommand(this.sprint, "new name", "new description",
						new Date(new Date().getTime() + 100000), new Date(
								new Date().getTime() + 200000), this.getTeam());
		Assert.assertTrue(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.SprintChangeCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             if an error occurs
	 */
	@Test
	public final void testGetDependingProject() throws IPScrumGeneralException {
		final SprintChangeCommand command =
				new SprintChangeCommand(this.sprint, "new name", "new description",
						new Date(new Date().getTime() + 100000), new Date(
								new Date().getTime() + 200000), this.getTeam());
		Assert.assertEquals(this.getProject(),
				command.getDependingProject(this.getModel()));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.SprintChangeCommand#execute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             if an error occurs
	 */
	@Test
	public final void testExecute() throws IPScrumGeneralException {
		final SprintChangeCommand command =
				new SprintChangeCommand(this.sprint, "new name", "new description",
						new Date(new Date().getTime() + 100000), new Date(
								new Date().getTime() + 200000), this.getTeam());
		command.execute(this.getModel());
		Assert.assertEquals("new name", this.sprint.getName());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.SprintChangeCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             if an error occurs
	 */
	@Test
	public final void testAccept() throws NoObjectFindException {
		final SprintChangeCommand command =
				new SprintChangeCommand(this.sprint, "new name", "new description",
						new Date(new Date().getTime() + 100000), new Date(
								new Date().getTime() + 200000), this.getTeam());
		command.accept(new CommandStandardVisitor() {

			@Override
			public void standardHandling(final ICommand command) {

			}
		});
	}

}
