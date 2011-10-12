package fhdw.ipscrum.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.session.User;

/**
 * Represents the interface of the {@link} fhdw.ipscrum.client.services.AccountService.
 */
public interface AccountServiceAsync {

	/**
	 * Represents the getter of the users of the account.
	 * 
	 * @param callback
	 *            is the asyncCallback which knows the related users
	 */
	void getUsers(AsyncCallback<List<User>> callback);

	/**
	 * Creates an account.
	 * 
	 * @param name
	 *            of the account
	 * @param password
	 *            of the account
	 * @param person
	 *            related to the account
	 * @param activeRole
	 *            of the account
	 * @param callback
	 *            needed to use this method in an asynchrony way
	 */
	void createAccount(String name, String password, Person person, Role activeRole, AsyncCallback<Void> callback);

}
