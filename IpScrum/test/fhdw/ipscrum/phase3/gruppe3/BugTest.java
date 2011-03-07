package fhdw.ipscrum.phase3.gruppe3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.WrongReleaseException;
import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.Rootsystem;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.interfaces.IBugState;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.visitor.IProductBacklogItemVisitor;

/**
 * The class <code>BugTest</code> contains tests for the class
 * <code>{@link Bug}</code>.
 * 
 */
public class BugTest {
	/**
	 * Run the Bug(String,String,IRelease,ProductBacklog) constructor test.
	 * 
	 * @throws Exception
	 */
	@Test(expected = NoValidValueException.class)
	public void testBug_1() throws Exception {
		final String name = "";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		new Bug(name, description, version, backlog);
	}

	/**
	 * Run the Bug(String,String,IRelease,ProductBacklog) constructor test.
	 * 
	 * @throws Exception
	 */
	@Test(expected = WrongReleaseException.class)
	public void testBug_2() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = null;
		final ProductBacklog backlog = pro.getBacklog();

		new Bug(name, description, version, backlog);
	}

	/**
	 * Run the Bug(String,String,IRelease,ProductBacklog) constructor test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testBug_3() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		assertEquals("Bug", bug.getName());
		assertEquals("", bug.getDescription());
		assertEquals(backlog, bug.getBacklog());
		assertEquals(pro, bug.getBacklog().getProject());
		assertEquals(version, bug.getRelease());
	}

	/**
	 * Run the void accept(IProductBacklogItemVisitor) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAccept_1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug expected = new Bug(name, description, version, backlog);

		final IProductBacklogItemVisitor visitor = new IProductBacklogItemVisitor() {

			@Override
			public void handleFeature(final Feature feature) {
				fail();
			}

			@Override
			public void handleBug(final Bug bug) {
				assertEquals(expected, bug);
			}
		};

		expected.accept(visitor);
	}

	/**
	 * Run the void addSystem(System) method test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddSystem_1() throws Exception {
		final String name = "Bug";
		final String description = "";
		final Project pro = new Project("Pro2");
		final IRelease version = new Release("R1", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		final Bug bug = new Bug(name, description, version, backlog);

		final Rootsystem root = new Rootsystem();
		final System sys1 = new System("S1", root);
		final System sys2 = new System("S2", root);

		pro.addPossibleSystem(sys1);
		pro.addPossibleSystem(sys2);

		bug.addSystem(sys1);
		bug.addSystem(sys2);

		assertEquals(2, bug.getSystems().size());
		assertTrue(bug.getSystems().contains(sys1));
		assertTrue(bug.getSystems().contains(sys2));
	}

	/**
	 * Run the void addSystem(System) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 07.03.11 11:54
	 */
	@Test
	public void testAddSystem_2() throws Exception {
		final Bug fixture = new Bug("", "", new Release("", new Date(),
				new Project("")), (ProductBacklog) null);
		fixture.doAddSystem(new System("", new Rootsystem()));
		final System system = new System("", new Rootsystem());

		fixture.addSystem(system);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:39)
	}

	/**
	 * Run the IRelease getRelease() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 07.03.11 11:54
	 */
	@Test
	public void testGetRelease_1() throws Exception {
		final Bug fixture = new Bug("", "", new Release("", new Date(),
				new Project("")), (ProductBacklog) null);
		fixture.doAddSystem(new System("", new Rootsystem()));

		final IRelease result = fixture.getRelease();

		assertNotNull(result);
	}

	/**
	 * Run the IBugState getState() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 07.03.11 11:54
	 */
	@Test
	public void testGetState_1() throws Exception {
		final Bug fixture = new Bug("", "", new Release("", new Date(),
				new Project("")), (ProductBacklog) null);
		fixture.doAddSystem(new System("", new Rootsystem()));

		final IBugState result = fixture.getState();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:39)
		assertNotNull(result);
	}

	/**
	 * Run the Collection<System> getSystems() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 07.03.11 11:54
	 */
	@Test
	public void testGetSystems_1() throws Exception {
		final Bug fixture = new Bug("", "", new Release("", new Date(),
				new Project("")), (ProductBacklog) null);
		fixture.doAddSystem(new System("", new Rootsystem()));

		final Collection<System> result = fixture.getSystems();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:39)
		assertNotNull(result);
	}

	/**
	 * Run the void removeSystem(System) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 07.03.11 11:54
	 */
	@Test
	public void testRemoveSystem_1() throws Exception {
		final Bug fixture = new Bug("", "", new Release("", new Date(),
				new Project("")), (ProductBacklog) null);
		fixture.doAddSystem(new System("", new Rootsystem()));
		final System system = new System("", new Rootsystem());

		fixture.removeSystem(system);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:39)
	}

	/**
	 * Run the void removeSystem(System) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 07.03.11 11:54
	 */
	@Test
	public void testRemoveSystem_2() throws Exception {
		final Bug fixture = new Bug("", "", new Release("", new Date(),
				new Project("")), (ProductBacklog) null);
		fixture.doAddSystem(new System("", new Rootsystem()));
		final System system = new System("", new Rootsystem());

		fixture.removeSystem(system);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:39)
	}

	/**
	 * Run the void setVersion(IRelease) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 07.03.11 11:54
	 */
	@Test
	public void testSetVersion_1() throws Exception {
		final Bug fixture = new Bug("", "", new Release("", new Date(),
				new Project("")), (ProductBacklog) null);
		fixture.doAddSystem(new System("", new Rootsystem()));
		final IRelease version = new Release("", new Date(), new Project(""));

		fixture.setVersion(version);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:39)
	}

	/**
	 * Run the void setVersion(IRelease) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 07.03.11 11:54
	 */
	@Test
	public void testSetVersion_2() throws Exception {
		final Bug fixture = new Bug("", "", new Release("", new Date(),
				new Project("")), (ProductBacklog) null);
		fixture.doAddSystem(new System("", new Rootsystem()));
		final IRelease version = new Release("", new Date(), new Project(""));

		fixture.setVersion(version);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:39)
	}

	/**
	 * Run the void setVersion(IRelease) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 07.03.11 11:54
	 */
	@Test
	public void testSetVersion_3() throws Exception {
		final Bug fixture = new Bug("", "", new Release("", new Date(),
				new Project("")), (ProductBacklog) null);
		fixture.doAddSystem(new System("", new Rootsystem()));
		final IRelease version = new Release("", new Date(), new Project(""));

		fixture.setVersion(version);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:39)
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 07.03.11 11:54
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
	 * @generatedBy CodePro at 07.03.11 11:54
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
	 * @generatedBy CodePro at 07.03.11 11:54
	 */
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(BugTest.class);
	}
}