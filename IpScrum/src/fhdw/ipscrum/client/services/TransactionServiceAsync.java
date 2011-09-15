package fhdw.ipscrum.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fhdw.ipscrum.shared.infrastructure.Transaction;
import fhdw.ipscrum.shared.model.Model;

public interface TransactionServiceAsync {

	void commitTransaction(Transaction transaction, AsyncCallback<Model> callback);

}
