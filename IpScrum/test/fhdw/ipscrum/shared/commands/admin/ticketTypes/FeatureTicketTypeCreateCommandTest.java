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
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;

/**
 * 
 */
public class FeatureTicketTypeCreateCommandTest extends ModelTestBase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.model.messages.ModelTestBase#setUp()
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.FeatureTicketTypeCreateCommandTest#FeatureTicketTypeCreateCommand(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void testFeatureTicketTypeCreateCommand() {
		final FeatureTicketTypeCreateCommand command =
				new FeatureTicketTypeCreateCommand("Test feature type", "This is a test feature type");
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.FeatureTicketTypeCreateCommandTest#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             on error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final FeatureTicketTypeCreateCommand command =
				new FeatureTicketTypeCreateCommand("Test feature type", "This is a test feature type");
		final FeatureTicketType type = command.onExecute(this.getModel());
		Assert.assertEquals("Test feature type", type.getTypeName());
		Assert.assertEquals("This is a test feature type", type.getTypeDescription());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.FeatureTicketTypeCreateCommandTest#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final FeatureTicketTypeCreateCommand command =
				new FeatureTicketTypeCreateCommand("Test feature type", "This is a test feature type");
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handleFeatureTicketTypeCreateCommand(
					final FeatureTicketTypeCreateCommand featureTicketTypeCreateCommand) {

			}

			@Override
			public void standardHandling(final ICommand command) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.FeatureTicketTypeCreateCommandTest#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final FeatureTicketTypeCreateCommand command =
				new FeatureTicketTypeCreateCommand("Test feature type", "This is a test feature type");
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.ticketTypes.FeatureTicketTypeCreateCommandTest#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final FeatureTicketTypeCreateCommand command =
				new FeatureTicketTypeCreateCommand("Test feature type", "This is a test feature type");
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
		final FeatureTicketTypeCreateCommand command =
				new FeatureTicketTypeCreateCommand("Test feature type", "This is a test feature type");
		command.execute(this.getModel());
		final FeatureTicketType type = command.getResult();
		Assert.assertEquals("Test feature type", type.getTypeName());
		Assert.assertEquals("This is a test feature type", type.getTypeDescription());
	}

}
