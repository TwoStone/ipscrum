package fhdw.ipscrum.phase3.gruppe3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.model.Rootsystem;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.interfaces.ISystem;
import fhdw.ipscrum.shared.model.visitor.HasChildVisitor;

/**
 * The class <code>RootsystemTest</code> contains tests for the class
 * <code>{@link Rootsystem}</code>.
 * 
 * @author wolf
 * @version $Revision: 1.0 $
 */
public class RootsystemTest {
	/**
	 * Run the Rootsystem() constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 07.03.11 16:56
	 */
	@Test
	public void testRootsystem_1() throws Exception {

		final Rootsystem result = new Rootsystem();

		assertNotNull(result);
		assertEquals("", result.toString());
		assertEquals("", result.getName());
		assertEquals(0, result.countObservers());
	}

	/**
	 * Run the void accept(HasChildVisitor) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAccept_1() throws Exception {
		final Rootsystem fixture = new Rootsystem();
		final HasChildVisitor visitor = new HasChildVisitor() {

			@Override
			public void handleSystem(final System system) {
				fail();
			}

			@Override
			public void handleRoot(final Rootsystem rootsystem) {
				assertEquals(fixture, rootsystem);
			}
		};

		fixture.accept(visitor);
	}

	/**
	 * Run the boolean contains(System) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 07.03.11 16:56
	 */
	@Test
	public void testContains_1() throws Exception {
		final Rootsystem fixture = new Rootsystem();
		final System child = new System("Sys1", fixture);
		final System child2 = new System("Sys2", child);
		final System child3 = new System("Sys3", child);
		final System child4 = new System("Sys4", child3);

		final boolean result = fixture.contains(child);
		final boolean result2 = fixture.contains(child2);
		final boolean result3 = fixture.contains(child3);
		final boolean result4 = fixture.contains(child4);

		assertTrue(result);
		assertTrue(result2);
		assertTrue(result3);
		assertTrue(result4);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void testEquals_1() throws Exception {
		final Rootsystem fixture = new Rootsystem();
		final Object obj = new Object();

		final boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void testEquals_2() throws Exception {
		final Rootsystem fixture = new Rootsystem();
		final Rootsystem fixture2 = new Rootsystem();

		final boolean result = fixture.equals(fixture2);

		assertEquals(true, result);
	}

	/**
	 * Run the String getName() method test.
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void testGetName_1() throws Exception {
		final Rootsystem fixture = new Rootsystem();

		final String result = fixture.getName();

		assertEquals("", result);
	}

	/**
	 * Run the ISystem getRoot() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 07.03.11 16:56
	 */
	@Test
	public void testGetRoot_1() throws Exception {
		final Rootsystem fixture = new Rootsystem();

		final ISystem result = fixture.getRoot();

		assertNotNull(result);
		assertEquals(fixture, result);
	}

	/**
	 * Run the Vector<System> getSystems() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 07.03.11 16:56
	 */
	@Test
	public void testGetSystems_1() throws Exception {
		final Rootsystem fixture = new Rootsystem();
		final System child = new System("Sys1", fixture);
		final System child2 = new System("Sys2", child);
		final System child3 = new System("Sys3", child);
		final System child4 = new System("Sys4", child3);

		final Vector<System> result = fixture.getSystems();

		// add additional test code here
		assertNotNull(result);
		assertEquals(1, result.size());
		assertTrue(result.contains(child));
	}

	/**
	 * Run the Vector<System> getSystems() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 07.03.11 16:56
	 */
	@Test
	public void testGetSystems_2() throws Exception {
		final Rootsystem fixture = new Rootsystem();
		final System child = new System("Sys1", fixture);
		final System child2 = new System("Sys2", fixture);
		final System child3 = new System("Sys3", fixture);
		final System child4 = new System("Sys4", fixture);

		final Vector<System> result = fixture.getSystems();

		// add additional test code here
		assertNotNull(result);
		assertEquals(4, result.size());
		assertTrue(result.contains(child));
		assertTrue(result.contains(child2));
		assertTrue(result.contains(child3));
		assertTrue(result.contains(child4));
	}

	/**
	 * Run the Vector<System> getSystemsRecursiv() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 07.03.11 16:56
	 */
	@Test
	public void testGetSystemsRecursiv_1() throws Exception {
		final Rootsystem fixture = new Rootsystem();
		final System child = new System("Sys1", fixture);
		final System child2 = new System("Sys2", child);
		final System child3 = new System("Sys3", child);
		final System child4 = new System("Sys4", child3);

		final Vector<System> result = fixture.getSystemsRecursiv();

		// add additional test code here
		assertNotNull(result);
		assertEquals(4, result.size());
		assertTrue(result.contains(child));
		assertTrue(result.contains(child2));
		assertTrue(result.contains(child3));
		assertTrue(result.contains(child4));
	}

	/**
	 * Run the String toString() method test.
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void testToString_1() throws Exception {
		final Rootsystem fixture = new Rootsystem();

		final String result = fixture.toString();

		assertEquals("", result);
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 07.03.11 16:56
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
	 * @generatedBy CodePro at 07.03.11 16:56
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
	 * @generatedBy CodePro at 07.03.11 16:56
	 */
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(RootsystemTest.class);
	}
}