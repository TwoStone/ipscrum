package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.Hint;

public class RemoveHintEventArgs extends EventArgs {
	private final Hint hint;

	public RemoveHintEventArgs(Hint hint) {
		super();
		this.hint = hint;
	}

	public Hint getHint() {
		return hint;
	}
}
