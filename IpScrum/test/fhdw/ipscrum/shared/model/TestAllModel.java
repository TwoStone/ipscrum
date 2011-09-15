package fhdw.ipscrum.shared.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fhdw.ipscrum.shared.model.messages.MessageTests;
import fhdw.ipscrum.shared.model.metamodel.TestAllMetamodell;
import fhdw.ipscrum.shared.model.nonMeta.TestAllNonMeta;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all of the tests
 * within its package as well as within any subpackages of its package.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
		ModelRootTest.class,
		TestAllMetamodell.class,
		TestAllNonMeta.class,
		MessageTests.class })
public final class TestAllModel {

	/**
	 * constructor of the TestAllModel.
	 */
	private TestAllModel() {

	}
}
