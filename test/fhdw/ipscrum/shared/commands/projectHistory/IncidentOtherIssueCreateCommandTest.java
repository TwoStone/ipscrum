package fhdw.ipscrum.shared.commands.projectHistory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.shared.commands.interfaces.ICommand;
import fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TaskTicketType;
import fhdw.ipscrum.shared.model.nonMeta.Feature;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklog;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.nonMeta.SprintBacklog;
import fhdw.ipscrum.shared.model.nonMeta.Task;
import fhdw.ipscrum.shared.model.nonMeta.Team;
import fhdw.ipscrum.shared.model.nonMeta.incidents.MultipleParticipantIncident;

/**
 * The class <code>IncidentOtherIssueCreateCommandTest</code> contains tests for the class
 * <code>{@link IncidentOtherIssueCreateCommand}</code>.
 */
public class IncidentOtherIssueCreateCommandTest {
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
	 * Run the IncidentOtherIssueCreateCommand(Date,Date,String,String,List<Person>,List<Project>) constructor test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testIncidentOtherIssueCreateCommand1() throws Exception {
		final String incidentTypeId = "blaa";
		final String description = "blupp";
		final List<Person> persons = new ArrayList<Person>();
		persons.add(this.per1);
		final List<Project> projects = new ArrayList<Project>();
		projects.add(this.test);
		final IncidentOtherIssueCreateCommand result =
				new IncidentOtherIssueCreateCommand(this.sprint.getBegin(), this.sprint.getEnd(), incidentTypeId,
						description, persons, projects);

		Assert.assertNotNull(result);
		Assert.assertEquals(false, result.dependsOnProject());
		Assert.assertEquals("", result.toString());
		Assert.assertEquals(null, result.getResult());
	}

	/**
	 * Run the void accept(CommandVisitor) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testAccept1() throws Exception {
		final List<Person> persons = new ArrayList<Person>();
		persons.add(this.per1);
		final List<Project> projects = new ArrayList<Project>();
		projects.add(this.test);
		final IncidentOtherIssueCreateCommand fixture =
				new IncidentOtherIssueCreateCommand(new Date(), new Date(), "", "", persons, projects);

		fixture.accept(new CommandStandardVisitor() {

			@Override
			public void standardHandling(final ICommand command) {

			}
		});

	}

	/**
	 * Run the boolean dependsOnProject() method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testDependsOnProject1() throws Exception {
		final List<Person> persons = new ArrayList<Person>();
		persons.add(this.per1);
		final List<Project> projects = new ArrayList<Project>();
		projects.add(this.test);
		final IncidentOtherIssueCreateCommand fixture =
				new IncidentOtherIssueCreateCommand(new Date(), new Date(), "i1", "i1", persons, projects);

		final boolean result = fixture.dependsOnProject();

		Assert.assertEquals(false, result);
	}

	/**
	 * Run the Project getDependingProject(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void testGetDependingProject1() throws Exception {
		final List<Person> persons = new ArrayList<Person>();
		persons.add(this.per1);
		final List<Project> projects = new ArrayList<Project>();
		projects.add(this.test);
		final IncidentOtherIssueCreateCommand fixture =
				new IncidentOtherIssueCreateCommand(new Date(), new Date(), "", "", persons, projects);

		final Project result = fixture.getDependingProject(this.model);

		Assert.assertEquals(null, result);
	}

	/**
	 * Run the MultipleParticipantIncident onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException.class)
	public void testOnExecute1() throws Exception {
		final List<Person> persons = new ArrayList<Person>();
		persons.add(this.per1);
		final List<Project> projects = new ArrayList<Project>();
		projects.add(this.test);
		final IncidentOtherIssueCreateCommand fixture =
				new IncidentOtherIssueCreateCommand(new Date(), new Date(), "i2", "i2", persons, projects);
		final Model model1 = new Model(new Date());

		final MultipleParticipantIncident result = fixture.onExecute(model1);

		Assert.assertNotNull(result);
	}

	/**
	 * Run the MultipleParticipantIncident onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test(expected = NullPointerException.class)
	public void testOnExecute2() throws Exception {
		final List<Person> persons = new ArrayList<Person>();
		persons.add(this.per1);
		final List<Project> projects = new ArrayList<Project>();
		projects.add(this.test);
		final IncidentOtherIssueCreateCommand fixture =
				new IncidentOtherIssueCreateCommand(new Date(), new Date(), "i2", "i2", null, projects);

		final MultipleParticipantIncident result = fixture.onExecute(this.model);

		Assert.assertNotNull(result);
	}

	/**
	 * Run the MultipleParticipantIncident onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	public void testOnExecute3() throws Exception {
		final List<Person> persons = new ArrayList<Person>();
		persons.add(this.per1);
		final List<Project> projects = new ArrayList<Project>();
		projects.add(this.test);
		final IncidentOtherIssueCreateCommand fixture =
				new IncidentOtherIssueCreateCommand(new Date(), new Date(), "i3", "i3", persons, projects);

		final MultipleParticipantIncident result = fixture.onExecute(this.model);

		Assert.assertNotNull(result);
	}

	/**
	 * Run the MultipleParticipantIncident onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test(expected = NoObjectFindException.class)
	public void testOnExecute4() throws Exception {
		final List<Person> persons = new ArrayList<Person>();
		persons.add(this.per1);
		persons.add(this.per2);
		final List<Project> projects = new ArrayList<Project>();
		projects.add(this.test);
		final IncidentOtherIssueCreateCommand fixture =
				new IncidentOtherIssueCreateCommand(new Date(), new Date(), "i8", "i8", persons, projects);

		final MultipleParticipantIncident result = fixture.onExecute(this.model);

		Assert.assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 */
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
		this.team1.addMember(this.per1);
		this.team1.addMember(this.per2);
		this.sprint = new Sprint(this.model, "Sprint", "Beschreibung", new Date(), new Date(), this.team1, this.test);
		this.sprintbl = this.sprint.getSprintBacklog();
		this.t6 = new Task(this.model, this.task, "Task 6", "Assigend", this.sprintbl);

		this.t6.changeState(this.model.getTypeManager().getInProcess());
		this.t6.setResponsibility(this.per1);

		this.pbi1.setSprint(this.sprint);
		this.pbi2.setSprint(this.sprint);
		this.pbi3.setSprint(this.sprint);
		this.pbi4.setSprint(this.sprint);
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
