package fhdw.ipscrum.shared.exceptions;

@SuppressWarnings("serial")
public class ForbiddenStateException extends UserException {
	public ForbiddenStateException(final String message) {
		super(message);
	}
}
