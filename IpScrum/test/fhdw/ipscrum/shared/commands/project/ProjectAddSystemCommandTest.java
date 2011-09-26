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
import fhdw.ipscrum.shared.model.nonMeta.System;

/**
 * 
 */
public class ProjectAddSystemCommandTest extends ProjectTestBase {

	/**
	 * System for test.
	 */
	private System system;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		this.system = new System(this.getModel(), "Test System", this.getModel().getRootsystem());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectAddSystemCommand#ProjectAddSystemCommand(fhdw.ipscrum.shared.model.nonMeta.Project, fhdw.ipscrum.shared.model.nonMeta.System)}
	 * .
	 */
	@Test
	public final void testProjectAddSystemCommand() {
		new ProjectAddSystemCommand(this.getProject(), this.system);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectAddSystemCommand#onExecute(fhdw.ipscrum.shared.model.Model)} .
	 * 
	 * @throws IPScrumGeneralException
	 *             if an error occurs
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final ProjectAddSystemCommand command = new ProjectAddSystemCommand(this.getProject(), this.system);
		command.onExecute(this.getModel());
	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.commands.project.ProjectAddSystemCommand#dependsOnProject()} .
	 */
	@Test
	public final void testDependsOnProject() {
		final ProjectAddSystemCommand command = new ProjectAddSystemCommand(this.getProject(), this.system);
		Assert.assertTrue(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectAddSystemCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             if an error occurs
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final ProjectAddSystemCommand command = new ProjectAddSystemCommand(this.getProject(), this.system);
		Assert.assertEquals(this.getProject(), command.getDependingProject(this.getModel()));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectAddSystemCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             if an error occurs
	 */
	@Test
	public final void testAccept() throws NoObjectFindException {
		final ProjectAddSystemCommand command = new ProjectAddSystemCommand(this.getProject(), this.system);
		command.accept(new CommandStandardVisitor() {

			@Override
			public void standardHandling(final ICommand command) {

			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectAddSystemCommand#execute(fhdw.ipscrum.shared.model.Model)} .
	 * 
	 * @throws IPScrumGeneralException
	 *             if an error occurs
	 */
	@Test
	public final void testExecute() throws IPScrumGeneralException {
		final ProjectAddSystemCommand command = new ProjectAddSystemCommand(this.getProject(), this.system);
		command.execute(this.getModel());
		Assert.assertTrue(this.getProject().getSystems().contains(this.system));
	}

}
