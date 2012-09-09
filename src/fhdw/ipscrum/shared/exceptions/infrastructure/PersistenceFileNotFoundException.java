package fhdw.ipscrum.shared.exceptions.infrastructure;

import fhdw.ipscrum.shared.exceptions.InfrastructureException;

/**
 * Represents a specific PersistenceException.<br />
 * <p>
 * This exception is thrown if loading a model cannot proceed because the required .xml file is not available.
 * </p>
 */
public class PersistenceFileNotFoundException extends InfrastructureException {

	/**
	 * Represents the serial Version UID.
	 */
	private static final long serialVersionUID = 7794478171652646911L;

	/**
	 * Constructor of the Exception.
	 * 
	 * @param message
	 *            the Exception throws.
	 */
	public PersistenceFileNotFoundException(final String message) {
		super(message);
	}

	/**
	 * Constructor of the Exception without parameters.
	 */
	@SuppressWarnings("unused")
	private PersistenceFileNotFoundException() {
	}
}
