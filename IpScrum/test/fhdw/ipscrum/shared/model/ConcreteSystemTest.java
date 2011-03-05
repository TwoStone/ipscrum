package fhdw.ipscrum.shared.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.model.interfaces.IHasChildren;

/**
 * The class <code>ConcreteSystemTest</code> contains tests for the class
 * <code>{@link ConcreteSystem}</code>.
 * 
 * @generatedBy CodePro at 05.03.11 10:57
 * @author wolf
 * @version $Revision: 1.0 $
 */
public class ConcreteSystemTest {
	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 05.03.11 10:57
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
	 * @generatedBy CodePro at 05.03.11 10:57
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Run the ConcreteSystem(String,IHasChildren) constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 10:57
	 */
	@Test
	public void testConcreteSystem_1() throws Exception {
		final String name = "";
		final IHasChildren parent = new Rootsystem();

		final ConcreteSystem result = new ConcreteSystem(name, parent);

		// add additional test code here
		assertNotNull(result);
		assertEquals("", result.toString());
		assertEquals("", result.getName());
		assertEquals(0, result.countObservers());
	}

	/**
	 * Run the boolean contains(AbsSystem) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 10:57
	 */
	@Test
	public void testContains_1() throws Exception {
		final ConcreteSystem fixture = new ConcreteSystem("", new Rootsystem());
		final System child = new ConcreteSystem("", new Rootsystem());

		final boolean result = fixture.contains(child);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean contains(AbsSystem) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 10:57
	 */
	@Test
	public void testContains_2() throws Exception {
		final ConcreteSystem fixture = new ConcreteSystem("", new Rootsystem());
		final System child = new ConcreteSystem("", new Rootsystem());

		final boolean result = fixture.contains(child);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the String toString() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 10:57
	 */
	@Test
	public void testToString_1() throws Exception {
		final ConcreteSystem fixture = new ConcreteSystem("", new Rootsystem());

		final String result = fixture.toString();

		// add additional test code here
		assertEquals("", result);
	}
}