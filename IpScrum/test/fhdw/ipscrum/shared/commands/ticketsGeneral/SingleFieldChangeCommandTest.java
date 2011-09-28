package fhdw.ipscrum.shared.commands.ticketsGeneral;

import java.io.Serializable;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.shared.commands.interfaces.ICommand;
import fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.fields.TextFieldType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TaskTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.Feature;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklog;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.nonMeta.SprintBacklog;
import fhdw.ipscrum.shared.model.nonMeta.Task;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * The class <code>SingleFieldChangeCommandTest</code> contains tests for the class
 * <code>{@link SingleFieldChangeCommand}</code>.
 */
public class SingleFieldChangeCommandTest {
	/**
	 * represents the model needed to use the IPScrum.
	 */
	private Model model = null;
	/**
	 * represents a person which is needed for complex tests.
	 */
	private Person per1 = null;
	/**
	 * represents a person which is needed for complex tests.
	 */
	private Person per2 = null;
	/**
	 * represents a feature which is needed for complex tests.
	 */
	private Feature pbi1 = null;
	/**
	 * represents a feature which is needed for complex tests.
	 */
	private Feature pbi2 = null;
	/**
	 * represents a feature which is needed for complex tests.
	 */
	private Feature pbi3 = null;
	/**
	 * represents a feature which is needed for complex tests.
	 */
	private Feature pbi4 = null;
	/**
	 * represents a project which is needed for complex tests.
	 */
	private Project test = null;
	/**
	 * represents a productBacklog which is needed for complex tests.
	 */
	private ProductBacklog pbltest = null;
	/**
	 * represents a task which is needed for complex tests.
	 */
	private Task t1 = null;
	/**
	 * represents a task which is needed for complex tests.
	 */
	private Task t6 = null;
	/**
	 * represents a sprint which is needed for complex tests.
	 */
	private Sprint sprint = null;
	/**
	 * represents a team which is needed for complex tests.
	 */
	private Team team1 = null;
	/**
	 * represents a sprintBacklog which is needed for complex tests.
	 */
	private SprintBacklog sprintbl = null;
	/**
	 * represents a featureTicketType which is needed for complex tests.
	 */
	private FeatureTicketType type = null;
	/**
	 * represents a taskTicketType which is needed for complex tests.
	 */
	private TaskTicketType task = null;
	/**
	 * 
	 */
	private SingleField<Serializable> singleField = null;

	/**
	 * Name field of pbi 1.
	 */
	private SingleField<String> pbi1NameField;

	/**
	 * Run the void accept(CommandVisitor) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testAccept1() throws Exception {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final SingleFieldChangeCommand fixture =
				new SingleFieldIdentifiableObjectChangeCommand(this.singleField, this.per1, this.t1);

		fixture.accept(new CommandStandardVisitor() {

			@Override
			public void standardHandling(final ICommand command) {

			}
		});

	}

	/**
	 * Run the SingleFieldChangeCommand<Serializable> createCommand(SingleField<T>,T,Ticket) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testCreateCommand2() throws Exception {
		final SingleField<Serializable> field = this.singleField;
		final Ticket ticket = this.pbi1;

		final SingleFieldChangeCommand<Serializable> result =
				SingleFieldChangeCommand.createCommand(field, "blaa", ticket);

		Assert.assertNotNull(result);
	}

	/**
	 * Run the SingleFieldChangeCommand<Serializable> createCommand(SingleField<T>,T,Ticket) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testCreateCommand3() throws Exception {

		final SingleField<Serializable> field = this.singleField;
		final Ticket ticket = this.pbi3;

		final SingleFieldChangeCommand<Serializable> result =
				SingleFieldChangeCommand.createCommand(field, this.sprint, ticket);

		Assert.assertNotNull(result);
	}

	/**
	 * Run the SingleFieldChangeCommand<Serializable> createCommand(SingleField<T>,T,Ticket) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testCreateCommand4() throws Exception {

		final Ticket ticket = this.pbi1;

		final SingleFieldChangeCommand<String> result =
				SingleFieldChangeCommand.createCommand(this.pbi1NameField, "NewName", ticket);

		Assert.assertNotNull(result);
	}

	/**
	 * Run the boolean dependsOnProject() method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testDependsOnProject1() throws Exception {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final SingleFieldChangeCommand fixture =
				new SingleFieldIdentifiableObjectChangeCommand(this.singleField, this.team1, this.pbi4);

		final boolean result = fixture.dependsOnProject();

		Assert.assertTrue(result);
	}

	/**
	 * Run the Project getDependingProject(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testGetDependingProject1() throws Exception {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final SingleFieldChangeCommand fixture =
				new SingleFieldIdentifiableObjectChangeCommand(this.singleField, this.per1, this.pbi2);

		final Project result = fixture.getDependingProject(this.model);

		Assert.assertNotNull(result);
	}

	/**
	 * Run the Project getDependingProject(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test(expected = NoObjectFindException.class)
	public void testGetDependingProject2() throws Exception {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final SingleFieldChangeCommand fixture =
				new SingleFieldIdentifiableObjectChangeCommand(this.singleField, this.per2, this.pbi2);
		final Model model1 = new Model(new Date());

		final Project result = fixture.getDependingProject(model1);

		Assert.assertNotNull(result);
	}

	/**
	 * Run the Project getDependingProject(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testGetDependingProject3() throws Exception {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final SingleFieldChangeCommand fixture =
				new SingleFieldIdentifiableObjectChangeCommand(this.singleField, this.per1, this.t6);

		final Project result = fixture.getDependingProject(this.model);

		Assert.assertNotNull(result);
	}

	/**
	 * Run the Ticket getTicket(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testGetTicket1() throws Exception {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final SingleFieldChangeCommand fixture =
				new SingleFieldIdentifiableObjectChangeCommand(this.singleField, this.sprint, this.t1);

		final Ticket result = fixture.getTicket(this.model);

		Assert.assertNotNull(result);
	}

	/**
	 * Run the Ticket getTicket(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test(expected = NoObjectFindException.class)
	public void testGetTicket2() throws Exception {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final SingleFieldChangeCommand fixture =
				new SingleFieldIdentifiableObjectChangeCommand(this.singleField, this.test, this.pbi2);
		final Model model1 = new Model(new Date());

		final Ticket result = fixture.getTicket(model1);

		Assert.assertNotNull(result);
	}

	/**
	 * Run the Void onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test(expected = ConsistencyException.class)
	public void testOnExecute1() throws Exception {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final SingleFieldChangeCommand fixture =
				new SingleFieldIdentifiableObjectChangeCommand(this.singleField, this.team1, this.pbi2);

		fixture.onExecute(this.model);

	}

	/**
	 * Run the Void onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test(expected = NoObjectFindException.class)
	public void testOnExecute2() throws Exception {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final SingleFieldChangeCommand fixture =
				new SingleFieldIdentifiableObjectChangeCommand(this.singleField, this.per2, this.pbi2);
		final Model model1 = new Model(new Date());

		fixture.onExecute(model1);

	}

	/**
	 * Run the Void onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test(expected = NullPointerException.class)
	public void testOnExecute3() throws Exception {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final SingleFieldChangeCommand fixture =
				new SingleFieldIdentifiableObjectChangeCommand(null, this.per2, this.pbi1);

		fixture.onExecute(this.model);

	}

	/**
	 * Run the Void onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test(expected = NullPointerException.class)
	public void testOnExecute4() throws Exception {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final SingleFieldChangeCommand fixture =
				new SingleFieldIdentifiableObjectChangeCommand(this.singleField, null, this.pbi1);

		fixture.onExecute(this.model);

	}

	/**
	 * Run the Void onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test(expected = NullPointerException.class)
	public void testOnExecute5() throws Exception {
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final SingleFieldChangeCommand fixture =
				new SingleFieldIdentifiableObjectChangeCommand(this.singleField, this.per2, null);

		fixture.onExecute(this.model);

	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 */
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		ServerContext.resetServerContext();
		this.model = ServerContext.getInstance().getPersistenceManager().getCurrentModel();
		this.model.setUuidManager(new IDGenerator());

		this.test = new Project(this.model, "Test");
		this.pbltest = this.test.getBacklog();
		this.per1 = new Person(this.model, "Max", "Mustermann");
		this.per2 = new Person(this.model, "Karin", "Katze");
		this.type = new FeatureTicketType(this.model, "Type", "TestType");
		this.pbi1 = new Feature(this.model, this.type, "A", "Test1", this.pbltest);
		this.pbi2 = new Feature(this.model, this.type, "B", "Test2", this.pbltest);
		this.pbi3 = new Feature(this.model, this.type, "C", "Test3", this.pbltest);
		this.pbi4 = new Feature(this.model, this.type, "D", "Test4", this.pbltest);
		this.task = this.model.getTypeManager().getStandardTaskType();
		this.team1 = new Team(this.model, "Team");
		this.team1.addProject(this.test);
		this.sprint = new Sprint(this.model, "Sprint", "Beschreibung", new Date(), new Date(), this.team1, this.test);
		this.sprintbl = this.sprint.getSprintBacklog();
		this.t1 = new Task(this.model, this.task, "Task 1", "Beschreibung", this.sprintbl);
		this.t6 = new Task(this.model, this.task, "Task 6", "Assigend", this.sprintbl);

		this.team1.addMember(this.per1);
		this.team1.addMember(this.per2);
		this.pbi1.setSprint(this.sprint);
		this.pbi2.setSprint(this.sprint);
		this.pbi3.setSprint(this.sprint);
		this.pbi4.setSprint(this.sprint);

		this.t6.changeState(this.model.getTypeManager().getInProcess());
		this.t6.setResponsibility(this.per1);

		this.singleField = new SingleField<Serializable>(this.model, this.model.getTypeManager().getVersionType());
		final TextFieldType nameFieldType = this.pbi1.getTicketType().getNameType();
		this.pbi1NameField = (SingleField<String>) this.t1.getTicketType().getField(nameFieldType, this.pbi1);

	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

}
