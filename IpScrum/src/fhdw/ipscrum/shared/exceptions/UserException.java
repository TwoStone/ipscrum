package fhdw.ipscrum.shared.exceptions;

/**
 * Base class for application generated excpetions.
 * 
 * @author n.w.
 * 
 */
public abstract class UserException extends Exception {

	public UserException(final String message) {
		super(message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -5337262119471167292L;

}
