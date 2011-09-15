package fhdw.ipscrum.server.services;

import java.util.Iterator;
import java.util.List;

import fhdw.ipscrum.client.services.AccountService;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.session.Account;
import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException;
import fhdw.ipscrum.shared.exceptions.infrastructure.PersistenceException;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.model.userRights.PersonRoleAdminRight;
import fhdw.ipscrum.shared.model.userRights.Right;
import fhdw.ipscrum.shared.model.visitor.RightStandardVisitor;
import fhdw.ipscrum.shared.session.User;
import fhdw.ipscrum.shared.utils.ListUtils;

/**
 * This class represents the AccountService implementation.
 */
public class AccountServiceImpl extends AbstractSecurityServlet
		implements AccountService {

	/**
	 * represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -2699356829636082597L;
	/**
	 * this flag determines that the creation of an account is allowed.
	 */
	private boolean allowed = false;

	@Override
	public List<User> getUsers() throws NotAuthorizedException {
		this.getUser();
		return ServerContext.getInstance().getAccountManager().getUsers();
	}

	@Override
	public void createAccount(final String name, final String password,
			final Person person, final Role activeRole) throws NotAuthorizedException,
			DoubleDefinitionException, PersistenceException {
		this.canBeExecuted(activeRole);
		this.getUser();
		final List<User> users = this.getUsers();
		if (!ListUtils.filter(users, new ListUtils.Predicate<User>() {

			@Override
			public boolean test(final User element) {
				return element.getName().equals(name);
			}
		}).isEmpty()) {
			throw new DoubleDefinitionException("Ein Benutzer mit dem Namen " + name
					+ " existiert bereits!");
		}
		final User user = new User(name, person);
		final Account account = new Account(user, password);
		ServerContext.getInstance().getAccountManager().addAccount(account);
	}

	/**
	 * checks if a user account can be created with the active role.
	 * 
	 * @param activeRole
	 *            active role of the user.
	 * @throws NotAuthorizedException
	 *             if the user isn't authorized.
	 */
	private void canBeExecuted(final Role activeRole) throws NotAuthorizedException {
		final Iterator<Right> rightsIterator = activeRole.getRights().iterator();
		while (rightsIterator.hasNext()) {
			final Right current = rightsIterator.next();
			current.accept(new RightStandardVisitor() {

				@Override
				public void standardHandling(final Right right) {
					// do nothing.
				}

				@Override
				public void handlePersonRoleAdminRight(
						final PersonRoleAdminRight personRoleAdminRight) {
					AccountServiceImpl.this.allowed();
				}
			});
			if (this.allowed) {
				break;
			}
		}
		if (!this.allowed) {
			throw new NotAuthorizedException(ExceptionConstants.NOT_AUTHORIZED_ERROR);
		}
	}

	/**
	 * signals that the creation of an account is allowed.
	 */
	private void allowed() {
		this.allowed = true;
	}
}
