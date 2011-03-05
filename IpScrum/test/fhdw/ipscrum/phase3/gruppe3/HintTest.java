package fhdw.ipscrum.phase3.gruppe3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.model.Hint;

/**
 * The class <code>HintTest</code> contains tests for the class
 * <code>{@link Hint}</code>.
 * 
 * @generatedBy CodePro at 03.03.11 15:39
 * @author wolf
 * @version $Revision: 1.0 $
 */
public class HintTest {
	/**
	 * Run the Hint(String) constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testHint_1() throws Exception {
		final String content = "";

		final Hint result = new Hint(content);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.getContent());
	}

	/**
	 * Run the boolean equals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testEquals_1() throws Exception {
		final Hint fixture = new Hint("");
		final Object obj = new Hint("");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testEquals_2() throws Exception {
		final Hint fixture = new Hint("");
		final Object obj = null;

		final boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testEquals_3() throws Exception {
		final Hint fixture = new Hint("");
		final Object obj = new Object();

		final boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testEquals_4() throws Exception {
		final Hint fixture = new Hint("");
		final Object obj = new Hint("");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testEquals_5() throws Exception {
		final Hint fixture = new Hint("");
		final Object obj = new Hint("");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testEquals_6() throws Exception {
		final Hint fixture = new Hint((String) null);
		final Object obj = new Hint((String) null);

		final boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the String getContent() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testGetContent_1() throws Exception {
		final Hint fixture = new Hint("");

		final String result = fixture.getContent();

		// add additional test code here
		assertEquals("", result);
	}

	/**
	 * Run the int hashCode() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testHashCode_1() throws Exception {
		final Hint fixture = new Hint("");

		final int result = fixture.hashCode();

		// add additional test code here
		assertEquals(31, result);
	}

	/**
	 * Run the int hashCode() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testHashCode_2() throws Exception {
		final Hint fixture = new Hint((String) null);

		final int result = fixture.hashCode();

		// add additional test code here
		assertEquals(31, result);
	}

	/**
	 * Run the void setContent(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testSetContent_1() throws Exception {
		final Hint fixture = new Hint("");
		final String content = "";

		fixture.setContent(content);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Before
	public void setUp() throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}
}