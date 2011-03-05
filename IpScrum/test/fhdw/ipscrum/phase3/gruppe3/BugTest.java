package fhdw.ipscrum.phase3.gruppe3;

import static org.junit.Assert.assertNotNull;

import java.util.Collection;
import java.util.Date;
import org.junit.*;
import fhdw.ipscrum.shared.model.ConcreteSystem;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.Rootsystem;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.interfaces.IBugState;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.IHasChildren;
import fhdw.ipscrum.shared.model.visitor.IProductBacklogItemVisitor;

/**
 * The class <code>BugTest</code> contains tests for the class <code>{@link Bug}</code>.
 *
 * @generatedBy CodePro at 05.03.11 11:29
 * @author wolf
 * @version $Revision: 1.0 $
 */
public class BugTest {
	/**
	 * Run the Bug(String,String,ProductBacklog) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:29
	 */
	@Test
	public void testBug_1()
		throws Exception {
		String name = "";
		String description = "";
		ProductBacklog backlog = null;

		Bug result = new Bug(name, description, backlog);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:43)
		assertNotNull(result);
	}

	/**
	 * Run the void accept(IProductBacklogItemVisitor) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:29
	 */
	@Test
	public void testAccept_1()
		throws Exception {
		Bug fixture = new Bug("", "", (ProductBacklog) null);
		fixture.doSetRelease(new Release("", new Date(), new Project("")));
		fixture.doAddSystem(new ConcreteSystem("", new Rootsystem()));
		IProductBacklogItemVisitor visitor = null;

		fixture.accept(visitor);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:43)
	}

	/**
	 * Run the void addSystem(System) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:29
	 */
	@Test
	public void testAddSystem_1()
		throws Exception {
		Bug fixture = new Bug("", "", (ProductBacklog) null);
		fixture.doSetRelease(new Release("", new Date(), new Project("")));
		fixture.doAddSystem(new ConcreteSystem("", new Rootsystem()));
		System system = new ConcreteSystem("", new Rootsystem());

		fixture.addSystem(system);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:43)
	}

	/**
	 * Run the void addSystem(System) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:29
	 */
	@Test
	public void testAddSystem_2()
		throws Exception {
		Bug fixture = new Bug("", "", (ProductBacklog) null);
		fixture.doSetRelease(new Release("", new Date(), new Project("")));
		fixture.doAddSystem(new ConcreteSystem("", new Rootsystem()));
		System system = new ConcreteSystem("", new Rootsystem());

		fixture.addSystem(system);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:43)
	}

	/**
	 * Run the void doAddSystem(System) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:29
	 */
	@Test
	public void testDoAddSystem_1()
		throws Exception {
		Bug fixture = new Bug("", "", (ProductBacklog) null);
		fixture.doSetRelease(new Release("", new Date(), new Project("")));
		fixture.doAddSystem(new ConcreteSystem("", new Rootsystem()));
		System system = new ConcreteSystem("", new Rootsystem());

		fixture.doAddSystem(system);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:43)
	}

	/**
	 * Run the void doSetRelease(IRelease) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:29
	 */
	@Test
	public void testDoSetRelease_1()
		throws Exception {
		Bug fixture = new Bug("", "", (ProductBacklog) null);
		fixture.doSetRelease(new Release("", new Date(), new Project("")));
		fixture.doAddSystem(new ConcreteSystem("", new Rootsystem()));
		IRelease release = new Release("", new Date(), new Project(""));

		fixture.doSetRelease(release);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:43)
	}

	/**
	 * Run the IRelease getRelease() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:29
	 */
	@Test
	public void testGetRelease_1()
		throws Exception {
		Bug fixture = new Bug("", "", (ProductBacklog) null);
		fixture.doSetRelease(new Release("", new Date(), new Project("")));
		fixture.doAddSystem(new ConcreteSystem("", new Rootsystem()));

		IRelease result = fixture.getRelease();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:43)
		assertNotNull(result);
	}

	/**
	 * Run the IBugState getState() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:29
	 */
	@Test
	public void testGetState_1()
		throws Exception {
		Bug fixture = new Bug("", "", (ProductBacklog) null);
		fixture.doSetRelease(new Release("", new Date(), new Project("")));
		fixture.doAddSystem(new ConcreteSystem("", new Rootsystem()));

		IBugState result = fixture.getState();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:43)
		assertNotNull(result);
	}

	/**
	 * Run the Collection<System> getSystems() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:29
	 */
	@Test
	public void testGetSystems_1()
		throws Exception {
		Bug fixture = new Bug("", "", (ProductBacklog) null);
		fixture.doSetRelease(new Release("", new Date(), new Project("")));
		fixture.doAddSystem(new ConcreteSystem("", new Rootsystem()));

		Collection<System> result = fixture.getSystems();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:43)
		assertNotNull(result);
	}

	/**
	 * Run the void setRelease(IRelease) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:29
	 */
	@Test
	public void testSetRelease_1()
		throws Exception {
		Bug fixture = new Bug("", "", (ProductBacklog) null);
		fixture.doSetRelease(new Release("", new Date(), new Project("")));
		fixture.doAddSystem(new ConcreteSystem("", new Rootsystem()));
		IRelease release = new Release("", new Date(), new Project(""));

		fixture.setRelease(release);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:43)
	}

	/**
	 * Run the void setRelease(IRelease) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:29
	 */
	@Test
	public void testSetRelease_2()
		throws Exception {
		Bug fixture = new Bug("", "", (ProductBacklog) null);
		fixture.doSetRelease(new Release("", new Date(), new Project("")));
		fixture.doAddSystem(new ConcreteSystem("", new Rootsystem()));
		IRelease release = new Release("", new Date(), new Project(""));

		fixture.setRelease(release);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:43)
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 05.03.11 11:29
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
	 * @generatedBy CodePro at 05.03.11 11:29
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
	 * @generatedBy CodePro at 05.03.11 11:29
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(BugTest.class);
	}
}