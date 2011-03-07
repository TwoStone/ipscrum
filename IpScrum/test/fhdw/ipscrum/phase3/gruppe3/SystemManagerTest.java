package fhdw.ipscrum.phase3.gruppe3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.model.Rootsystem;
import fhdw.ipscrum.shared.model.SystemManager;
import fhdw.ipscrum.shared.model.interfaces.ISystem;

/**
 * The class <code>SystemManagerTest</code> contains tests for the class
 * <code>{@link SystemManager}</code>.
 * 
 * @author wolf
 * @version $Revision: 1.0 $
 */
public class SystemManagerTest {
	/**
	 * Run the SystemManager() constructor test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSystemManager_1() throws Exception {

		final SystemManager result = new SystemManager();
		assertNotNull(result);
	}

	/**
	 * Run the IHasChildren getSystems() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testGetSystems_1() throws Exception {
		final SystemManager fixture = new SystemManager();

		final ISystem result = fixture.getSystems();

		assertNotNull(result);
		assertTrue(result instanceof Rootsystem);
		assertEquals("", result.getName());
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
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
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 * 
	 * @param args
	 *            the command line arguments
	 */
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(SystemManagerTest.class);
	}
}