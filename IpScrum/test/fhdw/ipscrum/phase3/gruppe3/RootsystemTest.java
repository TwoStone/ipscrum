package fhdw.ipscrum.phase3.gruppe3;

import java.util.List;
import fhdw.ipscrum.shared.model.Rootsystem;
import fhdw.ipscrum.shared.bdas.OneToMany;
import fhdw.ipscrum.shared.model.interfaces.IHasChildren;
import fhdw.ipscrum.shared.bdas.ManyToOne;
import java.util.Vector;
import org.junit.*;
import fhdw.ipscrum.shared.model.ConcreteSystem;
import fhdw.ipscrum.shared.model.visitor.HasChildVisitor;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.Systemgroup;
import static org.junit.Assert.*;

/**
 * The class <code>RootsystemTest</code> contains tests for the class <code>{@link Rootsystem}</code>.
 *
 * @generatedBy CodePro at 05.03.11 23:32
 * @author wolf
 * @version $Revision: 1.0 $
 */
public class RootsystemTest {
	/**
	 * Run the Rootsystem() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testRootsystem_1()
		throws Exception {

		Rootsystem result = new Rootsystem();

		// add additional test code here
		assertNotNull(result);
		assertEquals("Systemübersicht", result.toString());
		assertEquals("Systemübersicht", result.getName());
		assertEquals(-1505336617, result.indirectHashCode());
		assertEquals(0, result.countObservers());
	}

	/**
	 * Run the void accept(HasChildVisitor) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testAccept_1()
		throws Exception {
		Rootsystem fixture = new Rootsystem();
		HasChildVisitor visitor = null;

		fixture.accept(visitor);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.Rootsystem.accept(Rootsystem.java:163)
	}

	/**
	 * Run the void addChild(System) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testAddChild_1()
		throws Exception {
		Rootsystem fixture = new Rootsystem();
		System child = new ConcreteSystem("", new Rootsystem());

		fixture.addChild(child);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.System.setParent(System.java:55)
		//       at fhdw.ipscrum.shared.model.System.<init>(System.java:20)
		//       at fhdw.ipscrum.shared.model.ConcreteSystem.<init>(ConcreteSystem.java:16)
	}

	/**
	 * Run the void addChild(System) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testAddChild_2()
		throws Exception {
		Rootsystem fixture = new Rootsystem();
		System child = new ConcreteSystem("", new Rootsystem());

		fixture.addChild(child);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.System.setParent(System.java:55)
		//       at fhdw.ipscrum.shared.model.System.<init>(System.java:20)
		//       at fhdw.ipscrum.shared.model.ConcreteSystem.<init>(ConcreteSystem.java:16)
	}

	/**
	 * Run the boolean contains(System) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testContains_1()
		throws Exception {
		Rootsystem fixture = new Rootsystem();
		System child = new ConcreteSystem("", new Rootsystem());

		boolean result = fixture.contains(child);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.System.setParent(System.java:55)
		//       at fhdw.ipscrum.shared.model.System.<init>(System.java:20)
		//       at fhdw.ipscrum.shared.model.ConcreteSystem.<init>(ConcreteSystem.java:16)
		assertTrue(result);
	}

	/**
	 * Run the boolean contains(System) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testContains_2()
		throws Exception {
		Rootsystem fixture = new Rootsystem();
		System child = new ConcreteSystem("", new Rootsystem());

		boolean result = fixture.contains(child);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.System.setParent(System.java:55)
		//       at fhdw.ipscrum.shared.model.System.<init>(System.java:20)
		//       at fhdw.ipscrum.shared.model.ConcreteSystem.<init>(ConcreteSystem.java:16)
		assertTrue(result);
	}

	/**
	 * Run the boolean contains(System) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testContains_3()
		throws Exception {
		Rootsystem fixture = new Rootsystem();
		System child = new ConcreteSystem("", new Rootsystem());

		boolean result = fixture.contains(child);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.System.setParent(System.java:55)
		//       at fhdw.ipscrum.shared.model.System.<init>(System.java:20)
		//       at fhdw.ipscrum.shared.model.ConcreteSystem.<init>(ConcreteSystem.java:16)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		Rootsystem fixture = new Rootsystem();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		Rootsystem fixture = new Rootsystem();
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the Vector<System> getChilds() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testGetChilds_1()
		throws Exception {
		Rootsystem fixture = new Rootsystem();

		Vector<System> result = fixture.getChilds();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Vector<System> getChilds() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testGetChilds_2()
		throws Exception {
		Rootsystem fixture = new Rootsystem();

		Vector<System> result = fixture.getChilds();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the List<Systemgroup> getGroups() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testGetGroups_1()
		throws Exception {
		Rootsystem fixture = new Rootsystem();

		List<Systemgroup> result = fixture.getGroups();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the List<Systemgroup> getGroups() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testGetGroups_2()
		throws Exception {
		Rootsystem fixture = new Rootsystem();

		List<Systemgroup> result = fixture.getGroups();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testGetName_1()
		throws Exception {
		Rootsystem fixture = new Rootsystem();

		String result = fixture.getName();

		// add additional test code here
		assertEquals("Systemübersicht", result);
	}

	/**
	 * Run the OneToMany<ManyToOne, IHasChildren> getToSystemAssoc() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testGetToSystemAssoc_1()
		throws Exception {
		Rootsystem fixture = new Rootsystem();

		OneToMany<ManyToOne, IHasChildren> result = fixture.getToSystemAssoc();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		Rootsystem fixture = new Rootsystem();

		int result = fixture.hashCode();

		// add additional test code here
		assertEquals(-1505336617, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testIndirectEquals_1()
		throws Exception {
		Rootsystem fixture = new Rootsystem();
		Object obj = new Rootsystem();

		boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testIndirectEquals_2()
		throws Exception {
		Rootsystem fixture = new Rootsystem();
		Object obj = new Object();

		boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testIndirectEquals_3()
		throws Exception {
		Rootsystem fixture = new Rootsystem();
		Object obj = new Object();

		boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testIndirectEquals_4()
		throws Exception {
		Rootsystem fixture = new Rootsystem();
		Object obj = new Rootsystem();

		boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testIndirectEquals_5()
		throws Exception {
		Rootsystem fixture = new Rootsystem();
		Object obj = new Rootsystem();

		boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testIndirectEquals_6()
		throws Exception {
		Rootsystem fixture = new Rootsystem();
		Object obj = new Rootsystem();

		boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the int indirectHashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testIndirectHashCode_1()
		throws Exception {
		Rootsystem fixture = new Rootsystem();

		int result = fixture.indirectHashCode();

		// add additional test code here
		assertEquals(-1505336617, result);
	}

	/**
	 * Run the int indirectHashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testIndirectHashCode_2()
		throws Exception {
		Rootsystem fixture = new Rootsystem();

		int result = fixture.indirectHashCode();

		// add additional test code here
		assertEquals(-1505336617, result);
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testToString_1()
		throws Exception {
		Rootsystem fixture = new Rootsystem();

		String result = fixture.toString();

		// add additional test code here
		assertEquals("Systemübersicht", result);
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
		new org.junit.runner.JUnitCore().run(RootsystemTest.class);
	}
}