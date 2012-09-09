package fhdw.ipscrum.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fhdw.ipscrum.shared.infrastructure.Transaction;
import fhdw.ipscrum.shared.model.Model;

/**
 * Represents the interface of the asynchrony TransactionService.
 */
public interface TransactionServiceAsync {

	/**
	 * Needed for committing a Transaction asynchrony.
	 * 
	 * @param transaction
	 *            to commit
	 * @param callback
	 *            needed to use the method asynchrony
	 */
	void commitTransaction(Transaction transaction, AsyncCallback<Model> callback);

}
