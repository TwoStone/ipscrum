package fhdw.ipscrum.shared.commands.metamodel.task;

import java.io.File;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.TestUtils;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TaskTicketTypeCreateCommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskAddPBICommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskCreateCommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskDeleteCommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskRemovePBICommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskSetPlanEffortCommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskSetResponsibilityCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.nonMeta.Effort;
import fhdw.ipscrum.shared.model.nonMeta.Feature;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.RelationType;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.nonMeta.Task;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * VariousTaskCommandsTest.
 */
public class VariousTaskCommandsTest {

	/**
	 * inner Variable.
	 */
	private static Model model;
	/**
	 * inner Variable.
	 */
	private static Project project;
	/**
	 * inner Variable.
	 */
	private static Task task;
	/**
	 * inner Variable.
	 */
	private static Feature feature;
	/**
	 * inner Variable.
	 */
	private static Sprint sprint;

	/**
	 * Set up test data.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() {
		TestUtils.deleteFolderContent(new File("output"));
		ServerContext.resetServerContext();
		VariousTaskCommandsTest.model = ServerContext.getInstance().getPersistenceManager().getCurrentModel();
		VariousTaskCommandsTest.model.setUuidManager(new IDGenerator());
		try {
			new RelationType(VariousTaskCommandsTest.model, "Abhängig von");
			new RelationType(VariousTaskCommandsTest.model, "Siehe auch");

			VariousTaskCommandsTest.project = new Project(VariousTaskCommandsTest.model, "test");
			final FeatureTicketType type =
					new FeatureTicketType(VariousTaskCommandsTest.model, "Featuertype 1", "description");
			VariousTaskCommandsTest.feature =
					new Feature(VariousTaskCommandsTest.model, type, "feature 1", "description",
							VariousTaskCommandsTest.project.getBacklog());

			final Team team = new Team(VariousTaskCommandsTest.model, "Testeam");
			team.addProject(VariousTaskCommandsTest.project);
			final Person person = new Person(VariousTaskCommandsTest.model, "firstname", "lastname");
			team.addMember(person);

			VariousTaskCommandsTest.sprint =
					new Sprint(VariousTaskCommandsTest.model, "name", "description", new Date(), new Date(), team,
							VariousTaskCommandsTest.project);
			VariousTaskCommandsTest.feature.setSprint(VariousTaskCommandsTest.sprint);

			VariousTaskCommandsTest.task =
					new Task(VariousTaskCommandsTest.model, VariousTaskCommandsTest.model.getAllTaskTicketTypes()
							.get(0), "testtask", "setbeforetask", VariousTaskCommandsTest.sprint.getSprintBacklog());

		} catch (final IPScrumGeneralException e) {
			e.printStackTrace();
		}
	}

	/**
	 * test case to add pbi to task.
	 */
	@Test
	public void taskAddPBICommandTest() {
		try {
			final TaskAddPBICommand command =
					new TaskAddPBICommand(VariousTaskCommandsTest.task, VariousTaskCommandsTest.feature);

			command.execute(VariousTaskCommandsTest.model);
		} catch (final IPScrumGeneralException e) {
			e.printStackTrace();
			Assert.fail("Should not happen");
		}
	}

	/**
	 * test case to create task command.
	 */
	@Test
	public void taskCreateCommandTest() {
		try {
			final TaskCreateCommand command =
					new TaskCreateCommand("name", "description", VariousTaskCommandsTest.model.getAllTaskTicketTypes()
							.get(0), VariousTaskCommandsTest.sprint.getSprintBacklog());

			command.execute(VariousTaskCommandsTest.model);
		} catch (final IPScrumGeneralException e) {
			e.printStackTrace();
			Assert.fail("Should not happen");
		}
	}

	/**
	 * test case to set plan effort.
	 */
	@Test
	public void taskSetPlanEffortCommandTest() {
		try {
			final Effort effort = new Effort(10);
			final TaskSetPlanEffortCommand command = new TaskSetPlanEffortCommand(VariousTaskCommandsTest.task, effort);

			command.execute(VariousTaskCommandsTest.model);
		} catch (final IPScrumGeneralException e) {
			e.printStackTrace();
			Assert.fail("Should not happen");
		}
	}

	/**
	 * test case to set responsibility.
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public void taskSetResponsibilityCommandTest() throws IPScrumGeneralException {

		// VariousTaskCommandsTest.task.changeState(VariousTaskCommandsTest.model.getAllStateTypes().get(0));
		final Task myTask =
				new Task(VariousTaskCommandsTest.model, VariousTaskCommandsTest.model.getTypeManager()
						.getStandardTaskType(), "TestTask", "TT2", VariousTaskCommandsTest.sprint.getSprintBacklog());

		myTask.changeState(VariousTaskCommandsTest.model.getTypeManager().getInProcess());

		final TaskSetResponsibilityCommand command =
				new TaskSetResponsibilityCommand(myTask, VariousTaskCommandsTest.sprint.getTeam().getMembers().get(0));

		command.execute(VariousTaskCommandsTest.model);
	}

	/**
	 * test case to remove specific pbi.
	 */
	@Test
	public void taskRemovePBICommandTest() {
		try {
			final Feature lvFeature =
					new Feature(VariousTaskCommandsTest.model, VariousTaskCommandsTest.model.getAllFeatureTicketTypes()
							.get(0), "Feature 2", "description", VariousTaskCommandsTest.project.getBacklog());

			lvFeature.setSprint(VariousTaskCommandsTest.sprint);

			final Task lvTask =
					new Task(VariousTaskCommandsTest.model, VariousTaskCommandsTest.model.getAllTaskTicketTypes()
							.get(0), "local task", "local variable", VariousTaskCommandsTest.sprint.getSprintBacklog());
			lvTask.addPBI(lvFeature);

			final TaskRemovePBICommand command = new TaskRemovePBICommand(lvTask, lvFeature);

			command.execute(VariousTaskCommandsTest.model);
		} catch (final IPScrumGeneralException e) {
			e.printStackTrace();
			Assert.fail("Should not happen");
		}
	}

	/**
	 * test case to create tasktickettype.
	 */
	@Test
	public void taskTicketTypeCreateCommandTest() {
		try {
			final TaskTicketTypeCreateCommand command = new TaskTicketTypeCreateCommand("Testtype", "test description");

			command.execute(VariousTaskCommandsTest.model);
		} catch (final IPScrumGeneralException e) {
			e.printStackTrace();
			Assert.fail("Should not happen");
		}
	}

	/**
	 * test case to delete the task from SetUpBefore().
	 */
	@Test
	public void taskDeleteCommandTest() {
		try {
			final TaskDeleteCommand command = new TaskDeleteCommand(VariousTaskCommandsTest.task);

			command.execute(VariousTaskCommandsTest.model);
		} catch (final IPScrumGeneralException e) {
			e.printStackTrace();
			Assert.fail("Should not happen");
		}
	}

}
