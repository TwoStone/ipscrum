package fhdw.ipscrum.shared.exceptions;

import fhdw.ipscrum.shared.constants.ExceptionConstants;

public class ConsistencyException extends UserException {

	private static final long serialVersionUID = -613917456743461614L;

	public ConsistencyException(final String message) {
		super(ExceptionConstants.CONCISTENCY_BASE + message);
	}
}
