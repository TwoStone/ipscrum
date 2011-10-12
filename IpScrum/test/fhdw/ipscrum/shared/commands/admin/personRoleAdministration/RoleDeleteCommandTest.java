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
public class RoleDeleteCommandTest extends RoleTestBase {

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleDeleteCommand#RoleDeleteCommand(fhdw.ipscrum.shared.model.nonMeta.Role)}
	 * .
	 */
	@Test
	public final void testRoleDeleteCommand() {
		final RoleDeleteCommand command = new RoleDeleteCommand(this.getRole());
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleDeleteCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final RoleDeleteCommand command = new RoleDeleteCommand(this.getRole());
		command.onExecute(this.getModel());
		Assert.assertTrue(this.getRole().isDeleted());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleDeleteCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final RoleDeleteCommand command = new RoleDeleteCommand(this.getRole());
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handleRoleDeleteCommand(final RoleDeleteCommand roleDeleteCommand) {

			}

			@Override
			public void standardHandling(final ICommand cmd) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleDeleteCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final RoleDeleteCommand command = new RoleDeleteCommand(this.getRole());
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleDeleteCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final RoleDeleteCommand command = new RoleDeleteCommand(this.getRole());
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
		final RoleDeleteCommand command = new RoleDeleteCommand(this.getRole());
		command.execute(this.getModel());
		Assert.assertTrue(this.getRole().isDeleted());
	}

}
