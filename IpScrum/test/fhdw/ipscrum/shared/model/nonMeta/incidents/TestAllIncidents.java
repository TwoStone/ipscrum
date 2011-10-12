package fhdw.ipscrum.shared.model.nonMeta.incidents;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all of the tests within its package as well as
 * within any subpackages of its package.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
		IncidentTest.class,
		IncidentTypeTest.class,
		MultipleParticipantIncidentTest.class,
		OneParticipantIncidentTest.class })
public final class TestAllIncidents {

	/**
	 * constructor of the TestAllIncidents.
	 */
	private TestAllIncidents() {

	}

}
