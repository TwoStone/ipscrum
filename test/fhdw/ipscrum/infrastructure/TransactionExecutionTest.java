package fhdw.ipscrum.infrastructure;

import java.io.File;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.TestUtils;
import fhdw.ipscrum.server.persistence.IPersistenceManager;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonAddRoleCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonChangeNameCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonCreateCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleCreateCommand;
import fhdw.ipscrum.shared.commands.project.ProjectCreateCommand;
import fhdw.ipscrum.shared.commands.project.ReleaseCreateCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.InfrastructureException;
import fhdw.ipscrum.shared.infrastructure.Transaction;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.model.nonMeta.Team;
import fhdw.ipscrum.shared.utils.ClassUtils;

/**
 * Incremental Testing! With each test case the data in Model will grow.
 * 
 * @author patrick
 * 
 */
public class TransactionExecutionTest {

	/**
	 * represents the model which is needed to use the IPScrum.
	 */
	private Model modelClient;
	/**
	 * represents the server context which is needed to use the IPScrum.
	 */
	private ServerContext serverContext;
	/**
	 * represents the persistence manager which is needed to use the IPScrum.
	 */
	private IPersistenceManager persistenceManager;

	// DemoData
	/**
	 * represents a person in the test, needed to test something.
	 */
	private String basePerson1; // Role 1
	/**
	 * represents a person in the test, needed to test something.
	 */
	private String basePerson2; // Role 1 and 2
	/**
	 * represents a person in the test, needed to test something.
	 */
	private String basePerson3; // Role 3
	/**
	 * represents a role in the test, needed to test something.
	 */
	private String baseRole1; // Role 3
	/**
	 * represents a role in the test, needed to test something.
	 */
	private String baseRole2; // Role 3
	/**
	 * represents a role in the test, needed to test something.
	 */
	private String baseRole3; // Role 3
	/**
	 * role with all authorizations for ip scrum. (for testing)
	 */
	private Role masterRole;

	/**
	 * Sets up the data before every test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Before
	public void setUp() throws Exception {
		TestUtils.deleteFolderContent(new File("output"));

		ServerContext.resetServerContext();
		this.serverContext = ServerContext.getInstance();
		this.persistenceManager = this.serverContext.getPersistenceManager();
		this.modelClient = this.persistenceManager.getCurrentModel();
		this.masterRole = this.modelClient.getRightManager().getMasterRole();

		this.modelClient.setUuidManager(new IDGenerator());

		// Initial Data
		final PersonCreateCommand c1 = new PersonCreateCommand("p1", "lastname1");
		final PersonCreateCommand c2 = new PersonCreateCommand("p2", "lastname2");
		final PersonCreateCommand c3 = new PersonCreateCommand("p3", "lastname3");
		final RoleCreateCommand c4 = new RoleCreateCommand("R1");
		final RoleCreateCommand c5 = new RoleCreateCommand("R2");
		final RoleCreateCommand c6 = new RoleCreateCommand("R3");
		c1.execute(this.modelClient);
		c2.execute(this.modelClient);
		c3.execute(this.modelClient);
		c4.execute(this.modelClient);
		c5.execute(this.modelClient);
		c6.execute(this.modelClient);
		this.basePerson1 = c1.getResult().getId();
		this.basePerson2 = c2.getResult().getId();
		this.basePerson3 = c3.getResult().getId();
		this.baseRole1 = c4.getResult().getId();
		this.baseRole2 = c5.getResult().getId();
		this.baseRole3 = c6.getResult().getId();

		final PersonAddRoleCommand c7 = new PersonAddRoleCommand(c1.getResult(), c4.getResult());
		final PersonAddRoleCommand c8 = new PersonAddRoleCommand(c2.getResult(), c4.getResult());
		final PersonAddRoleCommand c9 = new PersonAddRoleCommand(c2.getResult(), c5.getResult());
		final PersonAddRoleCommand c10 = new PersonAddRoleCommand(c3.getResult(), c6.getResult());

		final Transaction t =
				new Transaction(this.modelClient.getRevisionDate(), c1.getResult(), this.masterRole, this.modelClient
						.getUuidManager().getAllUUIDs());
		t.addCommand(c1);
		t.addCommand(c2);
		t.addCommand(c3);
		t.addCommand(c4);
		t.addCommand(c5);
		t.addCommand(c6);
		t.addCommand(c7);
		t.addCommand(c8);
		t.addCommand(c9);
		t.addCommand(c10);
		this.serverContext.getExecutionController().commitTransaction(t);

		this.modelClient = this.persistenceManager.getModelForTesting();
		this.modelClient.setUuidManager(new IDGenerator());
	}

	/**
	 * Testing DemoData creation!
	 * 
	 * @throws InfrastructureException
	 *             if something in the infrastructure went wrong
	 */
	@Test
	public void test01() throws InfrastructureException {
		Assert.assertEquals(4, this.modelClient.getAllPersons().size());
		Assert.assertEquals(7, this.modelClient.getAllRoles().size());
		Assert.assertTrue(this.modelClient.getAllPersons().contains(this.modelClient.getObject(this.basePerson1)));
		Assert.assertTrue(this.modelClient.getAllPersons().contains(this.modelClient.getObject(this.basePerson2)));
		Assert.assertTrue(this.modelClient.getAllPersons().contains(this.modelClient.getObject(this.basePerson3)));
		Assert.assertTrue(this.modelClient.getAllRoles().contains(this.modelClient.getObject(this.baseRole1)));
		Assert.assertTrue(this.modelClient.getAllRoles().contains(this.modelClient.getObject(this.baseRole2)));
		Assert.assertTrue(this.modelClient.getAllRoles().contains(this.modelClient.getObject(this.baseRole3)));
		Assert.assertEquals(this.modelClient.getRevisionDate(), this.persistenceManager.getModelForTesting()
				.getRevisionDate());

		Assert.assertTrue(this.modelClient.getAdminPerson() != null);
		Assert.assertEquals("Administrator", this.modelClient.getAdminPerson().getFirstname());
		Assert.assertEquals("Administrator", this.modelClient.getAdminPerson().getLastname());

	}

	/**
	 * Testing Model difference.
	 * 
	 * * @throws InfrastructureException if a transaction is interrupted
	 */
	@Test
	public void test02() throws InfrastructureException {
		Assert.assertEquals(this.modelClient, this.persistenceManager.getModelForTesting());
	}

	/**
	 * Testing Model difference.
	 * 
	 * @throws IPScrumGeneralException
	 *             if the use of one of the methods fails
	 */
	@Test
	public void test03() throws IPScrumGeneralException {
		final Model model = this.persistenceManager.copyCurrentModel();
		new PersonCreateCommand("Tester", "Tester").execute(model);

		Assert.assertFalse(this.modelClient.equals(model));
	}

	/**
	 * Testing Model difference.
	 * 
	 * Notice: A New Person will add to model
	 * 
	 * @throws IPScrumGeneralException
	 *             if something fails
	 * @throws InterruptedException
	 *             if the transaction is interrupted
	 */
	@Test
	public void test04() throws IPScrumGeneralException, InterruptedException {
		Assert.assertTrue(this.modelClient.getAllPersons().size() == 4);

		final PersonCreateCommand c1 = new PersonCreateCommand("Tester", "Tester");
		c1.execute(this.modelClient);

		final Transaction t =
				new Transaction(this.modelClient.getRevisionDate(),
						(Person) this.modelClient.getObject(this.basePerson1), this.masterRole, this.modelClient
								.getUuidManager().getAllUUIDs());
		t.addCommand(c1);

		this.serverContext.getExecutionController().commitTransaction(t);

		Assert.assertFalse(this.modelClient.equals(this.persistenceManager.getModelForTesting()));

		final Model clientRefreshed = this.persistenceManager.getModelForTesting();

		Assert.assertTrue(this.modelClient.getAllPersons().size() == 5);
		Assert.assertTrue(clientRefreshed.getAllPersons().contains(clientRefreshed.getObject(c1.getResult().getId())));
		Assert.assertTrue(clientRefreshed.equals(this.persistenceManager.getModelForTesting()));
	}

	/**
	 * Testing conflict.
	 * 
	 * Notice: Person1 heißt jetzt Harry Potter
	 * 
	 * @throws IPScrumGeneralException
	 *             if the use of one of the methods fails
	 * @throws InterruptedException
	 *             if the transaction is interrupted
	 */
	@Test
	public void test05() throws IPScrumGeneralException, InterruptedException {
		// User 1 versucht Person 1 zu ändern
		final PersonChangeNameCommand c1 =
				new PersonChangeNameCommand((Person) this.modelClient.getObject(this.basePerson1), "Harry", "Potter");
		c1.execute(this.modelClient);
		final Transaction t =
				new Transaction(this.modelClient.getRevisionDate(),
						(Person) this.modelClient.getObject(this.basePerson1), this.masterRole, this.modelClient
								.getUuidManager().getAllUUIDs());
		t.addCommand(c1);

		// User 2 fügt gleichzeitig eine Rolle dem User hinzu
		final Model model2 = this.persistenceManager.getModelForTesting();
		model2.setUuidManager(new IDGenerator());
		final PersonAddRoleCommand c2 =
				new PersonAddRoleCommand((Person) model2.getObject(this.basePerson1),
						(Role) model2.getObject(this.baseRole3));
		c2.execute(model2);
		final Transaction t2 =
				new Transaction(model2.getRevisionDate(), (Person) this.modelClient.getObject(this.basePerson2),
						this.masterRole, model2.getUuidManager().getAllUUIDs());
		t2.addCommand(c2);

		// Anwender 1 führt zuerst aus, daher muss es für Anwender 2 einen
		// Konflikt geben
		this.serverContext.getExecutionController().commitTransaction(t);
		this.serverContext.getExecutionController().commitTransaction(t2);

		final Model serverModel = this.persistenceManager.getModelForTesting();

		Assert.assertEquals(((Person) serverModel.getObject(this.basePerson1)).getFirstname(), "Harry");
		Assert.assertEquals(((Person) serverModel.getObject(this.basePerson1)).getLastname(), "Potter");
		Assert.assertFalse(((Person) serverModel.getObject(this.basePerson1)).getRoles().contains(
				serverModel.getObject(this.baseRole3)));
	}

	/**
	 * Testing Class Utils.
	 */
	@Test
	public void test06() {
		Assert.assertTrue(ClassUtils.isAssignableFrom(ProductBacklogItem.class, Ticket.class));
	}

	/**
	 * Tests to commit transactions.
	 * 
	 * @throws IPScrumGeneralException
	 *             if something fails
	 * @throws InterruptedException
	 *             if a transaction is interrupted
	 */
	@Test
	public void test07() throws IPScrumGeneralException, InterruptedException {
		final ProjectCreateCommand createCommand = new ProjectCreateCommand("poject1");
		createCommand.execute(this.modelClient);
		final Project project = createCommand.getResult();
		final Team team = new Team(this.modelClient, "Team");
		team.addProject(project);

		final ReleaseCreateCommand c = new ReleaseCreateCommand(project, "Test", new Date());
		c.execute(this.modelClient);

		final Transaction t =
				new Transaction(this.modelClient.getRevisionDate(), this.modelClient.getAdminPerson(), this.masterRole,
						this.modelClient.getUuidManager().getAllUUIDs());

		t.addCommand(createCommand);
		t.addCommand(c);
		ServerContext.getInstance().getExecutionController().commitTransaction(t);
	}
}
