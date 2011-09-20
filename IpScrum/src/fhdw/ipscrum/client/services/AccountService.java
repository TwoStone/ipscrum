package fhdw.ipscrum.client.services;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException;
import fhdw.ipscrum.shared.exceptions.infrastructure.PersistenceException;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.session.User;

/**
 * Represents a services needed for the accounts.
 */
@RemoteServiceRelativePath("AccountService")
public interface AccountService extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		/**
		 * Represents the instance of the Util class.
		 */
		private static AccountServiceAsync instance;

		/**
		 * Getter of the instance of the Account async service.
		 * 
		 * @return the instance of the account instance service
		 */
		public static AccountServiceAsync getInstance() {
			if (AccountService.Util.instance == null) {
				AccountService.Util.instance = GWT.create(AccountService.class);
			}
			return AccountService.Util.instance;
		}
	}

	/**
	 * Getter of the users related to this account.
	 * 
	 * @return the related users
	 * @throws NotAuthorizedException
	 *             if someone isn't allowed to use this method.
	 */
	List<User> getUsers() throws NotAuthorizedException;

	/**
	 * creates an account.
	 * 
	 * @param name
	 *            of the account
	 * @param password
	 *            of the account
	 * @param person
	 *            related to the account
	 * @param activeRole
	 *            of the account
	 * @throws NotAuthorizedException
	 *             if someone isn't allowed to use this method
	 * @throws DoubleDefinitionException
	 *             if the account already exists
	 * @throws PersistenceException
	 *             if the persistence is hurt
	 */
	void createAccount(String name, String password, Person person, Role activeRole)
			throws NotAuthorizedException, DoubleDefinitionException,
			PersistenceException;
}
