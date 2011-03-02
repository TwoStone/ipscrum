package fhdw.ipscrum.phase3.gruppe3;

import java.util.Collection;
import java.util.Date;
import fhdw.ipscrum.shared.model.ProductBacklog;
import org.junit.*;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.interfaces.IBugState;
import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.visitor.IProductBacklogItemVisitor;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISystem;
import static org.junit.Assert.*;

/**
 * The class <code>BugTest</code> contains tests for the class <code>{@link Bug}</code>.
 *
 * @generatedBy CodePro at 02.03.11 20:35
 * @author wolf
 * @version $Revision: 1.0 $
 */
public class BugTest {
	/**
	 * Run the Bug(String,String,ProductBacklog) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
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
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the void accept(IProductBacklogItemVisitor) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testAccept_1()
		throws Exception {
		Bug fixture = new Bug("", "", (ProductBacklog) null);
		fixture.doSetRelease(new Release("", new Date(), new Project("")));
		fixture.doAddSystem((ISystem) null);
		IProductBacklogItemVisitor visitor = null;

		fixture.accept(visitor);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void addSystem(ISystem) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testAddSystem_1()
		throws Exception {
		Bug fixture = new Bug("", "", (ProductBacklog) null);
		fixture.doSetRelease(new Release("", new Date(), new Project("")));
		fixture.doAddSystem((ISystem) null);
		ISystem system = null;

		fixture.addSystem(system);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void addSystem(ISystem) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testAddSystem_2()
		throws Exception {
		Bug fixture = new Bug("", "", (ProductBacklog) null);
		fixture.doSetRelease(new Release("", new Date(), new Project("")));
		fixture.doAddSystem((ISystem) null);
		ISystem system = null;

		fixture.addSystem(system);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void doAddSystem(ISystem) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testDoAddSystem_1()
		throws Exception {
		Bug fixture = new Bug("", "", (ProductBacklog) null);
		fixture.doSetRelease(new Release("", new Date(), new Project("")));
		fixture.doAddSystem((ISystem) null);
		ISystem system = null;

		fixture.doAddSystem(system);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void doSetRelease(IRelease) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testDoSetRelease_1()
		throws Exception {
		Bug fixture = new Bug("", "", (ProductBacklog) null);
		fixture.doSetRelease(new Release("", new Date(), new Project("")));
		fixture.doAddSystem((ISystem) null);
		IRelease release = new Release("", new Date(), new Project(""));

		fixture.doSetRelease(release);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the IRelease getRelease() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testGetRelease_1()
		throws Exception {
		Bug fixture = new Bug("", "", (ProductBacklog) null);
		fixture.doSetRelease(new Release("", new Date(), new Project("")));
		fixture.doAddSystem((ISystem) null);

		IRelease result = fixture.getRelease();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the IBugState getState() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testGetState_1()
		throws Exception {
		Bug fixture = new Bug("", "", (ProductBacklog) null);
		fixture.doSetRelease(new Release("", new Date(), new Project("")));
		fixture.doAddSystem((ISystem) null);

		IBugState result = fixture.getState();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the Collection<ISystem> getSystems() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testGetSystems_1()
		throws Exception {
		Bug fixture = new Bug("", "", (ProductBacklog) null);
		fixture.doSetRelease(new Release("", new Date(), new Project("")));
		fixture.doAddSystem((ISystem) null);

		Collection<ISystem> result = fixture.getSystems();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the void setRelease(IRelease) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testSetRelease_1()
		throws Exception {
		Bug fixture = new Bug("", "", (ProductBacklog) null);
		fixture.doSetRelease(new Release("", new Date(), new Project("")));
		fixture.doAddSystem((ISystem) null);
		IRelease release = new Release("", new Date(), new Project(""));

		fixture.setRelease(release);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setRelease(IRelease) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testSetRelease_2()
		throws Exception {
		Bug fixture = new Bug("", "", (ProductBacklog) null);
		fixture.doSetRelease(new Release("", new Date(), new Project("")));
		fixture.doAddSystem((ISystem) null);
		IRelease release = new Release("", new Date(), new Project(""));

		fixture.setRelease(release);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
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
	 * @generatedBy CodePro at 02.03.11 20:35
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
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(BugTest.class);
	}
}