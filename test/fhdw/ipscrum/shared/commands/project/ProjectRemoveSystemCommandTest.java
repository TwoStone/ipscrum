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
public class ProjectRemoveSystemCommandTest extends ProjectTestBase {

	/**
	 * System to test.
	 */
	private System system;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		this.system = new System(this.getModel(), "Test System", this.getModel().getRootsystem());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectRemoveSystemCommand#ProjectRemoveSystemCommand(fhdw.ipscrum.shared.model.nonMeta.Project, fhdw.ipscrum.shared.model.nonMeta.System)}
	 * .
	 */
	@Test
	public final void testProjectRemoveSystemCommand() {
		new ProjectRemoveSystemCommand(this.getProject(), this.system);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectRemoveSystemCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             if an error occurs
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final ProjectRemoveSystemCommand command = new ProjectRemoveSystemCommand(this.getProject(), this.system);
		command.onExecute(this.getModel());
		Assert.assertFalse(this.getProject().getSystems().contains(this.system));
	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.commands.project.ProjectRemoveSystemCommand#dependsOnProject()} .
	 */
	@Test
	public final void testDependsOnProject() {
		final ProjectRemoveSystemCommand command = new ProjectRemoveSystemCommand(this.getProject(), this.system);
		Assert.assertTrue(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectRemoveSystemCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             if an error occurs
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final ProjectRemoveSystemCommand command = new ProjectRemoveSystemCommand(this.getProject(), this.system);
		Assert.assertEquals(this.getProject(), command.getDependingProject(this.getModel()));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectRemoveSystemCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             if an error occurs
	 */
	@Test
	public final void testExecute() throws IPScrumGeneralException {
		final ProjectRemoveSystemCommand command = new ProjectRemoveSystemCommand(this.getProject(), this.system);
		command.execute(this.getModel());
		Assert.assertFalse(this.getProject().getSystems().contains(this.system));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectRemoveSystemCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             if an error occurs
	 */
	@Test
	public final void testAccept() throws NoObjectFindException {
		final ProjectRemoveSystemCommand command = new ProjectRemoveSystemCommand(this.getProject(), this.system);
		command.accept(new CommandStandardVisitor() {

			@Override
			public void standardHandling(final ICommand cmd) {

			}
		});
	}

}
