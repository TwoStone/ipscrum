package fhdw.ipscrum.client.eventargs;

import java.util.List;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.nonMeta.Role;

/**
 * represents an event argument which knows multiple roles.
 */
public class MultipleRoleArgs extends EventArgs {

	/**
	 * represents the roles attached to the event argument.
	 */
	private final List<Role> roles;

	/**
	 * Constructor for MultipleRoleArgs.
	 * 
	 * @param roles
	 *            Set<IRole>
	 */
	public MultipleRoleArgs(final List<Role> roles) {
		super();
		this.roles = roles;
	}

	/**
	 * Method getRoles.
	 * 
	 * @return Set<IRole>
	 */
	public List<Role> getRoles() {
		return this.roles;
	}
}
