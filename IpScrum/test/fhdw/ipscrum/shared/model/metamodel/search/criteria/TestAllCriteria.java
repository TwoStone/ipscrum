package fhdw.ipscrum.shared.model.metamodel.search.criteria;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all of the tests within its package as well as
 * within any subpackages of its package.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ TestScruumleCriterion.class, TestEffortFieldCriterion.class, TestHintFieldCriterion.class })
public final class TestAllCriteria {

	/**
	 * constructor of the TestAllCriteria.
	 */
	private TestAllCriteria() {

	}

}
