package fhdw.ipscrum.phase3.gruppe3;

import java.util.Date;
import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.model.visitor.IPBIStateVisitor;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.BugOpenState;
import fhdw.ipscrum.shared.model.Rootsystem;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.interfaces.IHasChildren;
import org.junit.*;
import fhdw.ipscrum.shared.model.ConcreteSystem;
import fhdw.ipscrum.shared.model.Bug;
import static org.junit.Assert.*;

/**
 * The class <code>BugOpenStateTest</code> contains tests for the class <code>{@link BugOpenState}</code>.
 *
 * @generatedBy CodePro at 05.03.11 11:30
 * @author wolf
 * @version $Revision: 1.0 $
 */
public class BugOpenStateTest {
	/**
	 * Run the BugOpenState(Bug) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:30
	 */
	@Test
	public void testBugOpenState_1()
		throws Exception {
		Bug owner = new Bug("", "", (ProductBacklog) null);

		BugOpenState result = new BugOpenState(owner);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:43)
		assertNotNull(result);
	}

	/**
	 * Run the void accept(IPBIStateVisitor) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:30
	 */
	@Test
	public void testAccept_1()
		throws Exception {
		BugOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		IPBIStateVisitor visitor = null;

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
	 * @generatedBy CodePro at 05.03.11 11:30
	 */
	@Test
	public void testAddSystem_1()
		throws Exception {
		BugOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
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
	 * Run the void setRelease(IRelease) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:30
	 */
	@Test
	public void testSetRelease_1()
		throws Exception {
		BugOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
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
	 * @generatedBy CodePro at 05.03.11 11:30
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
	 * @generatedBy CodePro at 05.03.11 11:30
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
	 * @generatedBy CodePro at 05.03.11 11:30
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(BugOpenStateTest.class);
	}
}