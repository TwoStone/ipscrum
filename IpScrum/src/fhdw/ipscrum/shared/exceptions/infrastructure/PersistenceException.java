package fhdw.ipscrum.shared.exceptions.infrastructure;

import fhdw.ipscrum.shared.exceptions.InfrastructureException;

/**
 * Represents each Exception within the Persistence Framework.
 */
public class PersistenceException extends InfrastructureException {

	/**
	 * Represents the serial Version UID.
	 */
	private static final long serialVersionUID = -8987838419804405820L;

	/**
	 * Constructor of the Exception without parameters.
	 */
	protected PersistenceException() {
	}

	/**
	 * Constructor of the Exception.
	 * 
	 * @param message
	 *            the Exception throws.
	 */
	public PersistenceException(final String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param exception
	 */
	public PersistenceException(final String message, final Throwable exception) {
		super(message, exception);

	}

}
