package fhdw.ipscrum.shared.model.userRights;

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
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;
import fhdw.ipscrum.shared.model.metamodel.search.And;
import fhdw.ipscrum.shared.model.metamodel.search.Search;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Project;
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
		final Team team = new Team(RightHandlerTest.model, "team1");
		final Person person = new Person(RightHandlerTest.model, "bla", "blubb");
		final TeamAddMemberCommand a = new TeamAddMemberCommand(team, person);
		final TeamCreateCommand b = new TeamCreateCommand("team2");
		final TeamRemoveMemberCommand c = new TeamRemoveMemberCommand(team, person);
		final TeamSetDescriptionCommand d = new TeamSetDescriptionCommand(team, "Neue Beschr");
		final TeamAddProjectCommand e = new TeamAddProjectCommand(team, new Project(RightHandlerTest.model, "projekt"));
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
