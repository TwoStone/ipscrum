package fhdw.ipscrum.shared.exceptions.infrastructure;

import fhdw.ipscrum.shared.exceptions.InfrastructureException;

/**
 * Exception if a commit fails.
 * 
 */
@SuppressWarnings("serial")
public class CommitException extends InfrastructureException {

	/**
	 * Constructor of the Exception without parameters.
	 */
	public CommitException() {
		super();
	}

	/**
	 * Constructor of the Exception.
	 * 
	 * @param message
	 *            the Exception throws.
	 */
	public CommitException(final String message) {
		super(message);
	}

}
