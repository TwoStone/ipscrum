package fhdw.ipscrum.shared.model.nonMeta;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fhdw.ipscrum.shared.model.metamodel.search.TestAllSearch;
import fhdw.ipscrum.shared.model.nonMeta.incidents.TestAllIncidents;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all of the tests
 * within its package as well as within any subpackages of its package.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
		TestAllIncidents.class,
		TestAllSearch.class,
		AcceptanceCriterionTest.class,
		BugTest.class,
		FeatureTest.class,
		HintTest.class,
		PersonTest.class,
		ProductBacklogTest.class,
		ProjectTest.class,
		ReleaseTest.class,
		RoleTest.class,
		RootsystemTest.class,
		SprintBacklogTest.class,
		SprintTest.class,
		SystemTest.class,
		TeamTest.class,
		TaskTest.class })
public final class TestAllNonMeta {

	/**
	 * constructor of the TestAllNonMeta.
	 */
	private TestAllNonMeta() {

	}

}
