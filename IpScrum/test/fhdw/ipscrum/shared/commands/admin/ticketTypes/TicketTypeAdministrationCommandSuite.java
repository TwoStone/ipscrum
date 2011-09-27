package fhdw.ipscrum.shared.commands.admin.ticketTypes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Runs all ticket type administration related tests.
 */
@RunWith(Suite.class)
@SuiteClasses({
		BugTicketTypeCreateCommandTest.class,
		FeatureTicketTypeCreateCommandTest.class,
		StateTypeCreateCommandTest.class,
		TaskTicketTypeCreateCommandTest.class,
		TicketTypeAddFieldTypeCommandTest.class })
public class TicketTypeAdministrationCommandSuite {

}