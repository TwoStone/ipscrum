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
import fhdw.ipscrum.shared.model.metamodel.fields.HintFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.One;

/**
 * 
 */
public class HintFieldTypeCreateCommandTest extends ModelTestBase {

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.HintFieldTypeCreateCommand#HintFieldTypeCreateCommand(java.lang.String, fhdw.ipscrum.shared.model.metamodel.fields.Multiplicity)}
	 * .
	 */
	@Test
	public final void testHintFieldTypeCreateCommand() {
		final HintFieldTypeCreateCommand command =
				new HintFieldTypeCreateCommand("TestHintFieldType", new One(this.getModel()));
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.HintFieldTypeCreateCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final HintFieldTypeCreateCommand command =
				new HintFieldTypeCreateCommand("TestHintFieldType", new One(this.getModel()));
		final HintFieldType type = command.onExecute(this.getModel());
		Assert.assertEquals("TestHintFieldType", type.getName());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.HintFieldTypeCreateCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final HintFieldTypeCreateCommand command =
				new HintFieldTypeCreateCommand("TestHintFieldType", new One(this.getModel()));
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handleHintFieldTypeCreateCommand(final HintFieldTypeCreateCommand hintFieldTypeCreateCommand) {

			}

			@Override
			public void standardHandling(final ICommand cmd) {
				Assert.fail();

			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.HintFieldTypeCreateCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final HintFieldTypeCreateCommand command =
				new HintFieldTypeCreateCommand("TestHintFieldType", new One(this.getModel()));
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.HintFieldTypeCreateCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final HintFieldTypeCreateCommand command =
				new HintFieldTypeCreateCommand("TestHintFieldType", new One(this.getModel()));
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
		final HintFieldTypeCreateCommand command =
				new HintFieldTypeCreateCommand("TestHintFieldType", new One(this.getModel()));
		command.execute(this.getModel());
		final HintFieldType type = command.getResult();
		Assert.assertEquals("TestHintFieldType", type.getName());
	}

}
