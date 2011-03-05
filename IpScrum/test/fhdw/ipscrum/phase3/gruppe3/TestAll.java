package fhdw.ipscrum.phase3.gruppe3;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all
 * of the tests within its package as well as within any subpackages of its
 * package.
 *
 * @generatedBy CodePro at 05.03.11 11:30
 * @author wolf
 * @version $Revision: 1.0 $
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	SystemgroupTest.class,
	BugOpenStateTest.class,
	RootTest.class,
	ProductBacklogItemTest.class,
	SprintTest.class,
	ProjectTest.class,
	BugClosedStateTest.class,
	HintTest.class,
	RootsystemTest.class,
	ReleaseTest.class,
	BugTest.class,
	IHasChildrenTest.class,
	ProductBacklogTest.class,
	TaskTest.class,
	ConcreteSystemTest.class,
	IBugStateTest.class,
	FeatureTest.class,
	RelationTest.class,
})
public class TestAll {

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 05.03.11 11:30
	 */
	public static void main(String[] args) {
		JUnitCore.runClasses(new Class[] { TestAll.class });
	}
}
