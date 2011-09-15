package fhdw.ipscrum.shared.exceptions.infrastructure;

import fhdw.ipscrum.shared.exceptions.InfrastructureException;

/**
 * Exception thrown if someone isn't authorized to do something.
 *
 */
public class NotAuthorizedException extends InfrastructureException {

	/**
	 * Constructor of the Exception.
	 * 
	 * @param string thrown by the Exception
	 */
	public NotAuthorizedException(final String string) {
		super(string);
	}

	/**
	 * Represents the serial Version UID.
	 */
	private static final long serialVersionUID = -1575415758683972135L;

	/**
	 * Constructor of the Exception without parameters.
	 */
	public NotAuthorizedException() {
		super();
	}
}
