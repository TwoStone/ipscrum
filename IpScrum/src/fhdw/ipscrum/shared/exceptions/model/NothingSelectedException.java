package fhdw.ipscrum.shared.exceptions.model;

import fhdw.ipscrum.shared.exceptions.ModelException;

/**
 * Represents the Exception thrown if nothing is selected.
 *
 */
public class NothingSelectedException extends ModelException {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -4013661605554923689L;

	/**
	 * Constructor of the Exception.
	 * @param message thrown by the Exception
	 */
	public NothingSelectedException(final String message) {
		super(message);
	}

}
