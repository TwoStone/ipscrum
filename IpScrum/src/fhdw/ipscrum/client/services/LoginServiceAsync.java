package fhdw.ipscrum.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fhdw.ipscrum.client.services.LoginService.ResumedSession;
import fhdw.ipscrum.shared.session.User;

public interface LoginServiceAsync {

	void login(String username, String password, AsyncCallback<User> callback);

	void logout(AsyncCallback<Void> callback);

	void tryResumeSession(String username, String roleId,
			AsyncCallback<ResumedSession> callback);

}
