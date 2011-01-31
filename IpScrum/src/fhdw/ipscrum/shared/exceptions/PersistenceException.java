package fhdw.ipscrum.shared.exceptions;

/**
 * Represents each Exception within the Persistence Framework.
 */
public class PersistenceException extends Exception {

	private static final long serialVersionUID = -8987838419804405820L;

	public PersistenceException(String message) {
		super(message);
	}
}
