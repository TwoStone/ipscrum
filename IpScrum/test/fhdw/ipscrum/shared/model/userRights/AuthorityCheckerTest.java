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
	/**
	 * Represents the serverContext needed to use the IPScrum.
	 */
	private static ServerContext serverContext;
	/**
	 * Represents the model needed to use the IPScrum.
	 */
	private static Model model;
	/**
	 * Represents a project needed to use the IPScrum.
	 */
	private static Project project;
	/**
	 * Represents a project needed to use the IPScrum.
	 */
	private static Project projectnamechange;
	/**
	 * Represents a team needed to use the IPScrum.
	 */
	private static Team team;
	/**
	 * Represents a person needed to use the IPScrum.
	 */
	private static Person person;
	/**
	 * Represents a person needed to use the IPScrum.
	 */
	private static Person person2;
	/**
	 * Represents a role needed to use the IPScrum.
	 */
	private static Role role1;
	/**
	 * Represents a role needed to use the IPScrum.
	 */
	private static Role role2;
	/**
	 * Represents the PersonChangeNameCommand needed to use the IPScrum.
	 */
	private static PersonChangeNameCommand percnc;
	/**
	 * Represents the PersonRoleAdminRight needed to use the IPScrum.
	 */
	private static PersonRoleAdminRight prar;
	/**
	 * Represents the BugCreateCommand needed to use the IPScrum.
	 */
	private static BugCreateCommand bcc;
	/**
	 * Represents the ProductBacklogRight needed to use the IPScrum.
	 */
	private static ProductBacklogRight pbr;
	/**
	 * Represents the ProjectChangeNameCommand needed to use the IPScrum.
	 */
	private static ProjectChangeNameCommand procnc;
	/**
	 * Represents the ProjectRight needed to use the IPScrum.
	 */
	private static ProjectRight pr;
	/**
	 * Represents the TaskCreateCommand needed to use the IPScrum.
	 */
	private static TaskCreateCommand tcc;
	/**
	 * Represents the TaskboardRight needed to use the IPScrum.
	 */
	private static TaskboardRight tr;
	/**
	 * Represents the TeamAddMemberCommand needed to use the IPScrum.
	 */
	private static TeamAddMemberCommand tamc;
	/**
	 * Represents the TeamAdminRight needed to use the IPScrum.
	 */
	private static TeamAdminRight tar;
	/**
	 * Represents the FieldTypeAdminRight needed to use the IPScrum.
	 */
	private static FieldTypeAdminRight ftar;
	/**
	 * Represents the AcceptanceCriteriaFieldTypeCommand needed to use the IPScrum.
	 */
	private static AcceptanceCriteriaFieldTypeCreateCommand acftcc;
	/**
	 * Represents the ProjectHistoryRight needed to use the IPScrum.
	 */
	private static ProjectHistoryRight phr;
	/**
	 * Represents the IncidentIllnesCreateCommand needed to use the IPScrum.
	 */
	private static IncidentIllnessCreateCommand iicc;
	/**
	 * Represents the TicketTypeAdminRight needed to use the IPScrum.
	 */
	private static TicketTypeAdminRight ttar;
	/**
	 * Represents the BugTicketTypeCreateCommand needed to use the IPScrum.
	 */
	private static BugTicketTypeCreateCommand bttcc;
	/**
	 * Represents a release needed to use the IPScrum.
	 */
	private static Release release;
	/**
	 * Represents the BugTicketType needed to use the IPScrum.
	 */
	private static BugTicketType bt;
	/**
	 * Represents the TaskTicketType needed to use the IPScrum.
	 */
	private static TaskTicketType ttt;
	/**
	 * Represents the AuthorityChecker needed to use the IPScrum.
	 */
	private static AuthorityChecker checker;
	/**
	 * Represents a sprint needed to use the IPScrum.
	 */
	private static Sprint sprint;

	/**
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// SetUp
		AuthorityCheckerTest.serverContext = ServerContext.getInstance();
		AuthorityCheckerTest.model = AuthorityCheckerTest.serverContext.getPersistenceManager().getModelForTesting();
		AuthorityCheckerTest.model.setUuidManager(new IDGenerator());
		AuthorityCheckerTest.checker = new AuthorityChecker(AuthorityCheckerTest.model);

		// Projekte
		AuthorityCheckerTest.project = new Project(AuthorityCheckerTest.model, "Testprojekt");
		AuthorityCheckerTest.projectnamechange = new Project(AuthorityCheckerTest.model, "Projekt Namensänderung");
		AuthorityCheckerTest.release =
				new Release(AuthorityCheckerTest.model, "Testrelease", new Date(), AuthorityCheckerTest.project);
		AuthorityCheckerTest.bt = new BugTicketType(AuthorityCheckerTest.model, "BugType1", "BugTicketType1");
		AuthorityCheckerTest.ttt = new TaskTicketType(AuthorityCheckerTest.model, "TaskType", "TaskTicketType");

		// Personen und Teams
		AuthorityCheckerTest.person = new Person(AuthorityCheckerTest.model, "Max", "Mustermann");
		AuthorityCheckerTest.person2 = new Person(AuthorityCheckerTest.model, "Maxima", "Mustermania");
		AuthorityCheckerTest.team = new Team(AuthorityCheckerTest.model, "Testteam");
		AuthorityCheckerTest.team.addProject(AuthorityCheckerTest.project);
		AuthorityCheckerTest.team.addProject(AuthorityCheckerTest.projectnamechange);
		AuthorityCheckerTest.team.addMember(AuthorityCheckerTest.person);
		AuthorityCheckerTest.team.addMember(AuthorityCheckerTest.person2);
		AuthorityCheckerTest.sprint =
				new Sprint(AuthorityCheckerTest.model, "Sprint", "Testsprint", new Date(), new Date(),
						AuthorityCheckerTest.team, AuthorityCheckerTest.project);

		// Rechte
		AuthorityCheckerTest.tar = new TeamAdminRight(AuthorityCheckerTest.model);
		AuthorityCheckerTest.prar = new PersonRoleAdminRight(AuthorityCheckerTest.model);
		AuthorityCheckerTest.pbr = new ProductBacklogRight(AuthorityCheckerTest.model);
		AuthorityCheckerTest.pr = new ProjectRight(AuthorityCheckerTest.model);
		AuthorityCheckerTest.tr = new TaskboardRight(AuthorityCheckerTest.model);
		AuthorityCheckerTest.ftar = new FieldTypeAdminRight(AuthorityCheckerTest.model);
		AuthorityCheckerTest.phr = new ProjectHistoryRight(AuthorityCheckerTest.model);
		AuthorityCheckerTest.ttar = new TicketTypeAdminRight(AuthorityCheckerTest.model);

		// Commands
		AuthorityCheckerTest.percnc =
				new PersonChangeNameCommand(AuthorityCheckerTest.person2, "Olivia", "Mustermania");
		AuthorityCheckerTest.bcc =
				new BugCreateCommand("Bug", "TestBug", AuthorityCheckerTest.bt,
						AuthorityCheckerTest.project.getBacklog(), AuthorityCheckerTest.release);
		AuthorityCheckerTest.tamc = new TeamAddMemberCommand(AuthorityCheckerTest.team, AuthorityCheckerTest.person);
		AuthorityCheckerTest.procnc =
				new ProjectChangeNameCommand(AuthorityCheckerTest.projectnamechange, "geänderter Name");
		AuthorityCheckerTest.tcc =
				new TaskCreateCommand("TaskCreate", "TaskCreateCommand", AuthorityCheckerTest.ttt,
						AuthorityCheckerTest.sprint.getSprintBacklog());
		AuthorityCheckerTest.acftcc =
				new AcceptanceCriteriaFieldTypeCreateCommand("Akzeptanz", AuthorityCheckerTest.model.getTypeManager()
						.getMany());

		AuthorityCheckerTest.iicc =
				new IncidentIllnessCreateCommand(new Date(), new Date(), AuthorityCheckerTest.person2);
		AuthorityCheckerTest.bttcc = new BugTicketTypeCreateCommand("BugType2", "BugTicketType2");

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
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.tamc, AuthorityCheckerTest.role1);
		Assert.assertTrue(AuthorityCheckerTest.checker.isAllowed());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * . * @throws Exception if one of the used methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException.class)
	public void testCanBeExecuted2() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.tamc, AuthorityCheckerTest.role2);

	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * . * @throws Exception if one of the used methods fails
	 */
	@Test
	public void testCanBeExecuted3() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.percnc, AuthorityCheckerTest.role1);
		Assert.assertTrue(AuthorityCheckerTest.checker.isAllowed());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * . * @throws Exception if one of the used methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException.class)
	public void testCanBeExecuted4() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.percnc, AuthorityCheckerTest.role2);

	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * . * @throws Exception if one of the used methods fails
	 */
	@Test
	public void testCanBeExecuted5() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.bcc, AuthorityCheckerTest.role1);
		Assert.assertTrue(AuthorityCheckerTest.checker.isAllowed());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * . * @throws Exception if one of the used methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException.class)
	public void testCanBeExecuted6() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.bcc, AuthorityCheckerTest.role2);

	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * . * @throws Exception if one of the used methods fails
	 */
	@Test
	public void testCanBeExecuted7() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.procnc, AuthorityCheckerTest.role1);
		Assert.assertTrue(AuthorityCheckerTest.checker.isAllowed());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * . * @throws Exception if one of the used methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException.class)
	public void testCanBeExecuted8() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.procnc, AuthorityCheckerTest.role2);

	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * . * @throws Exception if one of the used methods fails
	 */
	@Test
	public void testCanBeExecuted9() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.tcc, AuthorityCheckerTest.role1);
		Assert.assertTrue(AuthorityCheckerTest.checker.isAllowed());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.model.userRights.AuthorityChecker#canBeExecuted(fhdw.ipscrum.shared.commands.interfaces.ICommand, fhdw.ipscrum.shared.model.nonMeta.Person)}
	 * . * @throws Exception if one of the used methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.infrastructure.NotAuthorizedException.class)
	public void testCanBeExecuted10() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.tcc, AuthorityCheckerTest.role2);

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
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.acftcc, AuthorityCheckerTest.role1);
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
	public void testCanBeExecuted12() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.acftcc, AuthorityCheckerTest.role2);

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
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.iicc, AuthorityCheckerTest.role1);
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
	public void testCanBeExecuted14() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.iicc, AuthorityCheckerTest.role2);

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
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.bttcc, AuthorityCheckerTest.role1);
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
	public void testCanBeExecuted16() throws Exception {
		AuthorityCheckerTest.checker.canBeExecuted(AuthorityCheckerTest.bttcc, AuthorityCheckerTest.role2);

	}

}
