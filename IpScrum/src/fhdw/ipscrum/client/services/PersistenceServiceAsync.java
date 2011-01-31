package fhdw.ipscrum.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fhdw.ipscrum.shared.persistence.SerializationRoot;

public interface PersistenceServiceAsync {

	void load(String identifier, AsyncCallback<SerializationRoot> callback);

	void save(SerializationRoot root, String identifier,
			AsyncCallback<Void> callback);

}
