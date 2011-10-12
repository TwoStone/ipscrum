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
import fhdw.ipscrum.shared.model.metamodel.fields.One;
import fhdw.ipscrum.shared.model.metamodel.fields.TextFieldType;

/**
 * 
 */
public class TicketTypeAddFieldTypeCommandTest extends TicketTypeTestBase {

	/**
	 * Field for tests.
	 */
	private TextFieldType field;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.field = new TextFieldType(this.getModel(), "TestTextField", new One(this.getModel()));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeAddFieldTypeCommand#TicketTypeAddFieldTypeCommand(fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType, fhdw.ipscrum.shared.model.metamodel.fields.FieldType)}
	 * .
	 */
	@Test
	public final void testTicketTypeAddFieldTypeCommand() {
		final TicketTypeAddFieldTypeCommand command =
				new TicketTypeAddFieldTypeCommand(this.getTicketType(), this.field);
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeAddFieldTypeCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final TicketTypeAddFieldTypeCommand command =
				new TicketTypeAddFieldTypeCommand(this.getTicketType(), this.field);
		Assert.assertFalse(this.getTicketType().getAllFieldTypes().contains(this.field));
		command.onExecute(this.getModel());
		Assert.assertTrue(this.getTicketType().getAllFieldTypes().contains(this.field));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeAddFieldTypeCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final TicketTypeAddFieldTypeCommand command =
				new TicketTypeAddFieldTypeCommand(this.getTicketType(), this.field);
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handleTicketTypeAddFieldTypeCommand(
					final TicketTypeAddFieldTypeCommand ticketTypeAddFieldTypeCommand) {

			}

			@Override
			public void standardHandling(final ICommand cmd) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeAddFieldTypeCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final TicketTypeAddFieldTypeCommand command =
				new TicketTypeAddFieldTypeCommand(this.getTicketType(), this.field);
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeAddFieldTypeCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object was not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final TicketTypeAddFieldTypeCommand command =
				new TicketTypeAddFieldTypeCommand(this.getTicketType(), this.field);
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
		final TicketTypeAddFieldTypeCommand command =
				new TicketTypeAddFieldTypeCommand(this.getTicketType(), this.field);
		Assert.assertFalse(this.getTicketType().getAllFieldTypes().contains(this.field));
		command.execute(this.getModel());
		Assert.assertTrue(this.getTicketType().getAllFieldTypes().contains(this.field));

	}

}
