package fhdw.ipscrum.shared.model.nonMeta;

import java.util.Date;
import java.util.Vector;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.visitor.ISystemVisitor;

/**
 * The class <code>RootsystemTest</code> contains tests for the class <code>{@link Rootsystem}</code>.
 * 
 * @author wolf
 * @version $Revision: 1.0 $
 */
public class RootsystemTest {

	/**
	 * Run the Rootsystem() constructor test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */

	@Test
	public void testRootsystem1() throws Exception {
		final Model model = new Model(new Date());
		model.setUuidManager(new IDGenerator());
		final Rootsystem result = new Rootsystem(model);

		Assert.assertNotNull(result);
		Assert.assertEquals("", result.toString());
		Assert.assertEquals("", result.getName());
		Assert.assertEquals(0, result.countObservers());
	}

	/**
	 * Run the void accept(HasChildVisitor) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAccept1() throws Exception {
		final Model model = new Model(new Date());
		model.setUuidManager(new IDGenerator());
		final Rootsystem fixture = new Rootsystem(model);
		final ISystemVisitor visitor = new ISystemVisitor() {

			@Override
			public void handleSystem(final System system) {
				Assert.fail();
			}

			@Override
			public void handleRoot(final Rootsystem rootsystem) {
				Assert.assertEquals(fixture, rootsystem);
			}
		};

		fixture.accept(visitor);
	}

	/**
	 * Run the boolean contains(System) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testContains1() throws Exception {
		final Model model = new Model(new Date());
		model.setUuidManager(new IDGenerator());
		final Rootsystem fixture = new Rootsystem(model);
		final System child = new System(model, "Sys1", fixture);
		final System child2 = new System(model, "Sys2", child);
		final System child3 = new System(model, "Sys3", child);
		final System child4 = new System(model, "Sys4", child3);

		final boolean result = fixture.contains(child);
		final boolean result2 = fixture.contains(child2);
		final boolean result3 = fixture.contains(child3);
		final boolean result4 = fixture.contains(child4);

		Assert.assertTrue(result);
		Assert.assertTrue(result2);
		Assert.assertTrue(result3);
		Assert.assertTrue(result4);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testEquals1() throws Exception {
		final Model model = new Model(new Date());
		model.setUuidManager(new IDGenerator());
		final Rootsystem fixture = new Rootsystem(model);
		final Object obj = new Object();

		final boolean result = fixture.equals(obj);

		Assert.assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testEquals2() throws Exception {
		final Model model = new Model(new Date());
		model.setUuidManager(new IDGenerator());
		final Rootsystem fixture = new Rootsystem(model);
		final Rootsystem fixture2 = new Rootsystem(model);

		final boolean result = fixture.equals(fixture2);

		Assert.assertEquals(false, result);
	}

	/**
	 * Run the String getName() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetName1() throws Exception {
		final Model model = new Model(new Date());
		model.setUuidManager(new IDGenerator());
		final Rootsystem fixture = new Rootsystem(model);

		final String result = fixture.getName();

		Assert.assertEquals("", result);
	}

	/**
	 * Run the System getRoot() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetRoot1() throws Exception {
		final Model model = new Model(new Date());
		model.setUuidManager(new IDGenerator());
		final Rootsystem fixture = new Rootsystem(model);

		final AbstractSystem result = fixture.getRoot();

		Assert.assertNotNull(result);
		Assert.assertEquals(fixture, result);
	}

	/**
	 * Run the Vector<System> getSystems() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetSystems1() throws Exception {
		final Model model = new Model(new Date());
		model.setUuidManager(new IDGenerator());
		final Rootsystem fixture = new Rootsystem(model);
		final System child = new System(model, "Sys1", fixture);
		final System child2 = new System(model, "Sys2", child);
		final System child3 = new System(model, "Sys3", child);
		final System child4 = new System(model, "Sys4", child3);

		final Vector<System> result = fixture.getSystems();

		// add additional test code here
		Assert.assertNotNull(child2);
		Assert.assertNotNull(child4);
		Assert.assertNotNull(result);
		Assert.assertEquals(1, result.size());
		Assert.assertTrue(result.contains(child));
	}

	/**
	 * Run the Vector<System> getSystems() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetSystems2() throws Exception {
		final Model model = new Model(new Date());
		model.setUuidManager(new IDGenerator());
		final Rootsystem fixture = new Rootsystem(model);
		final System child = new System(model, "Sys1", fixture);
		final System child2 = new System(model, "Sys2", fixture);
		final System child3 = new System(model, "Sys3", fixture);
		final System child4 = new System(model, "Sys4", fixture);

		final Vector<System> result = fixture.getSystems();

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals(4, result.size());
		Assert.assertTrue(result.contains(child));
		Assert.assertTrue(result.contains(child2));
		Assert.assertTrue(result.contains(child3));
		Assert.assertTrue(result.contains(child4));
	}

	/**
	 * Run the Vector<System> getSystemsRecursiv() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetSystemsRecursiv1() throws Exception {
		final Model model = new Model(new Date());
		model.setUuidManager(new IDGenerator());
		final Rootsystem fixture = new Rootsystem(model);
		final System child = new System(model, "Sys1", fixture);
		final System child2 = new System(model, "Sys2", child);
		final System child3 = new System(model, "Sys3", child);
		final System child4 = new System(model, "Sys4", child3);

		final Vector<System> result = fixture.getSystemsRecursiv();

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals(4, result.size());
		Assert.assertTrue(result.contains(child));
		Assert.assertTrue(result.contains(child2));
		Assert.assertTrue(result.contains(child3));
		Assert.assertTrue(result.contains(child4));
	}

	/**
	 * Run the String toString() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test
	public void testToString1() throws Exception {
		final Model model = new Model(new Date());
		model.setUuidManager(new IDGenerator());
		final Rootsystem fixture = new Rootsystem(model);

		final String result = fixture.toString();

		Assert.assertEquals("", result);
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

}
