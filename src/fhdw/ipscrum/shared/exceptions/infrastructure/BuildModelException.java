package fhdw.ipscrum.shared.exceptions.infrastructure;

import fhdw.ipscrum.shared.exceptions.InfrastructureException;

/**
 * Exception if the build of the model fails.
 * 
 */
@SuppressWarnings("serial")
public class BuildModelException extends InfrastructureException {

	/**
	 * Constructor of the Exception without parameters.
	 */
	@SuppressWarnings("unused")
	private BuildModelException() {
		super();
	}

	/**
	 * Constructor of the Exception.
	 * 
	 * @param message
	 *            the Exception throws.
	 */
	public BuildModelException(final String message) {
		super(message);
	}
}
