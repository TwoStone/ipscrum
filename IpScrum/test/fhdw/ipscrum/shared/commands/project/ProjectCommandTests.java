package fhdw.ipscrum.shared.commands.project;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test suite for the project commands.
 */
@RunWith(Suite.class)
@SuiteClasses({
		ProjectAddSystemCommandTest.class,
		ProjectChangeNameCommandTest.class,
		ProjectCreateCommandTest.class,
		ProjectRemoveSystemCommandTest.class,
		ReleaseAddSprintCommandTest.class,
		ReleaseCreateCommandTest.class,
		ReleaseRemoveSprintCommandTest.class,
		SprintChangeCommandTest.class,
		SprintCreateCommandTest.class })
public class ProjectCommandTests {

}
