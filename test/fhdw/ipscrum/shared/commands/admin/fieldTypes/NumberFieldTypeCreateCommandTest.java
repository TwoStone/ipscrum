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
import fhdw.ipscrum.shared.model.metamodel.fields.NumberFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.One;

/**
 * 
 */
public class NumberFieldTypeCreateCommandTest extends ModelTestBase {

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
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.NumberFieldTypeCreateCommand#NumberFieldTypeCreateCommand(java.lang.String, fhdw.ipscrum.shared.model.metamodel.fields.Multiplicity)}
	 * .
	 */
	@Test
	public final void testNumberFieldTypeCreateCommand() {
		final NumberFieldTypeCreateCommand command =
				new NumberFieldTypeCreateCommand("TestNumberFieldType", new One(this.getModel()));
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.NumberFieldTypeCreateCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final NumberFieldTypeCreateCommand command =
				new NumberFieldTypeCreateCommand("TestNumberFieldType", new One(this.getModel()));
		final NumberFieldType type = command.onExecute(this.getModel());
		Assert.assertEquals("TestNumberFieldType", type.getName());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.NumberFieldTypeCreateCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final NumberFieldTypeCreateCommand command =
				new NumberFieldTypeCreateCommand("TestNumberFieldType", new One(this.getModel()));
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handleNumberFieldTypeCreateCommand(
					final NumberFieldTypeCreateCommand numberFieldTypeCreateCommand) {

			}

			@Override
			public void standardHandling(final ICommand cmd) {
				Assert.fail();

			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.NumberFieldTypeCreateCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final NumberFieldTypeCreateCommand command =
				new NumberFieldTypeCreateCommand("TestNumberFieldType", new One(this.getModel()));
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.NumberFieldTypeCreateCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final NumberFieldTypeCreateCommand command =
				new NumberFieldTypeCreateCommand("TestNumberFieldType", new One(this.getModel()));
		Assert.assertNull(command.getDependingProject(this.getModel()));
	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.infrastructure.Command#execute(fhdw.ipscrum.shared.model.Model)}.
	 * 
	 * @throws IPScrumGeneralException
	 *             An error occurred
	 */
	@Test
	public final void testExecuteModel() throws IPScrumGeneralException {
		final NumberFieldTypeCreateCommand command =
				new NumberFieldTypeCreateCommand("TestNumberFieldType", new One(this.getModel()));
		command.execute(this.getModel());
		final NumberFieldType type = command.getResult();
		Assert.assertEquals("TestNumberFieldType", type.getName());
	}

}
