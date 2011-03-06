package fhdw.ipscrum.phase3.gruppe3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
 * The class <code>ConcreteSystemTest</code> contains tests for the class
 * <code>{@link ConcreteSystem}</code>.
 * 
 * @author wolf
 */
public class ConcreteSystemTest {
	/**
	 * Run the ConcreteSystem(String,IHasChildren) constructor test. Testing
	 * NoName!
	 * 
	 * @throws Exception
	 */
	@Test(expected = NoValidValueException.class)
	public void testConcreteSystem_1() throws Exception {
		final String name = "";
		final IHasChildren parent = new Rootsystem();

		new ConcreteSystem(name, parent);
	}

	/**
	 * Run the ConcreteSystem(String,IHasChildren) constructor test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testConcreteSystem_2() throws Exception {
		final String name = "MySystem";
		final IHasChildren parent = new Rootsystem();

		final ConcreteSystem result = new ConcreteSystem(name, parent);

		assertTrue(parent.getChilds().contains(result));
		assertEquals(parent, result.getParent());
	}

	/**
	 * Run the ConcreteSystem(String,IHasChildren) constructor test.
	 * 
	 * @throws Exception
	 */
	@Test(expected = DoubleDefinitionException.class)
	public void testConcreteSystem_3() throws Exception {
		final String name = "MySystem";
		final IHasChildren parent = new Rootsystem();

		new ConcreteSystem(name, parent);
		new ConcreteSystem(name, parent);
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
		final Systemgroup fixture = new Systemgroup("MySystem", root);
		final ConcreteSystem fixture2 = new ConcreteSystem("MySystem2", fixture);
		final System fixture3 = new ConcreteSystem("MySystem3", fixture);

		final boolean result = root.contains(fixture);
		final boolean result2 = root.contains(fixture2);
		final boolean result3 = root.contains(fixture3);

		assertTrue(result);
		assertTrue(result2);
		assertTrue(result3);
	}

	/**
	 * Run the List<Systemgroup> getGroups() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetGroups_1() throws Exception {
		// TODO Erst klären!!
		// final Rootsystem root = new Rootsystem();
		// final System fixture = new Systemgroup("G1", root);
		// final System fixture2 = new Systemgroup("G2", root);
		// final System fixture3 = new Systemgroup("G3", root);
		// final System fixture4 = new Systemgroup("G4", root);
		//
		// final List<Systemgroup> result = root.getGroups();
		//
		// // add additional test code here
		// // An unexpected exception was thrown in user code while executing
		// this
		// // test:
		// // java.lang.NullPointerException
		// // at fhdw.ipscrum.shared.model.System.setParent(System.java:55)
		// // at fhdw.ipscrum.shared.model.System.<init>(System.java:20)
		// // at
		// //
		// fhdw.ipscrum.shared.model.ConcreteSystem.<init>(ConcreteSystem.java:16)
		// assertNotNull(result);
		fail();
	}

	/**
	 * Run the String toString() method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testToString_1() throws Exception {
		final ConcreteSystem fixture = new ConcreteSystem("MySystem",
				new Rootsystem());

		final String result = fixture.toString();

		assertEquals("MySystem", result);
	}

	/**
	 * Run the void accept(ISystemVisitor) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAccept_1() throws Exception {
		// TODO Erst TreeItem klären!!!
		// final ConcreteSystem fixture = new ConcreteSystem("", new
		// Rootsystem());
		// final ISystemVisitor visitor = new SystemTreeItem(new ConcreteSystem(
		// "", new Rootsystem()));
		//
		// fixture.accept(visitor);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at fhdw.ipscrum.shared.model.System.setParent(System.java:55)
		// at fhdw.ipscrum.shared.model.System.<init>(System.java:20)
		// at
		// fhdw.ipscrum.shared.model.ConcreteSystem.<init>(ConcreteSystem.java:16)
		fail();
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
	 * 
	 * @generatedBy CodePro at 05.03.11 23:32
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
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(ConcreteSystemTest.class);
	}
}