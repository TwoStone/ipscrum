package fhdw.ipscrum.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Represents the interface of the asynchrony heart beat service.
 */
public interface HeartBeatServiceAsync {

	/**
	 * Represents the pulse of the heart beat.
	 * 
	 * @param callback
	 *            needed to use the heart beat asynchrony
	 */
	void pulse(AsyncCallback<Void> callback);

}
