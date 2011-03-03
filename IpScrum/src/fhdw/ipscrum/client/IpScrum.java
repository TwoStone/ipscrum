package fhdw.ipscrum.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import fhdw.ipscrum.client.presenter.RootPresenter;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.SessionManager.LoadCallback;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class IpScrum implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {

		SessionManager.getInstance().load(new LoadCallback() {

			@Override
			public void onLoaded() {
				new RootPresenter(RootPanel.get("mainPanel"));
			}
		});
	}
}
