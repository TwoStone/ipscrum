package fhdw.ipscrum.client.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Service for receiving heart beats from clients to notify the server about their
 * existence.
 */
@RemoteServiceRelativePath("HeartBeatService")
public interface HeartBeatService extends RemoteService {

	/**
	 * Let the heart beat!
	 */
	void pulse();

	public static class Util {
		private static HeartBeatServiceAsync instance;

		public static HeartBeatServiceAsync getInstance() {
			if (HeartBeatService.Util.instance == null) {
				HeartBeatService.Util.instance = GWT.create(HeartBeatService.class);
			}
			return HeartBeatService.Util.instance;
		}
	}
}
