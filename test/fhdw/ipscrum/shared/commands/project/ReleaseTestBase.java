/**
 * 
 */
package fhdw.ipscrum.shared.commands.project;

import java.util.Date;

import fhdw.ipscrum.shared.model.nonMeta.Release;

/**
 * 
 */
public class ReleaseTestBase extends ProjectTestBase {

	/**
	 * Release for tests.
	 */
	private Release release;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		this.release = new Release(this.getModel(), "Beta Project", new Date(), this.getProject());
	}

	/**
	 * 
	 * @return release for tests
	 */
	public Release getRelease() {
		return this.release;
	}
}
