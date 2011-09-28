/**
 * 
 */
package fhdw.ipscrum.shared.exceptions.infrastructure;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 */
public class CommitExceptionTest {

	/**
	 * Test method for {@link fhdw.ipscrum.shared.exceptions.infrastructure.CommitException#CommitException()}.
	 */
	@Test
	public final void testCommitException() {
		final CommitException exception = new CommitException();
		Assert.assertNotNull(exception);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.exceptions.infrastructure.CommitException#CommitException(java.lang.String)}.
	 */
	@Test
	public final void testCommitExceptionString() {
		final CommitException exception = new CommitException("ErrorMessage");
		Assert.assertNotNull(exception);
		Assert.assertEquals("ErrorMessage", exception.getMessage());
	}

}
