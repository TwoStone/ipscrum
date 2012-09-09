package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.session.User;

/**
 * represents an event argument which knows also a user and a role.
 */
public class UserRoleArgs {

	/**
	 * represents the user related to the event argument.
	 */
	private final User user;

	/**
	 * represents the role related to the event argument.
	 */
	private final Role role;

	/**
	 * Constructor for UserRoleArgs.
	 * 
	 * @param user
	 *            User
	 * @param role
	 *            Role
	 */
	public UserRoleArgs(final User user, final Role role) {
		this.user = user;
		this.role = role;
	}

	/**
	 * Method getUser.
	 * 
	 * @return User
	 */
	public User getUser() {
		return this.user;
	}

	/**
	 * Method getRole.
	 * 
	 * @return Role
	 */
	public Role getRole() {
		return this.role;
	}

}
