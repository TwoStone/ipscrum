package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.nonMeta.Role;

/**
 * represents an event argument which knows a role.
 */
public class SingleRoleArgs extends EventArgs {

	/**
	 * represents the role attached to the event argument.
	 */
	private final Role role;

	/**
	 * Constructor for SingleRoleArgs.
	 * 
	 * @param role
	 *            IRole
	 */
	public SingleRoleArgs(final Role role) {
		super();
		this.role = role;
	}

	/**
	 * Method getRole.
	 * 
	 * @return IRole
	 */
	public Role getRole() {
		return this.role;
	}
}
