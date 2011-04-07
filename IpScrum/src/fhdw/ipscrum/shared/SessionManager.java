package fhdw.ipscrum.shared;

import java.util.Iterator;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import fhdw.ipscrum.client.services.PersistenceService;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.DemoModel;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Root;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.persistence.SerializationRoot;

public class SessionManager {

	public static interface LoadCallback {
		void onLoaded();
	}

	public final static String IDENTIFIER = "RootModel";

	private static SessionManager instance;

	public static SessionManager getInstance() {
		if (instance == null) {
			instance = new SessionManager();
		}
		return instance;
	}

	private IPerson loginUser;

	private Root model;

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

	public void load(final LoadCallback callback) {

		PersistenceService.Util.getInstance().load(IDENTIFIER,
				new AsyncCallback<SerializationRoot>() {

					@Override
					public void onFailure(final Throwable caught) {
						try {
							DemoModel.populateStandardIncidentTypes(SessionManager.this.model);
							DemoModel.populateModel(SessionManager.this.model);
							GwtUtils.displayWarning("Modell korrumpiert. Demo-Daten geladen.");
							SessionManager.this.checkDeadlines(SessionManager.this.model);
							callback.onLoaded();
						} catch (final UserException e) {
							GwtUtils.displayError(e);
						}

					}

					@Override
					public void onSuccess(final SerializationRoot result) {
						SessionManager.this.model = (Root) result;
						SessionManager.this.checkDeadlines((Root)result);
						callback.onLoaded();
					}
				});
	}
	/**
	 * This Method checks if Sprint or Release deadlines have been reached.
	 * If so, it will populate new Incidents for the project history.
	 * the method will be obsolete if a permanent running
	 * server has been implemented and it will have to be called via
	 * periodic jobs
	 */
	private void checkDeadlines(Root root) {
		Iterator<Project> i = root.getProjects().iterator();
		while (i.hasNext()) {
			i.next().checkDeadlines();
		}
	}

	public void save() {
		PersistenceService.Util.getInstance().save(this.model, IDENTIFIER,
				new AsyncCallback<Void>() {

					@Override
					public void onFailure(final Throwable caught) {
						GwtUtils.displayError(caught);
					}

					@Override
					public void onSuccess(final Void result) {
						Window.alert("Speichern erfolgreich!");
					}
				});
	}

	public void setLoginUser(final IPerson loginUser) {
		this.loginUser = loginUser;
	}
}
