package fhdw.ipscrum.phase3.gruppe3;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.model.Root;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.SystemManager;

/**
 * The class <code>RootTest</code> contains tests for the class
 * <code>{@link Root}</code>.
 * 
 * @version $Revision: 1.0 $
 */
public class RootTest {

	/**
	 * Run the SystemManager getSysManager() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetSysManager_1() throws Exception {
		final Root fixture = new Root();

		final SystemManager result = fixture.getSysManager();

		assertNotNull(result);
	}

	/**
	 * Run the SystemManager getSysManager() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetSysManager_2() throws Exception {
		final Root fixture = new Root();

		final SystemManager result = fixture.getSysManager();

		final fhdw.ipscrum.shared.model.System system = new System("S1", result
				.getSystems());
		final fhdw.ipscrum.shared.model.System system2 = new System("S2",
				result.getSystems());
		final fhdw.ipscrum.shared.model.System system3 = new System("S3",
				system2);

		assertTrue(result.getSystems().getSystemsRecursiv().size() == 3);
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
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
		new org.junit.runner.JUnitCore().run(RootTest.class);
	}
}