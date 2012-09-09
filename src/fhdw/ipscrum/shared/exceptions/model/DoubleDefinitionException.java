package fhdw.ipscrum.shared.exceptions.model;

import fhdw.ipscrum.shared.exceptions.ModelException;

/**
 * This exception is thrown if an object must not be instantiated twice.
 * 
 * @author stefan
 * 
 */
public class DoubleDefinitionException extends ModelException {

	/**
	 * Constructor of the Exception without parameters.
	 */
	@SuppressWarnings("unused")
	private DoubleDefinitionException() {

	}

	/**
	 * Constructor of the Exception.
	 * 
	 * @param message
	 *            thrown by the Exception
	 */
	public DoubleDefinitionException(final String message) {
		super(message);
	}

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

}
