package fhdw.ipscrum.server.persistence;

import java.util.Date;
import java.util.List;
import java.util.Map;

import fhdw.ipscrum.server.session.Account;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.PersistenceException;
import fhdw.ipscrum.shared.infrastructure.Revision;
import fhdw.ipscrum.shared.model.Model;

/**
 * Interface for PersistenceManager.
 */
public interface IPersistenceManager {

	/**
	 * Returns the latest Model.
	 * 
	 * @return the latest model
	 */
	Model getCurrentModel();

	/**
	 * Returns a specific model Revision.
	 * 
	 * @param revisionDate
	 *            is the date of the revision
	 * @throws IPScrumGeneralException
	 *             if something fails
	 * @return the specific model
	 */
	Model getSpecificModel(final Date revisionDate) throws IPScrumGeneralException;

	/**
	 * Adds a new revision, updates the model and initiate the persisting process.
	 * 
	 * @param revision
	 *            New Revision
	 * @param revisionModel
	 *            New "latest" model
	 * @throws PersistenceException
	 *             if the persistence is hurt
	 */
	void addNewRevision(final Revision revision, final Model revisionModel)
			throws PersistenceException;

	/**
	 * Builds a copy of the latest Model.
	 * 
	 * @return a copy of the latest model
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	Model copyCurrentModel() throws IPScrumGeneralException;

	/**
	 * Use this method for testing only. With this method you can simulate the transfer of
	 * the model from the server to the client.
	 * 
	 * @return Current model on server side
	 */
	Model getModelForTesting();

	/**
	 * Returns a list of the latest persisted accounts.
	 * 
	 * @return all accounts
	 */
	List<Account> getAccounts();

	/**
	 * Adds a new account.
	 * 
	 * @param account
	 *            is the account to add
	 * @throws PersistenceException
	 *             if the persistence is hurt
	 */
	void addAccount(final Account account) throws PersistenceException;

	/**
	 * Returns a list of all revisions.
	 * 
	 * @return all revisions
	 */
	Map<Date, Revision> getAllRevisions();

}
