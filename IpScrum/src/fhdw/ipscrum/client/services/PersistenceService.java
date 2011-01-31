package fhdw.ipscrum.client.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fhdw.ipscrum.shared.persistence.PersistenceHandler;

@RemoteServiceRelativePath("PersistenceService")
public interface PersistenceService extends RemoteService, PersistenceHandler {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static PersistenceServiceAsync instance;
		public static PersistenceServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(PersistenceService.class);
			}
			return instance;
		}
	}
}
