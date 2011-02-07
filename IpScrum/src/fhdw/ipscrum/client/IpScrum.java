package fhdw.ipscrum.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import fhdw.ipscrum.client.presenter.RootPresenter;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class IpScrum implements EntryPoint {
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		new RootPresenter(RootPanel.get("mainPanel"));
	}
 }
	
