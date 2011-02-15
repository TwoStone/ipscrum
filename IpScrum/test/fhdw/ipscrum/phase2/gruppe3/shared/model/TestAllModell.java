package fhdw.ipscrum.phase2.gruppe3.shared.model;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all of
 * the tests within its package as well as within any subpackages of its
 * package.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ TeamTest.class, SprintTest.class, RoleTest.class, RootTest.class, PersonTest.class, })
public class TestAllModell {

	/**
	 * Launch the test.
	 */
	public static void main(String[] args) {
		JUnitCore.runClasses(new Class[] { TestAllModell.class });
	}
}
