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
import fhdw.ipscrum.shared.model.metamodel.fields.AcceptanceCriteriaFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.One;

/**
 * 
 */
public class AcceptanceCriteriaFieldTypeCreateCommandTest extends ModelTestBase {

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.AcceptanceCriteriaFieldTypeCreateCommand#AcceptanceCriteriaFieldTypeCreateCommand(java.lang.String, fhdw.ipscrum.shared.model.metamodel.fields.Multiplicity)}
	 * .
	 */
	@Test
	public final void testAcceptanceCriteriaFieldTypeCreateCommand() {
		final AcceptanceCriteriaFieldTypeCreateCommand command =
				new AcceptanceCriteriaFieldTypeCreateCommand("testAcceptanceCrit", new One(this.getModel()));
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.AcceptanceCriteriaFieldTypeCreateCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final AcceptanceCriteriaFieldTypeCreateCommand command =
				new AcceptanceCriteriaFieldTypeCreateCommand("testAcceptanceCrit", new One(this.getModel()));
		final AcceptanceCriteriaFieldType type = command.onExecute(this.getModel());
		Assert.assertEquals("testAcceptanceCrit", type.getName());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.AcceptanceCriteriaFieldTypeCreateCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final AcceptanceCriteriaFieldTypeCreateCommand command =
				new AcceptanceCriteriaFieldTypeCreateCommand("testAcceptanceCrit", new One(this.getModel()));
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handleAcceptanceCriteriaFieldTypeCreateCommand(
					final AcceptanceCriteriaFieldTypeCreateCommand acceptanceCriteriaFieldTypeCreateCommand) {

			}

			@Override
			public void standardHandling(final ICommand cmd) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.AcceptanceCriteriaFieldTypeCreateCommand#dependsOnProject()}
	 * .
	 */
	@Test
	public final void testDependsOnProject() {
		final AcceptanceCriteriaFieldTypeCreateCommand command =
				new AcceptanceCriteriaFieldTypeCreateCommand("testAcceptanceCrit", new One(this.getModel()));
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.fieldTypes.AcceptanceCriteriaFieldTypeCreateCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final AcceptanceCriteriaFieldTypeCreateCommand command =
				new AcceptanceCriteriaFieldTypeCreateCommand("testAcceptanceCrit", new One(this.getModel()));
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
		final AcceptanceCriteriaFieldTypeCreateCommand command =
				new AcceptanceCriteriaFieldTypeCreateCommand("testAcceptanceCrit", new One(this.getModel()));
		command.execute(this.getModel());
		final AcceptanceCriteriaFieldType type = command.getResult();
		Assert.assertEquals("testAcceptanceCrit", type.getName());
	}

}
