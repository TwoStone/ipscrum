package fhdw.ipscrum.client.services;

import java.util.Date;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException;
import fhdw.ipscrum.shared.infrastructure.Revision;
import fhdw.ipscrum.shared.model.Model;

/**
 * Service for receiving data from the server.
 */
@RemoteServiceRelativePath("ReceiveModelService")
public interface ReceiveModelService extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		/**
		 * Represents the instance of the asynchrony ReceiverModelService.
		 */
		private static ReceiveModelServiceAsync instance;

		/**
		 * Represents the getter of the instance of the asynchrony ReceiverModelService.
		 * 
		 * @return the instance
		 */
		public static ReceiveModelServiceAsync getInstance() {
			if (ReceiveModelService.Util.instance == null) {
				ReceiveModelService.Util.instance =
						GWT.create(ReceiveModelService.class);
			}
			return ReceiveModelService.Util.instance;
		}
	}

	/**
	 * @return the latest Model to the client.
	 * 
	 * @throws NotAuthorizedException
	 *             If the User is not authorized.
	 */
	Model getCurrentModel() throws NotAuthorizedException;

	/**
	 * @return all revisions to the client.
	 * 
	 * @throws IPScrumGeneralException
	 *             If the User is not authorized.
	 */
	Map<Date, Revision> getAllRevisions() throws IPScrumGeneralException;

}
