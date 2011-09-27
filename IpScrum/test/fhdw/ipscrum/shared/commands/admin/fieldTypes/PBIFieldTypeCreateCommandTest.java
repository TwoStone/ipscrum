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
import fhdw.ipscrum.shared.model.metamodel.fields.PBIFieldType;

/**
 * 
 */
public class PBIFieldTypeCreateCommandTest extends ModelTestBase {

	/**
	 * 
	 */
	private static final String PBIFIELD_NAME = "TestPBIFieldType";

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
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.PBIFieldTypeCreateCommand#PBIFieldTypeCreateCommand(java.lang.String, fhdw.ipscrum.shared.model.metamodel.fields.Multiplicity)}
	 * .
	 */
	@Test
	public final void testPBIFieldTypeCreateCommand() {
		final PBIFieldTypeCreateCommand command =
				new PBIFieldTypeCreateCommand(PBIFieldTypeCreateCommandTest.PBIFIELD_NAME, new One(this.getModel()));
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.PBIFieldTypeCreateCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final PBIFieldTypeCreateCommand command =
				new PBIFieldTypeCreateCommand(PBIFieldTypeCreateCommandTest.PBIFIELD_NAME, new One(this.getModel()));
		final PBIFieldType type = command.onExecute(this.getModel());
		Assert.assertEquals(PBIFieldTypeCreateCommandTest.PBIFIELD_NAME, type.getName());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.PBIFieldTypeCreateCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final PBIFieldTypeCreateCommand command =
				new PBIFieldTypeCreateCommand(PBIFieldTypeCreateCommandTest.PBIFIELD_NAME, new One(this.getModel()));
		command.accept(new CommandStandardVisitor() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#handlePBIFieldTypeCreateCommand(fhdw
			 * .ipscrum.shared.commands.admin.fieldTypes.PBIFieldTypeCreateCommand)
			 */
			@Override
			public void handlePBIFieldTypeCreateCommand(final PBIFieldTypeCreateCommand pBIFieldTypeCreateCommand) {

			}

			@Override
			public void standardHandling(final ICommand command) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.PBIFieldTypeCreateCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final PBIFieldTypeCreateCommand command =
				new PBIFieldTypeCreateCommand(PBIFieldTypeCreateCommandTest.PBIFIELD_NAME, new One(this.getModel()));
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.PBIFieldTypeCreateCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final PBIFieldTypeCreateCommand command =
				new PBIFieldTypeCreateCommand(PBIFieldTypeCreateCommandTest.PBIFIELD_NAME, new One(this.getModel()));
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
		final PBIFieldTypeCreateCommand command =
				new PBIFieldTypeCreateCommand(PBIFieldTypeCreateCommandTest.PBIFIELD_NAME, new One(this.getModel()));
		command.execute(this.getModel());
		final PBIFieldType type = command.getResult();
		Assert.assertEquals(PBIFieldTypeCreateCommandTest.PBIFIELD_NAME, type.getName());
	}

}
