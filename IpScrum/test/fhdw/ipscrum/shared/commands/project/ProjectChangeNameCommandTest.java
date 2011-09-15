/**
 * 
 */
package fhdw.ipscrum.shared.commands.project;

import org.junit.Assert;
import org.junit.Test;

import fhdw.ipscrum.shared.commands.interfaces.ICommand;
import fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;

/**
 * 
 */
public class ProjectChangeNameCommandTest extends ProjectTestBase {

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectChangeNameCommand#ProjectChangeNameCommand(fhdw.ipscrum.shared.model.nonMeta.Project, java.lang.String)}
	 * .
	 */
	@Test
	public final void testProjectChangeNameCommand() {
		new ProjectChangeNameCommand(this.getProject(), "new name");
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectChangeNameCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             if an error occurs
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final ProjectChangeNameCommand command =
				new ProjectChangeNameCommand(this.getProject(), "new name");
		command.onExecute(this.getModel());
		Assert.assertEquals("new name", this.getProject().getName());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectChangeNameCommand#dependsOnProject()}
	 * .
	 */
	@Test
	public final void testDependsOnProject() {
		final ProjectChangeNameCommand command =
				new ProjectChangeNameCommand(this.getProject(), "new name");
		Assert.assertTrue(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectChangeNameCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             if an error occurs
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final ProjectChangeNameCommand command =
				new ProjectChangeNameCommand(this.getProject(), "new name");
		Assert.assertEquals(this.getProject(),
				command.getDependingProject(this.getModel()));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectChangeNameCommand#execute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             if an error occurs
	 */
	@Test
	public final void testExecute() throws IPScrumGeneralException {
		final ProjectChangeNameCommand command =
				new ProjectChangeNameCommand(this.getProject(), "new name");
		command.execute(this.getModel());
		Assert.assertEquals("new name", this.getProject().getName());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectChangeNameCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             if an error occurs
	 */
	@Test
	public final void testAccept() throws NoObjectFindException {
		final ProjectChangeNameCommand command =
				new ProjectChangeNameCommand(this.getProject(), "new name");
		command.accept(new CommandStandardVisitor() {

			@Override
			public void standardHandling(final ICommand command) {

			}
		});
	}
}
