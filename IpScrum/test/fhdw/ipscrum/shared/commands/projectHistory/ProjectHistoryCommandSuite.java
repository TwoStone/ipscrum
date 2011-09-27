package fhdw.ipscrum.shared.commands.projectHistory;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Runs all administration command related tests.
 */
@RunWith(Suite.class)
@SuiteClasses({
		IncidentIllnessCreateCommandTest.class,
		IncidentOtherIssueCreateCommandTest.class,
		IncidentTypeCreateCommandTest.class,
		IncidentVacationCreateCommandTest.class })
public class ProjectHistoryCommandSuite {

}
