package fhdw.ipscrum.shared.exceptions.infrastructure;

import fhdw.ipscrum.shared.exceptions.InfrastructureException;

/**
 * Represents the Exception thrown if a commit is pending.
 * 
 */
public class PendingCommitException extends InfrastructureException {

	/**
	 * Represents the serial Version UID.
	 */
	private static final long serialVersionUID = 1335512504407293841L;

	/**
	 * Constructor of the Exception without parameters.
	 */
	public PendingCommitException() {
		super();

	}

	/**
	 * Constructor of the Exception.
	 * 
	 * @param message
	 *            the Exception throws.
	 */
	public PendingCommitException(final String message) {
		super(message);

	}

}
