package fhdw.ipscrum.shared.model.messages;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Release;

/**
 * Tests the {@link ReleaseCompletionMessage} class.
 */
public class ReleaseCompletionMessageTest extends ModelTestBase {

	/**
	 * Release used for tests.
	 */
	private Release release;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		final Project project = new Project(this.getModel(), "Test Project");
		this.release = new Release(this.getModel(), "RC1", new Date(), project);
	}

	/**
	 * Tests the {@link ReleaseCompletionMessage} constructor.
	 */
	@Test
	public void testReleaseCompletionMessage() {
		new ReleaseCompletionMessage(this.release);
	}

	/**
	 * Tests the method {@link ReleaseCompletionMessage#getRelease()}.
	 */
	@Test
	public void testGetRelease() {
		final ReleaseCompletionMessage message = new ReleaseCompletionMessage(this.release);
		Assert.assertEquals(this.release, message.getRelease());
	}

	/**
	 * Tests the method {@link ReleaseCompletionMessage#accept(MessageVisitor)}.
	 */
	@Test
	public void testAccept() {
		final ReleaseCompletionMessage message = new ReleaseCompletionMessage(this.release);
		message.accept(new MessageStandardVisitor() {

			@Override
			public void standardHandling() {

			}
		});
	}

}
