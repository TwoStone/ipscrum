package fhdw.ipscrum.shared.exceptions.model;

import fhdw.ipscrum.shared.exceptions.ModelException;

/**
 * Represents the Exception thrown if a Ticket reaches a state it mussn't reach.
 *
 */
@SuppressWarnings("serial")
public class ForbiddenStateException extends ModelException {
	/**
	 * Constructor of the Exception.
	 * 
	 * @param message thrown by the Exception
	 */
	public ForbiddenStateException(final String message) {
		super(message);
	}
}
