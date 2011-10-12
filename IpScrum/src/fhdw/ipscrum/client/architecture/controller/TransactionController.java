package fhdw.ipscrum.client.architecture.controller;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.ClientContext.ModelUpdateEvent;
import fhdw.ipscrum.client.architecture.events.eventbus.EventBus.Handler;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.services.TransactionService;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.ModelLockedException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoOpenTransactionException;
import fhdw.ipscrum.shared.exceptions.infrastructure.PendingCommitException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.infrastructure.Transaction;
import fhdw.ipscrum.shared.model.Model;

/**
 * this class represents the transactionController.
 */
public class TransactionController extends ClientController {

	/**
	 * represents the pending transaction.
	 */
	private Transaction pendingTransaction;

	/**
	 * Handles updates of the model. If a new model is received we have to ensure that no commands for the old model
	 * exist.
	 */
	private final Handler<ModelUpdateEvent> modelUpdateHandler = new ClientContext.ModelUpdateHandler() {

		@Override
		public void handleModelUpdated(final ModelUpdateEvent event) {
			GWT.log("[TransactionController] New model loaded, ensure that the pending transaction is reseted");
			final Transaction oldTransaction = TransactionController.this.pendingTransaction;
			TransactionController.this.pendingTransaction = null;

			if (oldTransaction != null) {
				try {
					TransactionController.this.beginTransaction();
				} catch (final PendingCommitException e) {
					// Normally this should not happen because we set the
					// pendingTransaction to null.
					GWT.log("[TransactionController]", e);
				}
			}
		}
	};

	/**
	 * constructor of the TransactionController.
	 * 
	 * @param context
	 *            the current context of the application
	 */
	public TransactionController(final ClientContext context) {
		super(context);

		context.getEventBus().registerHandler(ModelUpdateEvent.class, this.modelUpdateHandler);
	}

	/**
	 * begins the transaction.
	 * 
	 * @throws PendingCommitException
	 *             if the last transaction isn't already send to the server
	 */
	public void beginTransaction() throws PendingCommitException {
		final ClientContext context = this.getContext();

		if (context.getModel().getViewOnlyFlag()) {
			return;
		}
		if (this.pendingTransaction != null && this.pendingTransaction.getCommands().size() > 0) {
			throw new PendingCommitException();
		} else {
			GWT.log("[TransactionController] new transaction started");
			final Model model = context.getModel();
			this.pendingTransaction =
					new Transaction(model.getRevisionDate(), context.getCurrentUser().getPerson(),
							context.getActiveRole(), model.getUuidManager().getAllUUIDs());
		}
	}

	/**
	 * rolls back a transition.
	 * 
	 */
	public void rollbackTransaction() {
		GWT.log("[TransactionController] Rollback changes!");
		final ClientContext context = this.getContext();
		if (context.getModel().getViewOnlyFlag()) {
			return;
		}
		context.updateModel();
	}

	/**
	 * adds a command to a transaction.
	 * 
	 * @param command
	 *            to add
	 * @throws NoOpenTransactionException
	 *             if there is no transaction open to add a command to
	 */
	public void addTransactionCommand(final Command<?> command) throws NoOpenTransactionException {
		if (this.pendingTransaction != null) {
			this.pendingTransaction.addCommand(command);
		} else {
			throw new NoOpenTransactionException("Es existiert keine offene Transaktion!");
		}
	}

	/**
	 * commits a transaction.
	 * 
	 * @param callback
	 *            of the commit
	 * @throws ModelLockedException
	 *             if the transaction could be commited
	 */
	public void commitTransaction(final AsyncCallback<Void> callback) throws ModelLockedException {
		final ClientContext context = this.getContext();

		if (context.getModel().getViewOnlyFlag()) {
			throw new ModelLockedException();
		}

		GWT.log("[TransactionController] commiting transaction");

		if (this.pendingTransaction != null && this.pendingTransaction.getCommands().size() > 0) {
			TransactionService.Util.getInstance().commitTransaction(this.pendingTransaction,
					new AsyncCallback<Model>() {

						@Override
						public void onSuccess(final Model result) {
							TransactionController.this.pendingTransaction = null;
							context.setModel(result);
							GWT.log("[TransactionController] Commit succesfull!");
							callback.onSuccess(null);
						}

						@Override
						public void onFailure(final Throwable caught) {

							TransactionController.this.rollbackTransaction();
							GWT.log("[TransactionController] Error in commit!", caught);
							callback.onFailure(caught);
						}
					});
		}
	}

	/**
	 * Does a command.
	 * 
	 * @param <R>
	 *            is the result type
	 * @param presenter
	 *            which triggers the donation of the command
	 * @param command
	 *            to do
	 * @return the result of the command
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public <R> R doCommand(final WritePresenter presenter, final Command<R> command) throws IPScrumGeneralException {

		if (presenter.getContext().getModel().getViewOnlyFlag()) {
			throw new ModelLockedException();
		}

		command.execute(presenter.getContext().getModel(), presenter.getContext().getActiveRole());
		GWT.log("[TransactionController] Executed command local " + command.toString());
		final R result = command.getResult();
		this.addTransactionCommand(command);
		return result;
	}

	/**
	 * 
	 * @return <code>true</code> if there are commands contained the current transaction
	 */
	public boolean hasPendingChanged() {
		return this.pendingTransaction != null && !this.pendingTransaction.getCommands().isEmpty();
	}
}
