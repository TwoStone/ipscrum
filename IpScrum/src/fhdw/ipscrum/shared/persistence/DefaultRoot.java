package fhdw.ipscrum.shared.persistence;

import fhdw.ipscrum.shared.exceptions.PersistenceException;
import fhdw.ipscrum.shared.observer.Observable;

/**
 * Default implementation of the {@link SerializationRoot} interface.
 * Extends the {@link Observable} class of the Persistence-Framework
 */
// TODO Check if this class is useful in GWT environment. How to handle AsyncCallback???
public abstract class DefaultRoot extends Observable implements SerializationRoot {

	/**
	 * Identifier where the class is stored.
	 */
	public static String IDENTIFIER = "DefaultRoot";

	@Override
	public void save(String identifier) throws PersistenceException {
		// TODO implement the save method
		
	}
	
	public void save() throws PersistenceException {
		save(IDENTIFIER);
	}
	
	

}
