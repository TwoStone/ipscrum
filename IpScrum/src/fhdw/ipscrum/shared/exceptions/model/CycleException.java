package fhdw.ipscrum.shared.exceptions.model;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.exceptions.ModelException;

/**
 * Represents the Exception thrown if a operation creates a cycle.
 * 
 */
public class CycleException extends ModelException {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 9114661238704773908L;

	/**
	 * Constructor of the Exception.
	 */
	public CycleException() {
		super(ExceptionConstants.CYCLE_EXCEPTION);
	}
}
