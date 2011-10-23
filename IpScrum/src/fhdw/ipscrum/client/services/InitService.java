package fhdw.ipscrum.client.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fhdw.ipscrum.client.utils.AsyncCallbacks;
import fhdw.ipscrum.shared.exceptions.InfrastructureException;

/**
 * This Service is used to ensure that the server executer is executing and the data folder is created.
 */
@RemoteServiceRelativePath("InitService")
public interface InitService extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static InitServiceAsync instance;

		/**
		 * Initializes the server.
		 */
		public static void init() {
			InitService.Util.getInstance().initializeServer(AsyncCallbacks.noCallback(Void.class));
		}

		/**
		 * 
		 * @return the {@link InitServiceAsync} instance
		 */
		public static InitServiceAsync getInstance() {
			if (InitService.Util.instance == null) {
				InitService.Util.instance = GWT.create(InitService.class);
			}
			return InitService.Util.instance;
		}
	}

	/**
	 * Tries to initialize the server. If the server is already running. Nothing happens.
	 * 
	 * @throws InfrastructureException
	 *             when something went wrong while initializing the server
	 */
	void initializeServer() throws InfrastructureException;
}
