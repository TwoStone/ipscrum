package fhdw.ipscrum.shared.exceptions.model;

import fhdw.ipscrum.shared.exceptions.ModelException;

/**
 * Represents the Exception thrown if the release is wrong.
 * 
 */
public class WrongReleaseException extends ModelException {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 7709432482462482087L;

	/**
	 * Constructor of the Exception.
	 * 
	 * @param message
	 *            thrown by the Exception
	 */
	public WrongReleaseException(final String message) {
		super(message);
	}

}
