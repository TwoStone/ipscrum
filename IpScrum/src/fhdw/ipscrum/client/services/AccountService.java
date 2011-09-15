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

@RemoteServiceRelativePath("AccountService")
public interface AccountService extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static AccountServiceAsync instance;

		public static AccountServiceAsync getInstance() {
			if (AccountService.Util.instance == null) {
				AccountService.Util.instance = GWT.create(AccountService.class);
			}
			return AccountService.Util.instance;
		}
	}

	List<User> getUsers() throws NotAuthorizedException;

	void createAccount(String name, String password, Person person, Role activeRole)
			throws NotAuthorizedException, DoubleDefinitionException,
			PersistenceException;
}
