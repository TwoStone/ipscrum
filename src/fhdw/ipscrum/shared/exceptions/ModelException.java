package fhdw.ipscrum.shared.exceptions;

/**
 * Base class for application generated excpetions.
 * 
 * @author n.w.
 * 
 */
public abstract class ModelException extends IPScrumGeneralException {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 4101968109189386332L;

	/**
	 * Constructor of the Exception without parameters.
	 */
	public ModelException() {
	}

	/**
	 * Constructor of the Exception.
	 * 
	 * @param message
	 *            thrown by the Exception.
	 */
	public ModelException(final String message) {
		super(message);
	}

}
