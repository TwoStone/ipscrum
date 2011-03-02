package fhdw.ipscrum.phase3.gruppe3;

import org.junit.*;
import fhdw.ipscrum.shared.model.visitor.IPBIStateVisitor;
import fhdw.ipscrum.shared.model.FeatureOpenState;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklog;
import static org.junit.Assert.*;

/**
 * The class <code>FeatureOpenStateTest</code> contains tests for the class <code>{@link FeatureOpenState}</code>.
 *
 * @generatedBy CodePro at 02.03.11 20:35
 * @author wolf
 * @version $Revision: 1.0 $
 */
public class FeatureOpenStateTest {
	/**
	 * Run the FeatureOpenState(Feature) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testFeatureOpenState_1()
		throws Exception {
		Feature owner = new Feature("", "", (ProductBacklog) null);

		FeatureOpenState result = new FeatureOpenState(owner);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Feature.<init>(Feature.java:24)
		assertNotNull(result);
	}

	/**
	 * Run the void accept(IPBIStateVisitor) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testAccept_1()
		throws Exception {
		FeatureOpenState fixture = new FeatureOpenState(new Feature("", "", (ProductBacklog) null));
		IPBIStateVisitor visitor = null;

		fixture.accept(visitor);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Feature.<init>(Feature.java:24)
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
		new org.junit.runner.JUnitCore().run(FeatureOpenStateTest.class);
	}
}