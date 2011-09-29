package fhdw.ipscrum.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fhdw.ipscrum.shared.infrastructure.Revision;
import fhdw.ipscrum.shared.model.Model;

/**
 * Represents the interface of the asynchrony ReceiverModelService.
 */
public interface ReceiveModelServiceAsync {

	/**
	 * Getter of the current model.
	 * 
	 * @param model
	 *            is needed to use the method asynchrony
	 */
	void getCurrentModel(AsyncCallback<Model> model);

	/**
	 * Getter of all revisions.
	 * 
	 * @param model
	 *            is needed to use the method asynchrony
	 */
	void getAllRevisions(AsyncCallback<List<Revision>> model);
}
