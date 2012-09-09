/**
 * 
 */
package fhdw.ipscrum.shared.exceptions.infrastructure;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 */
public class NoOpenTransactionExceptionTest {

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.exceptions.infrastructure.NoOpenTransactionException#NoOpenTransactionException()}.
	 */
	@Test
	public final void testNoOpenTransactionException() {
		final NoOpenTransactionException exception = new NoOpenTransactionException();
		Assert.assertNotNull(exception);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.exceptions.infrastructure.NoOpenTransactionException#NoOpenTransactionException(java.lang.String)}
	 * .
	 */
	@Test
	public final void testNoOpenTransactionExceptionString() {
		final NoOpenTransactionException exception = new NoOpenTransactionException("ErrorMessage");
		Assert.assertNotNull(exception);
		Assert.assertEquals("ErrorMessage", exception.getMessage());
	}

}
