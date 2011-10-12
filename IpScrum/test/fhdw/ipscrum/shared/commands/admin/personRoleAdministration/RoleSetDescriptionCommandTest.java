/**
 * 
 */
package fhdw.ipscrum.shared.commands.admin.personRoleAdministration;

import junit.framework.Assert;

import org.junit.Test;

import fhdw.ipscrum.shared.commands.interfaces.ICommand;
import fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;

/**
 * 
 */
public class RoleSetDescriptionCommandTest extends RoleTestBase {

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleSetDescriptionCommand#RoleSetDescriptionCommand(fhdw.ipscrum.shared.model.nonMeta.Role, java.lang.String)}
	 * .
	 */
	@Test
	public final void testRoleSetDescriptionCommand() {
		final RoleSetDescriptionCommand command = new RoleSetDescriptionCommand(this.getRole(), "NewRoleDescription");
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleSetDescriptionCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final RoleSetDescriptionCommand command = new RoleSetDescriptionCommand(this.getRole(), "NewRoleDescription");
		command.onExecute(this.getModel());
		Assert.assertEquals("NewRoleDescription", this.getRole().getDescription());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleSetDescriptionCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final RoleSetDescriptionCommand command = new RoleSetDescriptionCommand(this.getRole(), "NewRoleDescription");
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handleRoleSetDescriptionCommand(final RoleSetDescriptionCommand roleSetDescriptionCommand) {

			}

			@Override
			public void standardHandling(final ICommand cmd) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleSetDescriptionCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final RoleSetDescriptionCommand command = new RoleSetDescriptionCommand(this.getRole(), "NewRoleDescription");
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleSetDescriptionCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final RoleSetDescriptionCommand command = new RoleSetDescriptionCommand(this.getRole(), "NewRoleDescription");
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
		final RoleSetDescriptionCommand command = new RoleSetDescriptionCommand(this.getRole(), "NewRoleDescription");
		command.execute(this.getModel());
		Assert.assertEquals("NewRoleDescription", this.getRole().getDescription());
	}

}
