package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.nonMeta.Hint;

/**
 * represents an event argument which knows a hint.
 */
public class RemoveHintEventArgs extends EventArgs {
	/**
	 * represents the hint attached to the event argument.
	 */
	private final Hint hint;

	/**
	 * constructor of the RemoveHintEventArgs.
	 * 
	 * @param hint
	 *            related to the argument
	 */
	public RemoveHintEventArgs(final Hint hint) {
		super();
		this.hint = hint;
	}

	/**
	 * getter of the hint.
	 * 
	 * @return the hint
	 */
	public Hint getHint() {
		return this.hint;
	}
}
