package fhdw.ipscrum.shared.exceptions;

public class ConsistencyException extends UserException {

	private static final long serialVersionUID = -613917456743461614L;

	public ConsistencyException(final String message) {
		// TODO Textkonstante bauen
		super("Konsistenzverletzung:\n" + message);
	}
}
