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
import fhdw.ipscrum.shared.model.userRights.ProjectRight;

/**
 * 
 */
public class RoleAddRightCommandTest extends RoleTestBase {

	/**
	 * Right used for tests.
	 */
	private ProjectRight right;

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		this.right = new ProjectRight(this.getModel());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleAddRightCommand#RoleAddRightCommand(fhdw.ipscrum.shared.model.nonMeta.Role, fhdw.ipscrum.shared.model.userRights.Right)}
	 * .
	 */
	@Test
	public final void testRoleAddRightCommandRoleRight() {
		final RoleAddRightCommand command = new RoleAddRightCommand(this.getRole(), this.right);
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleAddRightCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final RoleAddRightCommand command = new RoleAddRightCommand(this.getRole(), this.right);
		Assert.assertFalse(this.getRole().getRights().contains(this.right));
		command.onExecute(this.getModel());
		Assert.assertTrue(this.getRole().getRights().contains(this.right));
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleAddRightCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final RoleAddRightCommand command = new RoleAddRightCommand(this.getRole(), this.right);

		command.accept(new CommandStandardVisitor() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * fhdw.ipscrum.shared.commands.visitor.AdminCommandStandardVisitor#handleRoleAddRightCommand(fhdw.ipscrum
			 * .shared.commands.admin.personRoleAdministration.RoleAddRightCommand)
			 */
			@Override
			public void handleRoleAddRightCommand(final RoleAddRightCommand roleAddRightCommand) {

			}

			@Override
			public void standardHandling(final ICommand cmd) {
				Assert.fail();
			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleAddRightCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final RoleAddRightCommand command = new RoleAddRightCommand(this.getRole(), this.right);
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleAddRightCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final RoleAddRightCommand command = new RoleAddRightCommand(this.getRole(), this.right);
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
		final RoleAddRightCommand command = new RoleAddRightCommand(this.getRole(), this.right);
		Assert.assertFalse(this.getRole().getRights().contains(this.right));
		command.execute(this.getModel());
		Assert.assertTrue(this.getRole().getRights().contains(this.right));
	}

}
