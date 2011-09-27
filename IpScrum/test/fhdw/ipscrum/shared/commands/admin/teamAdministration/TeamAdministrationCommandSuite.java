package fhdw.ipscrum.shared.commands.admin.teamAdministration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Runs all team administration command related test.
 */
@RunWith(Suite.class)
@SuiteClasses({
		TeamAddMemberCommandTest.class,
		TeamAddProjectCommandTest.class,
		TeamCreateCommandTest.class,
		TeamRemoveMemberCommandTest.class,
		TeamSetDescriptionTest.class })
public class TeamAdministrationCommandSuite {

}
