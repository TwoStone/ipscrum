package fhdw.ipscrum.shared.model.messages;

import fhdw.ipscrum.shared.model.nonMeta.Release;

/**
 * represent the ReleaseCompletionMessage.
 */
public class ReleaseCompletionMessage implements Message {

	/**
	 * represents the affected release.
	 */
	private final Release release;

	/**
	 * Constructor of the ReleaseCompletionMessage.
	 * 
	 * @param release
	 *            that is affected
	 */
	public ReleaseCompletionMessage(final Release release) {
		this.release = release;
	}

	/**
	 * Getter of the affected release.
	 * 
	 * @return the affected release
	 */
	public final Release getRelease() {
		return this.release;
	}

	@Override
	public void accept(final MessageVisitor v) {
		v.handleReleaseCompletionMessage(this);
	}

}
