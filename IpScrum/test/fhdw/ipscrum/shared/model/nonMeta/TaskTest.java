package fhdw.ipscrum.shared.model.nonMeta;

import java.io.File;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.TestUtils;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.model.SprintAssociationException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TaskTicketType;

/**
 * The class <code>TaskTest</code> contains tests for the class <code>{@link Task}</code>.
 */
public class TaskTest {
	/**
	 * represents the model needed to use the IPScrum.
	 */
	private static Model model = null;
	/**
	 * represents a person which is needed for complex tests.
	 */
	private static Person per1 = null;
	/**
	 * represents a person which is needed for complex tests.
	 */
	private static Person per2 = null;
	/**
	 * represents a feature which is needed for complex tests.
	 */
	private static Feature pbi1 = null;
	/**
	 * represents a feature which is needed for complex tests.
	 */
	private static Feature pbi2 = null;
	/**
	 * represents a feature which is needed for complex tests.
	 */
	private static Feature pbi3 = null;
	/**
	 * represents a feature which is needed for complex tests.
	 */
	private static Feature pbi4 = null;
	/**
	 * represents a project which is needed for complex tests.
	 */
	private static Project test = null;
	/**
	 * represents a productBacklog which is needed for complex tests.
	 */
	private static ProductBacklog pbltest = null;
	/**
	 * represents a task which is needed for complex tests.
	 */
	private static Task t1 = null;
	/**
	 * represents a task which is needed for complex tests.
	 */
	private static Task t2 = null;
	/**
	 * represents a task which is needed for complex tests.
	 */
	private static Task t3 = null;
	/**
	 * represents a task which is needed for complex tests.
	 */
	private static Task t4 = null;
	/**
	 * represents a task which is needed for complex tests.
	 */
	private static Task t5 = null;
	/**
	 * represents a task which is needed for complex tests.
	 */
	private static Task t6 = null;
	/**
	 * represents a task which is needed for complex tests.
	 */
	private static Task t7 = null;
	/**
	 * represents a number which is needed for complex tests.
	 */
	private static Integer three = null;
	/**
	 * represents a sprint which is needed for complex tests.
	 */
	private static Sprint sprint = null;
	/**
	 * represents a team which is needed for complex tests.
	 */
	private static Team team1 = null;
	/**
	 * represents a sprintBacklog which is needed for complex tests.
	 */
	private static SprintBacklog sprintbl = null;
	/**
	 * represents a featureTicketType which is needed for complex tests.
	 */
	private static FeatureTicketType type = null;
	/**
	 * represents a taskTicketType which is needed for complex tests.
	 */
	private static TaskTicketType task = null;

	/**
	 * Method to initialize thins before starting the tests.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		TestUtils.deleteFolderContent(new File("output"));
		ServerContext.resetServerContext();
		TaskTest.model =
				ServerContext.getInstance().getPersistenceManager().getCurrentModel();
		TaskTest.model.setUuidManager(new IDGenerator());

		TaskTest.test = new Project(TaskTest.model, "Test");
		TaskTest.pbltest = TaskTest.test.getBacklog();
		TaskTest.per1 = new Person(TaskTest.model, "Max", "Mustermann");
		TaskTest.per2 = new Person(TaskTest.model, "Karin", "Katze");
		TaskTest.type = new FeatureTicketType(TaskTest.model, "Type", "TestType");
		TaskTest.pbi1 =
				new Feature(TaskTest.model, TaskTest.type, "A", "Test1",
						TaskTest.pbltest);
		TaskTest.pbi2 =
				new Feature(TaskTest.model, TaskTest.type, "B", "Test2",
						TaskTest.pbltest);
		TaskTest.pbi3 =
				new Feature(TaskTest.model, TaskTest.type, "C", "Test3",
						TaskTest.pbltest);
		TaskTest.pbi4 =
				new Feature(TaskTest.model, TaskTest.type, "D", "Test4",
						TaskTest.pbltest);
		TaskTest.task = TaskTest.model.getTypeManager().getStandardTaskType();
		TaskTest.team1 = new Team(TaskTest.model, "Team");
		TaskTest.team1.addProject(TaskTest.test);
		TaskTest.sprint =
				new Sprint(TaskTest.model, "Sprint", "Beschreibung", new Date(),
						new Date(), TaskTest.team1, TaskTest.test);
		TaskTest.sprintbl = TaskTest.sprint.getSprintBacklog();
		TaskTest.t1 =
				new Task(TaskTest.model, TaskTest.task, "Task 1", "Beschreibung",
						TaskTest.sprintbl);
		TaskTest.t2 =
				new Task(TaskTest.model, TaskTest.task, "Task 2", "Beschreibung 2",
						TaskTest.sprintbl);
		TaskTest.t3 =
				new Task(TaskTest.model, TaskTest.task, "Task 3", "Beschreibung 3",
						TaskTest.sprintbl);
		TaskTest.t4 =
				new Task(TaskTest.model, TaskTest.task, "Task 4", "Add and Remove",
						TaskTest.sprintbl);
		TaskTest.t5 =
				new Task(TaskTest.model, TaskTest.task, "Task 5", "HasPBI()",
						TaskTest.sprintbl);
		TaskTest.t6 =
				new Task(TaskTest.model, TaskTest.task, "Task 6", "Assigend",
						TaskTest.sprintbl);
		TaskTest.t7 =
				new Task(TaskTest.model, TaskTest.task, "Task 7", "Assigend",
						TaskTest.sprintbl);
		TaskTest.three = 3;

		TaskTest.team1.addMember(TaskTest.per1);
		TaskTest.team1.addMember(TaskTest.per2);
		TaskTest.pbi1.setSprint(TaskTest.sprint);
		TaskTest.pbi2.setSprint(TaskTest.sprint);
		TaskTest.pbi3.setSprint(TaskTest.sprint);
		TaskTest.pbi4.setSprint(TaskTest.sprint);

		TaskTest.t6.changeState(TaskTest.model.getTypeManager().getInProcess());
		TaskTest.t6.setResponsibility(TaskTest.per1);

	}

	/**
	 * Needed for the tear down after the test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	// ---------------------------------------------------------------------------
	// ------------------------- Test of basic functions
	// -------------------------
	// ---------------------------------------------------------------------------

	/**
	 * Get Name of a task.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetName() throws Exception {
		Assert.assertEquals("Task 1", TaskTest.t1.getName());
	}

	/**
	 * Test on getting the assigned person.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetResponsiblePerson() throws Exception {
		Assert.assertEquals(null, TaskTest.t1.getResponsiblePerson());
	}

	/**
	 * Test on assigned a task to a Person.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetResponsibility() throws Exception {
		TaskTest.t1.changeState(TaskTest.model.getTypeManager().getInProcess());
		TaskTest.t1.setResponsibility(TaskTest.per1);
		Assert.assertEquals(TaskTest.per1, TaskTest.t1.getResponsiblePerson());
	}

	/**
	 * Addition of a pbi.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAddPBI1() throws Exception {
		TaskTest.t4.addPBI(TaskTest.pbi1);
		Assert.assertTrue(TaskTest.t4.hasPBI(TaskTest.pbi1));
	}

	/**
	 * Addition of a pbi which is already added to check if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = DoubleDefinitionException.class)
	public void testAddPBI2() throws Exception {
		TaskTest.t4.addPBI(TaskTest.pbi1);
	}

	/**
	 * Getting the description.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testgetDescription() throws Exception {
		Assert.assertEquals("Beschreibung", TaskTest.t1.getDescription());
	}

	/**
	 * Getting the finish Date.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testgetFinishDate() throws Exception {
		Assert.assertEquals(null, TaskTest.t1.getFinishDate());
	}

	/**
	 * Getting planed effort.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetPlanEffort() throws Exception {
		Assert.assertTrue(TaskTest.t1.getPlanEffort().equals(Effort.NULL));
	}

	/**
	 * Setting the planed effort.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetPlanEffort() throws Exception {
		TaskTest.t1.setPlanEffort(new Effort(3));
		Assert.assertEquals(new Effort(TaskTest.three), TaskTest.t1.getPlanEffort());
	}

	/**
	 * Test of having a responsible person on a task having a responsible Person.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testHasResponsiblePerson1() throws Exception {
		Assert.assertEquals(true, TaskTest.t1.hasResponsiblePerson());
	}

	/**
	 * Test of having a responsible person on a task without a responsible Person.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testHasResponsiblePerson2() throws Exception {
		Assert.assertEquals(false, TaskTest.t2.hasResponsiblePerson());
	}

	/**
	 * Setting of description.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetDescription() throws Exception {
		TaskTest.t1.setDescription("Beschreibung geändert");
		Assert.assertEquals("Beschreibung geändert", TaskTest.t1.getDescription());
	}

	/**
	 * Removing a PBI.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testRemovePBI() throws Exception {
		TaskTest.t4.removePBI(TaskTest.pbi1);
		Assert.assertFalse(TaskTest.t4.hasPBI(TaskTest.pbi1));

	}

	/**
	 * Testing on False on isFinished() on an unfinished Task.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testIsFinished() throws Exception {
		Assert.assertEquals(false, TaskTest.t4.isFinished());
	}

	/**
	 * Closing of a task.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testFinish1() throws Exception {

		TaskTest.t1.setResponsibility(TaskTest.per1);
		TaskTest.t1.changeState(TaskTest.model.getTypeManager().getClosed());
		Assert.assertEquals(true, TaskTest.t1.isFinished());
	}

	/**
	 * Getting the SprintBacklog.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetSprintbacklog() throws Exception {
		Assert.assertEquals(TaskTest.sprintbl, TaskTest.t1.getSprintBacklog());
	}

	/**
	 * Testing on Equality. Test also of indirectEquals, as task.Equals() only calls on
	 * indirectEquals().
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testEquals() throws Exception {
		Assert.assertEquals(true, TaskTest.t1.equals(TaskTest.t1));
	}

	/**
	 * Test on having a PBI.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testHasPBI1() throws Exception {
		TaskTest.t5.addPBI(TaskTest.pbi1);
		Assert.assertEquals(true, TaskTest.t5.hasPBI(TaskTest.pbi1));
	}

	/**
	 * Test on not having a PBI.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testHasPBI2() throws Exception {
		Assert.assertEquals(false, TaskTest.t4.hasPBI(TaskTest.pbi3));
	}

	/**
	 * Test to get the state of a task.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetState1() throws Exception {
		Assert.assertEquals(TaskTest.model.getTypeManager().getOpen(),
				TaskTest.t3.getCurrentState());
	}

	/**
	 * tests to get the state of a task.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetState2() throws Exception {
		Assert.assertEquals(TaskTest.model.getTypeManager().getInProcess(),
				TaskTest.t6.getCurrentState());
	}

	/**
	 * Test to get the state of a task.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetState3() throws Exception {
		Assert.assertEquals(TaskTest.model.getTypeManager().getClosed(),
				TaskTest.t1.getCurrentState());
	}

	/**
	 * Test to add a pbi to the task which is already added to it.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = DoubleDefinitionException.class)
	public void testCheckAddPBIConsistency1() throws Exception {
		TaskTest.t7.addPBI(TaskTest.pbi1);
		TaskTest.t7.checkAddPBIConsistency(TaskTest.pbi1);
	}

	/**
	 * Test to add a pbi to the task from a different sprint to check if the exception is
	 * thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = SprintAssociationException.class)
	public void testCheckAddPBIConsistency2() throws Exception {
		final Task t8 =
				new Task(TaskTest.model, TaskTest.task, "Task 8", "blubb",
						TaskTest.sprintbl);
		final Feature pbi =
				new Feature(TaskTest.model, TaskTest.type,
						"testCheckAddPBIConsistency2", "Test1", TaskTest.pbltest);
		t8.checkAddPBIConsistency(pbi);
	}

	/**
	 * Checks the consistency of a task.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCheckAddPBIConsistency3() throws Exception {
		TaskTest.t7.checkAddPBIConsistency(TaskTest.pbi2);
	}

	/**
	 * tests the check of the name validity with a not valid value.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = NoValidValueException.class)
	public void testCheckNameValidity1() throws Exception {
		TaskTest.t1.checkNameValidity("");
	}

	/**
	 * test the check of the name validity of the task.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCheckNameValidity2() throws Exception {
		TaskTest.t1.checkNameValidity("Name");
	}

	/**
	 * Test to check the description of a task with a not valid value to check if the
	 * exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = NoValidValueException.class)
	public void testCheckDescriptionValidity1() throws Exception {
		TaskTest.t1.checkDescriptionValidity("");
	}

	/**
	 * Tests to get the description of a task.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCheckDescriptionValidity2() throws Exception {
		TaskTest.t1.checkDescriptionValidity("Name");
	}

	/**
	 * Test to get a project related to the task.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetProject() throws Exception {
		Assert.assertEquals(TaskTest.t1.getProject(), TaskTest.test);
	}
}
