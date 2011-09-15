package fhdw.ipscrum.shared.model.nonMeta;

import java.io.File;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.TestUtils;
import fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.SetUpTestData;

/**
 * The class <code>SprintBacklogTest</code> contains tests for the class
 * <code>{@link SprintBacklog}</code>.
 */
@SuppressWarnings("deprecation")
public class SprintBacklogTest extends SetUpTestData {
	/**
	 * represents the model needed for use the IPScrum.
	 */
	private Model model;
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
	private Task t2 = null;
	/**
	 * represents a task which is needed for complex tests.
	 */
	private Task t3 = null;
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
	 * represents a number which is needed for complex tests.
	 */
	private Integer eight = null;
	/**
	 * represents a number which is needed for complex tests.
	 */
	private Integer platzhalter = null;

	/**
	 * Needed for the set up of the data before the test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		TestUtils.deleteFolderContent(new File("output"));
		ServerContext.resetServerContext();
		this.model =
				ServerContext.getInstance().getPersistenceManager().getCurrentModel();
		this.model.setUuidManager(new IDGenerator());

		this.test = new Project(this.model, "Test");
		this.pbltest = this.test.getBacklog();
		this.per1 = new Person(this.model, "Max", "Mustermann");
		this.per2 = new Person(this.model, "Karin", "Katze");
		this.pbi1 =
				new Feature(this.model, this.model.getTypeManager()
						.getStandardFeatureType(), "A", "Test1", this.pbltest);
		this.pbi2 =
				new Feature(this.model, this.model.getTypeManager()
						.getStandardFeatureType(), "B", "Test2", this.pbltest);
		this.pbi3 =
				new Feature(this.model, this.model.getTypeManager()
						.getStandardFeatureType(), "c", "Test3", this.pbltest);
		this.team1 = new Team(this.model, "Team");
		this.team1.addProject(this.test);
		this.sprint =
				new Sprint(this.model, "Sprint", "Beschreibung", new Date(),
						new Date(), this.team1, this.test);
		this.sprintbl = this.sprint.getSprintBacklog();
		this.t1 =
				new Task(this.model, this.model.getTypeManager().getStandardTaskType(),
						"Task 1", "Beschreibung", this.sprintbl);
		this.t2 =
				new Task(this.model, this.model.getTypeManager().getStandardTaskType(),
						"Task 2", "Beschreibung 2", this.sprintbl);
		this.t3 =
				new Task(this.model, this.model.getTypeManager().getStandardTaskType(),
						"Task 3", "Beschreibung 3", this.sprintbl);
		this.eight = 8;

		this.team1.addMember(this.per1);
		this.team1.addMember(this.per2);
		this.pbi1.setSprint(this.sprint);
		this.pbi2.setSprint(this.sprint);
		this.pbi3.setSprint(this.sprint);

		this.t1.setPlanEffort(new Effort(3));
		this.t2.setPlanEffort(new Effort(5));
		this.sprint.setTeam(this.team1);
		this.t2.addPBI(this.pbi3);

		this.t1.addPBI(this.pbi1);
		this.t1.changeState(this.model.getTypeManager().getInProcess());
		this.t1.setResponsibility(this.per1);

	}

	// ----------------------------------------------------------------------------------
	// ----------------------------- Test of functions
	// ----------------------------------
	// ----------------------------------------------------------------------------------

	/**
	 * Getting the Sprint.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetSprint() throws Exception {
		Assert.assertEquals(this.sprint, this.sprintbl.getSprint());
	}

	/**
	 * Checking, if a task is in a specific sprint.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testHasTask1() throws Exception {
		Assert.assertEquals(true, this.sprintbl.hasTask(this.t1));
	}

	/**
	 * Checking, if a task is in a specific sprint.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testHasTask2() throws Exception {
		Assert.assertEquals(true, this.sprintbl.hasTask(this.t3));
	}

	/**
	 * Addition of a Task to a sprintbacklog.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAddTask() throws Exception {
		this.sprintbl.addTask(this.t3);
		Assert.assertEquals(true, this.sprintbl.hasTask(this.t3));
	}

	/**
	 * Removing of a task from a sprintbacklog.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testRemoveTask() throws Exception {
		this.sprintbl.removeTask(this.t3);
		Assert.assertEquals(false, this.sprintbl.hasTask(this.t3));
	}

	/**
	 * Checking, if a task belongs to a specific PBI.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testHasPBI1() throws Exception {
		Assert.assertEquals(true, this.sprintbl.hasPBI(this.pbi1));
	}

	/**
	 * Checking, if a task belongs to a specific PBI.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails@throws Exception if the use of
	 *             one of the methods fails
	 */
	@Test
	public void testHasPBI2() throws Exception {
		Assert.assertEquals(false, this.sprintbl.hasPBI(this.pbi2));
	}

	/**
	 * Removing a BPI from a sprint.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testRemovePBIFromTasks1() throws Exception {
		this.t2.addPBI(this.pbi2);
		this.sprintbl.removePBIFromTasks(this.pbi2);

		Assert.assertFalse(this.sprintbl.hasPBI(this.pbi2));
	}

	/**
	 * Removing a BPI from a sprint in a state this is fobidden to check if the exception
	 * is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = ForbiddenStateException.class)
	public void testRemovePBIFromTasks2() throws Exception {
		for (final Task current : this.sprintbl.getTasks()) {
			java.lang.System.out.println(current.getDescription() + ": "
					+ current.getCurrentState().getName());
		}
		this.sprintbl.removePBIFromTasks(this.pbi1);

	}

	/**
	 * Calculation of overall effort of all tasks.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCalculateOverallTaskEffort1() throws Exception {
		this.platzhalter = this.sprintbl.calculateOverallTaskEffort();
		Assert.assertEquals(this.eight, this.platzhalter);
	}

	/**
	 * Calculation of Effort remaining.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetEffortByDay() throws Exception {
		this.t1.changeState(this.model.getTypeManager().getClosed());
		this.platzhalter = this.sprintbl.getEffortByDay(new Date());
		Assert.assertEquals(Integer.valueOf(8), this.platzhalter);
	}

	/**
	 * tests if the effort by day is rightly calculated.
	 */
	@Test
	public void testGetEffortByDayForProject1Release1() {
		// EffortsByDay Sprint1 from Project1 Release1
		Assert.assertEquals(
				15,
				this.pro1rel1spr1.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 2 - 1, 1)));
		Assert.assertEquals(
				12,
				this.pro1rel1spr1.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 2 - 1, 2)));
		Assert.assertEquals(
				5,
				this.pro1rel1spr1.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 2 - 1, 3)));
		Assert.assertEquals(
				5,
				this.pro1rel1spr1.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 2 - 1, 4)));

		// EffortsByDay Sprint2 from Project1 Release1
		Assert.assertEquals(
				24,
				this.pro1rel1spr2.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 12)));
		Assert.assertEquals(
				22,
				this.pro1rel1spr2.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 13)));
		Assert.assertEquals(
				15,
				this.pro1rel1spr2.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 14)));

		// EffortsByDay Sprint3 from Project1 Release1
		Assert.assertEquals(
				35,
				this.pro1rel1spr3.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 1 - 1, 3)));
		Assert.assertEquals(
				21,
				this.pro1rel1spr3.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 1 - 1, 4)));

		// EffortsByDay Sprint4 from Project1 Release1
		Assert.assertEquals(
				17,
				this.pro1rel1spr4.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 2 - 1, 28)));
		Assert.assertEquals(
				12,
				this.pro1rel1spr4.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 1)));
		Assert.assertEquals(
				8,
				this.pro1rel1spr4.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 2)));

		// EffortsByDay Sprint5 from Project1 Release1
		Assert.assertEquals(
				21,
				this.pro1rel1spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 1)));
		Assert.assertEquals(
				16,
				this.pro1rel1spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 2)));
		Assert.assertEquals(
				13,
				this.pro1rel1spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 3)));
		Assert.assertEquals(
				9,
				this.pro1rel1spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 4)));
		Assert.assertEquals(
				2,
				this.pro1rel1spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 10)));
	}

	/**
	 * tests if the effort by day is rightly calculated.
	 */
	@Test
	public void testGetEffortByDayForProject1Release2() {
		// EffortsByDay Sprint1 from Project1 Release2
		Assert.assertEquals(
				32,
				this.pro1rel2spr1.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 1)));
		Assert.assertEquals(
				24,
				this.pro1rel2spr1.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 2)));

		// EffortsByDay Sprint2 from Project1 Release2
		Assert.assertEquals(
				23,
				this.pro1rel2spr2.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 2 - 1, 1)));
		Assert.assertEquals(
				20,
				this.pro1rel2spr2.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 2 - 1, 13)));
		Assert.assertEquals(
				17,
				this.pro1rel2spr2.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 6)));

		// EffortsByDay Sprint3 from Project1 Release2
		Assert.assertEquals(
				35,
				this.pro1rel2spr3.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 1)));
		Assert.assertEquals(
				18,
				this.pro1rel2spr3.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 4)));
		Assert.assertEquals(
				10,
				this.pro1rel2spr3.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 20)));

		// EffortsByDay Sprint4 from Project1 Release2
		Assert.assertEquals(
				13,
				this.pro1rel2spr4.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 1)));
		Assert.assertEquals(
				11,
				this.pro1rel2spr4.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 2)));
		Assert.assertEquals(
				2,
				this.pro1rel2spr4.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 3)));
		Assert.assertEquals(
				1,
				this.pro1rel2spr4.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 4)));

		// EffortsByDay Sprint5 from Project1 Release2
		Assert.assertEquals(
				40,
				this.pro1rel2spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 1)));
		Assert.assertEquals(
				40,
				this.pro1rel2spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 2)));
		Assert.assertEquals(
				40,
				this.pro1rel2spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 3)));
		Assert.assertEquals(
				40,
				this.pro1rel2spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 4)));
		Assert.assertEquals(
				40,
				this.pro1rel2spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 10)));
	}

	/**
	 * tests if the effort by day if rightly calculated.
	 */
	@Test
	public void testGetEffortByDayForProject2Release1() {
		// EffortsByDay Sprint1 from Project2 Release1
		Assert.assertEquals(
				22,
				this.pro2rel1spr1.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 2 - 1, 1)));
		Assert.assertEquals(
				11,
				this.pro2rel1spr1.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 1)));
		Assert.assertEquals(
				11,
				this.pro2rel1spr1.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 4 - 1, 1)));
		Assert.assertEquals(
				0,
				this.pro2rel1spr1.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 5 - 1, 1)));

		// EffortsByDay Sprint2 from Project2 Release1
		Assert.assertEquals(
				15,
				this.pro2rel1spr2.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 2 - 1, 1)));
		Assert.assertEquals(
				15,
				this.pro2rel1spr2.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 1)));
		Assert.assertEquals(
				12,
				this.pro2rel1spr2.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 15)));
		Assert.assertEquals(
				9,
				this.pro2rel1spr2.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 30)));
		Assert.assertEquals(
				6,
				this.pro2rel1spr2.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 4 - 1, 6)));

		// EffortsByDay Sprint3 from Project2 Release1
		Assert.assertEquals(
				20,
				this.pro2rel1spr3.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 1)));
		Assert.assertEquals(
				17,
				this.pro2rel1spr3.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 4)));
		Assert.assertEquals(
				17,
				this.pro2rel1spr3.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 4 - 1, 1)));
		Assert.assertEquals(
				9,
				this.pro2rel1spr3.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 6 - 1, 20)));

		// EffortsByDay Sprint4 from Project2 Release1
		Assert.assertEquals(
				26,
				this.pro2rel1spr4.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 1)));
		Assert.assertEquals(
				26,
				this.pro2rel1spr4.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 17)));
		Assert.assertEquals(
				25,
				this.pro2rel1spr4.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 23)));
		Assert.assertEquals(
				25,
				this.pro2rel1spr4.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 24)));

		// EffortsByDay Sprint5 from Project2 Release1
		Assert.assertEquals(
				21,
				this.pro2rel1spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 2 - 1, 6)));
		Assert.assertEquals(
				21,
				this.pro2rel1spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 7)));
		Assert.assertEquals(
				18,
				this.pro2rel1spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 8)));
		Assert.assertEquals(
				18,
				this.pro2rel1spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 14)));
		Assert.assertEquals(
				5,
				this.pro2rel1spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 6 - 1, 10)));
	}

	/**
	 * tests if the effort by day is rightly calculated.
	 */
	@Test
	public void testGetEffortByDayForProject2Release2() {
		// EffortsByDay Sprint1 from Project2 Release2
		Assert.assertEquals(
				25,
				this.pro2rel2spr1.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 2 - 1, 1)));
		Assert.assertEquals(
				25,
				this.pro2rel2spr1.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 2)));
		Assert.assertEquals(
				25,
				this.pro2rel2spr1.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 4 - 1, 1)));
		Assert.assertEquals(
				25,
				this.pro2rel2spr1.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 6 - 1, 2)));
		Assert.assertEquals(
				20,
				this.pro2rel2spr1.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 7 - 1, 1)));
		Assert.assertEquals(
				20,
				this.pro2rel2spr1.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 8 - 1, 2)));

		// EffortsByDay Sprint2 from Project2 Release2
		Assert.assertEquals(
				25,
				this.pro2rel2spr2.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 2 - 1, 1)));
		Assert.assertEquals(
				25,
				this.pro2rel2spr2.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 2 - 1, 11)));
		Assert.assertEquals(
				20,
				this.pro2rel2spr2.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 2 - 1, 12)));
		Assert.assertEquals(
				15,
				this.pro2rel2spr2.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 1)));
		Assert.assertEquals(
				10,
				this.pro2rel2spr2.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 6)));

		// EffortsByDay Sprint3 from Project2 Release2
		Assert.assertEquals(
				25,
				this.pro2rel2spr3.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 1 - 1, 1)));
		Assert.assertEquals(
				20,
				this.pro2rel2spr3.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 1 - 1, 2)));
		Assert.assertEquals(
				15,
				this.pro2rel2spr3.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 1 - 1, 9)));
		Assert.assertEquals(
				15,
				this.pro2rel2spr3.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 1 - 1, 11)));
		Assert.assertEquals(
				10,
				this.pro2rel2spr3.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 1 - 1, 12)));
		Assert.assertEquals(
				10,
				this.pro2rel2spr3.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 1 - 1, 20)));

		// EffortsByDay Sprint4 from Project2 Release2
		Assert.assertEquals(
				25,
				this.pro2rel2spr4.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 2 - 1, 14)));
		Assert.assertEquals(
				25,
				this.pro2rel2spr4.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 2 - 1, 28)));
		Assert.assertEquals(
				25,
				this.pro2rel2spr4.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 1)));
		Assert.assertEquals(
				0,
				this.pro2rel2spr4.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 4)));
		Assert.assertEquals(
				0,
				this.pro2rel2spr4.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 10)));
		Assert.assertEquals(
				0,
				this.pro2rel2spr4.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 18)));

		// EffortsByDay Sprint5 from Project2 Release2
		Assert.assertEquals(
				25,
				this.pro2rel2spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 2 - 1, 25)));
		Assert.assertEquals(
				25,
				this.pro2rel2spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 2 - 1, 26)));
		Assert.assertEquals(
				25,
				this.pro2rel2spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 2 - 1, 27)));
		Assert.assertEquals(
				15,
				this.pro2rel2spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 2 - 1, 28)));
		Assert.assertEquals(
				15,
				this.pro2rel2spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 1)));
		Assert.assertEquals(
				15,
				this.pro2rel2spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 2)));
		Assert.assertEquals(
				10,
				this.pro2rel2spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 3)));
		Assert.assertEquals(
				5,
				this.pro2rel2spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 4)));
		Assert.assertEquals(
				5,
				this.pro2rel2spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 5)));
		Assert.assertEquals(
				5,
				this.pro2rel2spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 6)));
		Assert.assertEquals(
				5,
				this.pro2rel2spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 7)));
		Assert.assertEquals(
				0,
				this.pro2rel2spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 8)));
		Assert.assertEquals(
				0,
				this.pro2rel2spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 9)));
		Assert.assertEquals(
				0,
				this.pro2rel2spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 10)));
		Assert.assertEquals(
				0,
				this.pro2rel2spr5.getSprintBacklog().getEffortByDay(
						new Date(2011 - 1900, 3 - 1, 11)));
	}

	/**
	 * tests that the overall task effort is rightly calculated.
	 */
	@Test
	public void testCalculateOverallTaskEffort2() {

		// Overall Task Efforts of Sprint 1 to Sprint 5 from Project1 Release1
		Assert.assertEquals(15, this.pro1rel1spr1.getSprintBacklog()
				.calculateOverallTaskEffort());
		Assert.assertEquals(24, this.pro1rel1spr2.getSprintBacklog()
				.calculateOverallTaskEffort());
		Assert.assertEquals(35, this.pro1rel1spr3.getSprintBacklog()
				.calculateOverallTaskEffort());
		Assert.assertEquals(17, this.pro1rel1spr4.getSprintBacklog()
				.calculateOverallTaskEffort());
		Assert.assertEquals(21, this.pro1rel1spr5.getSprintBacklog()
				.calculateOverallTaskEffort());

		// Overall Task Efforts of Sprint 1 to Sprint 5 from Project1 Release2
		Assert.assertEquals(32, this.pro1rel2spr1.getSprintBacklog()
				.calculateOverallTaskEffort());
		Assert.assertEquals(23, this.pro1rel2spr2.getSprintBacklog()
				.calculateOverallTaskEffort());
		Assert.assertEquals(35, this.pro1rel2spr3.getSprintBacklog()
				.calculateOverallTaskEffort());
		Assert.assertEquals(13, this.pro1rel2spr4.getSprintBacklog()
				.calculateOverallTaskEffort());
		Assert.assertEquals(40, this.pro1rel2spr5.getSprintBacklog()
				.calculateOverallTaskEffort());

		// Overall Task Efforts of Sprint 1 to Sprint 5 from Projekt2 Release1
		Assert.assertEquals(22, this.pro2rel1spr1.getSprintBacklog()
				.calculateOverallTaskEffort());
		Assert.assertEquals(15, this.pro2rel1spr2.getSprintBacklog()
				.calculateOverallTaskEffort());
		Assert.assertEquals(20, this.pro2rel1spr3.getSprintBacklog()
				.calculateOverallTaskEffort());
		Assert.assertEquals(26, this.pro2rel1spr4.getSprintBacklog()
				.calculateOverallTaskEffort());
		Assert.assertEquals(21, this.pro2rel1spr5.getSprintBacklog()
				.calculateOverallTaskEffort());

		// Overall Task Efforts of Sprint 1 to Sprint 5 from Project2 Release1
		Assert.assertEquals(25, this.pro2rel2spr1.getSprintBacklog()
				.calculateOverallTaskEffort());
		Assert.assertEquals(25, this.pro2rel2spr2.getSprintBacklog()
				.calculateOverallTaskEffort());
		Assert.assertEquals(25, this.pro2rel2spr3.getSprintBacklog()
				.calculateOverallTaskEffort());
		Assert.assertEquals(25, this.pro2rel2spr4.getSprintBacklog()
				.calculateOverallTaskEffort());
		Assert.assertEquals(25, this.pro2rel2spr5.getSprintBacklog()
				.calculateOverallTaskEffort());

	}

}
