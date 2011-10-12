/**
 * 
 */
package fhdw.ipscrum.shared.commands.admin.ticketTypes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.commands.interfaces.ICommand;
import fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.messages.ModelTestBase;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;

/**
 * 
 */
public class StateTypeCreateCommandTest extends ModelTestBase {

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.StateTypeCreateCommand#StateTypeCreateCommand(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void testStateTypeCreateCommand() {
		final StateTypeCreateCommand command =
				new StateTypeCreateCommand("New TestStateType", "This is test state type");
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.StateTypeCreateCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occured
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final StateTypeCreateCommand command =
				new StateTypeCreateCommand("New TestStateType", "This is a test state type");
		final StateType type = command.onExecute(this.getModel());
		Assert.assertEquals("New TestStateType", type.getName());
		Assert.assertEquals("This is a test state type", type.getDescription());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.StateTypeCreateCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final StateTypeCreateCommand command =
				new StateTypeCreateCommand("New TestStateType", "This is test state type");
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handleStateTypeCreateCommand(final StateTypeCreateCommand stateTypeCreateCommand) {

			}

			@Override
			public void standardHandling(final ICommand cmd) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.StateTypeCreateCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final StateTypeCreateCommand command =
				new StateTypeCreateCommand("New TestStateType", "This is test state type");

		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.StateTypeCreateCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final StateTypeCreateCommand command =
				new StateTypeCreateCommand("New TestStateType", "This is test state type");

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
		final StateTypeCreateCommand command =
				new StateTypeCreateCommand("New TestStateType", "This is a test state type");
		command.execute(this.getModel());
		final StateType type = command.getResult();
		Assert.assertEquals("New TestStateType", type.getName());
		Assert.assertEquals("This is a test state type", type.getDescription());
	}

}
