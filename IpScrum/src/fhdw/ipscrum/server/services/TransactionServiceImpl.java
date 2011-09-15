package fhdw.ipscrum.server.services;

import fhdw.ipscrum.client.services.TransactionService;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.PersistenceException;
import fhdw.ipscrum.shared.infrastructure.Transaction;
import fhdw.ipscrum.shared.model.Model;

/**
 * {@link TransactionService}.
 */
public class TransactionServiceImpl extends AbstractSecurityServlet
		implements TransactionService {

	/**
	 * represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 4260559044869004117L;

	@Override
	public Model commitTransaction(final Transaction transaction)
			throws IPScrumGeneralException {
		try {
			super.getExecutionController().commitTransaction(transaction);
			transaction.checkUserException();
			return ServerContext.getInstance().getPersistenceManager()
					.getCurrentModel();
		} catch (final InterruptedException e) {
			throw new PersistenceException("Executor was interrupted");
		}
	}

}
