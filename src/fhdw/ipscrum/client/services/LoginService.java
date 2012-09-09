package fhdw.ipscrum.client.services;

import java.io.Serializable;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fhdw.ipscrum.shared.exceptions.infrastructure.LoginException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.session.User;

/**
 * Interface for login anf logout services.
 */
@RemoteServiceRelativePath("LoginService")
public interface LoginService extends RemoteService {

	/**
	 * Represents the session which should be resumed.
	 */
	public static class ResumedSession implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 6439125308535009788L;
		/**
		 * Represents the related user.
		 */
		private User user;
		/**
		 * Represents the related role.
		 */
		private Role role;

		/**
		 * constructor without parameters. Needed for serilaization.
		 */
		private ResumedSession() {

		}

		/**
		 * Constructor of the ResumedSession.
		 * 
		 * @param user
		 *            related to the session
		 * @param role
		 *            related to the session
		 */
		public ResumedSession(final User user, final Role role) {
			this();
			this.setUser(user);
			this.setRole(role);
		}

		/**
		 * Getter of the user.
		 * 
		 * @return the user
		 */
		public User getUser() {
			return this.user;
		}

		/**
		 * Getter of the role.
		 * 
		 * @return the role
		 */
		public Role getRole() {
			return this.role;
		}

		/**
		 * @param user
		 *            the user to set
		 */
		protected void setUser(final User user) {
			this.user = user;
		}

		/**
		 * @param role
		 *            the role to set
		 */
		protected void setRole(final Role role) {
			this.role = role;
		}

	}

	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		/**
		 * Represents the instance of the asynchrony login service.
		 */
		private static LoginServiceAsync instance;

		/**
		 * Represents the getter of the asynchrony login service.
		 * 
		 * @return the instance
		 */
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
	 * Tries to resume a session. If the user was previously loggedIn with the same name and the same JSESSIONID the
	 * server will continue the session.
	 * 
	 * @param username
	 *            Name of the User.
	 * @param roleId
	 *            represented the active role of the user
	 * @return the logged in user
	 * @throws NotAuthorizedException
	 *             If resuming was not possible
	 */
	ResumedSession tryResumeSession(String username, String roleId) throws NotAuthorizedException;

	/**
	 * Logout of a User.
	 */
	void logout();
}
