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
import fhdw.ipscrum.shared.model.metamodel.fields.DateFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.Many;

/**
 * 
 */
public class DateFieldTypeCreateCommandTest extends ModelTestBase {

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.DateFieldTypeCreateCommand#DateFieldTypeCreateCommand(java.lang.String, fhdw.ipscrum.shared.model.metamodel.fields.Multiplicity)}
	 * .
	 */
	@Test
	public final void testDateFieldTypeCreateCommand() {
		final DateFieldTypeCreateCommand command =
				new DateFieldTypeCreateCommand("TestDateFieldType", new Many(this.getModel()));
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.DateFieldTypeCreateCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final DateFieldTypeCreateCommand command =
				new DateFieldTypeCreateCommand("TestDateFieldType", new Many(this.getModel()));
		final DateFieldType type = command.onExecute(this.getModel());
		Assert.assertEquals("TestDateFieldType", type.getName());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.DateFieldTypeCreateCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final DateFieldTypeCreateCommand command =
				new DateFieldTypeCreateCommand("TestDateFieldType", new Many(this.getModel()));
		command.accept(new CommandStandardVisitor() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#handleDateFieldTypeCreateCommand(fhdw
			 * .ipscrum.shared.commands.admin.fieldTypes.DateFieldTypeCreateCommand)
			 */
			@Override
			public void handleDateFieldTypeCreateCommand(final DateFieldTypeCreateCommand dateFieldTypeCreateCommand) {

			}

			@Override
			public void standardHandling(final ICommand cmd) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.DateFieldTypeCreateCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final DateFieldTypeCreateCommand command =
				new DateFieldTypeCreateCommand("TestDateFieldType", new Many(this.getModel()));
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.DateFieldTypeCreateCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final DateFieldTypeCreateCommand command =
				new DateFieldTypeCreateCommand("TestDateFieldType", new Many(this.getModel()));
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
		final DateFieldTypeCreateCommand command =
				new DateFieldTypeCreateCommand("TestDateFieldType", new Many(this.getModel()));
		command.execute(this.getModel());
		final DateFieldType type = command.getResult();
		Assert.assertEquals("TestDateFieldType", type.getName());
	}

}
