package fhdw.ipscrum.shared.exceptions;

/**
 * Represents the Exception thrown if the failure is throw by a infrastructure problem.
 * 
 */
public abstract class InfrastructureException extends IPScrumGeneralException {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -4804862969048362392L;

	/**
	 * Constructor of the Exception.
	 * 
	 * @param message
	 *            thrown by the Exception
	 * @param exception
	 *            related to the Exception
	 */
	public InfrastructureException(final String message, final Throwable exception) {
		super(message, exception);
	}

	/**
	 * Constructor of the Exception.
	 * 
	 * @param message
	 *            thrown by the Exception
	 */
	public InfrastructureException(final String message) {
		super(message);
	}

	/**
	 * Constructor of the Exception.
	 * 
	 * @param exception
	 *            related to the Exception
	 */
	public InfrastructureException(final Throwable exception) {
		super(exception);
	}

	/**
	 * Constructor of the Exception without parameters.
	 */
	public InfrastructureException() {
		super();
	}

}
