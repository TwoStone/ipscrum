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
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TaskTicketType;

/**
 * 
 */
public class TaskTicketTypeCreateCommandTest extends ModelTestBase {

	/**
	 * test string for description.
	 */
	private static final String TYPE_DESCRIPTION = "This is a new task type!";
	/**
	 * test string for name.
	 */
	private static final String TYPE_NAME = "New task type";

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TaskTicketTypeCreateCommand#TaskTicketTypeCreateCommand(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void testTaskTicketTypeCreateCommand() {
		final TaskTicketTypeCreateCommand command =
				new TaskTicketTypeCreateCommand(TaskTicketTypeCreateCommandTest.TYPE_NAME,
						TaskTicketTypeCreateCommandTest.TYPE_DESCRIPTION);
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TaskTicketTypeCreateCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final TaskTicketTypeCreateCommand command =
				new TaskTicketTypeCreateCommand(TaskTicketTypeCreateCommandTest.TYPE_NAME,
						TaskTicketTypeCreateCommandTest.TYPE_DESCRIPTION);

		final TaskTicketType type = command.onExecute(this.getModel());
		Assert.assertEquals(TaskTicketTypeCreateCommandTest.TYPE_NAME, type.getTypeName());
		Assert.assertEquals(TaskTicketTypeCreateCommandTest.TYPE_DESCRIPTION, type.getTypeDescription());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TaskTicketTypeCreateCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final TaskTicketTypeCreateCommand command =
				new TaskTicketTypeCreateCommand(TaskTicketTypeCreateCommandTest.TYPE_NAME,
						TaskTicketTypeCreateCommandTest.TYPE_DESCRIPTION);
		command.accept(new CommandStandardVisitor() {

			@Override
			public void
					handleTaskTicketTypeCreateCommand(final TaskTicketTypeCreateCommand taskTicketTypeCreateCommand) {

			}

			@Override
			public void standardHandling(final ICommand cmd) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TaskTicketTypeCreateCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final TaskTicketTypeCreateCommand command =
				new TaskTicketTypeCreateCommand(TaskTicketTypeCreateCommandTest.TYPE_NAME,
						TaskTicketTypeCreateCommandTest.TYPE_DESCRIPTION);
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TaskTicketTypeCreateCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object was not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final TaskTicketTypeCreateCommand command =
				new TaskTicketTypeCreateCommand(TaskTicketTypeCreateCommandTest.TYPE_NAME,
						TaskTicketTypeCreateCommandTest.TYPE_DESCRIPTION);

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
		final TaskTicketTypeCreateCommand command =
				new TaskTicketTypeCreateCommand(TaskTicketTypeCreateCommandTest.TYPE_NAME,
						TaskTicketTypeCreateCommandTest.TYPE_DESCRIPTION);

		command.execute(this.getModel());
		final TaskTicketType type = command.getResult();
		Assert.assertEquals(TaskTicketTypeCreateCommandTest.TYPE_NAME, type.getTypeName());
		Assert.assertEquals(TaskTicketTypeCreateCommandTest.TYPE_DESCRIPTION, type.getTypeDescription());
	}

}
