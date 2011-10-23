package fhdw.ipscrum.server;

import fhdw.ipscrum.server.configuration.Configuration;
import fhdw.ipscrum.server.persistence.ExecutionController;
import fhdw.ipscrum.server.persistence.IPersistenceManager;
import fhdw.ipscrum.server.persistence.PersistenceManager;
import fhdw.ipscrum.server.session.AccountManager;
import fhdw.ipscrum.server.session.SessionManager;
import fhdw.ipscrum.shared.exceptions.infrastructure.PersistenceException;

/**
 * Initialization class for server relevant managers objects.
 */
public final class ServerContext {
	/**
	 * represents the instance of the ServerContext.
	 */
	private static ServerContext instance;

	/**
	 * Getter of the Instance of the ServerContext.
	 * 
	 * @return the ServerContext.
	 */
	public static ServerContext getInstance() {
		if (ServerContext.instance == null) {
			final ServerContext context = new ServerContext();
			context.getExecutionController().start();
			ServerContext.instance = context;
		}
		return ServerContext.instance;
	}

	/**
	 * Resets the ServerContext to null.
	 */
	public static void resetServerContext() {
		ServerContext.instance = null;
	}

	/**
	 * constructor of the ServerContext.
	 */
	private ServerContext() {
		try {
			this.configuration = new Configuration();
			this.persistenceManager = new PersistenceManager(this);
		} catch (final PersistenceException e1) {
			// TODO überlegen was hier getan werden muss! Der Fehler müsste bis
			// an den Client übergeben werden
			this.persistenceManager = null;
		}

		this.executionController = new ExecutionController(this.persistenceManager);
		this.sessionManager = new SessionManager();
		this.accountManager = new AccountManager(this.sessionManager, this.persistenceManager);
	}

	/**
	 * represents the account manager.
	 */
	private final AccountManager accountManager;
	/**
	 * represents the session manager.
	 */
	private final SessionManager sessionManager;
	/**
	 * represents the executionController.
	 */
	private final ExecutionController executionController;
	/**
	 * represents the persistence manager.
	 */
	private IPersistenceManager persistenceManager;
	private Configuration configuration;

	/**
	 * @return the accountManager
	 */
	public AccountManager getAccountManager() {
		return this.accountManager;
	}

	/**
	 * @return the sessionManager
	 */
	public SessionManager getSessionManager() {
		return this.sessionManager;
	}

	/**
	 * @return the execution controller
	 */
	public ExecutionController getExecutionController() {
		return this.executionController;
	}

	/**
	 * @return the persistence manager
	 */
	public IPersistenceManager getPersistenceManager() {
		return this.persistenceManager;
	}

	/**
	 * Sets the persistence manager to the specific manager.
	 * 
	 * @param persistenceManager
	 *            the new persistence manager
	 */
	public void setPersistenceManager(final IPersistenceManager persistenceManager) {
		this.persistenceManager = persistenceManager;
	}

	/**
	 * @return <code>true</code> if and only if the {@link ServerContext} was initialized before.
	 */
	public static boolean isInitialized() {
		return ServerContext.instance != null;
	}

	/**
	 * @return the configuration of the server
	 */
	public Configuration getConfiguration() {
		return this.configuration;
	}
}
