package fhdw.ipscrum.shared.exceptions.model;

import fhdw.ipscrum.shared.exceptions.ModelException;

/**
 * Major Taskboard consistency exception. This exception will be thrown if the context of a sprint does not allow
 * assignments with tasks, for example assign a person which is not contained in the sprint team
 */
public class SprintAssociationException extends ModelException {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -8444006756078567113L;

	/**
	 * Constructor of the Exception.
	 * 
	 * @param message
	 *            thrown by the Exception
	 */
	public SprintAssociationException(final String message) {
		super(message);
	}

}
