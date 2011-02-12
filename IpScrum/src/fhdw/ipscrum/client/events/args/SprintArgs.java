package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

public class SprintArgs extends EventArgs {

	private final ISprint sprint;

	public SprintArgs(ISprint sprint) {
		super();
		this.sprint = sprint;
	}

	public ISprint getSprint() {
		return this.sprint;
	}
}
