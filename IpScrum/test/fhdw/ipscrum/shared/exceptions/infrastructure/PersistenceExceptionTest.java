/**
 * 
 */
package fhdw.ipscrum.shared.exceptions.infrastructure;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 */
public class PersistenceExceptionTest {

	/**
	 * Test method for {@link fhdw.ipscrum.shared.exceptions.infrastructure.PersistenceException#PersistenceException()}
	 * .
	 */
	@Test
	public final void testPersistenceException() {
		final PersistenceException exception = new PersistenceException();
		Assert.assertNotNull(exception);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.exceptions.infrastructure.PersistenceException#PersistenceException(java.lang.String)}
	 * .
	 */
	@Test
	public final void testPersistenceExceptionString() {
		final PersistenceException exception = new PersistenceException("ErrorMessage");
		Assert.assertNotNull(exception);
		Assert.assertEquals("ErrorMessage", exception.getMessage());
	}

}
