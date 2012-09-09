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
import fhdw.ipscrum.shared.model.messages.ModelTestBase;
import fhdw.ipscrum.shared.model.nonMeta.Role;

/**
 * 
 */
public class RoleCreateCommandTest extends ModelTestBase {

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleCreateCommand#RoleCreateCommand(java.lang.String)}
	 * .
	 */
	@Test
	public final void testRoleCreateCommand() {
		final RoleCreateCommand command = new RoleCreateCommand("TestRole");
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleCreateCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final RoleCreateCommand command = new RoleCreateCommand("TestRole");
		final Role role = command.onExecute(this.getModel());
		Assert.assertEquals("TestRole", role.getDescription());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleCreateCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final RoleCreateCommand command = new RoleCreateCommand("TestRole");
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handleRoleCreateCommand(final RoleCreateCommand roleCreateCommand) {

			}

			@Override
			public void standardHandling(final ICommand cmd) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleCreateCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final RoleCreateCommand command = new RoleCreateCommand("TestRole");
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleCreateCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final RoleCreateCommand command = new RoleCreateCommand("TestRole");
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
		final RoleCreateCommand command = new RoleCreateCommand("TestRole");
		command.execute(this.getModel());
		final Role role = command.getResult();
		Assert.assertEquals("TestRole", role.getDescription());
	}

}
