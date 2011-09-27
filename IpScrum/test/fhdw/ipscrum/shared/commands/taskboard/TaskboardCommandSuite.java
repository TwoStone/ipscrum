package fhdw.ipscrum.shared.commands.taskboard;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Runs all administration command related tests.
 */
@RunWith(Suite.class)
@SuiteClasses({
		TaskAddPBICommandTest.class,
		TaskCreateCommandTest.class,
		TaskDeleteCommandTest.class,
		TaskRemovePBICommandTest.class,
		TaskSetPlanEffortCommandTest.class,
		TaskSetResponsibilityCommandTest.class })
public class TaskboardCommandSuite {

}
