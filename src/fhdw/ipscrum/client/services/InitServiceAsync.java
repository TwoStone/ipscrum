package fhdw.ipscrum.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Asynchronous interface for {@link InitService}.
 */
public interface InitServiceAsync {

	/**
	 * Tries to initialize the server. If the server is already running. Nothing happens.
	 * 
	 * @param callback
	 *            null
	 */
	void initializeServer(AsyncCallback<Void> callback);

}
