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
import fhdw.ipscrum.shared.model.metamodel.fields.PersonFieldType;

/**
 * 
 */
public class PersonFieldTypeCreateCommandTest extends ModelTestBase {

	/**
	 * Name of the field type.
	 */
	private static final String FIELDTYPE_NAME = "TestPersonFieldType";

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
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.PersonFieldTypeCreateCommand#PersonFieldTypeCreateCommand(java.lang.String, fhdw.ipscrum.shared.model.metamodel.fields.Multiplicity)}
	 * .
	 */
	@Test
	public final void testPersonFieldTypeCreateCommand() {
		final PersonFieldTypeCreateCommand command =
				new PersonFieldTypeCreateCommand(PersonFieldTypeCreateCommandTest.FIELDTYPE_NAME, new Many(
						this.getModel()));
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.PersonFieldTypeCreateCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final PersonFieldTypeCreateCommand command =
				new PersonFieldTypeCreateCommand(PersonFieldTypeCreateCommandTest.FIELDTYPE_NAME, new Many(
						this.getModel()));
		final PersonFieldType type = command.onExecute(this.getModel());
		Assert.assertEquals(PersonFieldTypeCreateCommandTest.FIELDTYPE_NAME, type.getName());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.PersonFieldTypeCreateCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final PersonFieldTypeCreateCommand command =
				new PersonFieldTypeCreateCommand(PersonFieldTypeCreateCommandTest.FIELDTYPE_NAME, new Many(
						this.getModel()));
		command.accept(new CommandStandardVisitor() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#handlePersonFieldTypeCreateCommand(fhdw
			 * .ipscrum.shared.commands.admin.fieldTypes.PersonFieldTypeCreateCommand)
			 */
			@Override
			public void handlePersonFieldTypeCreateCommand(
					final PersonFieldTypeCreateCommand personFieldTypeCreateCommand) {

			}

			@Override
			public void standardHandling(final ICommand command) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.PersonFieldTypeCreateCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final PersonFieldTypeCreateCommand command =
				new PersonFieldTypeCreateCommand(PersonFieldTypeCreateCommandTest.FIELDTYPE_NAME, new Many(
						this.getModel()));
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.PersonFieldTypeCreateCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final PersonFieldTypeCreateCommand command =
				new PersonFieldTypeCreateCommand(PersonFieldTypeCreateCommandTest.FIELDTYPE_NAME, new Many(
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
		final PersonFieldTypeCreateCommand command =
				new PersonFieldTypeCreateCommand(PersonFieldTypeCreateCommandTest.FIELDTYPE_NAME, new Many(
						this.getModel()));
		command.execute(this.getModel());
		final PersonFieldType type = command.getResult();
		Assert.assertEquals(PersonFieldTypeCreateCommandTest.FIELDTYPE_NAME, type.getName());
	}

}
