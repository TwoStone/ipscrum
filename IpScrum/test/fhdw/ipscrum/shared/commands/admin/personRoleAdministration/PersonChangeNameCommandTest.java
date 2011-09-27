/**
 * 
 */
package fhdw.ipscrum.shared.commands.admin.personRoleAdministration;

import org.junit.Assert;
import org.junit.Test;

import fhdw.ipscrum.shared.commands.interfaces.ICommand;
import fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;

/**
 * 
 */
public class PersonChangeNameCommandTest extends PersonTestBase {

	/**
	 * New firstname of the person.
	 */
	private static final String NEW_FIRSTNAME = "Bruce";
	/**
	 * New lastname of the person.
	 */
	private static final String NEW_LASTNAME = "Banner";

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonChangeNameCommand#PersonChangeNameCommand(fhdw.ipscrum.shared.model.nonMeta.Person, java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void testPersonChangeNameCommand() {
		final PersonChangeNameCommand command =
				new PersonChangeNameCommand(this.getPerson(), PersonChangeNameCommandTest.NEW_FIRSTNAME,
						PersonChangeNameCommandTest.NEW_LASTNAME);
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonChangeNameCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final PersonChangeNameCommand command =
				new PersonChangeNameCommand(this.getPerson(), PersonChangeNameCommandTest.NEW_FIRSTNAME,
						PersonChangeNameCommandTest.NEW_LASTNAME);
		command.onExecute(this.getModel());
		Assert.assertEquals(PersonChangeNameCommandTest.NEW_FIRSTNAME, this.getPerson().getFirstname());
		Assert.assertEquals(PersonChangeNameCommandTest.NEW_LASTNAME, this.getPerson().getLastname());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonChangeNameCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final PersonChangeNameCommand command =
				new PersonChangeNameCommand(this.getPerson(), PersonChangeNameCommandTest.NEW_FIRSTNAME,
						PersonChangeNameCommandTest.NEW_LASTNAME);
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handlePersonChangeNameCommand(final PersonChangeNameCommand personChangeNameCommand) {

			}

			@Override
			public void standardHandling(final ICommand command) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonChangeNameCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final PersonChangeNameCommand command =
				new PersonChangeNameCommand(this.getPerson(), PersonChangeNameCommandTest.NEW_FIRSTNAME,
						PersonChangeNameCommandTest.NEW_LASTNAME);
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonChangeNameCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final PersonChangeNameCommand command =
				new PersonChangeNameCommand(this.getPerson(), PersonChangeNameCommandTest.NEW_FIRSTNAME,
						PersonChangeNameCommandTest.NEW_LASTNAME);
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
		final PersonChangeNameCommand command =
				new PersonChangeNameCommand(this.getPerson(), PersonChangeNameCommandTest.NEW_FIRSTNAME,
						PersonChangeNameCommandTest.NEW_LASTNAME);

		command.execute(this.getModel());
		Assert.assertEquals(PersonChangeNameCommandTest.NEW_FIRSTNAME, this.getPerson().getFirstname());
		Assert.assertEquals(PersonChangeNameCommandTest.NEW_LASTNAME, this.getPerson().getLastname());
	}

}
