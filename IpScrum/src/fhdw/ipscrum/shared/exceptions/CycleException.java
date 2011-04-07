package fhdw.ipscrum.shared.exceptions;

public class CycleException extends Exception {

	private static final long serialVersionUID = 9114661238704773908L;

	public CycleException() {
		// TODO Textkonstante bauen!
		super("Zyklus entdeckt!");
	}
}
