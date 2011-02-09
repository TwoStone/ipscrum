package fhdw.ipscrum.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import fhdw.ipscrum.client.presenter.RootPresenter;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.model.Project;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class IpScrum implements EntryPoint {
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		SessionManager.getInstance().getModel().addProject(new Project("Testprojekt 1"));
		SessionManager.getInstance().getModel().addProject(new Project("Testprojekt 2"));
		SessionManager.getInstance().getModel().addProject(new Project("Testprojekt 3"));
		new RootPresenter(RootPanel.get("mainPanel"));
	}
 }
	
