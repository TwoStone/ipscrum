/**
 * 
 */
package fhdw.ipscrum.shared.commands.admin.personRoleAdministration;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.commands.interfaces.ICommand;
import fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.userRights.ProjectRight;
import fhdw.ipscrum.shared.model.userRights.Right;

/**
 * 
 */
public class RoleRemoveRightCommandTest extends RoleTestBase {

	/**
	 * Right used for tests.
	 */
	private Right right;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.right = new ProjectRight(this.getModel());
		this.getRole().addRight(this.right);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleRemoveRightCommand#RoleRemoveRightCommand(fhdw.ipscrum.shared.model.nonMeta.Role, fhdw.ipscrum.shared.model.userRights.Right)}
	 * .
	 */
	@Test
	public final void testRoleRemoveRightCommandRoleRight() {
		final RoleRemoveRightCommand command = new RoleRemoveRightCommand(this.getRole(), this.right);
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleRemoveRightCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final RoleRemoveRightCommand command = new RoleRemoveRightCommand(this.getRole(), this.right);
		Assert.assertTrue(this.getRole().getRights().contains(this.right));
		command.onExecute(this.getModel());
		Assert.assertFalse(this.getRole().getRights().contains(this.right));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleRemoveRightCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final RoleRemoveRightCommand command = new RoleRemoveRightCommand(this.getRole(), this.right);
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handleRoleRemoveRightCommand(final RoleRemoveRightCommand roleRemoveRightCommand) {

			}

			@Override
			public void standardHandling(final ICommand cmd) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleRemoveRightCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final RoleRemoveRightCommand command = new RoleRemoveRightCommand(this.getRole(), this.right);
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleRemoveRightCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final RoleRemoveRightCommand command = new RoleRemoveRightCommand(this.getRole(), this.right);
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
		final RoleRemoveRightCommand command = new RoleRemoveRightCommand(this.getRole(), this.right);
		Assert.assertTrue(this.getRole().getRights().contains(this.right));
		command.execute(this.getModel());
		Assert.assertFalse(this.getRole().getRights().contains(this.right));
	}

}
