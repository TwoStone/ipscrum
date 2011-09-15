package fhdw.ipscrum.shared.exceptions.model;

import fhdw.ipscrum.shared.exceptions.ModelException;

/**
 * Represents the Exception thrown if no PBI is selected.
 *
 */
public class NoPBISelectedException extends ModelException {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -8026951663938397482L;

	/**
	 * Constructor of the Exception.
	 * 
	 * @param string thrown by the Exception
	 */
	public NoPBISelectedException(final String string) {
		super(string);
	}

}
