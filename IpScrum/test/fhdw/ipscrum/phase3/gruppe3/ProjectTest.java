package fhdw.ipscrum.phase3.gruppe3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Rootsystem;
import fhdw.ipscrum.shared.model.System;

/**
 * The class <code>ProjectTest</code> contains tests for the class
 * <code>{@link Project}</code>.
 * 
 * @author wolf
 * @version $Revision: 1.0 $
 */
public class ProjectTest {

	/**
	 * Run the void addPossibleSystem(System) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddPossibleSystem_1() throws Exception {
		final Project fixture = new Project("Test");

		final Rootsystem root = new Rootsystem();
		final System system = new System("S1", root);
		final System system2 = new System("S2", root);
		final System system3 = new System("S3", system2);
		final System system4 = new System("S4", root);
		final System system5 = new System("S5", system4);
		final System system6 = new System("S6", root);

		// Alle werden doppelt hinzugefügt, dürfen aber nur 1 mal enthalten sein
		fixture.addPossibleSystem(system);
		fixture.addPossibleSystem(system);
		fixture.addPossibleSystem(system2);
		fixture.addPossibleSystem(system2);
		fixture.addPossibleSystem(system3);
		fixture.addPossibleSystem(system3);
		fixture.addPossibleSystem(system4);
		fixture.addPossibleSystem(system4);
		fixture.addPossibleSystem(system5);
		fixture.addPossibleSystem(system5);
		fixture.addPossibleSystem(system6);
		fixture.addPossibleSystem(system6);

		final List<System> result = fixture.getPossibleSystems();

		assertEquals(4, result.size());
		assertTrue(result.contains(system));
		assertTrue(result.contains(system2));
		assertFalse(result.contains(system3));
		assertTrue(result.contains(system4));
		assertFalse(result.contains(system5));
		assertTrue(result.contains(system6));
	}

	/**
	 * Run the List<System> getPossibleSystems() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetPossibleSystems_1() throws Exception {
		final Project fixture = new Project("Test");

		final Rootsystem root = new Rootsystem();
		final System system = new System("S1", root);
		final System system2 = new System("S2", root);
		final System system3 = new System("S3", system2);

		fixture.addPossibleSystem(system);
		fixture.addPossibleSystem(system2);
		fixture.addPossibleSystem(system3);

		final List<System> result = fixture.getPossibleSystems();

		assertEquals(2, result.size());
		assertTrue(result.contains(system));
		assertTrue(result.contains(system2));
		assertFalse(result.contains(system3));
	}

	/**
	 * Run the Boolean isPossibleSystem(System) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testIsPossibleSystem_1() throws Exception {
		final Project fixture = new Project("Test");

		final Rootsystem root = new Rootsystem();
		final System system = new System("S1", root);

		fixture.addPossibleSystem(system);
		assertTrue(fixture.isPossibleSystem(system));
	}

	/**
	 * Run the Boolean isPossibleSystem(System) method test. Complex!
	 * 
	 * @throws Exception
	 */
	@Test
	public void testIsPossibleSystem_2() throws Exception {
		final Project fixture = new Project("Test");
		final Project fixture2 = new Project("Test");

		final Rootsystem root = new Rootsystem();
		final System system = new System("S1", root);
		final System system2 = new System("S2", root);
		final System system3 = new System("S3", system2);

		fixture.addPossibleSystem(system);
		fixture.addPossibleSystem(system2);

		fixture2.addPossibleSystem(system3);

		assertTrue(fixture.isPossibleSystem(system));
		assertTrue(fixture.isPossibleSystem(system2));
		assertTrue(fixture.isPossibleSystem(system3));
		assertFalse(fixture2.isPossibleSystem(system2));
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 07.03.11 17:10
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
	 * @generatedBy CodePro at 07.03.11 17:10
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
	 * 
	 * @generatedBy CodePro at 07.03.11 17:10
	 */
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(ProjectTest.class);
	}
}