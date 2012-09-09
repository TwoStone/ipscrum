package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.nonMeta.Release;

/**
 * represents an event argument which knows a release.
 */
public class ReleaseArgs extends EventArgs {

	/**
	 * represents the release attached to the event argument.
	 */
	private final Release release;

	/**
	 * constructor of the ReleaseArgs.
	 * 
	 * @param release
	 *            related to the argument
	 */
	public ReleaseArgs(final Release release) {
		super();
		this.release = release;
	}

	/**
	 * getter of the release.
	 * 
	 * @return the release
	 */
	public Release getRelease() {
		return this.release;
	}
}
