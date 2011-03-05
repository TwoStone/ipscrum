package fhdw.ipscrum.phase3.gruppe3;

import org.junit.*;
import fhdw.ipscrum.shared.model.SystemManager;
import fhdw.ipscrum.shared.model.interfaces.IHasChildren;
import static org.junit.Assert.*;

/**
 * The class <code>SystemManagerTest</code> contains tests for the class <code>{@link SystemManager}</code>.
 *
 * @generatedBy CodePro at 05.03.11 23:32
 * @author wolf
 * @version $Revision: 1.0 $
 */
public class SystemManagerTest {
	/**
	 * Run the SystemManager() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testSystemManager_1()
		throws Exception {

		SystemManager result = new SystemManager();

		// add additional test code here
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
	public void testGetSystems_1()
		throws Exception {
		SystemManager fixture = new SystemManager();

		IHasChildren result = fixture.getSystems();

		// add additional test code here
		assertNotNull(result);
		assertEquals(-1505336617, result.indirectHashCode());
	}

	/**
	 * Run the IHasChildren getSystems() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testGetSystems_2()
		throws Exception {
		SystemManager fixture = new SystemManager();

		IHasChildren result = fixture.getSystems();

		// add additional test code here
		assertNotNull(result);
		assertEquals(-1505336617, result.indirectHashCode());
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(SystemManagerTest.class);
	}
}