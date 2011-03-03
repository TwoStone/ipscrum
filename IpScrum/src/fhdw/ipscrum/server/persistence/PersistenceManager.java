package fhdw.ipscrum.server.persistence;

import fhdw.ipscrum.server.persistence.xStream.XStreamConfiguration;
import fhdw.ipscrum.server.persistence.xStream.XStreamHandler;
import fhdw.ipscrum.server.persistence.xStream.XStreamProgramConfiguration;
import fhdw.ipscrum.shared.exceptions.PersistenceException;
import fhdw.ipscrum.shared.persistence.PersistenceHandler;
import fhdw.ipscrum.shared.persistence.SerializationRoot;

/**
 * <b>Singleton Class</b>
 * <p>
 * This class represents the persistence manager.<br />
 * <br />
 * Function of this class is to define the persistence handler once. So, while
 * life-cycle only one persistence behavior will be used.<br />
 * <br />
 * At default XStream will be used for persistence.
 * </p>
 */
public final class PersistenceManager implements PersistenceHandler {

	private static PersistenceManager instance;

	/**
	 * Returns the PersistenceManager. <br />
	 * <br />
	 * <b>Attention</b> The first call of this method while program life-cycle
	 * decides the functioning. <br />
	 * <br />
	 * If this method is called first, the default handler "XStream" will be
	 * used all the time no matter if getInstance() or
	 * getInstance(PersistenceHandlerInterface handler) will be called another
	 * time.
	 */
	public static PersistenceManager getInstance() throws PersistenceException {
		if (instance == null) {
			instance = new PersistenceManager();
		}

		return instance;
	}

	/**
	 * Returns the PersistenceManager. <br />
	 * <br />
	 * <b>Attention</b> The first call of this method while program life-cycle
	 * decides the functioning an sets the given handler "handler" of type
	 * PersistenceHandlerInterface. <br />
	 * <br />
	 * If this method is called first, the given handler will be used all the
	 * time no matter if getInstance() or
	 * getInstance(PersistenceHandlerInterface handler) will be called another
	 * time.
	 */
	public static PersistenceManager getInstance(
			final PersistenceHandler handler) {
		if (instance == null) {
			instance = new PersistenceManager(handler);
		}

		return instance;
	}

	private final PersistenceHandler handler;

	/**
	 * Uses Default Handler (XStream)
	 */
	private PersistenceManager() throws PersistenceException {
		final XStreamConfiguration configuration = new XStreamProgramConfiguration(
				"output", ".xml");
		this.handler = new XStreamHandler(configuration);
	}

	/**
	 * Uses the given handler
	 * 
	 * @param handler
	 *            The handler to be used
	 */
	private PersistenceManager(final PersistenceHandler handler) {
		this.handler = handler;
	}

	@Override
	public SerializationRoot load(final String identifier)
			throws PersistenceException {
		return this.handler.load(identifier);
	}

	@Override
	public void save(final SerializationRoot root, final String identifier)
			throws PersistenceException {
		this.handler.save(root, identifier);
	}
}
