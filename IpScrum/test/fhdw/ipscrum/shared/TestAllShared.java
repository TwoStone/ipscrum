package fhdw.ipscrum.shared;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fhdw.ipscrum.shared.commands.admin.AdminCommandSuite;
import fhdw.ipscrum.shared.commands.metamodel.pbi.VariousBugCommandsTest;
import fhdw.ipscrum.shared.commands.metamodel.pbi.VariousFeatureCommandsTest;
import fhdw.ipscrum.shared.commands.metamodel.pbi.VariousPBICommandsTest;
import fhdw.ipscrum.shared.commands.metamodel.task.VariousTaskCommandsTest;
import fhdw.ipscrum.shared.commands.productBacklog.ProductBacklogCommandSuite;
import fhdw.ipscrum.shared.commands.project.ProjectCommandTests;
import fhdw.ipscrum.shared.commands.projectHistory.ProjectHistoryCommandSuite;
import fhdw.ipscrum.shared.commands.taskboard.TaskboardCommandSuite;
import fhdw.ipscrum.shared.commands.ticketsGeneral.TicketsGeneralCommandSuite;
import fhdw.ipscrum.shared.exceptions.infrastructure.InfrastructureExceptionSuite;
import fhdw.ipscrum.shared.model.TestAllModel;
import fhdw.ipscrum.shared.utils.TestAllUtils;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all of the tests within its package as well as
 * within any subpackages of its package.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
		TestAllModel.class,
		TestAllUtils.class,
		VariousTaskCommandsTest.class,
		VariousPBICommandsTest.class,
		VariousBugCommandsTest.class,
		VariousFeatureCommandsTest.class,
		ProjectCommandTests.class,
		AdminCommandSuite.class,
		TicketsGeneralCommandSuite.class,
		ProjectHistoryCommandSuite.class,
		TaskboardCommandSuite.class,
		ProductBacklogCommandSuite.class,
		InfrastructureExceptionSuite.class })
public final class TestAllShared {

	/**
	 * constructor of the TestAllShared.
	 */
	private TestAllShared() {

	}

}
