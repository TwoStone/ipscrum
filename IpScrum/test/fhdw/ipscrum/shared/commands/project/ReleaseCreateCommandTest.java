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
import fhdw.ipscrum.shared.model.nonMeta.Release;

/**
 * 
 */
public class ReleaseCreateCommandTest extends ProjectTestBase {

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ReleaseCreateCommand#ReleaseCreateCommand(fhdw.ipscrum.shared.model.nonMeta.Project, java.lang.String, java.util.Date)}
	 * .
	 */
	@Test
	public final void testReleaseCreateCommand() {
		new ReleaseCreateCommand(this.getProject(), "Beta Base", new Date());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ReleaseCreateCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             if an error occurs
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final ReleaseCreateCommand command =
				new ReleaseCreateCommand(this.getProject(), "Beta Base", new Date());
		final Release release = command.onExecute(this.getModel());
		Assert.assertEquals("Beta Base", release.getVersion());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ReleaseCreateCommand#dependsOnProject()}
	 * .
	 */
	@Test
	public final void testDependsOnProject() {
		final ReleaseCreateCommand command =
				new ReleaseCreateCommand(this.getProject(), "Beta Base", new Date());
		Assert.assertTrue(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ReleaseCreateCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             If an error occurs
	 */
	@Test
	public final void testGetDependingProject() throws IPScrumGeneralException {
		final ReleaseCreateCommand command =
				new ReleaseCreateCommand(this.getProject(), "Beta Base", new Date());
		Assert.assertEquals(this.getProject(),
				command.getDependingProject(this.getModel()));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ReleaseCreateCommand#execute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             if an error occurs
	 */
	@Test
	public final void testExecute() throws IPScrumGeneralException {
		final ReleaseCreateCommand command =
				new ReleaseCreateCommand(this.getProject(), "Beta Base", new Date());
		command.execute(this.getModel());
		Assert.assertEquals("Beta Base", command.getResult().getVersion());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ReleasCreateCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             if an error occurs
	 */
	@Test
	public final void testAccept() throws NoObjectFindException {
		final ReleaseCreateCommand command =
				new ReleaseCreateCommand(this.getProject(), "Beta Base", new Date());
		command.accept(new CommandStandardVisitor() {

			@Override
			public void standardHandling(final ICommand command) {

			}
		});
	}

}
