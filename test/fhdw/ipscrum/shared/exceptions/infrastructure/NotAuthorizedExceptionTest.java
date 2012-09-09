/**
 * 
 */
package fhdw.ipscrum.shared.exceptions.infrastructure;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 */
public class NotAuthorizedExceptionTest {

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException#NotAuthorizedException(java.lang.String)}
	 * .
	 */
	@Test
	public final void testNotAuthorizedExceptionString() {
		final NotAuthorizedException exception = new NotAuthorizedException();
		Assert.assertNotNull(exception);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException#NotAuthorizedException()}.
	 */
	@Test
	public final void testNotAuthorizedException() {
		final NotAuthorizedException exception = new NotAuthorizedException("ErrorMessage");
		Assert.assertNotNull(exception);
		Assert.assertEquals("ErrorMessage", exception.getMessage());
	}

}
