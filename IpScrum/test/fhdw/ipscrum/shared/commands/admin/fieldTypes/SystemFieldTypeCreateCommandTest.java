/**
 * 
 */
package fhdw.ipscrum.shared.commands.admin.fieldTypes;

import org.junit.Assert;
import org.junit.Test;

import fhdw.ipscrum.shared.commands.interfaces.ICommand;
import fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.messages.ModelTestBase;
import fhdw.ipscrum.shared.model.metamodel.fields.Many;
import fhdw.ipscrum.shared.model.metamodel.fields.SystemFieldType;

/**
 * 
 */
public class SystemFieldTypeCreateCommandTest extends ModelTestBase {

	/**
	 * Name of the field type.
	 */
	private static final String FIELDTYPE_NAME = "TestSystemFieldType";

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.SystemFieldTypeCreateCommand#SystemFieldTypeCreateCommand(java.lang.String, fhdw.ipscrum.shared.model.metamodel.fields.Multiplicity)}
	 * .
	 */
	@Test
	public final void testSystemFieldTypeCreateCommand() {
		final SystemFieldTypeCreateCommand command =
				new SystemFieldTypeCreateCommand(SystemFieldTypeCreateCommandTest.FIELDTYPE_NAME, new Many(
						this.getModel()));
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.SystemFieldTypeCreateCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final SystemFieldTypeCreateCommand command =
				new SystemFieldTypeCreateCommand(SystemFieldTypeCreateCommandTest.FIELDTYPE_NAME, new Many(
						this.getModel()));
		final SystemFieldType type = command.onExecute(this.getModel());
		Assert.assertEquals(SystemFieldTypeCreateCommandTest.FIELDTYPE_NAME, type.getName());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.SystemFieldTypeCreateCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final SystemFieldTypeCreateCommand command =
				new SystemFieldTypeCreateCommand(SystemFieldTypeCreateCommandTest.FIELDTYPE_NAME, new Many(
						this.getModel()));
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handleSystemFieldTypeCreateCommand(
					final SystemFieldTypeCreateCommand systemFieldTypeCreateCommand) {

			}

			@Override
			public void standardHandling(final ICommand command) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.SystemFieldTypeCreateCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final SystemFieldTypeCreateCommand command =
				new SystemFieldTypeCreateCommand(SystemFieldTypeCreateCommandTest.FIELDTYPE_NAME, new Many(
						this.getModel()));
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.SystemFieldTypeCreateCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final SystemFieldTypeCreateCommand command =
				new SystemFieldTypeCreateCommand(SystemFieldTypeCreateCommandTest.FIELDTYPE_NAME, new Many(
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
		final SystemFieldTypeCreateCommand command =
				new SystemFieldTypeCreateCommand(SystemFieldTypeCreateCommandTest.FIELDTYPE_NAME, new Many(
						this.getModel()));
		command.execute(this.getModel());
		final SystemFieldType type = command.getResult();
		Assert.assertEquals(SystemFieldTypeCreateCommandTest.FIELDTYPE_NAME, type.getName());
	}

}
