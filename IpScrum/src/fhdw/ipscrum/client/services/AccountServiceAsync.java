package fhdw.ipscrum.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.session.User;

public interface AccountServiceAsync {

	void getUsers(AsyncCallback<List<User>> callback);

	void createAccount(String name, String password, Person person, Role activeRole,
			AsyncCallback<Void> callback);

}
