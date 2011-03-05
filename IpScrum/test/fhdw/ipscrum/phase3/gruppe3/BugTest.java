package fhdw.ipscrum.phase3.gruppe3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.ConcreteSystem;
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
 * @generatedBy CodePro at 05.03.11 23:32
 * @author wolf
 * @version $Revision: 1.0 $
 */
public class BugTest {
	/**
	 * Run the Bug(String,String,IRelease,ProductBacklog) constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testBug_1() throws Exception {
		final String name = "MyBug";
		final String description = "";
		final Project pro = new Project("Test");
		final IRelease version = new Release("", new Date(), pro);

		final Bug result = new Bug(name, description, version, pro.getBacklog());

		assertTrue(pro.getBacklog().getItems().contains(result));
		assertEquals(pro.getBacklog(), result.getBacklog());

	}

	/**
	 * Run the Bug(String,String,IRelease,ProductBacklog) constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test(expected = UserException.class)
	public void testBug_2() throws Exception {
		final String name = "";
		final String description = "";
		final Project pro = new Project("Test");
		final IRelease version = new Release("", new Date(), pro);
		final ProductBacklog backlog = pro.getBacklog();

		new Bug(name, description, version, backlog);

	}

	/**
	 * Run the void addSystem(System) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testAddSystem_1() throws Exception {
		final Bug fixture = new Bug("", "", new Release("", new Date(),
				new Project("")), (ProductBacklog) null);
		fixture.doAddSystem(new ConcreteSystem("", new Rootsystem()));
		final System system = new ConcreteSystem("", new Rootsystem());

		fixture.addSystem(system);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:41)
	}

	/**
	 * Run the void addSystem(System) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testAddSystem_2() throws Exception {
		final Bug fixture = new Bug("", "", new Release("", new Date(),
				new Project("")), (ProductBacklog) null);
		fixture.doAddSystem(new ConcreteSystem("", new Rootsystem()));
		final System system = new ConcreteSystem("", new Rootsystem());

		fixture.addSystem(system);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:41)
	}

	/**
	 * Run the void doAddSystem(System) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testDoAddSystem_1() throws Exception {
		final Bug fixture = new Bug("", "", new Release("", new Date(),
				new Project("")), (ProductBacklog) null);
		fixture.doAddSystem(new ConcreteSystem("", new Rootsystem()));
		final System system = new ConcreteSystem("", new Rootsystem());

		fixture.doAddSystem(system);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:41)
	}

	/**
	 * Run the void doAddSystem(System) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testDoAddSystem_2() throws Exception {
		final Bug fixture = new Bug("", "", new Release("", new Date(),
				new Project("")), (ProductBacklog) null);
		fixture.doAddSystem(new ConcreteSystem("", new Rootsystem()));
		final System system = new ConcreteSystem("", new Rootsystem());

		fixture.doAddSystem(system);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:41)
	}

	/**
	 * Run the void doSetVersion(IRelease) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testDoSetVersion_1() throws Exception {
		final Bug fixture = new Bug("", "", new Release("", new Date(),
				new Project("")), (ProductBacklog) null);
		fixture.doAddSystem(new ConcreteSystem("", new Rootsystem()));
		final IRelease version = new Release("", new Date(), new Project(""));

		fixture.doSetVersion(version);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:41)
	}

	/**
	 * Run the void doSetVersion(IRelease) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testDoSetVersion_2() throws Exception {
		final Bug fixture = new Bug("", "", new Release("", new Date(),
				new Project("")), (ProductBacklog) null);
		fixture.doAddSystem(new ConcreteSystem("", new Rootsystem()));
		final IRelease version = new Release("", new Date(), new Project(""));

		fixture.doSetVersion(version);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:41)
	}

	/**
	 * Run the IRelease getRelease() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testGetRelease_1() throws Exception {
		final Bug fixture = new Bug("", "", new Release("", new Date(),
				new Project("")), (ProductBacklog) null);
		fixture.doAddSystem(new ConcreteSystem("", new Rootsystem()));

		final IRelease result = fixture.getRelease();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:41)
		assertNotNull(result);
	}

	/**
	 * Run the IBugState getState() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testGetState_1() throws Exception {
		final Bug fixture = new Bug("", "", new Release("", new Date(),
				new Project("")), (ProductBacklog) null);
		fixture.doAddSystem(new ConcreteSystem("", new Rootsystem()));

		final IBugState result = fixture.getState();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:41)
		assertNotNull(result);
	}

	/**
	 * Run the Collection<System> getSystems() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testGetSystems_1() throws Exception {
		final Bug fixture = new Bug("", "", new Release("", new Date(),
				new Project("")), (ProductBacklog) null);
		fixture.doAddSystem(new ConcreteSystem("", new Rootsystem()));

		final Collection<System> result = fixture.getSystems();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:41)
		assertNotNull(result);
	}

	/**
	 * Run the void setVersion(IRelease) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testSetVersion_1() throws Exception {
		final Bug fixture = new Bug("", "", new Release("", new Date(),
				new Project("")), (ProductBacklog) null);
		fixture.doAddSystem(new ConcreteSystem("", new Rootsystem()));
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
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:41)
	}

	/**
	 * Run the void setVersion(IRelease) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testSetVersion_2() throws Exception {
		final Bug fixture = new Bug("", "", new Release("", new Date(),
				new Project("")), (ProductBacklog) null);
		fixture.doAddSystem(new ConcreteSystem("", new Rootsystem()));
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
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:41)
	}

	/**
	 * Run the void setVersion(IRelease) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testSetVersion_3() throws Exception {
		final Bug fixture = new Bug("", "", new Release("", new Date(),
				new Project("")), (ProductBacklog) null);
		fixture.doAddSystem(new ConcreteSystem("", new Rootsystem()));
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
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:41)
	}

	/**
	 * Run the void accept(IProductBacklogItemVisitor) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 05.03.11 23:32
	 */
	@Test
	public void testAccept_1() throws Exception {
		final Project pro = new Project("Test");
		final Bug fixture = new Bug("Test", "",
				new Release("", new Date(), pro), pro.getBacklog());

		fixture.doAddSystem(new ConcreteSystem("", new Rootsystem()));
		final IProductBacklogItemVisitor visitor = null;

		fixture.accept(visitor);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:41)
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
		new org.junit.runner.JUnitCore().run(BugTest.class);
	}
}