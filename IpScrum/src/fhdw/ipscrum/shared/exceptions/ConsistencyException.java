package fhdw.ipscrum.shared.exceptions;

public class ConsistencyException extends Exception {

	private static final long serialVersionUID = -613917456743461614L;

	public ConsistencyException(String message) {
		//TODO Textkonstante bauen
		super("Konsistenzverletzung:\n"+message);
	}
}
