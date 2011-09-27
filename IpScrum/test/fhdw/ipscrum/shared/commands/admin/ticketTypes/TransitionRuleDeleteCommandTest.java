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
public class TransitionRuleDeleteCommandTest extends TicketTypeTestBase {

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

	/**
	 * Transition rule for tests.
	 */
	private TransitionRule transitionRule;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.toStatetype =
				new StateType(this.getModel(), TransitionRuleDeleteCommandTest.TO_STATETYPE_NAME,
						TransitionRuleDeleteCommandTest.TO_STATETYPE_DESC);
		this.fromStatetype =
				new StateType(this.getModel(), TransitionRuleDeleteCommandTest.FROM_STATETYPE_NAME,
						TransitionRuleDeleteCommandTest.FROM_STATETYPE_DESC);
		this.getTicketType().addPossibleState(this.fromStatetype);
		this.getTicketType().addPossibleState(this.toStatetype);
		this.transitionRule = new TransitionRule(this.getModel(), this.fromStatetype, this.toStatetype);
		this.getTicketType().addTransitionRule(this.transitionRule);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TransitionRuleDeleteCommand#TransitionRuleDeleteCommand(fhdw.ipscrum.shared.model.metamodel.states.TransitionRule, fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType)}
	 * .
	 */
	@Test
	public final void testTransitionRuleDeleteCommand() {
		final TransitionRuleDeleteCommand command =
				new TransitionRuleDeleteCommand(this.transitionRule, this.getTicketType());
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TransitionRuleDeleteCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final TransitionRuleDeleteCommand command =
				new TransitionRuleDeleteCommand(this.transitionRule, this.getTicketType());
		Assert.assertTrue(this.getTicketType().getStateProfile().getTransitionRules().contains(this.transitionRule));
		command.onExecute(this.getModel());
		Assert.assertFalse(this.getTicketType().getStateProfile().getTransitionRules().contains(this.transitionRule));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TransitionRuleDeleteCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final TransitionRuleDeleteCommand command =
				new TransitionRuleDeleteCommand(this.transitionRule, this.getTicketType());
		command.accept(new CommandStandardVisitor() {

			@Override
			public void
					handleTransitionRuleDeleteCommand(final TransitionRuleDeleteCommand transitionRuleDeleteCommand) {

			}

			@Override
			public void standardHandling(final ICommand command) {
				Assert.fail();

			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TransitionRuleDeleteCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final TransitionRuleDeleteCommand command =
				new TransitionRuleDeleteCommand(this.transitionRule, this.getTicketType());
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TransitionRuleDeleteCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final TransitionRuleDeleteCommand command =
				new TransitionRuleDeleteCommand(this.transitionRule, this.getTicketType());
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
		final TransitionRuleDeleteCommand command =
				new TransitionRuleDeleteCommand(this.transitionRule, this.getTicketType());
		Assert.assertTrue(this.getTicketType().getStateProfile().getTransitionRules().contains(this.transitionRule));
		command.execute(this.getModel());
		Assert.assertFalse(this.getTicketType().getStateProfile().getTransitionRules().contains(this.transitionRule));
	}

}
