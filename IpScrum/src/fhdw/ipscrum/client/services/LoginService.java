package fhdw.ipscrum.client.services;

import java.io.Serializable;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fhdw.ipscrum.shared.exceptions.infrastructure.LoginException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.session.User;

@RemoteServiceRelativePath("LoginService")
/**
 * Interface for login anf logout services.
 */
public interface LoginService extends RemoteService {

	public static class ResumedSession implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 6439125308535009788L;
		protected User user;
		protected Role role;

		private ResumedSession() {

		}

		public ResumedSession(final User user, final Role role) {
			this();
			this.user = user;
			this.role = role;
		}

		public User getUser() {
			return this.user;
		}

		public Role getRole() {
			return this.role;
		}

	}

	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static LoginServiceAsync instance;

		public static LoginServiceAsync getInstance() {
			if (LoginService.Util.instance == null) {
				LoginService.Util.instance = GWT.create(LoginService.class);
			}
			return LoginService.Util.instance;
		}
	}

	/**
	 * Login operation.
	 * 
	 * @param username
	 *            Name of the User
	 * @param password
	 *            Password of the User
	 * @return If login was successful the user object will be return.
	 * @throws LoginException
	 *             If login was not possible
	 */
	User login(String username, String password) throws LoginException;

	/**
	 * Tries to resume a session. If the user was previously loggedIn with the same name
	 * and the same JSESSIONID the server will continue the session.
	 * 
	 * @param username
	 *            Name of the User.
	 * @return the logged in user
	 * @throws NotAuthorizedException
	 *             If resuming was not possible
	 */
	ResumedSession tryResumeSession(String username, String roleId)
			throws NotAuthorizedException;

	/**
	 * Logout of a User.
	 */
	void logout();
}
