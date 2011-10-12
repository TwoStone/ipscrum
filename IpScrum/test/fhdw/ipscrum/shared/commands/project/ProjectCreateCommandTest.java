/**
 * 
 */
package fhdw.ipscrum.shared.commands.project;

import org.junit.Assert;
import org.junit.Test;

import fhdw.ipscrum.shared.commands.interfaces.ICommand;
import fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.InfrastructureException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.messages.ModelTestBase;
import fhdw.ipscrum.shared.model.nonMeta.Project;

/**
 * 
 */
public class ProjectCreateCommandTest extends ModelTestBase {

	/**
	 * Project name.
	 */
	private static final String TESTPROJECTNAME = "Test Projekt";

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectCreateCommand#ProjectCreateCommand(java.lang.String)} .
	 */
	@Test
	public final void testProjectCreateCommand() {
		new ProjectCreateCommand(ProjectCreateCommandTest.TESTPROJECTNAME);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectCreateCommand#onExecute(fhdw.ipscrum.shared.model.Model)} .
	 * 
	 * @throws IPScrumGeneralException
	 *             if an error occurs
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final ProjectCreateCommand command = new ProjectCreateCommand(ProjectCreateCommandTest.TESTPROJECTNAME);
		final Project project = command.onExecute(this.getModel());
		Assert.assertEquals(ProjectCreateCommandTest.TESTPROJECTNAME, project.getName());

	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.commands.project.ProjectCreateCommand#dependsOnProject()} .
	 */
	@Test
	public final void testDependsOnProject() {
		final ProjectCreateCommand command = new ProjectCreateCommand(ProjectCreateCommandTest.TESTPROJECTNAME);
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectCreateCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws InfrastructureException
	 *             if an error occurs
	 */
	@Test
	public final void testGetDependingProject() throws InfrastructureException {
		final ProjectCreateCommand command = new ProjectCreateCommand(ProjectCreateCommandTest.TESTPROJECTNAME);
		Assert.assertNull(command.getDependingProject(this.getModel()));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectCreateCommand#execute(fhdw.ipscrum.shared.model.Model)} .
	 * 
	 * @throws IPScrumGeneralException
	 *             if an error occurs
	 * 
	 */
	@Test
	public final void testExecute() throws IPScrumGeneralException {
		final ProjectCreateCommand command = new ProjectCreateCommand(ProjectCreateCommandTest.TESTPROJECTNAME);
		command.execute(this.getModel());
		final Project project = command.getResult();
		Assert.assertEquals(ProjectCreateCommandTest.TESTPROJECTNAME, project.getName());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.project.ProjectCreateCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             if an error occurs
	 */
	@Test
	public final void testAccept() throws NoObjectFindException {
		final ProjectCreateCommand command = new ProjectCreateCommand(ProjectCreateCommandTest.TESTPROJECTNAME);
		command.accept(new CommandStandardVisitor() {

			@Override
			public void standardHandling(final ICommand cmd) {

			}
		});
	}
}
