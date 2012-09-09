package fhdw.ipscrum.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fhdw.ipscrum.client.services.LoginService.ResumedSession;
import fhdw.ipscrum.shared.session.User;

/**
 * Represents the interface of the asynchrony login service.
 */
public interface LoginServiceAsync {

	/**
	 * Represents the method needed for the login.
	 * 
	 * @param username
	 *            of the user to log in
	 * @param password
	 *            of the user to log in
	 * @param callback
	 *            to use the asynchrony login service
	 */
	void login(String username, String password, AsyncCallback<User> callback);

	/**
	 * Represents the method needed for the logout.
	 * 
	 * @param callback
	 *            to use the asynchrony logout
	 */
	void logout(AsyncCallback<Void> callback);

	/**
	 * Method needed to try to resume the session.
	 * 
	 * @param username
	 *            related to the session
	 * @param roleId
	 *            related to the session
	 * @param callback
	 *            is needed to use the method asynchrony
	 */
	void tryResumeSession(String username, String roleId, AsyncCallback<ResumedSession> callback);

}
