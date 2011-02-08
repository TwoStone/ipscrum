package fhdw.ipscrum.shared.exceptions;

/**
 * This exception is thrown if an object must not be instantiated twice.
 * @author stefan
 *
 */
public class DoubleDefinitionException extends Exception {


	public DoubleDefinitionException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;
	
}
