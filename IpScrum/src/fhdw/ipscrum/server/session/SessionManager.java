package fhdw.ipscrum.server.session;

import javax.servlet.http.HttpSession;

import fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException;
import fhdw.ipscrum.shared.session.User;

/**
 * Help class for working with the gwt session management.
 */
public class SessionManager {

	/**
	 * represents the user space.
	 */
	public static final String USERSPACE = "user";

	/**
	 * constructor of the SessionManager.
	 */
	public SessionManager() {
	}

	/**
	 * Adds the User to the session attributes.
	 * 
	 * @param user
	 *            to add
	 * @param session
	 *            is the session to add the user to
	 */
	public void newSession(final User user, final HttpSession session) {
		session.setAttribute(SessionManager.USERSPACE, user);
	}

	/**
	 * Returns the User sent within the attributes of a session.
	 * 
	 * @param session
	 *            is the session to get the user from
	 * @throws NotAuthorizedException
	 *             The session has no user attribute. Means, that there was no login
	 *             process done before.
	 * @return the user
	 */
	public User getUser(final HttpSession session) throws NotAuthorizedException {

		final User user = (User) session.getAttribute(SessionManager.USERSPACE);
		if (user != null) {
			return user;
		} else {
			throw new NotAuthorizedException("Sitzung ist nicht gültig!");
		}
	}

	/**
	 * Removes the user attribute from the session.
	 * 
	 * @param session
	 *            is the session to logout
	 */
	public void logoutSession(final HttpSession session) {
		session.removeAttribute(SessionManager.USERSPACE);
	}
}
