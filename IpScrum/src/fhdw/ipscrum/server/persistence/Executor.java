package fhdw.ipscrum.server.persistence;

import java.util.Date;
import java.util.List;

import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.CommitException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.exceptions.infrastructure.PersistenceException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.infrastructure.Revision;
import fhdw.ipscrum.shared.infrastructure.Transaction;
import fhdw.ipscrum.shared.infrastructure.UUIDReceiver;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Role;

/**
 * Class for execution transactions and checking conflicts.
 */
public class Executor {

	/**
	 * represents the ExecutionController needed for the Executor.
	 */
	private final ExecutionController controller;

	/**
	 * constructor of the Executor.
	 * 
	 * @param controller
	 *            is the needed ExecutionController
	 */
	public Executor(final ExecutionController controller) {
		super();
		this.controller = controller;
	}

	/**
	 * Execution of a transaction.
	 * 
	 * @param transaction
	 *            to execute
	 * @throws IPScrumGeneralException
	 *             if something fails.
	 */
	void execute(final Transaction transaction) throws IPScrumGeneralException {

		// Führe Commands auf Kopie der Revision passen zur Transaktion aus
		final Model changedRevisionModel = this.replayOnRevisionCopy(transaction);

		// Prüfe auf Konflikte
		this.checkForConflicts(changedRevisionModel);

		// Kopie vom Original
		final Model newLatestModel = this.tryToPublicChanges(transaction);

		// Neues Revision wird erstellt
		this.confirmNewRevision(newLatestModel, transaction);

	}

	/**
	 * Checks for Conflicts.
	 * 
	 * @param changedRevisionModel
	 *            is the model to check
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	private void checkForConflicts(final Model changedRevisionModel)
			throws IPScrumGeneralException {
		// Lass dir alle geänderten Objekte geben
		final List<IdentifiableObject> localChangedObjects =
				changedRevisionModel.getChangedObjects();

		// Hole das aktuelle originale Modell
		final Model originalModel = this.controller.getLatestModel();

		// Prüfe auf Konflikte
		for (final IdentifiableObject current : localChangedObjects) {
			IdentifiableObject original;
			try {
				original = originalModel.getObject(current.getId());
				if (current.getRevisionDate() != null) {
					if (original.isDeleted()
							|| original.getRevisionDate().after(
									current.getRevisionDate())) {
						throw new CommitException(
								"Commit fehlgeschlagen! Zwischenzeitliche Änderung durch anderen Anwender!");
					}
				}
			} catch (final NoObjectFindException e) {
				// If the object can not be found in the old model, it was created in this
				// transaction. That is okay!
			}

		}
	}

	/**
	 * Executes transaction on revision copy.
	 * 
	 * @param transaction
	 *            to replay
	 * @throws IPScrumGeneralException
	 *             if something fails
	 * @return the revision model
	 */
	private Model replayOnRevisionCopy(final Transaction transaction)
			throws IPScrumGeneralException {
		final Model copyOfTransactionRev =
				this.controller.getSpecificRevisionCopy(transaction.getModelRevision());

		// --- ... UUIDReceiver setzen
		copyOfTransactionRev.setUuidManager(new UUIDReceiver(transaction
				.getGeneratedUUIDs()));

		for (final Command<?> current : transaction.getCommands()) {
			current.execute(copyOfTransactionRev, (Role) copyOfTransactionRev
					.getObject(transaction.getActiveRoleId()));
		}
		return copyOfTransactionRev;
	}

	/**
	 * Publish changes to latest model copy.
	 * 
	 * @param transaction
	 *            to execute
	 * @throws IPScrumGeneralException
	 *             if something fails
	 * @return the model
	 */
	private Model tryToPublicChanges(final Transaction transaction)
			throws IPScrumGeneralException {
		final Model newLatestModel = this.controller.getLatestModelCopy();

		// --- ... UUIDReceiver wird gesetzt
		newLatestModel
				.setUuidManager(new UUIDReceiver(transaction.getGeneratedUUIDs()));

		// Nachspielen der Transaktion
		for (final Command<?> current : transaction.getCommands()) {
			current.execute(newLatestModel,
					(Role) newLatestModel.getObject(transaction.getActiveRoleId()));
		}
		return newLatestModel;
	}

	/**
	 * Confirms a new revision.
	 * 
	 * @param changedModel
	 *            is the model to change
	 * @param transaction
	 *            is the transaction executed on the model
	 * @throws PersistenceException
	 *             if the persistence is hurt
	 */
	private void confirmNewRevision(final Model changedModel,
			final Transaction transaction) throws PersistenceException {
		final Date newRevDate = new Date();

		for (final IdentifiableObject current : changedModel.getChangedObjects()) {
			current.undoChangeFlag();
			current.setRevisionDate(newRevDate);
		}

		changedModel.setRevisionDate(newRevDate);

		final Revision newRev =
				new Revision(transaction.getCommands(), newRevDate,
						transaction.getEditorId(), transaction.getGeneratedUUIDs());

		this.controller.addNewRevision(newRev, changedModel);
	}
}
