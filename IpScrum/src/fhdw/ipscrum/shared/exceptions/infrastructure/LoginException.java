package fhdw.ipscrum.shared.exceptions.infrastructure;

import fhdw.ipscrum.shared.exceptions.InfrastructureException;

/**
 * Represents the Exception thrown if the Login fails.
 *
 */
public class LoginException extends InfrastructureException {

	/**
	 * Constructor of the Exception.
	 * 
	 * @param string thrown by the Exception
	 */
	public LoginException(final String string) {
		super(string);
	}
	
	/**
	 * Constructor of the Exception without parameters.
	 */
	public LoginException() {
		super();
	}

	/**
	 * Represents the serial Version UID.
	 */
	private static final long serialVersionUID = 8411660001076901858L;

}
