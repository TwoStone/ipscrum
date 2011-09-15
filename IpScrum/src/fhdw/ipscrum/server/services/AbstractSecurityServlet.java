package fhdw.ipscrum.server.services;

import javax.servlet.http.HttpSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.persistence.ExecutionController;
import fhdw.ipscrum.server.session.SessionManager;
import fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException;
import fhdw.ipscrum.shared.session.User;

/**
 * Base class for all Services. Provide the security handling for client requests.
 */
public abstract class AbstractSecurityServlet extends RemoteServiceServlet {

	/**
	 * represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -8290114070065282749L;

	/**
	 * Help method for checking the authorization of a client.
	 * 
	 * @throws NotAuthorizedException
	 *             If a client is not authorized to run the service implementation.
	 * @return the User
	 */
	protected User getUser() throws NotAuthorizedException {
		final SessionManager sessionManager =
				ServerContext.getInstance().getSessionManager();

		final HttpSession httpSession = this.getThreadLocalRequest().getSession();
		return sessionManager.getUser(httpSession);
	}

	/**
	 * Returns the execution controller after checking authorizations.
	 * 
	 * @return the execution controller
	 * @throws NotAuthorizedException
	 *             if the user is not authorized
	 */
	protected ExecutionController getExecutionController()
			throws NotAuthorizedException {
		this.getUser();
		return ServerContext.getInstance().getExecutionController();
	}
}
