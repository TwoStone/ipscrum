package fhdw.ipscrum.shared.exceptions.model;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.exceptions.ModelException;

/**
 * Represents the Exception thrown if the consistency is hurt.
 * 
 */
public class ConsistencyException extends ModelException {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -613917456743461614L;

	/**
	 * Constructor of the Exception.
	 * 
	 * @param message
	 *            thrown by the Exception
	 */
	public ConsistencyException(final String message) {
		super(ExceptionConstants.CONCISTENCY_BASE + message);
	}
}
