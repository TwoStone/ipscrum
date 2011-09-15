package fhdw.ipscrum.server.session;

import fhdw.ipscrum.shared.session.User;

/**
 * An account connects a User with a password so that the user can login the system.
 * 
 */
public class Account {

	/**
	 * represents the user of the account.
	 */
	private final User user;
	/**
	 * represents the password of the user of the account.
	 */
	private final String password;

	/**
	 * constructor of the Account.
	 * 
	 * @param user
	 *            of the account
	 * @param password
	 *            of the account
	 */
	public Account(final User user, final String password) {
		super();
		this.user = user;
		this.password = password;
	}

	/**
	 * getter of the user if the account.
	 * 
	 * @return the user
	 */
	public User getUser() {
		return this.user;
	}

	/**
	 * getter of the password of the account.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}
}
