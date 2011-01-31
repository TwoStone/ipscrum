package fhdw.ipscrum.shared.persistence;

import fhdw.ipscrum.shared.exceptions.PersistenceException;
import fhdw.ipscrum.shared.exceptions.PersistenceFileNotFoundException;

/**
 * Interface for persistence handlers like XStream.<br />
 * <p>
 * Own persistence handlers have to implement this
 * interface to be used with the PersistenceManager.</p>
 */
public interface PersistenceHandler {

	/**
	 * Persists the model under the given identifier.
	 * @param root Root to persist.
	 * @param identifier Identifies the output, has to be unique.
	 * @throws PersistenceException 
	 */
	public void save(SerializationRoot root,String identifier) throws PersistenceException;
	
	
	/**
	 * Loading the complete object graph stored under the identifier. 
	 * @param identifier of the stored object.
	 * @return Returns the stored object.
	 * @throws PersistenceFileNotFoundException If there was no object stored under the given identifier.
	 * @throws PersistenceException
	 */
	public SerializationRoot load(String identifier) throws PersistenceException;
	
}
