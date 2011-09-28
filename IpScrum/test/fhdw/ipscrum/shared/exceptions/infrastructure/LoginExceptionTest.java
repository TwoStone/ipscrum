/**
 * 
 */
package fhdw.ipscrum.shared.exceptions.infrastructure;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 */
public class LoginExceptionTest {

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.exceptions.infrastructure.LoginException#LoginException(java.lang.String)}.
	 */
	@Test
	public final void testLoginExceptionString() {
		final LoginException exception = new LoginException();
		Assert.assertNotNull(exception);
	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.exceptions.infrastructure.LoginException#LoginException()}.
	 */
	@Test
	public final void testLoginException() {
		final LoginException exception = new LoginException("ErrorMessage");
		Assert.assertNotNull(exception);
		Assert.assertEquals("ErrorMessage", exception.getMessage());
	}

}
