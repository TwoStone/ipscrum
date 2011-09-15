package fhdw.ipscrum;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fhdw.ipscrum.client.view.widgets.charts.TestAllClient;
import fhdw.ipscrum.infrastructure.TestAllInfrastructure;
import fhdw.ipscrum.shared.TestAllShared;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all of the tests
 * within its package as well as within any subpackages of its package.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
		TestAllClient.class,
		TestAllInfrastructure.class,
		TestAllShared.class,
		AllInOneTests.class })
public final class TestAllIpScrum {

	/**
	 * constructor of the TestAllIpScrum.
	 */
	private TestAllIpScrum() {

	}

}
