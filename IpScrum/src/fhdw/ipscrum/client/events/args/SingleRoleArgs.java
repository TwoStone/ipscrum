package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.interfaces.IRole;

/**
 */
public class SingleRoleArgs extends EventArgs {

	private IRole role;

	/**
	 * Constructor for SingleRoleArgs.
	 * @param role IRole
	 */
	public SingleRoleArgs(IRole role) {
		super();
		this.role = role;
	}

	/**
	 * Method getRole.
	
	 * @return IRole */
	public IRole getRole() {
		return this.role;
	}
}
