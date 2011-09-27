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
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.Many;
import fhdw.ipscrum.shared.model.metamodel.fields.TextFieldType;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;

/**
 * 
 */
public class TicketTypeSetFieldTypeActivityCommandTest extends TicketTypeTestBase {

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

	/**
	 * Name of the test type.
	 */
	private static final String TYPE_NAME = "TestTextFieldType";
	/**
	 * Field type for tests.
	 */
	private FieldType fieldType;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.fieldType =
				new TextFieldType(this.getModel(), TicketTypeSetFieldTypeActivityCommandTest.TYPE_NAME, new Many(
						this.getModel()));
		this.statetype =
				new StateType(this.getModel(), TicketTypeSetFieldTypeActivityCommandTest.STATETYPE_NAME,
						TicketTypeSetFieldTypeActivityCommandTest.STATETYPE_DESC);
		this.getTicketType().addPossibleState(this.statetype);
		this.getTicketType().addFieldType(this.fieldType);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeSetFieldTypeActivityCommand#TicketTypeSetFieldTypeActivityCommand(fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType, fhdw.ipscrum.shared.model.metamodel.fields.FieldType, fhdw.ipscrum.shared.model.metamodel.states.StateType, java.lang.Boolean)}
	 * .
	 */
	@Test
	public final void testTicketTypeSetFieldTypeActivityCommand() {
		final TicketTypeSetFieldTypeActivityCommand command =
				new TicketTypeSetFieldTypeActivityCommand(this.getTicketType(), this.fieldType, this.statetype, true);
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeSetFieldTypeActivityCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final TicketTypeSetFieldTypeActivityCommand command =
				new TicketTypeSetFieldTypeActivityCommand(this.getTicketType(), this.fieldType, this.statetype, true);
		Assert.assertFalse(this.getTicketType().getStateProfile().isFieldActive(this.statetype, this.fieldType));
		command.onExecute(this.getModel());
		Assert.assertTrue(this.getTicketType().getStateProfile().isFieldActive(this.statetype, this.fieldType));

		final TicketTypeSetFieldTypeActivityCommand command2 =
				new TicketTypeSetFieldTypeActivityCommand(this.getTicketType(), this.fieldType, this.statetype, false);
		command2.onExecute(this.getModel());
		Assert.assertFalse(this.getTicketType().getStateProfile().isFieldActive(this.statetype, this.fieldType));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeSetFieldTypeActivityCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final TicketTypeSetFieldTypeActivityCommand command =
				new TicketTypeSetFieldTypeActivityCommand(this.getTicketType(), this.fieldType, this.statetype, true);
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handleTicketTypeSetFieldTypeActivityCommand(
					final TicketTypeSetFieldTypeActivityCommand ticketTypeSetFieldTypeActivityCommand) {

			}

			@Override
			public void standardHandling(final ICommand command) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeSetFieldTypeActivityCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final TicketTypeSetFieldTypeActivityCommand command =
				new TicketTypeSetFieldTypeActivityCommand(this.getTicketType(), this.fieldType, this.statetype, true);
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeSetFieldTypeActivityCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final TicketTypeSetFieldTypeActivityCommand command =
				new TicketTypeSetFieldTypeActivityCommand(this.getTicketType(), this.fieldType, this.statetype, true);
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
		final TicketTypeSetFieldTypeActivityCommand command =
				new TicketTypeSetFieldTypeActivityCommand(this.getTicketType(), this.fieldType, this.statetype, true);

		Assert.assertFalse(this.getTicketType().getStateProfile().isFieldActive(this.statetype, this.fieldType));
		command.execute(this.getModel());
		Assert.assertTrue(this.getTicketType().getStateProfile().isFieldActive(this.statetype, this.fieldType));

		final TicketTypeSetFieldTypeActivityCommand command2 =
				new TicketTypeSetFieldTypeActivityCommand(this.getTicketType(), this.fieldType, this.statetype, false);
		command2.execute(this.getModel());
		Assert.assertFalse(this.getTicketType().getStateProfile().isFieldActive(this.statetype, this.fieldType));

	}

}
