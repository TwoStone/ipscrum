/**
 * 
 */
package fhdw.ipscrum.shared.exceptions.infrastructure;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 */
public class BuildModelExceptionTest {

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.exceptions.infrastructure.BuildModelException#BuildModelException(java.lang.String)}.
	 */
	@Test
	public final void testBuildModelException() {
		final BuildModelException exception = new BuildModelException("ErrorMessage");
		Assert.assertNotNull(exception);
		Assert.assertEquals("ErrorMessage", exception.getMessage());
	}

}
