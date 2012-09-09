/**
 * 
 */
package fhdw.ipscrum.shared.exceptions.infrastructure;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 */
public class ModelLockedExceptionTest {

	/**
	 * Test method for {@link fhdw.ipscrum.shared.exceptions.infrastructure.ModelLockedException#ModelLockedException()}
	 * .
	 */
	@Test
	public final void testModelLockedException() {
		final ModelLockedException exception = new ModelLockedException();
		Assert.assertNotNull(exception);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.exceptions.infrastructure.ModelLockedException#ModelLockedException(java.lang.String)}
	 * .
	 */
	@Test
	public final void testModelLockedExceptionString() {
		final ModelLockedException exception = new ModelLockedException("ErrorMessage");
		Assert.assertNotNull(exception);
		Assert.assertEquals("ErrorMessage", exception.getMessage());
	}

}
