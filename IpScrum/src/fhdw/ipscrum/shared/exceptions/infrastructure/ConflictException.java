package fhdw.ipscrum.shared.exceptions.infrastructure;

import fhdw.ipscrum.shared.exceptions.InfrastructureException;

/**
 * Exception thrown if there is a conflict.
 * 
 */
public class ConflictException extends InfrastructureException {

	/**
	 * Represents the serial Version UID.
	 */
	private static final long serialVersionUID = 4674333022666048114L;

	/**
	 * Constructor of the Exception without parameters.
	 */
	public ConflictException() {
		super();
	}

	/**
	 * Constructor of the Exception.
	 * 
	 * @param message
	 *            the Exception throws.
	 */
	public ConflictException(final String message) {
		super(message);
	}

}
