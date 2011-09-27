package fhdw.ipscrum.shared.commands.productBacklog;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Runs all administration command related tests.
 */
@RunWith(Suite.class)
@SuiteClasses({
		BugCreateCommandTest.class,
		FeatureCreateCommandTest.class,
		PBIAddRelationCommandTest.class,
		PBIPriorityDecreaseCommandTest.class,
		PBIPriorityIncreaseCommandTest.class,
		PBIRemoveRelationCommandTest.class,
		RelationTypeCreateCommandTest.class })
public class ProductBacklogCommandSuite {

}
