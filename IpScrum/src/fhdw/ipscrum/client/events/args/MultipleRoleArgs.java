package fhdw.ipscrum.client.events.args;

import java.util.Set;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.interfaces.IRole;

/**
 */
public class MultipleRoleArgs extends EventArgs {

	private Set<IRole> roles;

	/**
	 * Constructor for MultipleRoleArgs.
	 * @param roles Set<IRole>
	 */
	public MultipleRoleArgs(Set<IRole> roles) {
		super();
		this.roles = roles;
	}

	/**
	 * Method getRoles.
	 * @return Set<IRole>
	 */
	public Set<IRole> getRoles() {
		return this.roles;
	}
}
