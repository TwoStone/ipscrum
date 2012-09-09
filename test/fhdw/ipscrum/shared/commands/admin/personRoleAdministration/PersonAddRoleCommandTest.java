/**
 * 
 */
package fhdw.ipscrum.shared.commands.admin.personRoleAdministration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.commands.interfaces.ICommand;
import fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.nonMeta.Role;

/**
 * 
 */
public class PersonAddRoleCommandTest extends PersonTestBase {

	/**
	 * Role for testing.
	 */
	private Role role;

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonTestBase#setUp()
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.role = new Role(this.getModel(), "TestRole");
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonAddRoleCommand#PersonAddRoleCommand(fhdw.ipscrum.shared.model.nonMeta.Person, fhdw.ipscrum.shared.model.nonMeta.Role)}
	 * .
	 */
	@Test
	public final void testPersonAddRoleCommand() {
		final PersonAddRoleCommand command = new PersonAddRoleCommand(this.getPerson(), this.role);
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonAddRoleCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final PersonAddRoleCommand command = new PersonAddRoleCommand(this.getPerson(), this.role);
		Assert.assertFalse(this.getPerson().getRoles().contains(this.role));
		command.onExecute(this.getModel());
		Assert.assertTrue(this.getPerson().getRoles().contains(this.role));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonAddRoleCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final PersonAddRoleCommand command = new PersonAddRoleCommand(this.getPerson(), this.role);
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handlePersonAddRoleCommand(final PersonAddRoleCommand personAddRoleCommand) {

			}

			@Override
			public void standardHandling(final ICommand cmd) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonAddRoleCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final PersonAddRoleCommand command = new PersonAddRoleCommand(this.getPerson(), this.role);
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonAddRoleCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final PersonAddRoleCommand command = new PersonAddRoleCommand(this.getPerson(), this.role);
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
		final PersonAddRoleCommand command = new PersonAddRoleCommand(this.getPerson(), this.role);
		Assert.assertFalse(this.getPerson().getRoles().contains(this.role));
		command.execute(this.getModel());
		Assert.assertTrue(this.getPerson().getRoles().contains(this.role));
	}

}
