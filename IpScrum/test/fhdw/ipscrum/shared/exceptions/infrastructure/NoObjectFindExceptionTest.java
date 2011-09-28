/**
 * 
 */
package fhdw.ipscrum.shared.exceptions.infrastructure;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 */
public class NoObjectFindExceptionTest {

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException#NoObjectFindException(java.lang.String)}
	 * .
	 */
	@Test
	public final void testNoObjectFindException() {
		final NoObjectFindException exception = new NoObjectFindException("ErrorMessage");
		Assert.assertNotNull(exception);
	}

}
