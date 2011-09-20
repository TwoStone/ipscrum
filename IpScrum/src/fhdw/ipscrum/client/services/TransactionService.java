package fhdw.ipscrum.client.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.infrastructure.Transaction;
import fhdw.ipscrum.shared.model.Model;

/**
 * Services for sending transactions to the server.
 */
@RemoteServiceRelativePath("TransactionService")
public interface TransactionService extends RemoteService {

	/**
	 * Sends a transaction to the server an try to commit it.
	 * 
	 * @return the model after the transaction is committed
	 * @param transaction
	 *            is the transaction to commit
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	Model commitTransaction(Transaction transaction) throws IPScrumGeneralException;

	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		/**
		 * Represents the instance of the asynchrony TransactionService.
		 */
		private static TransactionServiceAsync instance;

		/**
		 * Represents the getter of the asynchrony TransactionService.
		 * 
		 * @return the instance
		 */
		public static TransactionServiceAsync getInstance() {
			if (TransactionService.Util.instance == null) {
				TransactionService.Util.instance = GWT.create(TransactionService.class);
			}
			return TransactionService.Util.instance;
		}
	}
}
