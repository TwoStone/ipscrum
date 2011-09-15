package fhdw.ipscrum.server.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import fhdw.ipscrum.server.session.Account;
import fhdw.ipscrum.shared.infrastructure.Revision;
import fhdw.ipscrum.shared.infrastructure.SerializationRoot;
import fhdw.ipscrum.shared.model.Model;

/**
 * Wrapper class for data that will be persisted.
 */
public class PersistData implements SerializationRoot {

	/**
	 * represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -1142910510997825516L;
	/**
	 * represents the currentModel needed to use the IPScrum.
	 */
	private Model currentModel;
	/**
	 * represents all current revisions.
	 */
	private HashMap<Date, Revision> revisions;
	/**
	 * represents all current accounts.
	 */
	private List<Account> accounts;

	/**
	 * constructor of the persistData.
	 */
	public PersistData() {
		super();
	}

	/**
	 * Returns all accounts.
	 * 
	 * @return all accounts
	 */
	public List<Account> getAccounts() {
		if (this.accounts == null) {
			this.accounts = new ArrayList<Account>();
		}
		return this.accounts;
	}

	/**
	 * Returns the latest model revision.
	 * 
	 * @return the latest model
	 */
	public Model getCurrentModel() {
		if (this.currentModel == null) {
			this.currentModel = new Model(new Date());
		}
		return this.currentModel;
	}

	/**
	 * Returns all revision.
	 * 
	 * @return all revisions
	 */
	public HashMap<Date, Revision> getRevisions() {
		if (this.revisions == null) {
			this.revisions = new HashMap<Date, Revision>();
		}
		return this.revisions;
	}

	/**
	 * Changes the latest model.
	 * 
	 * @param currentModel
	 *            is the model to set
	 */
	public void setCurrentModel(final Model currentModel) {
		this.currentModel = currentModel;
	}
}
