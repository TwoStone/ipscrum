/**
 * 
 */
package fhdw.ipscrum.shared.commands.admin.personRoleAdministration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 
 */
@RunWith(Suite.class)
@SuiteClasses({
		PersonAddRoleCommandTest.class,
		PersonChangeNameCommandTest.class,
		PersonCreateCommandTest.class,
		PersonRemoveRoleCommandTest.class,
		RoleAddRightCommandTest.class,
		RoleCreateCommandTest.class,
		RoleDeleteCommandTest.class,
		RoleRemoveRightCommandTest.class,
		RoleSetDescriptionCommandTest.class })
public class PersonRoleAdministrationCommandSuite {

}
