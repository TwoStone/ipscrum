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
	private Model model;
	/**
	 * inner Variable.
	 */
	private Project project;
	/**
	 * inner Variable.
	 */
	private Task task;
	/**
	 * inner Variable.
	 */
	private Feature feature;
	/**
	 * inner Variable.
	 */
	private Sprint sprint;

	/**
	 * Set up test data.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() {
		TestUtils.deleteFolderContent(new File("output"));
		ServerContext.resetServerContext();
		this.model = ServerContext.getInstance().getPersistenceManager().getCurrentModel();
		this.model.setUuidManager(new IDGenerator());
		try {
			new RelationType(this.model, "Abhängig von");
			new RelationType(this.model, "Siehe auch");

			this.project = new Project(this.model, "test");
			final FeatureTicketType type = new FeatureTicketType(this.model, "Featuertype 1", "description");
			this.feature = new Feature(this.model, type, "feature 1", "description", this.project.getBacklog());

			final Team team = new Team(this.model, "Testeam");
			team.addProject(this.project);
			final Person person = new Person(this.model, "firstname", "lastname");
			team.addMember(person);

			this.sprint = new Sprint(this.model, "name", "description", new Date(), new Date(), team, this.project);
			this.feature.setSprint(this.sprint);

			this.task =
					new Task(this.model, this.model.getAllTaskTicketTypes().get(0), "testtask", "setbeforetask",
							this.sprint.getSprintBacklog());

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
			final TaskAddPBICommand command = new TaskAddPBICommand(this.task, this.feature);

			command.execute(this.model);
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
					new TaskCreateCommand("name", "description", this.model.getAllTaskTicketTypes().get(0),
							this.sprint.getSprintBacklog());

			command.execute(this.model);
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
			final TaskSetPlanEffortCommand command = new TaskSetPlanEffortCommand(this.task, effort);

			command.execute(this.model);
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

		// this.task.changeState(this.model.getAllStateTypes().get(0));
		final Task myTask =
				new Task(this.model, this.model.getTypeManager().getStandardTaskType(), "TestTask", "TT2",
						this.sprint.getSprintBacklog());

		myTask.changeState(this.model.getTypeManager().getInProcess());

		final TaskSetResponsibilityCommand command =
				new TaskSetResponsibilityCommand(myTask, this.sprint.getTeam().getMembers().get(0));

		command.execute(this.model);
	}

	/**
	 * test case to remove specific pbi.
	 */
	@Test
	public void taskRemovePBICommandTest() {
		try {
			final Feature lvFeature =
					new Feature(this.model, this.model.getAllFeatureTicketTypes().get(0), "Feature 2", "description",
							this.project.getBacklog());

			lvFeature.setSprint(this.sprint);

			final Task lvTask =
					new Task(this.model, this.model.getAllTaskTicketTypes().get(0), "local task", "local variable",
							this.sprint.getSprintBacklog());
			lvTask.addPBI(lvFeature);

			final TaskRemovePBICommand command = new TaskRemovePBICommand(lvTask, lvFeature);

			command.execute(this.model);
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

			command.execute(this.model);
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
			final TaskDeleteCommand command = new TaskDeleteCommand(this.task);

			command.execute(this.model);
		} catch (final IPScrumGeneralException e) {
			e.printStackTrace();
			Assert.fail("Should not happen");
		}
	}

}
