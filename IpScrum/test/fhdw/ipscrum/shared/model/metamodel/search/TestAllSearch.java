package fhdw.ipscrum.shared.model.metamodel.search;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fhdw.ipscrum.shared.model.metamodel.search.criteria.TestAllCriteria;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all of the tests
 * within its package as well as within any subpackages of its package.
 * 
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
		TestAllCriteria.class,
		AndTest.class,
		MultiLogicSearchOperatorTest.class,
		NotTest.class,
		OrTest.class,
		SearchCriteriaTest.class,
		SearchManagerTest.class,
		SearchTest.class,
		SingleLogicSearchOperatorTest.class })
public final class TestAllSearch {

	/**
	 * constructor of the TestAllSearch.
	 */
	private TestAllSearch() {

	}

}
