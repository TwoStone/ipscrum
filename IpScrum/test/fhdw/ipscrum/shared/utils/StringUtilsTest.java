package fhdw.ipscrum.shared.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is to test the util-operations.
 */
public class StringUtilsTest {

	/**
	 * Tests the string utils.
	 */
	@Test
	public void testFormat() {
		final String result = StringUtils.format("Neues Projekt '%s' erstellt.", "X");
		Assert.assertEquals("Neues Projekt 'X' erstellt.", result);
	}

	/**
	 * tests the string utils.
	 */
	@Test
	public void testFormat2() {
		final String result =
				StringUtils.format("Neues Projekt '%s' mit %s erstellt.", "X",
						"mäßigem Erfolg");
		Assert.assertEquals("Neues Projekt 'X' mit mäßigem Erfolg erstellt.", result);
	}
}
