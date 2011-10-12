package fhdw.ipscrum.server.session;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import fhdw.ipscrum.server.persistence.IPersistenceManager;
import fhdw.ipscrum.shared.exceptions.infrastructure.LoginException;
import fhdw.ipscrum.shared.exceptions.infrastructure.PersistenceException;
import fhdw.ipscrum.shared.session.User;

/**
 * Manager class for managing accounts and the login process.
 */
public class AccountManager {
	/**
	 * represents the sessionManager.
	 */
	private final SessionManager sessionManager;
	/**
	 * represents the persistenceManager.
	 */
	private final IPersistenceManager manager;

	/**
	 * constructor of the AccountManager.
	 * 
	 * @param sessionManager
	 *            needed for the session
	 * @param manager
	 *            needed to persist
	 */
	public AccountManager(final SessionManager sessionManager, final IPersistenceManager manager) {
		super();
		this.sessionManager = sessionManager;
		this.manager = manager;
	}

	/**
	 * Try to login a User by its user name and its password.
	 * 
	 * @param username
	 *            Name of the User
	 * @param password
	 *            Password of the user
	 * @param session
	 *            The Session object used by the gwt session management.
	 * @return The User object which is connected to the user name and password combination
	 * @throws LoginException
	 *             If there is no account with the user name and password combination.
	 */
	public User login(final String username, final String password, final HttpSession session) throws LoginException {
		for (final Account account : this.manager.getAccounts()) {
			if (account.getUser().getName().equals(username) && account.getPassword().equals(password)) {

				if (account.getUser().getPerson() != null && !account.getUser().getPerson().isDeleted()) {
					this.sessionManager.newSession(account.getUser(), session);
					return account.getUser();
				} else {
					throw new LoginException("Account ist ungültig! Die Person zum Account existiert nicht mehr!");
				}
			}
		}

		throw new LoginException("Kombination von Name und Passwort existiert nicht!");

	}

	/**
	 * Try to add a new account to the system.
	 * 
	 * @param account
	 *            to add
	 * @throws PersistenceException
	 *             if the persistence is hurt
	 */
	public void addAccount(final Account account) throws PersistenceException {
		this.manager.addAccount(account);
	}

	/**
	 * getter of all users the accountManager manages.
	 * 
	 * @return all current users
	 */
	public List<User> getUsers() {
		final List<Account> accounts = this.manager.getAccounts();
		final List<User> result = new ArrayList<User>();
		for (final Account account : accounts) {
			result.add(account.getUser());
		}
		return result;
	}

}
