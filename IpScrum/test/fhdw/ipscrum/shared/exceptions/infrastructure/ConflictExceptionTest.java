/**
 * 
 */
package fhdw.ipscrum.shared.exceptions.infrastructure;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 */
public class ConflictExceptionTest {

	/**
	 * Test method for {@link fhdw.ipscrum.shared.exceptions.infrastructure.ConflictException#ConflictException()}.
	 */
	@Test
	public final void testConflictException() {
		final ConflictException exception = new ConflictException();
		Assert.assertNotNull(exception);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.exceptions.infrastructure.ConflictException#ConflictException(java.lang.String)}.
	 */
	@Test
	public final void testConflictExceptionString() {
		final ConflictException exception = new ConflictException("ErrorMessage");
		Assert.assertNotNull(exception);
		Assert.assertEquals("ErrorMessage", exception.getMessage());
	}

}
