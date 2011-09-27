/**
 * 
 */
package fhdw.ipscrum.shared.commands.admin.personRoleAdministration;

import fhdw.ipscrum.shared.model.messages.ModelTestBase;
import fhdw.ipscrum.shared.model.nonMeta.Role;

/**
 * 
 */
public class RoleTestBase extends ModelTestBase {
	/**
	 * role for testing.
	 */
	private Role role;

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.model.messages.ModelTestBase#setUp()
	 */
	@Override
	public void setUp() throws Exception {
		super.setUp();
		this.role = new Role(this.getModel(), "TestRole");
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return this.role;
	}
}
