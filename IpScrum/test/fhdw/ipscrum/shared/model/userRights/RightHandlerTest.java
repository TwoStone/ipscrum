package fhdw.ipscrum.shared.model.userRights;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.shared.commands.admin.SystemCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.AcceptanceCriteriaFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.DateFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.EffortFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.HintFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.NumberFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.PBIFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.PersonFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.ReleaseFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.SprintFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.SystemFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.TextFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonRemoveRoleCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleAddRightCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleDeleteCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleRemoveRightCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleSetDescriptionCommand;
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
import fhdw.ipscrum.shared.commands.productBacklog.BugCreateCommand;
import fhdw.ipscrum.shared.commands.productBacklog.FeatureCreateCommand;
import fhdw.ipscrum.shared.commands.productBacklog.PBIAddRelationCommand;
import fhdw.ipscrum.shared.commands.productBacklog.PBIPriorityDecreaseCommand;
import fhdw.ipscrum.shared.commands.productBacklog.PBIPriorityIncreaseCommand;
import fhdw.ipscrum.shared.commands.productBacklog.PBIRemoveRelationCommand;
import fhdw.ipscrum.shared.commands.project.ProjectAddSystemCommand;
import fhdw.ipscrum.shared.commands.project.ProjectChangeNameCommand;
import fhdw.ipscrum.shared.commands.project.ProjectCreateCommand;
import fhdw.ipscrum.shared.commands.project.ProjectDeleteCommand;
import fhdw.ipscrum.shared.commands.project.ProjectRemoveSystemCommand;
import fhdw.ipscrum.shared.commands.project.ReleaseAddSprintCommand;
import fhdw.ipscrum.shared.commands.project.ReleaseCreateCommand;
import fhdw.ipscrum.shared.commands.project.ReleaseDeleteCommand;
import fhdw.ipscrum.shared.commands.project.ReleaseRemoveSprintCommand;
import fhdw.ipscrum.shared.commands.project.SprintChangeCommand;
import fhdw.ipscrum.shared.commands.project.SprintCreateCommand;
import fhdw.ipscrum.shared.commands.projectHistory.IncidentIllnessCreateCommand;
import fhdw.ipscrum.shared.commands.projectHistory.IncidentOtherIssueCreateCommand;
import fhdw.ipscrum.shared.commands.projectHistory.IncidentTypeCreateCommand;
import fhdw.ipscrum.shared.commands.projectHistory.IncidentVacationCreateCommand;
import fhdw.ipscrum.shared.commands.search.SearchCreateCommand;
import fhdw.ipscrum.shared.commands.search.SearchDeleteCommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskAddPBICommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskCreateCommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskDeleteCommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskRemovePBICommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskSetPlanEffortCommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskSetResponsibilityCommand;
import fhdw.ipscrum.shared.commands.ticketsGeneral.TicketChangeStateCommand;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.One;
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
import fhdw.ipscrum.shared.model.nonMeta.Relation;
import fhdw.ipscrum.shared.model.nonMeta.RelationType;
import fhdw.ipscrum.shared.model.nonMeta.Release;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.nonMeta.SprintBacklog;
import fhdw.ipscrum.shared.model.nonMeta.System;
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
	 * represents a sprint.
	 */
	private static Sprint sprint;
	/**
	 * Represents the role needed to use the IPScrum.
	 */
	private static Role role;
	/**
	 * Represents a release needed to use the IPScrum.
	 */
	private static Release release;
	/**
	 * Represents a pbi.
	 */
	private static ProductBacklogItem pbi;

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
		RightHandlerTest.role = new Role(RightHandlerTest.model, "Testrole");

		RightHandlerTest.project = new Project(RightHandlerTest.model, "Test");
		RightHandlerTest.team = new Team(RightHandlerTest.model, "team2");
		RightHandlerTest.person = new Person(RightHandlerTest.model, "bla", "blubb");
		RightHandlerTest.team.addProject(RightHandlerTest.project);
		RightHandlerTest.sprint =
				new Sprint(RightHandlerTest.model, "Sprint", "Beschreibung", new Date(), new Date(),
						RightHandlerTest.team, RightHandlerTest.project);
		RightHandlerTest.release =
				new Release(RightHandlerTest.model, "Testrelease", new Date(), RightHandlerTest.project);
		RightHandlerTest.pbi =
				new Feature(RightHandlerTest.model, new FeatureTicketType(RightHandlerTest.model, "Type", "TestType"),
						"A", "Test1", RightHandlerTest.project.getBacklog());

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
		RightHandlerTest.ftar.canBeExecuted(scc, RightHandlerTest.model);
		RightHandlerTest.ftar.canBeExecuted(sdc, RightHandlerTest.model);
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

		RightHandlerTest.ttar.canBeExecuted(a, RightHandlerTest.model);
		RightHandlerTest.ttar.canBeExecuted(b, RightHandlerTest.model);
		RightHandlerTest.ttar.canBeExecuted(c, RightHandlerTest.model);
		RightHandlerTest.ttar.canBeExecuted(d, RightHandlerTest.model);
		RightHandlerTest.ttar.canBeExecuted(e, RightHandlerTest.model);
		RightHandlerTest.ttar.canBeExecuted(f, RightHandlerTest.model);
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
		RightHandlerTest.tar.canBeExecuted(a, RightHandlerTest.model);
		RightHandlerTest.tar.canBeExecuted(b, RightHandlerTest.model);
		RightHandlerTest.tar.canBeExecuted(c, RightHandlerTest.model);
		RightHandlerTest.tar.canBeExecuted(d, RightHandlerTest.model);
		RightHandlerTest.tar.canBeExecuted(e, RightHandlerTest.model);
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
		final SprintBacklog sprintbl = RightHandlerTest.sprint.getSprintBacklog();
		final Task task = new Task(RightHandlerTest.model, taskTicketType, "asd", "das", sprintbl);

		final TaskAddPBICommand a = new TaskAddPBICommand(task, RightHandlerTest.pbi);
		final TaskCreateCommand b = new TaskCreateCommand("Neuer Task", "bla", taskTicketType, sprintbl);
		final TaskDeleteCommand c = new TaskDeleteCommand(task);
		final TaskRemovePBICommand d = new TaskRemovePBICommand(task, RightHandlerTest.pbi);
		final TaskSetPlanEffortCommand e = new TaskSetPlanEffortCommand(task, new Effort(1));
		final TaskSetResponsibilityCommand f = new TaskSetResponsibilityCommand(task, RightHandlerTest.person);

		RightHandlerTest.tr.canBeExecuted(a, RightHandlerTest.model);
		RightHandlerTest.tr.canBeExecuted(b, RightHandlerTest.model);
		RightHandlerTest.tr.canBeExecuted(c, RightHandlerTest.model);
		RightHandlerTest.tr.canBeExecuted(d, RightHandlerTest.model);
		RightHandlerTest.tr.canBeExecuted(e, RightHandlerTest.model);
		RightHandlerTest.tr.canBeExecuted(f, RightHandlerTest.model);
	}

	/**
	 * Tests the methods which are in the RightHandler.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testProjectRightHandler() throws Exception {
		final System system =
				new System(RightHandlerTest.model, "neues System", RightHandlerTest.model.getRootsystem());
		final Release release1 = new Release(RightHandlerTest.model, "asd", new Date(), RightHandlerTest.project);

		final ProjectAddSystemCommand a = new ProjectAddSystemCommand(RightHandlerTest.project, system);
		final ProjectChangeNameCommand b = new ProjectChangeNameCommand(RightHandlerTest.project, "neues Projekt");
		final ProjectCreateCommand c = new ProjectCreateCommand("Neueres Projekt");
		final ProjectDeleteCommand d = new ProjectDeleteCommand(RightHandlerTest.project);
		final ProjectRemoveSystemCommand e = new ProjectRemoveSystemCommand(RightHandlerTest.project, system);
		final ReleaseAddSprintCommand f = new ReleaseAddSprintCommand(release1, RightHandlerTest.sprint);
		final ReleaseCreateCommand g = new ReleaseCreateCommand(RightHandlerTest.project, "qawe", new Date());
		final ReleaseDeleteCommand h = new ReleaseDeleteCommand(release1);
		final ReleaseRemoveSprintCommand i = new ReleaseRemoveSprintCommand(release1, RightHandlerTest.sprint);
		final SprintChangeCommand j =
				new SprintChangeCommand(RightHandlerTest.sprint, "a", "c", new Date(), new Date(),
						RightHandlerTest.team);
		final SprintCreateCommand k =
				new SprintCreateCommand("", new Date(), new Date(), "b", RightHandlerTest.team,
						RightHandlerTest.project);
		final SystemCreateCommand l = new SystemCreateCommand("d", RightHandlerTest.model.getRootsystem());

		RightHandlerTest.pr.canBeExecuted(a, RightHandlerTest.model);
		RightHandlerTest.pr.canBeExecuted(b, RightHandlerTest.model);
		RightHandlerTest.pr.canBeExecuted(c, RightHandlerTest.model);
		RightHandlerTest.pr.canBeExecuted(d, RightHandlerTest.model);
		RightHandlerTest.pr.canBeExecuted(e, RightHandlerTest.model);
		RightHandlerTest.pr.canBeExecuted(f, RightHandlerTest.model);
		RightHandlerTest.pr.canBeExecuted(g, RightHandlerTest.model);
		RightHandlerTest.pr.canBeExecuted(h, RightHandlerTest.model);
		RightHandlerTest.pr.canBeExecuted(i, RightHandlerTest.model);
		RightHandlerTest.pr.canBeExecuted(j, RightHandlerTest.model);
		RightHandlerTest.pr.canBeExecuted(k, RightHandlerTest.model);
		RightHandlerTest.pr.canBeExecuted(l, RightHandlerTest.model);

	}

	/**
	 * Tests the methods which are in the RightHandler.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testProjectHistoryRightHandler() throws Exception {
		final List<Person> persons = new ArrayList<Person>();
		final List<Project> projects = new ArrayList<Project>();
		persons.add(RightHandlerTest.person);
		projects.add(RightHandlerTest.project);
		final IncidentIllnessCreateCommand a =
				new IncidentIllnessCreateCommand(new Date(), new Date(), RightHandlerTest.person);
		final IncidentOtherIssueCreateCommand b =
				new IncidentOtherIssueCreateCommand(new Date(), new Date(), "", "", persons, projects);
		final IncidentTypeCreateCommand c = new IncidentTypeCreateCommand("Neuer Typ");
		final IncidentVacationCreateCommand d =
				new IncidentVacationCreateCommand(new Date(), new Date(), RightHandlerTest.person);

		RightHandlerTest.phr.canBeExecuted(a, RightHandlerTest.model);
		RightHandlerTest.phr.canBeExecuted(b, RightHandlerTest.model);
		RightHandlerTest.phr.canBeExecuted(c, RightHandlerTest.model);
		RightHandlerTest.phr.canBeExecuted(d, RightHandlerTest.model);
	}

	/**
	 * Tests the methods which are in the RightHandler.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testPersonRoleAdminRightHandler() throws Exception {
		final PersonRemoveRoleCommand a = new PersonRemoveRoleCommand(RightHandlerTest.person, RightHandlerTest.role);
		final PersonRemoveRoleCommand b = new PersonRemoveRoleCommand(RightHandlerTest.person, RightHandlerTest.role);
		final RoleDeleteCommand c = new RoleDeleteCommand(RightHandlerTest.role);
		final RoleSetDescriptionCommand d = new RoleSetDescriptionCommand(RightHandlerTest.role, "neue beschr");
		final RoleAddRightCommand e = new RoleAddRightCommand(RightHandlerTest.role, RightHandlerTest.ftar);
		final RoleRemoveRightCommand f = new RoleRemoveRightCommand(RightHandlerTest.role, RightHandlerTest.ftar);

		RightHandlerTest.prar.canBeExecuted(a, RightHandlerTest.model);
		RightHandlerTest.prar.canBeExecuted(b, RightHandlerTest.model);
		RightHandlerTest.prar.canBeExecuted(c, RightHandlerTest.model);
		RightHandlerTest.prar.canBeExecuted(d, RightHandlerTest.model);
		RightHandlerTest.prar.canBeExecuted(e, RightHandlerTest.model);
		RightHandlerTest.prar.canBeExecuted(f, RightHandlerTest.model);
	}

	/**
	 * Tests the methods which are in the RightHandler.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testPBLRightHandler() throws Exception {
		final Relation relation =
				new Relation(RightHandlerTest.model, new RelationType(RightHandlerTest.model, "Relationstyp"),
						RightHandlerTest.pbi);
		final BugCreateCommand a =
				new BugCreateCommand("asdasdasd", "aaa", RightHandlerTest.model.getTypeManager().getStandardBugType(),
						RightHandlerTest.project.getBacklog(), RightHandlerTest.release);
		final FeatureCreateCommand b =
				new FeatureCreateCommand("", "", RightHandlerTest.model.getTypeManager().getStandardFeatureType(),
						RightHandlerTest.project.getBacklog());
		final PBIAddRelationCommand c = new PBIAddRelationCommand(RightHandlerTest.pbi, relation);
		final PBIPriorityDecreaseCommand d = new PBIPriorityDecreaseCommand(RightHandlerTest.pbi);
		final PBIPriorityIncreaseCommand e = new PBIPriorityIncreaseCommand(RightHandlerTest.pbi);
		final PBIRemoveRelationCommand f = new PBIRemoveRelationCommand(RightHandlerTest.pbi, relation);
		final TicketChangeStateCommand g =
				new TicketChangeStateCommand(RightHandlerTest.pbi, RightHandlerTest.model.getTypeManager()
						.getInProcess());

		RightHandlerTest.pbr.canBeExecuted(a, RightHandlerTest.model);
		RightHandlerTest.pbr.canBeExecuted(b, RightHandlerTest.model);
		RightHandlerTest.pbr.canBeExecuted(c, RightHandlerTest.model);
		RightHandlerTest.pbr.canBeExecuted(d, RightHandlerTest.model);
		RightHandlerTest.pbr.canBeExecuted(e, RightHandlerTest.model);
		RightHandlerTest.pbr.canBeExecuted(f, RightHandlerTest.model);
		RightHandlerTest.pbr.canBeExecuted(g, RightHandlerTest.model);
	}

	/**
	 * Tests the methods which are in the RightHandler.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testFieldTypeAdminRightHandler() throws Exception {
		final AcceptanceCriteriaFieldTypeCreateCommand a =
				new AcceptanceCriteriaFieldTypeCreateCommand("absda", new One(RightHandlerTest.model));
		final DateFieldTypeCreateCommand b = new DateFieldTypeCreateCommand("asdasd", new One(RightHandlerTest.model));
		final EffortFieldTypeCreateCommand c =
				new EffortFieldTypeCreateCommand("asda", new One(RightHandlerTest.model));
		final HintFieldTypeCreateCommand d = new HintFieldTypeCreateCommand("kjasd", new One(RightHandlerTest.model));
		final NumberFieldTypeCreateCommand e =
				new NumberFieldTypeCreateCommand("hjsh", new One(RightHandlerTest.model));
		final PBIFieldTypeCreateCommand f = new PBIFieldTypeCreateCommand("lkajsld", new One(RightHandlerTest.model));
		final PersonFieldTypeCreateCommand g =
				new PersonFieldTypeCreateCommand("usjdn", new One(RightHandlerTest.model));
		final ReleaseFieldTypeCreateCommand h =
				new ReleaseFieldTypeCreateCommand("udjfj", new One(RightHandlerTest.model));
		final SprintFieldTypeCreateCommand i =
				new SprintFieldTypeCreateCommand("iuhsfn", new One(RightHandlerTest.model));
		final SystemFieldTypeCreateCommand j =
				new SystemFieldTypeCreateCommand("aushd", new One(RightHandlerTest.model));
		final TextFieldTypeCreateCommand k = new TextFieldTypeCreateCommand("uajsdn", new One(RightHandlerTest.model));

		RightHandlerTest.ftar.canBeExecuted(a, RightHandlerTest.model);
		RightHandlerTest.ftar.canBeExecuted(b, RightHandlerTest.model);
		RightHandlerTest.ftar.canBeExecuted(c, RightHandlerTest.model);
		RightHandlerTest.ftar.canBeExecuted(d, RightHandlerTest.model);
		RightHandlerTest.ftar.canBeExecuted(e, RightHandlerTest.model);
		RightHandlerTest.ftar.canBeExecuted(f, RightHandlerTest.model);
		RightHandlerTest.ftar.canBeExecuted(g, RightHandlerTest.model);
		RightHandlerTest.ftar.canBeExecuted(h, RightHandlerTest.model);
		RightHandlerTest.ftar.canBeExecuted(i, RightHandlerTest.model);
		RightHandlerTest.ftar.canBeExecuted(j, RightHandlerTest.model);
		RightHandlerTest.ftar.canBeExecuted(k, RightHandlerTest.model);
	}
}
