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
public class ProjectDeleteCommandTest extends ProjectTestBase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.project.ProjectTestBase#setUp()
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectDeleteCommand#ProjectDeleteCommand(fhdw.ipscrum.shared.model.nonMeta.Project)}
	 * .
	 */
	@Test
	public final void testProjectDeleteCommand() {
		final ProjectDeleteCommand command = new ProjectDeleteCommand(this.getProject());
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectDeleteCommand#onExecute(fhdw.ipscrum.shared.model.Model)}.
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final ProjectDeleteCommand command = new ProjectDeleteCommand(this.getProject());
		Assert.assertTrue(this.getModel().getProjects().contains(this.getProject()));
		command.onExecute(this.getModel());
		Assert.assertTrue(this.getProject().isDeleted());
		Assert.assertFalse(this.getModel().getProjects().contains(this.getProject()));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectDeleteCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final ProjectDeleteCommand command = new ProjectDeleteCommand(this.getProject());
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handleProjectDeleteCommand(final ProjectDeleteCommand projectDeleteCommand) {

			}

			@Override
			public void standardHandling(final ICommand command) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.commands.project.ProjectDeleteCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final ProjectDeleteCommand command = new ProjectDeleteCommand(this.getProject());
		Assert.assertTrue(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectDeleteCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final ProjectDeleteCommand command = new ProjectDeleteCommand(this.getProject());
		Assert.assertEquals(this.getProject(), command.getDependingProject(this.getModel()));
	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.infrastructure.Command#execute(fhdw.ipscrum.shared.model.Model)}.
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testExecuteModel() throws IPScrumGeneralException {
		final ProjectDeleteCommand command = new ProjectDeleteCommand(this.getProject());
		Assert.assertTrue(this.getModel().getProjects().contains(this.getProject()));
		command.execute(this.getModel());
		Assert.assertTrue(this.getProject().isDeleted());
		Assert.assertFalse(this.getModel().getProjects().contains(this.getProject()));
	}

}
