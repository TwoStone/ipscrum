package fhdw.ipscrum.shared.exceptions.infrastructure;

import fhdw.ipscrum.shared.exceptions.InfrastructureException;

/**
 * Represents the Exception thrown if a object couldn't be found.
 * 
 */
public class NoObjectFindException extends InfrastructureException {

	/**
	 * Represents the serial Version UID.
	 */
	private static final long serialVersionUID = -5395753852433346253L;

	/**
	 * Constructor of the Exception without parameters.
	 */
	@SuppressWarnings("unused")
	private NoObjectFindException() {
		super();
	}

	/**
	 * Constructor of the Exception.
	 * 
	 * @param message
	 *            thrown by the Exception.
	 */
	public NoObjectFindException(final String message) {
		super(message);
	}

}
