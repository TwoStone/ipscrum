package fhdw.ipscrum.client.services;

import java.util.Date;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fhdw.ipscrum.shared.infrastructure.Revision;
import fhdw.ipscrum.shared.model.Model;

public interface ReceiveModelServiceAsync {

	void getCurrentModel(AsyncCallback<Model> model);

	void getAllRevisions(AsyncCallback<Map<Date, Revision>> model);
}
