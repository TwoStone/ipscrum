package fhdw.ipscrum.shared.commands.admin;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fhdw.ipscrum.shared.commands.admin.fieldTypes.FieldTypeAdministrationCommandSuite;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamAdministrationCommandSuite;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeAdministrationCommandSuite;

/**
 * Runs all administration command related tests.
 */
@RunWith(Suite.class)
@SuiteClasses({
		SystemCreateCommandTest.class,
		TeamAdministrationCommandSuite.class,
		TicketTypeAdministrationCommandSuite.class,
		FieldTypeAdministrationCommandSuite.class })
public class AdminCommandSuite {

}
