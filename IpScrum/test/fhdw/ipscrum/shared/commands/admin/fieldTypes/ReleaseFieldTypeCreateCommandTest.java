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
import fhdw.ipscrum.shared.model.metamodel.fields.One;
import fhdw.ipscrum.shared.model.metamodel.fields.ReleaseFieldType;

/**
 * 
 */
public class ReleaseFieldTypeCreateCommandTest extends ModelTestBase {

	/**
	 * Name of the field type.
	 */
	private static final String FIELDTYPE_NAME = "TestReleaseFieldType";

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
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.ReleaseFieldTypeCreateCommand#ReleaseFieldTypeCreateCommand(java.lang.String, fhdw.ipscrum.shared.model.metamodel.fields.Multiplicity)}
	 * .
	 */
	@Test
	public final void testReleaseFieldTypeCreateCommand() {
		final ReleaseFieldTypeCreateCommand command =
				new ReleaseFieldTypeCreateCommand(ReleaseFieldTypeCreateCommandTest.FIELDTYPE_NAME, new One(
						this.getModel()));
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.ReleaseFieldTypeCreateCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final ReleaseFieldTypeCreateCommand command =
				new ReleaseFieldTypeCreateCommand(ReleaseFieldTypeCreateCommandTest.FIELDTYPE_NAME, new One(
						this.getModel()));
		final ReleaseFieldType type = command.onExecute(this.getModel());
		Assert.assertEquals(ReleaseFieldTypeCreateCommandTest.FIELDTYPE_NAME, type.getName());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.ReleaseFieldTypeCreateCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final ReleaseFieldTypeCreateCommand command =
				new ReleaseFieldTypeCreateCommand(ReleaseFieldTypeCreateCommandTest.FIELDTYPE_NAME, new One(
						this.getModel()));
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handleReleaseFieldTypeCreateCommand(
					final ReleaseFieldTypeCreateCommand releaseFieldTypeCreateCommand) {

			}

			@Override
			public void standardHandling(final ICommand command) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.ReleaseFieldTypeCreateCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final ReleaseFieldTypeCreateCommand command =
				new ReleaseFieldTypeCreateCommand(ReleaseFieldTypeCreateCommandTest.FIELDTYPE_NAME, new One(
						this.getModel()));
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.ReleaseFieldTypeCreateCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final ReleaseFieldTypeCreateCommand command =
				new ReleaseFieldTypeCreateCommand(ReleaseFieldTypeCreateCommandTest.FIELDTYPE_NAME, new One(
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
		final ReleaseFieldTypeCreateCommand command =
				new ReleaseFieldTypeCreateCommand(ReleaseFieldTypeCreateCommandTest.FIELDTYPE_NAME, new One(
						this.getModel()));
		command.execute(this.getModel());
		final ReleaseFieldType type = command.getResult();
		Assert.assertEquals(ReleaseFieldTypeCreateCommandTest.FIELDTYPE_NAME, type.getName());
	}

}
