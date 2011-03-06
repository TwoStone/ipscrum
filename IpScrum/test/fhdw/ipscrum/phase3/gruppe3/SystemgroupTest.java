package fhdw.ipscrum.phase3.gruppe3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.ConcreteSystem;
import fhdw.ipscrum.shared.model.Rootsystem;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.Systemgroup;
import fhdw.ipscrum.shared.model.interfaces.IHasChildren;

/**
 * The class <code>SystemgroupTest</code> contains tests for the class
 * <code>{@link Systemgroup}</code>.
 * 
 * @author wolf
 */
public class SystemgroupTest {
	/**
	 * Run the Systemgroup(String,IHasChildren) constructor test.
	 * 
	 * @throws Exception
	 * 
	 */
	@Test(expected = NoValidValueException.class)
	public void testSystemgroup_1() throws Exception {
		final String name = "";
		final IHasChildren parent = new Rootsystem();

		new Systemgroup(name, parent);
	}

	/**
	 * Run the Systemgroup(String,IHasChildren) constructor test.
	 * 
	 * @throws Exception
	 * 
	 */
	@Test(expected = DoubleDefinitionException.class)
	public void testSystemgroup_2() throws Exception {
		final String name = "G1";
		final IHasChildren parent = new Rootsystem();

		new Systemgroup(name, parent);
		new Systemgroup(name, parent);
		fail();
	}

	/**
	 * Run the void addChild(System) method test.
	 * 
	 * @throws Exception
	 */
	@Test(expected = DoubleDefinitionException.class)
	public void testAddChild_1() throws Exception {
		final Systemgroup fixture = new Systemgroup("G1", new Rootsystem());
		final System child = new ConcreteSystem("MySystem", fixture);

		fixture.addChild(child);

		assertTrue(fixture.getChilds().size() == 1);
		assertTrue(fixture.contains(child));
		assertEquals(fixture, child.getParent());
	}

	/**
	 * Run the void addChild(System) method test.
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void testAddChild_2() throws Exception {
		final Systemgroup fixture = new Systemgroup("G1", new Rootsystem());
		final System child = new ConcreteSystem("MySystem", fixture);
		final System child2 = new ConcreteSystem("MySystem2", fixture);
		final Systemgroup child3 = new Systemgroup("G2", fixture);
		final System child4 = new ConcreteSystem("MySystem3", child3);

		fixture.addChild(child4);// Bewirkt einen Wechsel

		assertEquals(4, fixture.getChilds().size());
		assertTrue(fixture.contains(child));
		assertEquals(fixture, child.getParent());

		assertTrue(fixture.contains(child2));
		assertEquals(fixture, child2.getParent());

		assertTrue(fixture.contains(child3));
		assertEquals(fixture, child3.getParent());

		// Achtung! Parent war vorher child3
		assertTrue(fixture.contains(child4));
		assertEquals(fixture, child4.getParent());
		assertFalse(child3.contains(child4));
		assertTrue(child3.getChilds().size() == 0);
	}

	/**
	 * Run the boolean contains(System) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testContains_1() throws Exception {
		final Rootsystem root = new Rootsystem();
		final Systemgroup fixture = new Systemgroup("G1", root);
		final System child = new ConcreteSystem("MySystem", fixture);

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
		final Systemgroup fixture = new Systemgroup("G1", root);
		final System child = new ConcreteSystem("MySystem", fixture);
		final System child2 = new ConcreteSystem("MySystem2", fixture);
		final System child3 = new Systemgroup("G2", fixture);
		final System child4 = new ConcreteSystem("MySystem3", fixture);

		final Vector<System> result = fixture.getChilds();
		final int count = fixture.getChilds().size();

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
		final Systemgroup fixture = new Systemgroup("G1", root);
		new ConcreteSystem("MySystem", fixture);
		new ConcreteSystem("MySystem", fixture);// DoubleDefined!!!
		new Systemgroup("G2", fixture);
		new ConcreteSystem("MySystem3", fixture);
	}

	/**
	 * Run the List<Systemgroup> getGroups() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetGroups_1() throws Exception {
		final Systemgroup fixture = new Systemgroup("G1", new Rootsystem());
		new ConcreteSystem("C1", fixture);
		new ConcreteSystem("C2", fixture);
		new ConcreteSystem("C3", fixture);

		final List<Systemgroup> result = fixture.getGroups();

		assertTrue(result.size() == 0);
	}

	/**
	 * Run the List<Systemgroup> getGroups() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetGroups_2() throws Exception {
		final Systemgroup fixture = new Systemgroup("G1", new Rootsystem());
		final Systemgroup g1 = new Systemgroup("G1", fixture);
		final Systemgroup g2 = new Systemgroup("G2", fixture);
		final ConcreteSystem c3 = new ConcreteSystem("C3", fixture);

		final List<Systemgroup> result = fixture.getGroups();

		assertTrue(result.size() == 2);
		assertTrue(result.contains(g1));
		assertTrue(result.contains(g2));
		assertFalse(result.contains(c3));
	}

	/**
	 * Run the String toString() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testToString_1() throws Exception {
		final Systemgroup fixture = new Systemgroup("G1", new Rootsystem());

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
		new org.junit.runner.JUnitCore().run(SystemgroupTest.class);
	}
}