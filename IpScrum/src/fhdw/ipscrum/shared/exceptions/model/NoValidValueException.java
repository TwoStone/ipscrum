package fhdw.ipscrum.shared.exceptions.model;

import fhdw.ipscrum.shared.exceptions.ModelException;

/**
 * Represents the Exception thrown if a value is not valid.
 *
 */
public class NoValidValueException extends ModelException {
	
	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 2623970838234804370L;

	/**
	 * Constructor of the Exception.
	 * 
	 * @param message thrown by the Exception
	 */
	public NoValidValueException(final String message) {
		super(message);
	}

}
