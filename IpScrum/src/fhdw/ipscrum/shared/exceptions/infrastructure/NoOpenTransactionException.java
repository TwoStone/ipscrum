package fhdw.ipscrum.shared.exceptions.infrastructure;

import fhdw.ipscrum.shared.exceptions.InfrastructureException;

/**
 * Represents the Exception thrown if there is no transaction open.
 * 
 */
public class NoOpenTransactionException extends InfrastructureException {

	/**
	 * Represents the sereialVersionUID.
	 */
	private static final long serialVersionUID = 9106322879140466240L;

	/**
	 * Constructor of the Exception without parameters.
	 */
	public NoOpenTransactionException() {
		super();

	}

	/**
	 * Constructor of the Exception.
	 * 
	 * @param message
	 *            thrown by the Exception
	 */
	public NoOpenTransactionException(final String message) {
		super(message);

	}

}
