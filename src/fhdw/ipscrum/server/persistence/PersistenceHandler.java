package fhdw.ipscrum.server.persistence;

import fhdw.ipscrum.shared.exceptions.InfrastructureException;
import fhdw.ipscrum.shared.exceptions.infrastructure.PersistenceException;
import fhdw.ipscrum.shared.infrastructure.SerializationRoot;

/**
 * Interface for persistence handlers like XStream.<br />
 * <p>
 * Own persistence handlers have to implement this interface to be used with the PersistenceManager.
 * </p>
 */
public interface PersistenceHandler {

	/**
	 * Persists the model under the given identifier.
	 * 
	 * @param root
	 *            Root to persist.
	 * @param identifier
	 *            Identifies the output, has to be unique.
	 * @throws PersistenceException
	 *             if the model could not been persisted
	 */
	void save(SerializationRoot root, String identifier) throws PersistenceException;

	/**
	 * Loading the complete object graph stored under the identifier.
	 * 
	 * @param identifier
	 *            of the stored object.
	 * @param <T>
	 *            type of the serialized model.
	 * @return Returns the stored object.
	 * 
	 * @throws InfrastructureException
	 *             if there is a problem in the infrastructure
	 */
	<T extends SerializationRoot> T load(String identifier) throws InfrastructureException;

}
