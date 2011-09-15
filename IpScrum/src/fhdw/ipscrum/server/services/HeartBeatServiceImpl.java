package fhdw.ipscrum.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fhdw.ipscrum.client.services.HeartBeatService;

/**
 * This service sends a "heart beat" periodically to server so that the session will not
 * die until the client log-off or close the browser.
 */
public class HeartBeatServiceImpl extends RemoteServiceServlet
		implements HeartBeatService {

	/**
	 * represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -3327313760644704355L;

	@Override
	public void pulse() {
		final String remoteHost = this.getThreadLocalRequest().getRemoteHost();
		System.out.println("Received heart beat from " + remoteHost
				+ " - seems to be still alive!");
	}
}
