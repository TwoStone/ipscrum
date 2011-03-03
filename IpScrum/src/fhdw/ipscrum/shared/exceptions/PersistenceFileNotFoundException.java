package fhdw.ipscrum.shared.exceptions;

/**
 * Represents a specific PersistenceException.<br />
 * <p>
 * This exception is thrown if loading a model cannot proceed because the
 * required .xml file is not available.
 * </p>
 */
public class PersistenceFileNotFoundException extends PersistenceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7794478171652646911L;

	public PersistenceFileNotFoundException(final String message) {
		super(message);
	}
}
