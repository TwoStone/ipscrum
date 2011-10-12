package fhdw.ipscrum.shared.exceptions.model;

import fhdw.ipscrum.shared.exceptions.ModelException;

/**
 * Represents the Exception thrown if the sprint is not defined.
 * 
 */
@SuppressWarnings("serial")
public class NoSprintDefinedException extends ModelException {

	/**
	 * Constructor of the Exception.
	 * 
	 * @param message
	 *            thrown by the Exception
	 */
	public NoSprintDefinedException(final String message) {
		super(message);
	}
}
