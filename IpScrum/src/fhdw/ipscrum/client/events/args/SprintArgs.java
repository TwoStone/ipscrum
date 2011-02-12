package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

/**
 */
public class SprintArgs extends EventArgs {

	private final ISprint sprint;

	/**
	 * Constructor for SprintArgs.
	 * @param sprint ISprint
	 */
	public SprintArgs(ISprint sprint) {
		super();
		this.sprint = sprint;
	}

	/**
	 * Method getSprint.
	
	 * @return ISprint */
	public ISprint getSprint() {
		return this.sprint;
	}
}
