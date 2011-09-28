/**
 * 
 */
package fhdw.ipscrum.shared.commands.project;

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
public class ReleaseDeleteCommandTest extends ReleaseTestBase {

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ReleaseDeleteCommand#ReleaseDeleteCommand(fhdw.ipscrum.shared.model.nonMeta.Release)}
	 * .
	 */
	@Test
	public final void testReleaseDeleteCommand() {
		final ReleaseDeleteCommand command = new ReleaseDeleteCommand(this.getRelease());
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ReleaseDeleteCommand#onExecute(fhdw.ipscrum.shared.model.Model)}.
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final ReleaseDeleteCommand command = new ReleaseDeleteCommand(this.getRelease());
		Assert.assertTrue(this.getModel().getAllReleases().contains(this.getRelease()));
		command.onExecute(this.getModel());
		Assert.assertFalse(this.getModel().getAllReleases().contains(this.getRelease()));
		Assert.assertTrue(this.getRelease().isDeleted());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ReleaseDeleteCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final ReleaseDeleteCommand command = new ReleaseDeleteCommand(this.getRelease());
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handleReleaseDeleteCommand(final ReleaseDeleteCommand releaseDeleteCommand) {

			}

			@Override
			public void standardHandling(final ICommand command) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.commands.project.ReleaseDeleteCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final ReleaseDeleteCommand command = new ReleaseDeleteCommand(this.getRelease());
		Assert.assertTrue(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ReleaseDeleteCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final ReleaseDeleteCommand command = new ReleaseDeleteCommand(this.getRelease());
		Assert.assertEquals(this.getRelease().getProject(), command.getDependingProject(this.getModel()));
	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.infrastructure.Command#execute(fhdw.ipscrum.shared.model.Model)}.
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testExecuteModel() throws IPScrumGeneralException {
		final ReleaseDeleteCommand command = new ReleaseDeleteCommand(this.getRelease());
		Assert.assertTrue(this.getModel().getAllReleases().contains(this.getRelease()));
		command.execute(this.getModel());
		Assert.assertFalse(this.getModel().getAllReleases().contains(this.getRelease()));
		Assert.assertTrue(this.getRelease().isDeleted());
	}

}
