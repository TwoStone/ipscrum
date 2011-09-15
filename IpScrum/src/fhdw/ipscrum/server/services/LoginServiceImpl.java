package fhdw.ipscrum.server.services;

import javax.servlet.http.HttpSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fhdw.ipscrum.client.services.LoginService;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.session.SessionManager;
import fhdw.ipscrum.shared.exceptions.infrastructure.LoginException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.session.User;

/**
 * This service provides the login and logout mechanism.
 */
public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

	/**
	 * String for no active session.
	 */
	private static final String KEINE_AKTIVE_SITZUNG_VORHANDEN =
			"Keine aktive Sitzung vorhanden!";
	/**
	 * represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 6931028832071255513L;

	@Override
	public User login(final String username, final String password)
			throws LoginException {
		final HttpSession session = this.getThreadLocalRequest().getSession();
		final User user =
				ServerContext.getInstance().getAccountManager()
						.login(username, password, session);
		return user;
	}

	@Override
	public void logout() {
		final HttpSession session = this.getThreadLocalRequest().getSession();
		ServerContext.getInstance().getSessionManager().logoutSession(session);
	}

	@Override
	public ResumedSession tryResumeSession(final String username, final String roleId)
			throws NotAuthorizedException {
		final HttpSession session = this.getThreadLocalRequest().getSession();
		final Object attribute = session.getAttribute(SessionManager.USERSPACE);
		if (attribute != null && attribute instanceof User) {
			final User user = (User) attribute;
			if (user.getName().equals(username)) {
				ServerContext.getInstance().getSessionManager().getUser(session);
				try {
					final Role role =
							(Role) ServerContext.getInstance().getPersistenceManager()
									.getCurrentModel().getObject(roleId);
					return new ResumedSession(user, role);

				} catch (final NoObjectFindException e) {
					throw new NotAuthorizedException(
							LoginServiceImpl.KEINE_AKTIVE_SITZUNG_VORHANDEN);
				}
			}
		}
		throw new NotAuthorizedException(
				LoginServiceImpl.KEINE_AKTIVE_SITZUNG_VORHANDEN);
	}
}
