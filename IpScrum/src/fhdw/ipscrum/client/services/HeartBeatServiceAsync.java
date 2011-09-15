package fhdw.ipscrum.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface HeartBeatServiceAsync {

	void pulse(AsyncCallback<Void> callback);

}
