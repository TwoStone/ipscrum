package fhdw.ipscrum.client.architecture.presenter;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.controller.ToastMessageController;
import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.widgets.Answer;
import fhdw.ipscrum.client.architecture.widgets.QuestionDialog;
import fhdw.ipscrum.client.utils.SimpleCallback;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.ModelLockedException;
import fhdw.ipscrum.shared.exceptions.infrastructure.PendingCommitException;
import fhdw.ipscrum.shared.infrastructure.Command;

/**
 * represents a presenter in which the model could be changed.
 */
public abstract class WritePresenter extends Presenter {

	/**
	 * represents the saveEvent which is needed to persist the change.
	 */
	private final DefaultEvent saveEvent = new DefaultEvent();

	// private final Event<EventArgs> abortEvent = new Event<EventArgs>();

	/**
	 * constructor of the WritePresenter.
	 * 
	 * @param context
	 *            is the context of the presenter
	 */
	public WritePresenter(final ClientContext context) {
		super(context);
	}

	/**
	 * Saves the work of the presenter. Deriving presenters should overwrite
	 * {@link WritePresenter#onSave()} to do own tasks as committing transaction on save.
	 */
	public final void save() {
		if (this.onSave()) {
			this.saveEvent.fire(this);
		}
	}

	/**
	 * this method is a flag for the save.
	 * 
	 * @return true
	 */
	public Boolean onSave() {
		return true;
	}

	// public final void abort() {
	// if (this.onAbort()) {
	// this.abortEvent.fire(this, new EventArgs());
	// }
	// }
	//
	// public Boolean onAbort() {
	// return true;
	// }

	/**
	 * this is the handler to handle the save event.
	 * 
	 * @param handler
	 *            is needed to handle the event
	 * @return the event to fire
	 */
	public final EventRegistration registerSaveHandler(
			final EventHandler<EventArgs> handler) {
		return this.saveEvent.add(handler);
	}

	// public final EventRegistration registerAbortHandler(
	// final EventHandler<EventArgs> handler) {
	// return this.abortEvent.add(handler);
	// }

	/**
	 * this method commits the transaction.
	 */
	protected void commitTransaction() {
		this.commitTransaction(new SimpleCallback() {

			@Override
			public void callback() {

			}
		});
	}

	/**
	 * this method commits the transaction an rolls it back if something fails.
	 * 
	 * @param callback
	 *            is the callback of the transaction
	 */
	protected void commitTransaction(final SimpleCallback callback) {
		this.commitTransaction(new AsyncCallback<Void>() {

			@Override
			public void onSuccess(final Void result) {
				callback.callback();
			}

			@Override
			public void onFailure(final Throwable caught) {
				WritePresenter.this.toastMessage(
						"Error on Commit:\n" + caught.getMessage(),
						ToastMessageController.DisplayDuration.MEDIUM);
			}
		});
	}

	/**
	 * this commits the transaction.
	 * 
	 * @param callback
	 *            is the callback of the transaction
	 */
	protected void commitTransaction(final AsyncCallback<Void> callback) {
		try {
			this.getContext().getTransactionController().commitTransaction(callback);
		} catch (final ModelLockedException e) {
			this.toastMessage("Bearbeiten im Revisionsmodus ist nicht möglich! Kehren Sie zur aktuellen Revision zurück um Änderungen vorzunehmen!");
		}
	}

	/**
	 * this method begins a transaction which could be commited.
	 */
	protected void beginTransaction() {
		try {
			this.getContext().getTransactionController().beginTransaction();
		} catch (final PendingCommitException e) {
			this.showQuestion(
					"Es existieren noch nicht übertragene Änderungen. Wie sollen diese behandelt werden?",
					new Answer("An den Server senden.") {

						@Override
						public void onAction(final QuestionDialog widget) {
							WritePresenter.this.commitTransaction();
							widget.hide();
						}
					}, new Answer("Verwerfen") {

						@Override
						public void onAction(final QuestionDialog widget) {
							WritePresenter.this.rollbackTransaction();
							widget.hide();
						}
					});
		}
	}

	/**
	 * this method rolls back a transaction in which something failed.
	 */
	protected void rollbackTransaction() {
		this.getContext().getTransactionController().rollbackTransaction();
	}

	/**
	 * this method is needed to do a command.
	 * 
	 * @param <R>
	 *            is the result type
	 * @param command
	 *            is the command which should be done
	 * @return the result of the command
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	protected <R> R doCommand(final Command<R> command) throws IPScrumGeneralException {
		return this.getContext().getTransactionController().doCommand(this, command);
	}

	/**
	 * @return <code>true</code> if there are commands contained the current transaction
	 */
	protected boolean hasPendingChanges() {
		return this.getContext().getTransactionController().hasPendingChanged();
	}
}
