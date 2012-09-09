/**
 * 
 */
package fhdw.ipscrum.shared.exceptions.infrastructure;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 */
public class PendingCommitExceptionTest {

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.exceptions.infrastructure.PendingCommitException#PendingCommitException()}.
	 */
	@Test
	public final void testPendingCommitException() {
		final PendingCommitException exception = new PendingCommitException();
		Assert.assertNotNull(exception);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.exceptions.infrastructure.PendingCommitException#PendingCommitException(java.lang.String)}
	 * .
	 */
	@Test
	public final void testPendingCommitExceptionString() {
		final PendingCommitException exception = new PendingCommitException("ErrorMessage");
		Assert.assertNotNull(exception);
		Assert.assertEquals("ErrorMessage", exception.getMessage());
	}

}
