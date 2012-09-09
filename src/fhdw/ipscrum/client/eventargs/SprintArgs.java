package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;

/**
 * represents the event argument which knows a sprint.
 */
public class SprintArgs extends EventArgs {

	/**
	 * represent the sprint attached to the event argument.
	 */
	private final Sprint sprint;

	/**
	 * Constructor for SprintArgs.
	 * 
	 * @param sprint
	 *            Sprint
	 */
	public SprintArgs(final Sprint sprint) {
		super();
		this.sprint = sprint;
	}

	/**
	 * Method getSprint.
	 * 
	 * @return Sprint
	 */
	public Sprint getSprint() {
		return this.sprint;
	}
}
