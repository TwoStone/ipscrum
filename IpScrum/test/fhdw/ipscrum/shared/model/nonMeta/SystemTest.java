package fhdw.ipscrum.shared.model.nonMeta;

import java.util.Date;
import java.util.Vector;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.model.Model;

/**
 * The class <code>SystemgroupTest</code> contains tests for the class <code>{@link Systemgroup}</code>.
 * 
 * @author wolf
 */
public class SystemTest {

	/**
	 * represents the model needed to use the IPScrum.
	 */
	private Model model;

	/**
	 * Run the Systemgroup(String,HasChildren) constructor test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test(expected = NoValidValueException.class)
	public void testSystem1() throws Exception {

		final String name = "";
		final Rootsystem parent = new Rootsystem(this.model);

		new System(this.model, name, parent);
	}

	/**
	 * Run the Systemgroup(String,HasChildren) constructor test. With a double definition to check if the exception is
	 * thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 * 
	 */
	@Test(expected = DoubleDefinitionException.class)
	public void testSystem2() throws Exception {

		final String name = "G1";
		final Rootsystem parent = new Rootsystem(this.model);

		new System(this.model, name, parent);
		new System(this.model, name, parent);
		Assert.fail();
	}

	/**
	 * Run the boolean contains(System) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testContains1() throws Exception {
		final Rootsystem root = new Rootsystem(this.model);
		final System fixture = new System(this.model, "G1", root);
		final System child = new System(this.model, "MySystem", fixture);

		final boolean result = root.contains(child);
		final boolean result2 = fixture.contains(child);

		Assert.assertTrue(result);
		Assert.assertTrue(result2);
	}

	/**
	 * Run the Vector<System> getChilds() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetChilds1() throws Exception {
		final Rootsystem root = new Rootsystem(this.model);
		final System fixture = new System(this.model, "G1", root);
		final System child = new System(this.model, "MySystem", fixture);
		final System child2 = new System(this.model, "MySystem2", fixture);
		final System child3 = new System(this.model, "G2", fixture);
		final System child4 = new System(this.model, "MySystem3", fixture);

		final Vector<System> result = fixture.getSystems();
		final int count = fixture.getSystems().size();

		Assert.assertEquals(4, count);
		Assert.assertTrue(result.contains(child));
		Assert.assertTrue(result.contains(child2));
		Assert.assertTrue(result.contains(child3));
		Assert.assertTrue(result.contains(child4));
	}

	/**
	 * Run the Vector<System> getChilds() method test. with a double definition to check if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = DoubleDefinitionException.class)
	public void testGetChilds2() throws Exception {
		final Rootsystem root = new Rootsystem(this.model);
		final System fixture = new System(this.model, "G1", root);
		new System(this.model, "MySystem", fixture);
		new System(this.model, "MySystem", fixture); // DoubleDefined!!!
		new System(this.model, "G2", fixture);
		new System(this.model, "MySystem3", fixture);
	}

	/**
	 * Run the Vector<System> getSystemsRecursiv() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetSystemsRecursiv1() throws Exception {
		final Rootsystem root = new Rootsystem(this.model);
		final System fixture = new System(this.model, "G1", root);
		final System fixture1 = new System(this.model, "MySystem", fixture);
		final System fixture2 = new System(this.model, "MySystem2", fixture);
		final System fixture3 = new System(this.model, "G2", fixture2);
		final System fixture4 = new System(this.model, "MySystem3", fixture2);

		final Vector<System> result = root.getSystemsRecursiv();

		Assert.assertTrue(result.contains(fixture));
		Assert.assertTrue(result.contains(fixture1));
		Assert.assertTrue(result.contains(fixture2));
		Assert.assertTrue(result.contains(fixture3));
		Assert.assertTrue(result.contains(fixture4));
	}

	/**
	 * Run the Vector<System> getParent() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetParent1() throws Exception {
		final Rootsystem root = new Rootsystem(this.model);
		final System fixture = new System(this.model, "G1", root);
		final System fixture1 = new System(this.model, "MySystem", fixture);
		final System fixture2 = new System(this.model, "MySystem2", fixture);
		final System fixture3 = new System(this.model, "G2", fixture2);
		final System fixture4 = new System(this.model, "MySystem3", fixture2);

		Assert.assertEquals(root, fixture.getParent());
		Assert.assertEquals(fixture, fixture1.getParent());
		Assert.assertEquals(fixture, fixture2.getParent());
		Assert.assertEquals(fixture2, fixture3.getParent());
		Assert.assertEquals(fixture2, fixture4.getParent());
	}

	/**
	 * Run the Vector<System> getSystemsRecursiv() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetSystemsRecursiv2() throws Exception {
		final Rootsystem root = new Rootsystem(this.model);
		final System fixture = new System(this.model, "G1", root);
		final System fixture1 = new System(this.model, "MySystem", fixture);
		final System fixture2 = new System(this.model, "MySystem2", fixture);
		final System fixture3 = new System(this.model, "G2", fixture2);
		final System fixture4 = new System(this.model, "MySystem3", fixture2);
		final System fixture5 = new System(this.model, "MySystem4", fixture4);
		final System fixture6 = new System(this.model, "MySystem5", fixture5);
		final System fixture7 = new System(this.model, "MySystem6", fixture6);

		final Vector<System> result = root.getSystemsRecursiv();
		final Vector<System> result2 = fixture5.getSystemsRecursiv();

		Assert.assertTrue(result.contains(fixture));
		Assert.assertTrue(result.contains(fixture1));
		Assert.assertTrue(result.contains(fixture2));
		Assert.assertTrue(result.contains(fixture3));
		Assert.assertTrue(result.contains(fixture4));
		Assert.assertTrue(result.contains(fixture5));
		Assert.assertTrue(result.contains(fixture6));
		Assert.assertTrue(result.contains(fixture7));

		Assert.assertTrue(result2.contains(fixture6));
		Assert.assertTrue(result2.contains(fixture7));
	}

	/**
	 * Run the Vector<System> getRoot() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetRoot1() throws Exception {
		final Rootsystem root = new Rootsystem(this.model);
		final System fixture = new System(this.model, "G1", root);
		final System fixture1 = new System(this.model, "MySystem", fixture);
		final System fixture2 = new System(this.model, "MySystem2", fixture);
		final System fixture3 = new System(this.model, "G2", fixture2);
		final System fixture4 = new System(this.model, "MySystem3", fixture2);
		final System fixture5 = new System(this.model, "MySystem4", fixture4);
		final System fixture6 = new System(this.model, "MySystem5", fixture5);
		final System fixture7 = new System(this.model, "MySystem6", fixture6);

		Assert.assertEquals(root, fixture.getRoot());
		Assert.assertEquals(root, fixture1.getRoot());
		Assert.assertEquals(root, fixture2.getRoot());
		Assert.assertEquals(root, fixture3.getRoot());
		Assert.assertEquals(root, fixture4.getRoot());
		Assert.assertEquals(root, fixture5.getRoot());
		Assert.assertEquals(root, fixture6.getRoot());
		Assert.assertEquals(root, fixture7.getRoot());
	}

	/**
	 * Run the Vector<System> getRoot() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetSystems1() throws Exception {
		final Rootsystem root = new Rootsystem(this.model);
		final System fixture = new System(this.model, "G1", root);
		final System fixture2 = new System(this.model, "MySystem2", fixture);
		final System fixture3 = new System(this.model, "G2", fixture2);
		final System fixture4 = new System(this.model, "MySystem3", fixture2);
		final System fixture5 = new System(this.model, "MySystem4", fixture4);
		final System fixture6 = new System(this.model, "MySystem5", fixture5);
		final System fixture7 = new System(this.model, "MySystem6", fixture6);

		final Vector<System> result = root.getSystems();
		final Vector<System> result2 = fixture2.getSystems();
		final Vector<System> result3 = fixture5.getSystems();
		final Vector<System> result4 = fixture6.getSystems();

		Assert.assertTrue(root == fixture.getRoot());
		Assert.assertTrue(result.size() == 1);
		Assert.assertTrue(result2.size() == 2);
		Assert.assertTrue(result3.size() == 1);
		Assert.assertTrue(result4.size() == 1);

		Assert.assertEquals(fixture, result.get(0));
		java.lang.System.out.println(result2);
		Assert.assertTrue(result2.contains(fixture3));
		Assert.assertTrue(result2.contains(fixture4));
		Assert.assertTrue(result3.contains(fixture6));
		Assert.assertTrue(result4.contains(fixture7));
	}

	/**
	 * Run the String toString() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testToString1() throws Exception {
		final System fixture = new System(this.model, "G1", new Rootsystem(this.model));

		final String result = fixture.toString();

		Assert.assertEquals("G1", result);
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
		this.model = new Model(new Date());
		this.model.setUuidManager(new IDGenerator());
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
	 * Getting the state of a PBI.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetName1() throws Exception {
		final Rootsystem root = new Rootsystem(this.model);
		final System fixture = new System(this.model, "G1", root);
		fixture.setName("Neuer Name");
	}

	/**
	 * Getting the state of a PBI.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = NoValidValueException.class)
	public void testSetName2() throws Exception {
		final Rootsystem root = new Rootsystem(this.model);
		final System fixture = new System(this.model, "G1", root);
		fixture.setName(null);
	}

	/**
	 * Getting the state of a PBI.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = NoValidValueException.class)
	public void testSetName3() throws Exception {
		final Rootsystem root = new Rootsystem(this.model);
		final System fixture = new System(this.model, "G1", root);
		fixture.setName("");
	}

	/**
	 * Getting the state of a PBI.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testToDisplayWithParent1() throws Exception {
		final Rootsystem root = new Rootsystem(this.model);
		final System fixture = new System(this.model, "G1", root);
		Assert.assertEquals(fixture.toDisplayWithParent(), fixture.getName());
	}

	/**
	 * Getting the state of a PBI.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testToDisplayWithParent2() throws Exception {
		final Rootsystem root = new Rootsystem(this.model);
		final System sys1 = new System(this.model, "G1", root);
		final System fixture = new System(this.model, "G2", sys1);
		Assert.assertEquals(fixture.toDisplayWithParent(), fixture.getParent().getName() + ">" + fixture.getName());
	}

	/**
	 * Getting the state of a PBI.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testToDisplayWithParent3() throws Exception {
		final Rootsystem root = new Rootsystem(this.model);
		final System sys1 = new System(this.model, "G1", root);
		final System sys2 = new System(this.model, "G2", sys1);
		final System fixture = new System(this.model, "G3", sys2);
		Assert.assertEquals(fixture.toDisplayWithParent(), fixture.getParent().getName() + ">" + fixture.getName());
	}

}
