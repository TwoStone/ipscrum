package fhdw.ipscrum.shared.model.userRights;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamAddMemberCommand;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamAddProjectCommand;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamCreateCommand;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamRemoveMemberCommand;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamSetDescriptionCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.BugTicketTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.FeatureTicketTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.StateTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TaskTicketTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeAddFieldTypeCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeAddStatetypeCommand;
import fhdw.ipscrum.shared.commands.search.SearchCreateCommand;
import fhdw.ipscrum.shared.commands.search.SearchDeleteCommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskAddPBICommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskCreateCommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskDeleteCommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskRemovePBICommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskSetPlanEffortCommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskSetResponsibilityCommand;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;
import fhdw.ipscrum.shared.model.metamodel.search.And;
import fhdw.ipscrum.shared.model.metamodel.search.Search;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TaskTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;
import fhdw.ipscrum.shared.model.nonMeta.Effort;
import fhdw.ipscrum.shared.model.nonMeta.Feature;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.nonMeta.SprintBacklog;
import fhdw.ipscrum.shared.model.nonMeta.Task;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * Represents the class which tests the right handler.
 */
public class RightHandlerTest {
	/**
	 * Represents the serverContext needed to use the IPScrum.
	 */
	private static ServerContext serverContext;
	/**
	 * Represents the model needed to use the IPScrum.
	 */
	private static Model model;
	/**
	 * Represents the PersonRoleAdminRight needed to use the IPScrum.
	 */
	private static PersonRoleAdminRight prar;
	/**
	 * Represents the ProductBacklogRight needed to use the IPScrum.
	 */
	private static ProductBacklogRight pbr;
	/**
	 * Represents the ProjectRight needed to use the IPScrum.
	 */
	private static ProjectRight pr;
	/**
	 * Represents the TaskboardRight needed to use the IPScrum.
	 */
	private static TaskboardRight tr;
	/**
	 * Represents the TeamAdminRight needed to use the IPScrum.
	 */
	private static TeamAdminRight tar;
	/**
	 * Represents the FieldTypeAdminRight needed to use the IPScrum.
	 */
	private static FieldTypeAdminRight ftar;
	/**
	 * Represents the ProjectHistoryRight needed to use the IPScrum.
	 */
	private static ProjectHistoryRight phr;
	/**
	 * Represents the TicketTypeAdminRight needed to use the IPScrum.
	 */
	private static TicketTypeAdminRight ttar;
	/**
	 * represents a team needed to test the ticketTypes.
	 */
	private static Team team;
	/**
	 * represents a person.
	 */
	private static Person person;
	/**
	 * represents a project.
	 */
	private static Project project;

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 */
	@Before
	public void setUp() throws Exception {

	}

	/**
	 * Sets up the data before the whole class.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		RightHandlerTest.serverContext = ServerContext.getInstance();
		RightHandlerTest.model = RightHandlerTest.serverContext.getPersistenceManager().getModelForTesting();
		RightHandlerTest.model.setUuidManager(new IDGenerator());

		RightHandlerTest.project = new Project(RightHandlerTest.model, "Test");
		RightHandlerTest.team = new Team(RightHandlerTest.model, "team2");
		RightHandlerTest.person = new Person(RightHandlerTest.model, "bla", "blubb");
		RightHandlerTest.team.addProject(RightHandlerTest.project);

		RightHandlerTest.prar = new PersonRoleAdminRight(RightHandlerTest.model);
		RightHandlerTest.pbr = new ProductBacklogRight(RightHandlerTest.model);
		RightHandlerTest.pr = new ProjectRight(RightHandlerTest.model);
		RightHandlerTest.tr = new TaskboardRight(RightHandlerTest.model);
		RightHandlerTest.tar = new TeamAdminRight(RightHandlerTest.model);
		RightHandlerTest.ftar = new FieldTypeAdminRight(RightHandlerTest.model);
		RightHandlerTest.phr = new ProjectHistoryRight(RightHandlerTest.model);
		RightHandlerTest.ttar = new TicketTypeAdminRight(RightHandlerTest.model);

	}

	/**
	 * Tears down the data after the whole class.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Tears Down the data after every test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Tests the methods which are in the RightHandler.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testRightHandler() throws Exception {
		final SearchCreateCommand scc = new SearchCreateCommand("", new And(RightHandlerTest.model));
		final SearchDeleteCommand sdc =
				new SearchDeleteCommand(new Search(RightHandlerTest.model, "sdc", new And(RightHandlerTest.model)));
		RightHandlerTest.ftar.canBeExecuted(scc);
		RightHandlerTest.ftar.canBeExecuted(sdc);
	}

	/**
	 * Tests the methods which are in the RightHandler.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testTicketTypeAdminRightHandler() throws Exception {
		final TicketType receiver = RightHandlerTest.model.getTypeManager().getStandardFeatureType();
		final FieldType fieldtype = RightHandlerTest.model.getTypeManager().getFieldTypes().get(0);
		final StateType statetype = RightHandlerTest.model.getTypeManager().getStateTypes().get(0);
		final BugTicketTypeCreateCommand a = new BugTicketTypeCreateCommand("a", "aaa");
		final FeatureTicketTypeCreateCommand b = new FeatureTicketTypeCreateCommand("b", "bbb");
		final TaskTicketTypeCreateCommand c = new TaskTicketTypeCreateCommand("c", "ccc");
		final StateTypeCreateCommand d = new StateTypeCreateCommand("d", "ddd");
		final TicketTypeAddFieldTypeCommand e = new TicketTypeAddFieldTypeCommand(receiver, fieldtype);
		final TicketTypeAddStatetypeCommand f = new TicketTypeAddStatetypeCommand(receiver, statetype);

		RightHandlerTest.ttar.canBeExecuted(a);
		RightHandlerTest.ttar.canBeExecuted(b);
		RightHandlerTest.ttar.canBeExecuted(c);
		RightHandlerTest.ttar.canBeExecuted(d);
		RightHandlerTest.ttar.canBeExecuted(e);
		RightHandlerTest.ttar.canBeExecuted(f);
	}

	/**
	 * Tests the methods which are in the RightHandler.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testTeamAdminRightHandler() throws Exception {
		final TeamAddMemberCommand a = new TeamAddMemberCommand(RightHandlerTest.team, RightHandlerTest.person);
		final TeamCreateCommand b = new TeamCreateCommand("team2");
		final TeamRemoveMemberCommand c = new TeamRemoveMemberCommand(RightHandlerTest.team, RightHandlerTest.person);
		final TeamSetDescriptionCommand d = new TeamSetDescriptionCommand(RightHandlerTest.team, "Neue Beschr");
		final TeamAddProjectCommand e =
				new TeamAddProjectCommand(RightHandlerTest.team, new Project(RightHandlerTest.model, "projekt"));
		RightHandlerTest.tar.canBeExecuted(a);
		RightHandlerTest.tar.canBeExecuted(b);
		RightHandlerTest.tar.canBeExecuted(c);
		RightHandlerTest.tar.canBeExecuted(d);
		RightHandlerTest.tar.canBeExecuted(e);
	}

	/**
	 * Tests the methods which are in the RightHandler.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testTaskboardRightHandler() throws Exception {
		final TaskTicketType taskTicketType = RightHandlerTest.model.getTypeManager().getStandardTaskType();
		final Sprint sprint =
				new Sprint(RightHandlerTest.model, "Sprint", "Beschreibung", new Date(), new Date(),
						RightHandlerTest.team, RightHandlerTest.project);
		final SprintBacklog sprintbl = sprint.getSprintBacklog();
		final Task task = new Task(RightHandlerTest.model, taskTicketType, "asd", "das", sprintbl);
		final ProductBacklogItem pbi =
				new Feature(RightHandlerTest.model, new FeatureTicketType(RightHandlerTest.model, "Type", "TestType"),
						"A", "Test1", RightHandlerTest.project.getBacklog());

		final TaskAddPBICommand a = new TaskAddPBICommand(task, pbi);
		final TaskCreateCommand b = new TaskCreateCommand("Neuer Task", "bla", taskTicketType, sprintbl);
		final TaskDeleteCommand c = new TaskDeleteCommand(task);
		final TaskRemovePBICommand d = new TaskRemovePBICommand(task, pbi);
		final TaskSetPlanEffortCommand e = new TaskSetPlanEffortCommand(task, new Effort(1));
		final TaskSetResponsibilityCommand f = new TaskSetResponsibilityCommand(task, RightHandlerTest.person);

		RightHandlerTest.tr.canBeExecuted(a);
		RightHandlerTest.tr.canBeExecuted(b);
		RightHandlerTest.tr.canBeExecuted(c);
		RightHandlerTest.tr.canBeExecuted(d);
		RightHandlerTest.tr.canBeExecuted(e);
		RightHandlerTest.tr.canBeExecuted(f);
	}

	/**
	 * Tests the methods which are in the RightHandler.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testsRightHandler() throws Exception {
		// final a = new ;
		// RightHandlerTest.ttar.canBeExecuted(a);
	}

	/**
	 * Tests the method which is needed to get all rights.
	 */
	@Test
	public void test() {
		// RightHandlerTest.ftar;
		// RightHandlerTest.ttar;
		// RightHandlerTest.tar;
		// RightHandlerTest.prar;
		// RightHandlerTest.pbr;
		// RightHandlerTest.pr;
		// RightHandlerTest.phr;
		// RightHandlerTest.tr;
	}
}
