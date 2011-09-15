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
public class ReleaseAddSprintCommandTest extends ReleaseTestBase {

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
	 * {@link fhdw.ipscrum.shared.commands.project.ReleaseAddSprintCommand#ReleaseAddSprintCommand(fhdw.ipscrum.shared.model.nonMeta.Release, fhdw.ipscrum.shared.model.nonMeta.Sprint)}
	 * .
	 */
	@Test
	public final void testReleaseAddSprintCommand() {
		new ReleaseAddSprintCommand(this.getRelease(), this.sprint);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ReleaseAddSprintCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             if an error occurs
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final ReleaseAddSprintCommand command =
				new ReleaseAddSprintCommand(this.getRelease(), this.sprint);
		command.onExecute(this.getModel());
		Assert.assertTrue(this.getRelease().getSprints().contains(this.sprint));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ReleaseAddSprintCommand#dependsOnProject()}
	 * .
	 */
	@Test
	public final void testDependsOnProject() {
		final ReleaseAddSprintCommand command =
				new ReleaseAddSprintCommand(this.getRelease(), this.sprint);
		Assert.assertTrue(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ReleaseAddSprintCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             if an error occurs
	 */
	@Test
	public final void testGetDependingProject() throws IPScrumGeneralException {
		final ReleaseAddSprintCommand command =
				new ReleaseAddSprintCommand(this.getRelease(), this.sprint);
		Assert.assertEquals(this.getProject(),
				command.getDependingProject(this.getModel()));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ReleaseAddSprintCommand#execute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             if an error occurs
	 */
	@Test
	public final void testExecute() throws IPScrumGeneralException {
		final ReleaseAddSprintCommand command =
				new ReleaseAddSprintCommand(this.getRelease(), this.sprint);
		command.execute(this.getModel());
		Assert.assertTrue(this.getRelease().getSprints().contains(this.sprint));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ReleaseAddSprintCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             if an error occurs
	 */
	@Test
	public final void testAccept() throws NoObjectFindException {
		final ReleaseAddSprintCommand command =
				new ReleaseAddSprintCommand(this.getRelease(), this.sprint);
		command.accept(new CommandStandardVisitor() {

			@Override
			public void standardHandling(final ICommand command) {

			}
		});
	}

}
