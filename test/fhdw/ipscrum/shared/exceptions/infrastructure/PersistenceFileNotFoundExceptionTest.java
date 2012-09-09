/**
 * 
 */
package fhdw.ipscrum.shared.exceptions.infrastructure;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 */
public class PersistenceFileNotFoundExceptionTest {

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.exceptions.infrastructure.PersistenceFileNotFoundException#PersistenceFileNotFoundException(java.lang.String)}
	 * .
	 */
	@Test
	public final void testPersistenceFileNotFoundException() {
		final PersistenceFileNotFoundException exception = new PersistenceFileNotFoundException("ErrorMessage");
		Assert.assertNotNull(exception);
		Assert.assertEquals("ErrorMessage", exception.getMessage());
	}

}
