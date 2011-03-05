package fhdw.ipscrum.shared.exceptions;

import fhdw.ipscrum.shared.exceptions.UserException;

public class WrongReleaseException extends UserException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7709432482462482087L;

	public WrongReleaseException(String message) {
		super(message);
	}

}
