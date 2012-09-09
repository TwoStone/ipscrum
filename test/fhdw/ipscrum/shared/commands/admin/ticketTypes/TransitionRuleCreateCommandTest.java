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
import fhdw.ipscrum.shared.model.metamodel.states.TransitionRule;

/**
 * 
 */
public class TransitionRuleCreateCommandTest extends TicketTypeTestBase {

	/**
	 * Description of the test state type.
	 */
	private static final String TO_STATETYPE_DESC = "This is a test state type";

	/**
	 * Name of the test state type.
	 */
	private static final String TO_STATETYPE_NAME = "TestToStateType";

	/**
	 * Description of the test state type.
	 */
	private static final String FROM_STATETYPE_DESC = "This is a test state type";

	/**
	 * Name of the test state type.
	 */
	private static final String FROM_STATETYPE_NAME = "TestFromStateType";

	/**
	 * to State type for tests.
	 */
	private StateType toStatetype;

	/**
	 * from state type for tests.
	 */
	private StateType fromStatetype;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.toStatetype =
				new StateType(this.getModel(), TransitionRuleCreateCommandTest.TO_STATETYPE_NAME,
						TransitionRuleCreateCommandTest.TO_STATETYPE_DESC);
		this.fromStatetype =
				new StateType(this.getModel(), TransitionRuleCreateCommandTest.FROM_STATETYPE_NAME,
						TransitionRuleCreateCommandTest.FROM_STATETYPE_DESC);
		this.getTicketType().addPossibleState(this.fromStatetype);
		this.getTicketType().addPossibleState(this.toStatetype);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TransitionRuleCreateCommand#TransitionRuleCreateCommand(fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType, fhdw.ipscrum.shared.model.metamodel.states.StateType, fhdw.ipscrum.shared.model.metamodel.states.StateType)}
	 * .
	 */
	@Test
	public final void testTransitionRuleCreateCommand() {
		final TransitionRuleCreateCommand command =
				new TransitionRuleCreateCommand(this.getTicketType(), this.fromStatetype, this.toStatetype);
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TransitionRuleCreateCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final TransitionRuleCreateCommand command =
				new TransitionRuleCreateCommand(this.getTicketType(), this.fromStatetype, this.toStatetype);

		final TransitionRule transitionRule = command.onExecute(this.getModel());
		Assert.assertEquals(this.fromStatetype, transitionRule.getFrom());
		Assert.assertEquals(this.toStatetype, transitionRule.getTo());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TransitionRuleCreateCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final TransitionRuleCreateCommand command =
				new TransitionRuleCreateCommand(this.getTicketType(), this.fromStatetype, this.toStatetype);
		command.accept(new CommandStandardVisitor() {

			@Override
			public void
					handleTransitionRuleCreateCommand(final TransitionRuleCreateCommand transitionRuleCreateCommand) {

			}

			@Override
			public void standardHandling(final ICommand cmd) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TransitionRuleCreateCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final TransitionRuleCreateCommand command =
				new TransitionRuleCreateCommand(this.getTicketType(), this.fromStatetype, this.toStatetype);
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TransitionRuleCreateCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final TransitionRuleCreateCommand command =
				new TransitionRuleCreateCommand(this.getTicketType(), this.fromStatetype, this.toStatetype);
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
		final TransitionRuleCreateCommand command =
				new TransitionRuleCreateCommand(this.getTicketType(), this.fromStatetype, this.toStatetype);
		command.execute(this.getModel());
		final TransitionRule transitionRule = command.getResult();
		Assert.assertEquals(this.fromStatetype, transitionRule.getFrom());
		Assert.assertEquals(this.toStatetype, transitionRule.getTo());
	}

}
