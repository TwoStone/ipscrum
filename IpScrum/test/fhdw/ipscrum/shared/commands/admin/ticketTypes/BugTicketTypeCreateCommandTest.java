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
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.BugTicketType;

/**
 * 
 */
public class BugTicketTypeCreateCommandTest extends ModelTestBase {

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.BugTicketTypeCreateCommand#BugTicketTypeCreateCommand(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void testBugTicketTypeCreateCommand() {
		final BugTicketTypeCreateCommand command =
				new BugTicketTypeCreateCommand("New Bugtest Type", "This is a new test type!");
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.BugTicketTypeCreateCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final BugTicketTypeCreateCommand command =
				new BugTicketTypeCreateCommand("New Bugtest Type", "This is a new test type!");

		final BugTicketType bugTicketType = command.onExecute(this.getModel());
		Assert.assertEquals("New Bugtest Type", bugTicketType.getTypeName());

	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.BugTicketTypeCreateCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final BugTicketTypeCreateCommand command =
				new BugTicketTypeCreateCommand("New Bugtest Type", "This is a new test type!");

		command.accept(new CommandStandardVisitor() {

			@Override
			public void handleBugTicketTypeCreateCommand(final BugTicketTypeCreateCommand bugTicketTypeCreateCommand) {

			}

			@Override
			public void standardHandling(final ICommand command) {
				Assert.fail();
			}
		});

	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.BugTicketTypeCreateCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final BugTicketTypeCreateCommand command =
				new BugTicketTypeCreateCommand("New Bugtest Type", "This is a new test type!");

		Assert.assertFalse(command.dependsOnProject());

	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.BugTicketTypeCreateCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object was missing
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final BugTicketTypeCreateCommand command =
				new BugTicketTypeCreateCommand("New Bugtest Type", "This is a new test type!");

		Assert.assertNull(command.getDependingProject(this.getModel()));
	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.infrastructure.Command#execute(fhdw.ipscrum.shared.model.Model)}.
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occured
	 */
	@Test
	public final void testExecuteModel() throws IPScrumGeneralException {
		final BugTicketTypeCreateCommand command =
				new BugTicketTypeCreateCommand("New Bugtest Type", "This is a new test type!");

		command.execute(this.getModel());
		final BugTicketType result = command.getResult();
		Assert.assertEquals("New Bugtest Type", result.getTypeName());
		Assert.assertEquals("This is a new test type!", result.getTypeDescription());
	}

}
