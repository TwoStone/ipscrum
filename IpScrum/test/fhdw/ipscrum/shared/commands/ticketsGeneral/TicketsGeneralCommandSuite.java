package fhdw.ipscrum.shared.commands.ticketsGeneral;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Runs all administration command related tests.
 */
@RunWith(Suite.class)
@SuiteClasses({
		ListFieldAddValueCommandTest.class,
		ListFieldIdentifiableObjectAddValueCommandTest.class,
		ListFieldIdentifiableObjectRemoveValueCommandTest.class,
		ListFieldNonIdentifiableObjectAddValueCommandTest.class,
		ListFieldNonIdentifiableObjectRemoveValueCommandTest.class,
		ListFieldRemoveValueCommandTest.class,
		SingleFieldChangeCommandTest.class,
		SingleFieldIdentifiableObjectChangeCommandTest.class,
		SingleFieldIdentifiableObjectChangeCommandTest.class,
		TicketChangeStateCommandTest.class })
public class TicketsGeneralCommandSuite {

}
