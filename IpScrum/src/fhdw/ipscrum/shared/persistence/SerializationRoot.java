package fhdw.ipscrum.shared.persistence;

import java.io.Serializable;

import fhdw.ipscrum.shared.exceptions.PersistenceException;

/**
 * Represents the root element for serialization.
 */
public interface SerializationRoot extends Serializable {

	/**
	 * Persists the object structure
	 * 
	 * @param identifier
	 *            TODO
	 */
	public void save(String identifier) throws PersistenceException;

}
