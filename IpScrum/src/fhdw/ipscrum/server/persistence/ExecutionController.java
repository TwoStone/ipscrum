package fhdw.ipscrum.server.persistence;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.BuildModelException;
import fhdw.ipscrum.shared.exceptions.infrastructure.PersistenceException;
import fhdw.ipscrum.shared.infrastructure.Revision;
import fhdw.ipscrum.shared.infrastructure.Transaction;
import fhdw.ipscrum.shared.model.Model;

/**
 * Controles the execution of the transactions sended to the server.
 */
public class ExecutionController extends Thread {

	/**
	 * represents the pipeline related to the executionController.
	 */
	private final Pipeline<Transaction> pipeline;
	/**
	 * represents the executor related to the executionController.
	 */
	private final Executor executor;

	/**
	 * representing the waitingServices of the executionController.
	 */
	private final Map<Transaction, Semaphore> waitingServices;

	/**
	 * represents the persistence Manager.
	 */
	private final IPersistenceManager manager;

	/**
	 * constructor of the ExecutionController.
	 * 
	 * @param manager
	 *            of the ExecutionController
	 */
	public ExecutionController(final IPersistenceManager manager) {
		this.manager = manager;
		this.pipeline = new Pipeline<Transaction>();
		this.waitingServices =
				Collections.synchronizedMap(new HashMap<Transaction, Semaphore>());
		this.executor = new Executor(this);
	}

	/**
	 * Returns the latest Model Release from the persistence manager.
	 * 
	 * @return the latest model
	 */
	public Model getLatestModel() {
		return this.manager.getCurrentModel();
	}

	/**
	 * Adds a new Revision to the persistence manager and refreshes the actual model.
	 * 
	 * @param revision
	 *            is a new revision
	 * @param revisionModel
	 *            is the model before the new revision
	 * 
	 * @throws PersistenceException
	 *             if the persistence is hurt
	 */
	public void addNewRevision(final Revision revision, final Model revisionModel)
			throws PersistenceException {
		this.manager.addNewRevision(revision, revisionModel);
	}

	/**
	 * Returns a copy of the latest model revision from the persistence manager.
	 * 
	 * @throws IPScrumGeneralException
	 *             if something fails
	 * @return the latest model
	 * 
	 */
	public Model getLatestModelCopy() throws IPScrumGeneralException {
		return this.manager.copyCurrentModel();
	}

	/**
	 * Returns a copy of a specific model revision from the persistence manager.
	 * 
	 * @param revisionDate
	 *            is the date of the searched model
	 * @throws IPScrumGeneralException
	 *             if something fails
	 * @return the specific copy of the model
	 */
	public Model getSpecificRevisionCopy(final Date revisionDate)
			throws IPScrumGeneralException {
		try {
			return this.manager.getSpecificModel(revisionDate);
		} catch (final IPScrumGeneralException e) {
			System.err.println(e.getMessage());
			throw new BuildModelException(
					"Es konnte keine Modellkopie erzeugt werden!\n" + e.getMessage());
		}
	}

	@Override
	public void run() {
		while (this.isAlive()) {
			try {
				final Transaction transaction = this.pipeline.get();
				System.out.println("Aktuelle Transaktion:" + transaction);
				try {
					this.executor.execute(transaction);
				} catch (final IPScrumGeneralException e) {
					System.err.println(e.getMessage());
					transaction.setUserException(e);
				}
				final Semaphore semaphore = this.waitingServices.get(transaction);
				semaphore.release();

			} catch (final InterruptedException e) {
				this.interrupt();
			}
		}
	}

	/**
	 * Initiating the committing process of a transaction.
	 * 
	 * @param transaction
	 *            is the transaction to commit
	 * @throws InterruptedException
	 *             if the commit is interrupted
	 */
	public void commitTransaction(final Transaction transaction)
			throws InterruptedException {

		final Semaphore semaphore = new Semaphore(0);
		this.waitingServices.put(transaction, semaphore);
		this.pipeline.put(transaction);

		System.out.println("Before Aquire");
		semaphore.acquire();
		System.out.println("After Aquire");
		this.waitingServices.remove(transaction);
	}
}
