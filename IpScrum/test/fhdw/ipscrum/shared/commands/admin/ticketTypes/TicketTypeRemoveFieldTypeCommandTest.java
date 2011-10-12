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
import fhdw.ipscrum.shared.model.metamodel.fields.One;
import fhdw.ipscrum.shared.model.metamodel.fields.TextFieldType;

/**
 * 
 */
public class TicketTypeRemoveFieldTypeCommandTest extends TicketTypeTestBase {

	/**
	 * Name of the test type.
	 */
	private static final String TYPE_NAME = "TestTextFieldType";
	/**
	 * Field type for tests.
	 */
	private FieldType fieldType;

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeTestBase#setUp()
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.fieldType =
				new TextFieldType(this.getModel(), TicketTypeRemoveFieldTypeCommandTest.TYPE_NAME, new One(
						this.getModel()));
		this.getTicketType().addFieldType(this.fieldType);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeRemoveFieldTypeCommand#TicketTypeRemoveFieldTypeCommand(fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType, fhdw.ipscrum.shared.model.metamodel.fields.FieldType)}
	 * .
	 */
	@Test
	public final void testTicketTypeRemoveFieldTypeCommand() {
		final TicketTypeRemoveFieldTypeCommand command =
				new TicketTypeRemoveFieldTypeCommand(this.getTicketType(), this.fieldType);
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeRemoveFieldTypeCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final TicketTypeRemoveFieldTypeCommand command =
				new TicketTypeRemoveFieldTypeCommand(this.getTicketType(), this.fieldType);
		Assert.assertTrue(this.getTicketType().getAllFieldTypes().contains(this.fieldType));
		command.onExecute(this.getModel());
		Assert.assertFalse(this.getTicketType().getAllFieldTypes().contains(this.fieldType));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeRemoveFieldTypeCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final TicketTypeRemoveFieldTypeCommand command =
				new TicketTypeRemoveFieldTypeCommand(this.getTicketType(), this.fieldType);
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handleTicketTypeRemoveFieldTypeCommand(
					final TicketTypeRemoveFieldTypeCommand ticketTypeRemoveFieldTypeCommand) {

			}

			@Override
			public void standardHandling(final ICommand cmd) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeRemoveFieldTypeCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final TicketTypeRemoveFieldTypeCommand command =
				new TicketTypeRemoveFieldTypeCommand(this.getTicketType(), this.fieldType);
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeRemoveFieldTypeCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final TicketTypeRemoveFieldTypeCommand command =
				new TicketTypeRemoveFieldTypeCommand(this.getTicketType(), this.fieldType);
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
		final TicketTypeRemoveFieldTypeCommand command =
				new TicketTypeRemoveFieldTypeCommand(this.getTicketType(), this.fieldType);
		Assert.assertTrue(this.getTicketType().getAllFieldTypes().contains(this.fieldType));
		command.execute(this.getModel());
		Assert.assertFalse(this.getTicketType().getAllFieldTypes().contains(this.fieldType));
	}

}
