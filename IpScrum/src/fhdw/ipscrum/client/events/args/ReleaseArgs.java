package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.Release;

public class ReleaseArgs extends EventArgs {

	private Release release;

	public ReleaseArgs(Release release) {
		super();
		this.release = release;
	}
	
	public Release getRelease() {
		return release;
	}
}
