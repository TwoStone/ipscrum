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
import fhdw.ipscrum.shared.model.metamodel.states.StateType;

/**
 * 
 */
public class TicketTypeRemoveStateTypeCommandTest extends TicketTypeTestBase {

	/**
	 * Description of the test state type.
	 */
	private static final String STATETYPE_DESC = "This is a test state type";

	/**
	 * Name of the test state type.
	 */
	private static final String STATETYPE_NAME = "TestStateType";

	/**
	 * State type for tests.
	 */
	private StateType statetype;

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeTestBase#setUp()
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.statetype =
				new StateType(this.getModel(), TicketTypeRemoveStateTypeCommandTest.STATETYPE_NAME,
						TicketTypeRemoveStateTypeCommandTest.STATETYPE_DESC);
		this.getTicketType().addPossibleState(this.statetype);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeRemoveStateTypeCommand#TicketTypeRemoveStateTypeCommand(fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType, fhdw.ipscrum.shared.model.metamodel.states.StateType)}
	 * .
	 */
	@Test
	public final void testTicketTypeRemoveStateTypeCommand() {
		final TicketTypeRemoveStateTypeCommand command =
				new TicketTypeRemoveStateTypeCommand(this.getTicketType(), this.statetype);
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeRemoveStateTypeCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final TicketTypeRemoveStateTypeCommand command =
				new TicketTypeRemoveStateTypeCommand(this.getTicketType(), this.statetype);
		Assert.assertTrue(this.getTicketType().getStateProfile().getPossibleStates().contains(this.statetype));
		command.onExecute(this.getModel());
		Assert.assertFalse(this.getTicketType().getStateProfile().getPossibleStates().contains(this.statetype));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeRemoveStateTypeCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final TicketTypeRemoveStateTypeCommand command =
				new TicketTypeRemoveStateTypeCommand(this.getTicketType(), this.statetype);
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handleTicketTypeRemoveStateTypeCommand(
					final TicketTypeRemoveStateTypeCommand ticketTypeRemoveStateTypeCommand) {

			}

			@Override
			public void standardHandling(final ICommand command) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeRemoveStateTypeCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final TicketTypeRemoveStateTypeCommand command =
				new TicketTypeRemoveStateTypeCommand(this.getTicketType(), this.statetype);
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeRemoveStateTypeCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final TicketTypeRemoveStateTypeCommand command =
				new TicketTypeRemoveStateTypeCommand(this.getTicketType(), this.statetype);
		Assert.assertNull(command.getDependingProject(this.getModel()));
	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.infrastructure.Command#execute(fhdw.ipscrum.shared.model.Model)}.
	 * 
	 * @throws IPScrumGeneralException
	 *             error occurred
	 */
	@Test
	public final void testExecuteModel() throws IPScrumGeneralException {
		final TicketTypeRemoveStateTypeCommand command =
				new TicketTypeRemoveStateTypeCommand(this.getTicketType(), this.statetype);
		Assert.assertTrue(this.getTicketType().getStateProfile().getPossibleStates().contains(this.statetype));
		command.execute(this.getModel());
		Assert.assertFalse(this.getTicketType().getStateProfile().getPossibleStates().contains(this.statetype));
	}

}
