package fhdw.ipscrum.shared.model.messages;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Represents the test suite for all messageTests.
 */
@RunWith(Suite.class)
@SuiteClasses({
		AddGlobalIncidentMessageTest.class,
		PBICompletionMessageTest.class,
		ReleaseCompletionMessageTest.class,
		RemoveGlobalIncidentMessageTest.class,
		SprintCompletionMessageTest.class,
		TaskCompletionMessageTest.class })
public class MessageTests {

}
