package fhdw.ipscrum.phase3.gruppe3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.Rootsystem;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.interfaces.ISystem;

/**
 * The class <code>SystemgroupTest</code> contains tests for the class
 * <code>{@link Systemgroup}</code>.
 * 
 * @author wolf
 */
public class SystemTest {
	/**
	 * Run the Systemgroup(String,IHasChildren) constructor test.
	 * 
	 * @throws Exception
	 * 
	 */
	@Test(expected = NoValidValueException.class)
	public void testSystem_1() throws Exception {
		final String name = "";
		final ISystem parent = new Rootsystem();

		new System(name, parent);
	}

	/**
	 * Run the Systemgroup(String,IHasChildren) constructor test.
	 * 
	 * @throws Exception
	 * 
	 */
	@Test(expected = DoubleDefinitionException.class)
	public void testSystem_2() throws Exception {
		final String name = "G1";
		final ISystem parent = new Rootsystem();

		new System(name, parent);
		new System(name, parent);
		fail();
	}

	/**
	 * Run the boolean contains(System) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testContains_1() throws Exception {
		final Rootsystem root = new Rootsystem();
		final System fixture = new System("G1", root);
		final System child = new System("MySystem", fixture);

		final boolean result = root.contains(child);
		final boolean result2 = fixture.contains(child);

		assertTrue(result);
		assertTrue(result2);
	}

	/**
	 * Run the Vector<System> getChilds() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetChilds_1() throws Exception {
		final Rootsystem root = new Rootsystem();
		final System fixture = new System("G1", root);
		final System child = new System("MySystem", fixture);
		final System child2 = new System("MySystem2", fixture);
		final System child3 = new System("G2", fixture);
		final System child4 = new System("MySystem3", fixture);

		final Vector<System> result = fixture.getSystems();
		final int count = fixture.getSystems().size();

		assertEquals(4, count);
		assertTrue(result.contains(child));
		assertTrue(result.contains(child2));
		assertTrue(result.contains(child3));
		assertTrue(result.contains(child4));
	}

	/**
	 * Run the Vector<System> getChilds() method test.
	 * 
	 * @throws Exception
	 */
	@Test(expected = DoubleDefinitionException.class)
	public void testGetChilds_2() throws Exception {
		final Rootsystem root = new Rootsystem();
		final System fixture = new System("G1", root);
		new System("MySystem", fixture);
		new System("MySystem", fixture);// DoubleDefined!!!
		new System("G2", fixture);
		new System("MySystem3", fixture);
	}

	/**
	 * Run the Vector<System> getSystemsRecursiv() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetSystemsRecursiv_1() throws Exception {
		final Rootsystem root = new Rootsystem();
		final System fixture = new System("G1", root);
		final System fixture1 = new System("MySystem", fixture);
		final System fixture2 = new System("MySystem2", fixture);
		final System fixture3 = new System("G2", fixture2);
		final System fixture4 = new System("MySystem3", fixture2);

		final Vector<System> result = root.getSystemsRecursiv();

		assertTrue(result.contains(fixture));
		assertTrue(result.contains(fixture1));
		assertTrue(result.contains(fixture2));
		assertTrue(result.contains(fixture3));
		assertTrue(result.contains(fixture4));
	}

	/**
	 * Run the Vector<System> getParent() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetParent_1() throws Exception {
		final Rootsystem root = new Rootsystem();
		final System fixture = new System("G1", root);
		final System fixture1 = new System("MySystem", fixture);
		final System fixture2 = new System("MySystem2", fixture);
		final System fixture3 = new System("G2", fixture2);
		final System fixture4 = new System("MySystem3", fixture2);

		assertEquals(root, fixture.getParent());
		assertEquals(fixture, fixture1.getParent());
		assertEquals(fixture, fixture2.getParent());
		assertEquals(fixture2, fixture3.getParent());
		assertEquals(fixture2, fixture4.getParent());
	}

	/**
	 * Run the Vector<System> getSystemsRecursiv() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetSystemsRecursiv_2() throws Exception {
		final Rootsystem root = new Rootsystem();
		final System fixture = new System("G1", root);
		final System fixture1 = new System("MySystem", fixture);
		final System fixture2 = new System("MySystem2", fixture);
		final System fixture3 = new System("G2", fixture2);
		final System fixture4 = new System("MySystem3", fixture2);
		final System fixture5 = new System("MySystem3", fixture4);
		final System fixture6 = new System("MySystem3", fixture5);
		final System fixture7 = new System("MySystem3", fixture6);

		final Vector<System> result = root.getSystemsRecursiv();
		final Vector<System> result2 = fixture5.getSystemsRecursiv();

		assertTrue(result.contains(fixture));
		assertTrue(result.contains(fixture1));
		assertTrue(result.contains(fixture2));
		assertTrue(result.contains(fixture3));
		assertTrue(result.contains(fixture4));
		assertTrue(result.contains(fixture5));
		assertTrue(result.contains(fixture6));
		assertTrue(result.contains(fixture7));

		assertTrue(result2.contains(fixture6));
		assertTrue(result2.contains(fixture7));
	}

	/**
	 * Run the Vector<System> getRoot() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetRoot_1() throws Exception {
		final Rootsystem root = new Rootsystem();
		final System fixture = new System("G1", root);
		final System fixture1 = new System("MySystem", fixture);
		final System fixture2 = new System("MySystem2", fixture);
		final System fixture3 = new System("G2", fixture2);
		final System fixture4 = new System("MySystem3", fixture2);
		final System fixture5 = new System("MySystem3", fixture4);
		final System fixture6 = new System("MySystem3", fixture5);
		final System fixture7 = new System("MySystem3", fixture6);

		assertEquals(root, fixture.getRoot());
		assertEquals(root, fixture1.getRoot());
		assertEquals(root, fixture2.getRoot());
		assertEquals(root, fixture3.getRoot());
		assertEquals(root, fixture4.getRoot());
		assertEquals(root, fixture5.getRoot());
		assertEquals(root, fixture6.getRoot());
		assertEquals(root, fixture7.getRoot());
	}

	/**
	 * Run the Vector<System> getRoot() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetSystems_1() throws Exception {
		final Rootsystem root = new Rootsystem();
		final System fixture = new System("G1", root);
		final System fixture1 = new System("MySystem", fixture);
		final System fixture2 = new System("MySystem2", fixture);
		final System fixture3 = new System("G2", fixture2);
		final System fixture4 = new System("MySystem3", fixture2);
		final System fixture5 = new System("MySystem3", fixture4);
		final System fixture6 = new System("MySystem3", fixture5);
		final System fixture7 = new System("MySystem3", fixture6);

		final Vector<System> result = root.getSystems();
		final Vector<System> result2 = fixture2.getSystems();
		final Vector<System> result3 = fixture5.getSystems();
		final Vector<System> result4 = fixture6.getSystems();

		assertTrue(result.size() == 1);
		assertTrue(result2.size() == 2);
		assertTrue(result3.size() == 1);
		assertTrue(result4.size() == 1);

		assertEquals(fixture, result.get(0));
		assertEquals(fixture3, result2.get(0));
		assertEquals(fixture4, result2.get(1));
		assertEquals(fixture6, result3.get(0));
		assertEquals(fixture7, result4.get(0));
	}

	/**
	 * Run the String toString() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testToString_1() throws Exception {
		final System fixture = new System("G1", new Rootsystem());

		final String result = fixture.toString();

		assertEquals("G1", result);
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 05.03.11 23:32
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
		new org.junit.runner.JUnitCore().run(SystemTest.class);
	}
}