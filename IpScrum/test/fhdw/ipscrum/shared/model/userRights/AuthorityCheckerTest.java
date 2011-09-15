/**
 * 
 */
package fhdw.ipscrum.shared.model.userRights;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.AcceptanceCriteriaFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonChangeNameCommand;
import fhdw.ipscrum.shared.commands.admin.teamAdministration.TeamAddMemberCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.BugTicketTypeCreateCommand;
import fhdw.ipscrum.shared.commands.productBacklog.BugCreateCommand;
import fhdw.ipscrum.shared.commands.project.ProjectChangeNameCommand;
import fhdw.ipscrum.shared.commands.projectHistory.IncidentIllnessCreateCommand;
import fhdw.ipscrum.shared.commands.taskboard.TaskCreateCommand;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.BugTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TaskTicketType;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Release;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * 
 */
public class AuthorityCheckerTest {
	private static ServerContext serverContext;
	private static Model model;
	private static Project project;
	private static Project projectnamechange;
	private static Team team;
	private static Person person;
	private static Person person2;
	private static Role role1;
	private static Role role2;
	private static PersonChangeNameCommand percnc;
	private static PersonRoleAdminRight prar;
	private static BugCreateCommand bcc;
	private static ProductBacklogRight pbr;
	private static ProjectChangeNameCommand procnc;
	private static ProjectRight pr;
	private static TaskCreateCommand tcc;
	private static TaskboardRight tr;
	private static TeamAddMemberCommand tamc;
	private static TeamAdminRight tar;
	private static FieldTypeAdminRight ftar;
	private static AcceptanceCriteriaFieldTypeCreateCommand acftcc;
	private static ProjectHistoryRight phr;
	private static IncidentIllnessCreateCommand iicc;
	private static TicketTypeAdminRight ttar;
	private static BugTicketTypeCreateCommand bttcc;
	private static Release release;
	private static BugTicketType bt;
	private static TaskTicketType ttt;
	private static AuthorityChecker checker;
	private static Sprint sprint;

	/**
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// SetUp
		AuthorityCheckerTest.serverContext = ServerContext.getInstance();
		AuthorityCheckerTest.model =
				AuthorityCheckerTest.serverContext.getPersistenceManager()
						.getModelForTesting();
		AuthorityCheckerTest.model.setUuidManager(new IDGenerator());
		AuthorityCheckerTest.checker = new AuthorityChecker(AuthorityCheckerTest.model);

		// Projekte
		AuthorityCheckerTest.project =
				new Project(AuthorityCheckerTest.model, "Testprojekt");
		AuthorityCheckerTest.projectnamechange =
				new Project(AuthorityCheckerTest.model, "Projekt Namensänderung");
		AuthorityCheckerTest.release =
				new Release(AuthorityCheckerTest.model, "Testrelease", new Date(),
						AuthorityCheckerTest.project);
		AuthorityCheckerTest.bt =
				new BugTicketType(AuthorityCheckerTest.model, "BugType1",
						"BugTicketType1");
		AuthorityCheckerTest.ttt =
				new TaskTicketType(AuthorityCheckerTest.model, "TaskType",
						"TaskTicketType");

		// Personen und Teams
		AuthorityCheckerTest.person =
				new Person(AuthorityCheckerTest.model, "Max", "Mustermann");
		AuthorityCheckerTest.person2 =
				new Person(AuthorityCheckerTest.model, "Maxima", "Mustermania");
		AuthorityCheckerTest.team = new Team(AuthorityCheckerTest.model, "Testteam");
		AuthorityCheckerTest.team.addProject(AuthorityCheckerTest.project);
		AuthorityCheckerTest.team.addProject(AuthorityCheckerTest.projectnamechange);
		AuthorityCheckerTest.team.addMember(AuthorityCheckerTest.person);
		AuthorityCheckerTest.team.addMember(AuthorityCheckerTest.person2);
		AuthorityCheckerTest.sprint =
				new Sprint(AuthorityCheckerTest.model, "Sprint", "Testsprint",
						new Date(), new Date(), AuthorityCheckerTest.team,
						AuthorityCheckerTest.project);

		// Rechte
		AuthorityCheckerTest.tar = new TeamAdminRight(AuthorityCheckerTest.model);
		AuthorityCheckerTest.prar =
				new PersonRoleAdminRight(AuthorityCheckerTest.model);
		AuthorityCheckerTest.pbr = new ProductBacklogRight(AuthorityCheckerTest.model);
		AuthorityCheckerTest.pr = new ProjectRight(AuthorityCheckerTest.model);
		AuthorityCheckerTest.tr = new TaskboardRight(AuthorityCheckerTest.model);
		AuthorityCheckerTest.ftar = new FieldTypeAdminRight(AuthorityCheckerTest.model);
		AuthorityCheckerTest.phr = new ProjectHistoryRight(AuthorityCheckerTest.model);
		AuthorityCheckerTest.ttar =
				new TicketTypeAdminRight(AuthorityCheckerTest.model);

		// Commands
		AuthorityCheckerTest.percnc =
				new PersonChangeNameCommand(AuthorityCheckerTest.person2, "Olivia",
						"Mustermania");
		AuthorityCheckerTest.bcc =
				new BugCreateCommand("Bug", "TestBug", AuthorityCheckerTest.bt,
						AuthorityCheckerTest.project.getBacklog(),
						AuthorityCheckerTest.release);
		AuthorityCheckerTest.tamc =
				new TeamAddMemberCommand(AuthorityCheckerTest.team,
						AuthorityCheckerTest.person);
		AuthorityCheckerTest.procnc =
				new ProjectChangeNameCommand(AuthorityCheckerTest.projectnamechange,
						"geänderter Name");
		AuthorityCheckerTest.tcc =
				new TaskCreateCommand("TaskCreate", "TaskCreateCommand",
						AuthorityCheckerTest.ttt,
						AuthorityCheckerTest.sprint.getSprintBacklog());
		AuthorityCheckerTest.acftcc =
				new AcceptanceCriteriaFieldTypeCreateCommand("Akzeptanz",
						AuthorityCheckerTest.model.getTypeManager().getMany());

		AuthorityCheckerTest.iicc =
				new IncidentIllnessCreateCommand(new Date(), new Date(),
						AuthorityCheckerTest.person2);
		AuthorityCheckerTest.bttcc =
				new BugTicketTypeCreateCommand("BugType2", "BugTicketType2");

		// Rollen
		AuthorityCheckerTest.role1 = new Role(AuthorityCheckerTest.model, "Testrole1");
		AuthorityCheckerTest.role1.addRight(AuthorityCheckerTest.tar);
		AuthorityCheckerTest.role1.addRight(AuthorityCheckerTest.pbr);
		AuthorityCheckerTest.role1.addRight(AuthorityCheckerTest.pr);
		AuthorityCheckerTest.role1.addRight(AuthorityCheckerTest.prar);
		AuthorityCheckerTest.role1.addRight(AuthorityCheckerTest.tr);
		AuthorityCheckerTest.role1.addRight(AuthorityCheckerTest.phr);
		AuthorityCheckerTest.role1.addRight(AuthorityCheckerTest.ftar);
		AuthorityCheckerTest.role1.addRight(AuthorityCheckerTest.ttar);
		AuthorityCheckerTest.person.addRole(AuthorityCheckerTest.role1);
		AuthorityCheckerTest.role2 = new Role(AuthorityCheckerTest.model, "Testrole2");
		AuthorityCheckerTest.person2.addRole(AuthorityCheckerTest.role2);

	}

	/**
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * .
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testCanBeExecuted1() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.tamc,
				AuthorityCheckerTest.role1);
		Assert.assertTrue(AuthorityCheckerTest.checker.isAllowed());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * . * @throws Exception if one of the used methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException.class)
	public
			void testCanBeExecuted2() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.tamc,
				AuthorityCheckerTest.role2);

	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * . * @throws Exception if one of the used methods fails
	 */
	@Test
	public void testCanBeExecuted3() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.percnc,
				AuthorityCheckerTest.role1);
		Assert.assertTrue(AuthorityCheckerTest.checker.isAllowed());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * . * @throws Exception if one of the used methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException.class)
	public
			void testCanBeExecuted4() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.percnc,
				AuthorityCheckerTest.role2);

	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * . * @throws Exception if one of the used methods fails
	 */
	@Test
	public void testCanBeExecuted5() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.bcc,
				AuthorityCheckerTest.role1);
		Assert.assertTrue(AuthorityCheckerTest.checker.isAllowed());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * . * @throws Exception if one of the used methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException.class)
	public
			void testCanBeExecuted6() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.bcc,
				AuthorityCheckerTest.role2);

	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * . * @throws Exception if one of the used methods fails
	 */
	@Test
	public void testCanBeExecuted7() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.procnc,
				AuthorityCheckerTest.role1);
		Assert.assertTrue(AuthorityCheckerTest.checker.isAllowed());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * . * @throws Exception if one of the used methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException.class)
	public
			void testCanBeExecuted8() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.procnc,
				AuthorityCheckerTest.role2);

	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * . * @throws Exception if one of the used methods fails
	 */
	@Test
	public void testCanBeExecuted9() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.tcc,
				AuthorityCheckerTest.role1);
		Assert.assertTrue(AuthorityCheckerTest.checker.isAllowed());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * . * @throws Exception if one of the used methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException.class)
	public
			void testCanBeExecuted10() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.tcc,
				AuthorityCheckerTest.role2);

	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * .
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testCanBeExecuted11() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.acftcc,
				AuthorityCheckerTest.role1);
		Assert.assertTrue(AuthorityCheckerTest.checker.isAllowed());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * .
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException.class)
	public
			void testCanBeExecuted12() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.acftcc,
				AuthorityCheckerTest.role2);

	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * .
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testCanBeExecuted13() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.iicc,
				AuthorityCheckerTest.role1);
		Assert.assertTrue(AuthorityCheckerTest.checker.isAllowed());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * .
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException.class)
	public
			void testCanBeExecuted14() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.iicc,
				AuthorityCheckerTest.role2);

	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * .
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testCanBeExecuted15() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.bttcc,
				AuthorityCheckerTest.role1);
		Assert.assertTrue(AuthorityCheckerTest.checker.isAllowed());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * .
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException.class)
	public
			void testCanBeExecuted16() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.bttcc,
				AuthorityCheckerTest.role2);

	}

}
