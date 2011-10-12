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
import fhdw.ipscrum.shared.model.metamodel.fields.EffortFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.One;

/**
 * 
 */
public class EffortFieldTypeCreateCommandTest extends ModelTestBase {

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
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.EffortFieldTypeCreateCommand#EffortFieldTypeCreateCommand(java.lang.String, fhdw.ipscrum.shared.model.metamodel.fields.Multiplicity)}
	 * .
	 */
	@Test
	public final void testEffortFieldTypeCreateCommand() {
		final EffortFieldTypeCreateCommand command =
				new EffortFieldTypeCreateCommand("TestEffortFieldType", new One(this.getModel()));
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.EffortFieldTypeCreateCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final EffortFieldTypeCreateCommand command =
				new EffortFieldTypeCreateCommand("TestEffortFieldType", new One(this.getModel()));
		final EffortFieldType type = command.onExecute(this.getModel());
		Assert.assertEquals("TestEffortFieldType", type.getName());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.EffortFieldTypeCreateCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final EffortFieldTypeCreateCommand command =
				new EffortFieldTypeCreateCommand("TestEffortFieldType", new One(this.getModel()));
		command.accept(new CommandStandardVisitor() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#handleEffortFieldTypeCreateCommand(fhdw
			 * .ipscrum.shared.commands.admin.fieldTypes.EffortFieldTypeCreateCommand)
			 */
			@Override
			public void handleEffortFieldTypeCreateCommand(
					final EffortFieldTypeCreateCommand effortFieldTypeCreateCommand) {

			}

			@Override
			public void standardHandling(final ICommand cmd) {
				Assert.fail();

			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.EffortFieldTypeCreateCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final EffortFieldTypeCreateCommand command =
				new EffortFieldTypeCreateCommand("TestEffortFieldType", new One(this.getModel()));
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.EffortFieldTypeCreateCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final EffortFieldTypeCreateCommand command =
				new EffortFieldTypeCreateCommand("TestEffortFieldType", new One(this.getModel()));
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
		final EffortFieldTypeCreateCommand command =
				new EffortFieldTypeCreateCommand("TestEffortFieldType", new One(this.getModel()));
		command.execute(this.getModel());
		final EffortFieldType type = command.getResult();
		Assert.assertEquals("TestEffortFieldType", type.getName());
	}

}
