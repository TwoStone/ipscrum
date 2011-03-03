package fhdw.ipscrum.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fhdw.ipscrum.client.services.PersistenceService;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.shared.model.Root;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

public class SessionManager {

	public final static String IDENTIFIER = "RootModel";
	private static SessionManager instance;

	public static SessionManager getInstance() {
		if (instance == null) {
			instance = new SessionManager();
		}
		return instance;
	}

	private IPerson loginUser;

	private final Root model;

	private SessionManager() {
		super();
		this.model = new Root();
	}

	public IPerson getLoginUser() {
		return this.loginUser;
	}

	public Root getModel() {
		return this.model;
	}

	public void save() {
		PersistenceService.Util.getInstance().save(this.model, IDENTIFIER,
				new AsyncCallback<Void>() {

					@Override
					public void onFailure(final Throwable caught) {
						caught.printStackTrace();
						GwtUtils.displayError(caught.getMessage());
					}

					@Override
					public void onSuccess(final Void result) {

					}
				});
	}

	public void setLoginUser(final IPerson loginUser) {
		this.loginUser = loginUser;
	}
}
