package fhdw.ipscrum.shared.exceptions.model;

import fhdw.ipscrum.shared.exceptions.ModelException;

/**
 * Represents the Exception if it is the wrong system.
 *
 */
public class WrongSystemException extends ModelException {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 1487010731419179588L;

	/**
	 * Constructor of the Exception.
	 * 
	 * @param message thrown by the Exception
	 */
	public WrongSystemException(final String message) {
		super(message);
	}

}
