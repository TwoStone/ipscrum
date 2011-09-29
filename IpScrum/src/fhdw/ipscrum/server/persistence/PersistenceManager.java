package fhdw.ipscrum.server.persistence;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.persistence.xStream.XStreamHandler;
import fhdw.ipscrum.server.persistence.xStream.XStreamProgramConfiguration;
import fhdw.ipscrum.server.session.Account;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.InfrastructureException;
import fhdw.ipscrum.shared.exceptions.infrastructure.BuildModelException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.exceptions.infrastructure.PersistenceException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.infrastructure.InitialCommand;
import fhdw.ipscrum.shared.infrastructure.Revision;
import fhdw.ipscrum.shared.infrastructure.Transaction;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.session.User;
import fhdw.ipscrum.shared.utils.InfrastructureUtils;

/**
 * This class controles the process of persisting and loading data.
 * 
 * TODO PersistenceManager muss zum Monitor werden. Dazu relevante Methoden mit synchronized versehen. Grund: Der PM
 * wird vom Hauptthread und von Executor Thread verwendet.
 * 
 */
public class PersistenceManager implements IPersistenceManager {
	/**
	 * the user name of the admin.
	 */
	private static final String ADMIN_NAME = "admin";
	/**
	 * represents the used xstream handler.
	 */
	private final transient XStreamHandler persistentHandler;
	/**
	 * Identifier for the name of the output file.
	 */
	public static final String FILENAME = "model";

	/**
	 * File ending of the output file.
	 */
	public static final String FILEENDING = ".xml";

	/**
	 * Output path.
	 */
	public static final String OUTPUTDIERECTORY = "output";

	/**
	 * represents the persistent data.
	 */
	private transient PersistData persistData;

	/**
	 * constructor of the persistenceManager.
	 * 
	 * @throws PersistenceException
	 *             if the persistence is hurt
	 */
	public PersistenceManager() throws PersistenceException {
		this.persistentHandler =
				new XStreamHandler(new XStreamProgramConfiguration(PersistenceManager.OUTPUTDIERECTORY,
						PersistenceManager.FILEENDING));
	}

	/**
	 * Returns the used XStream handler (see persistence documentation).
	 * 
	 * @return the used XStream hanlder
	 */
	public XStreamHandler getPersistentHandler() {
		return this.persistentHandler;
	}

	/**
	 * Initiate the process of persisting data.
	 * 
	 * @throws PersistenceException
	 *             if the persistence is hurt
	 */
	private void persistData() throws PersistenceException {
		this.getPersistentHandler().save(this.getPersistData(), PersistenceManager.FILENAME);
	}

	/**
	 * Initiate the process of loading data.
	 */
	private void loadData() {
		try {
			this.persistData = (PersistData) this.persistentHandler.load(PersistenceManager.FILENAME);
		} catch (final InfrastructureException e) {
			this.buildInitialRevision();
		}
	}

	/**
	 * Returns the latest persisted data.
	 * 
	 * @return the latest persisted data
	 */
	private PersistData getPersistData() {
		if (this.persistData == null) {
			this.loadData();
		}
		return this.persistData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.server.persistence.IPersistenceManager#getCurrentModel()
	 */
	@Override
	public Model getCurrentModel() {
		return this.getPersistData().getCurrentModel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.server.persistence.IPersistenceManager#getSpecificModel(java.util. Date)
	 */
	@Override
	public Model getSpecificModel(final Date revisionDate) throws IPScrumGeneralException {
		return InfrastructureUtils.buildSpecificModel(revisionDate, this.getPersistData().getRevisions());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.server.persistence.IPersistenceManager#addNewRevision(fhdw.ipscrum
	 * .shared.infrastructure.Revision, fhdw.ipscrum.shared.model.Model)
	 */
	@Override
	public void addNewRevision(final Revision revision, final Model revisionModel) throws PersistenceException {
		this.getPersistData().getRevisions().add(revision);
		this.getPersistData().setCurrentModel(revisionModel);
		this.updateAccounts(revisionModel);
		try {
			this.persistData();
		} catch (final PersistenceException e) {
			this.loadData();
			throw e;
		}
	}

	/**
	 * Updates the account. This updates the person reference in every user object to the one of the actual model.
	 * 
	 * @param revisionModel
	 *            the actual model containing the new persons.
	 */
	private void updateAccounts(final Model revisionModel) {
		final Iterator<Account> iterator = this.getAccounts().iterator();
		while (iterator.hasNext()) {
			final Account account = iterator.next();
			try {
				account.getUser().updatePerson(revisionModel.getObject(account.getUser().getPerson()));
			} catch (final NoObjectFindException e) {
				System.out.println("Person for user " + account.getUser().getName()
						+ " does not exist any longer. Deleting corresponding the account.");
				iterator.remove();
			}
		}
	}

	/**
	 * Help method for building the initial revision when no model file was found in the output directory.
	 * 
	 * @return the initial revision
	 */
	private PersistData buildInitialRevision() {
		try {
			// --- ...Initial Model
			final Model model = new Model(new Date());
			model.setUuidManager(new IDGenerator());
			final InitialCommand c = new InitialCommand();
			c.execute(model);

			// --- ...Dummy Transaction
			final Transaction t =
					new Transaction(model.getRevisionDate(), null, null, model.getUuidManager().getAllUUIDs());
			t.addCommand(c);

			// --- ...Initial Revision
			final Revision r =
					new Revision(t.getCommands(), model.getRevisionDate(), t.getEditorId(), t.getGeneratedUUIDs());

			// --- ...undo Flags
			for (final IdentifiableObject current : model.getChangedObjects()) {
				current.undoChangeFlag();
				current.setRevisionDate(model.getRevisionDate());
			}

			final PersistData data = new PersistData();
			data.setCurrentModel(model);
			data.getRevisions().add(r);

			// --- ...initialize admin account
			data.getAccounts().add(
					new Account(new User(PersistenceManager.ADMIN_NAME, model.getAdminPerson()),
							PersistenceManager.ADMIN_NAME));

			// --- ...persist
			this.persistData = data;
			this.persistData();

			return data;

		} catch (final IPScrumGeneralException e2) {
			e2.printStackTrace();
			return new PersistData();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.server.persistence.IPersistenceManager#copyCurrentModel()
	 */
	@Override
	public Model copyCurrentModel() throws IPScrumGeneralException {
		try {
			return InfrastructureUtils.buildSpecificModel(this.getPersistData().getCurrentModel().getRevisionDate(),
					this.getPersistData().getRevisions());
		} catch (final IPScrumGeneralException e) {
			throw new BuildModelException("Es konnte keine Modellkopie erstellt werden:" + e.getMessage());
		}
	}

	@Override
	public Model getModelForTesting() {
		try {
			return ((PersistData) this.getPersistentHandler().load(PersistenceManager.FILENAME)).getCurrentModel();
		} catch (final InfrastructureException e) {
			return this.buildInitialRevision().getCurrentModel();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.server.persistence.IPersistenceManager#getAccounts()
	 */
	@Override
	public List<Account> getAccounts() {
		return this.getPersistData().getAccounts();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.server.persistence.IPersistenceManager#addAccount(fhdw.ipscrum.server .session.Account)
	 */
	@Override
	public void addAccount(final Account account) throws PersistenceException {
		this.getPersistData().getAccounts().add(account);
		this.persistData();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.server.persistence.IPersistenceManager#getAllRevisions()
	 */
	@Override
	public List<Revision> getAllRevisions() {
		return this.getPersistData().getRevisions();
	}

}
