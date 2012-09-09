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
public class ReleaseRemoveSprintCommandTest extends ReleaseTestBase {

	/**
	 * Sprint to use for tests.
	 */
	private Sprint sprint;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		this.sprint =
				new Sprint(this.getModel(), "Test Sprint", "This is a test sprint!", new Date(), new Date(
						new Date().getTime() + 50000), this.getTeam(), this.getProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ReleaseRemoveSprintCommand#ReleaseRemoveSprintCommand(fhdw.ipscrum.shared.model.nonMeta.Release, fhdw.ipscrum.shared.model.nonMeta.Sprint)}
	 * .
	 */
	@Test
	public final void testReleaseRemoveSprintCommand() {
		new ReleaseRemoveSprintCommand(this.getRelease(), this.sprint);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ReleaseRemoveSprintCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             if an error occurs
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final ReleaseRemoveSprintCommand command = new ReleaseRemoveSprintCommand(this.getRelease(), this.sprint);
		command.onExecute(this.getModel());
		Assert.assertFalse(this.getRelease().getSprints().contains(this.sprint));
	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.commands.project.ReleaseRemoveSprintCommand#dependsOnProject()} .
	 */
	@Test
	public final void testDependsOnProject() {
		final ReleaseRemoveSprintCommand command = new ReleaseRemoveSprintCommand(this.getRelease(), this.sprint);
		Assert.assertTrue(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ReleaseRemoveSprintCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             if an error occurs
	 */
	@Test
	public final void testGetDependingProject() throws IPScrumGeneralException {
		final ReleaseRemoveSprintCommand command = new ReleaseRemoveSprintCommand(this.getRelease(), this.sprint);
		Assert.assertEquals(this.getProject(), command.getDependingProject(this.getModel()));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ReleaseRemoveSprintCommand#execute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             if an error occurs
	 */
	@Test
	public final void testExecute() throws IPScrumGeneralException {
		final ReleaseRemoveSprintCommand command = new ReleaseRemoveSprintCommand(this.getRelease(), this.sprint);
		command.execute(this.getModel());
		Assert.assertFalse(this.getRelease().getSprints().contains(this.sprint));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ReleasRemoveSprintCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             if an error occurs
	 */
	@Test
	public final void testAccept() throws NoObjectFindException {
		final ReleaseRemoveSprintCommand command = new ReleaseRemoveSprintCommand(this.getRelease(), this.sprint);
		command.accept(new CommandStandardVisitor() {

			@Override
			public void standardHandling(final ICommand cmd) {

			}
		});
	}

}
