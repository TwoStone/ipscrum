package fhdw.ipscrum.client.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.infrastructure.Transaction;
import fhdw.ipscrum.shared.model.Model;

@RemoteServiceRelativePath("TransactionService")
/**
 * Services for sending transactions to the server.
 */
public interface TransactionService extends RemoteService {

	/**
	 * Sends a transaction to the server an try to commit it.
	 */
	Model commitTransaction(Transaction transaction) throws IPScrumGeneralException;

	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static TransactionServiceAsync instance;

		public static TransactionServiceAsync getInstance() {
			if (TransactionService.Util.instance == null) {
				TransactionService.Util.instance = GWT.create(TransactionService.class);
			}
			return TransactionService.Util.instance;
		}
	}
}
