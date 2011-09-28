package fhdw.ipscrum.shared.model.metamodel;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fhdw.ipscrum.shared.model.metamodel.search.TestAllSearch;
import fhdw.ipscrum.shared.model.metamodel.states.TestAllStates;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TestAllTicketsAndTypes;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all of the tests within its package as well as
 * within any subpackages of its package.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({

TestAllSearch.class, TestAllStates.class, TestAllTicketsAndTypes.class })
public final class TestAllMetamodell {

	/**
	 * constructor of the TestAllMetamodell.
	 */
	private TestAllMetamodell() {

	}

}
