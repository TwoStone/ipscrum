package fhdw.ipscrum.shared.exceptions.infrastructure;

import fhdw.ipscrum.shared.exceptions.InfrastructureException;

/**
 * Represents the Exception throw if the model is locked.
 */
public class ModelLockedException extends InfrastructureException {

	/**
	 * Represents the serial Version UID.
	 */
	private static final long serialVersionUID = 2506354347283066762L;

	/**
	 * Constructor of the Exception without parameters.
	 */
	public ModelLockedException() {
		super("Das Modell ist gesperrt!");

	}

	/**
	 * Constructor of the Exception.
	 * 
	 * @param message
	 *            thrown by the Exception
	 */
	public ModelLockedException(final String message) {
		super(message);

	}

}
