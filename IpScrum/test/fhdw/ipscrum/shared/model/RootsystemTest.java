package fhdw.ipscrum.shared.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.model.interfaces.AbsSystem;

/**
 * The class <code>RootsystemTest</code> contains tests for the class
 * <code>{@link Rootsystem}</code>.
 * 
 * @generatedBy CodePro at 05.03.11 10:57
 * @author wolf
 * @version $Revision: 1.0 $
 */
public class RootsystemTest {
	/**
	 * Run the Rootsystem() constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 10:57
	 */
	@Test
	public void testRootsystem_1() throws Exception {

		final Rootsystem result = new Rootsystem();

		// add additional test code here
		assertNotNull(result);
		assertEquals("Systemübersicht", result.toString());
		assertEquals("Systemübersicht", result.getName());
		assertEquals(0, result.countObservers());
	}

	/**
	 * Run the void addChild(AbsSystem) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 10:57
	 */
	@Test
	public void testAddChild_1() throws Exception {
		final Rootsystem fixture = new Rootsystem();
		final AbsSystem child = new ConcreteSystem("", new Rootsystem());

		fixture.addChild(child);

		// add additional test code here
	}

	/**
	 * Run the void addChild(AbsSystem) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 10:57
	 */
	@Test
	public void testAddChild_2() throws Exception {
		final Rootsystem fixture = new Rootsystem();
		final AbsSystem child = new ConcreteSystem("", new Rootsystem());

		fixture.addChild(child);

		// add additional test code here
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
		final Rootsystem fixture = new Rootsystem();
		final AbsSystem child = new ConcreteSystem("", new Rootsystem());

		final boolean result = fixture.contains(child);

		// add additional test code here
		assertEquals(false, result);
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
		final Rootsystem fixture = new Rootsystem();
		final AbsSystem child = new ConcreteSystem("", new Rootsystem());

		final boolean result = fixture.contains(child);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the HashSet<AbsSystem> getChilds() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 10:57
	 */
	@Test
	public void testGetChilds_1() throws Exception {
		final Rootsystem fixture = new Rootsystem();

		final HashSet<AbsSystem> result = fixture.getChilds();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the HashSet<AbsSystem> getChilds() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 10:57
	 */
	@Test
	public void testGetChilds_2() throws Exception {
		final Rootsystem fixture = new Rootsystem();

		final HashSet<AbsSystem> result = fixture.getChilds();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getName() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 10:57
	 */
	@Test
	public void testGetName_1() throws Exception {
		final Rootsystem fixture = new Rootsystem();

		final String result = fixture.getName();

		// add additional test code here
		assertEquals("Systemübersicht", result);
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
		final Rootsystem fixture = new Rootsystem();

		final String result = fixture.toString();

		// add additional test code here
		assertEquals("Systemübersicht", result);
	}

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
}