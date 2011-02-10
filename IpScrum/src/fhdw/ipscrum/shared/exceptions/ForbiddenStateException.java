package fhdw.ipscrum.shared.exceptions;

@SuppressWarnings("serial")
public class ForbiddenStateException extends Exception {
	public ForbiddenStateException(String message){
		super(message);
	}
}
