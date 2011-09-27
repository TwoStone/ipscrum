/**
 * 
 */
package fhdw.ipscrum.shared.commands.admin.fieldTypes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.commands.interfaces.ICommand;
import fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.messages.ModelTestBase;
import fhdw.ipscrum.shared.model.metamodel.fields.Many;
import fhdw.ipscrum.shared.model.metamodel.fields.SprintFieldType;

/**
 * 
 */
public class SprintFieldTypeCreateCommandTest extends ModelTestBase {

	/**
	 * Name of the field type.
	 */
	private static final String FIELDTYPE_NAME = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.model.messages.ModelTestBase#setUp()
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.SprintFieldTypeCreateCommand#SprintFieldTypeCreateCommand(java.lang.String, fhdw.ipscrum.shared.model.metamodel.fields.Multiplicity)}
	 * .
	 */
	@Test
	public final void testSprintFieldTypeCreateCommand() {
		final SprintFieldTypeCreateCommand command =
				new SprintFieldTypeCreateCommand(SprintFieldTypeCreateCommandTest.FIELDTYPE_NAME, new Many(
						this.getModel()));
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.SprintFieldTypeCreateCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final SprintFieldTypeCreateCommand command =
				new SprintFieldTypeCreateCommand(SprintFieldTypeCreateCommandTest.FIELDTYPE_NAME, new Many(
						this.getModel()));
		final SprintFieldType type = command.onExecute(this.getModel());
		Assert.assertEquals(SprintFieldTypeCreateCommandTest.FIELDTYPE_NAME, type.getName());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.SprintFieldTypeCreateCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final SprintFieldTypeCreateCommand command =
				new SprintFieldTypeCreateCommand(SprintFieldTypeCreateCommandTest.FIELDTYPE_NAME, new Many(
						this.getModel()));
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handleSprintFieldTypeCreateCommand(
					final SprintFieldTypeCreateCommand sprintFieldTypeCreateCommand) {

			}

			@Override
			public void standardHandling(final ICommand command) {
				Assert.fail();

			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.SprintFieldTypeCreateCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final SprintFieldTypeCreateCommand command =
				new SprintFieldTypeCreateCommand(SprintFieldTypeCreateCommandTest.FIELDTYPE_NAME, new Many(
						this.getModel()));
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.SprintFieldTypeCreateCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final SprintFieldTypeCreateCommand command =
				new SprintFieldTypeCreateCommand(SprintFieldTypeCreateCommandTest.FIELDTYPE_NAME, new Many(
						this.getModel()));
		Assert.assertNull(command.getDependingProject(this.getModel()));
	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.infrastructure.Command#execute(fhdw.ipscrum.shared.model.Model)}.
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testExecuteModel() throws IPScrumGeneralException {
		final SprintFieldTypeCreateCommand command =
				new SprintFieldTypeCreateCommand(SprintFieldTypeCreateCommandTest.FIELDTYPE_NAME, new Many(
						this.getModel()));
		command.execute(this.getModel());
		final SprintFieldType type = command.getResult();
		Assert.assertEquals(SprintFieldTypeCreateCommandTest.FIELDTYPE_NAME, type.getName());
	}

}
