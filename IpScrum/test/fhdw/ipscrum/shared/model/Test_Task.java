package fhdw.ipscrum.shared.model;

import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_Task {

	private static Person per1 = null;
	private static Person per2 = null;
	private static Feature pbi1 = null;
	private static Feature pbi2 = null;
	private static Feature pbi3 = null;
	private static Feature pbi4 = null;
	private static Project test = null;
	private static ProductBacklog pbltest = null;
	private static Task t1 = null;
	private static Task t2 = null;
	private static Task t3 = null;
	private static List<ProductBacklogItem> apbis;
	private static List<ProductBacklogItem> apbis2;
	private static List<ProductBacklogItem> apbis3;
	private static Integer zero = null;
	private static Integer three = null;
	private static Sprint sprint = null;
	private static Team team1 = null;
	private static SprintBacklog sprintbl = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test = new Project("Test");
		pbltest = test.getBacklog();
		per1 = new Person("Max", "Mustermann");
		per2 = new Person("Karin", "Katze");
		pbi1 = new Feature("A", "Test1", pbltest);
		pbi2 = new Feature("B", "Test2", pbltest);
		pbi3 = new Feature("C", "Test3", pbltest);
		pbi4 = new Feature("D", "Test4", pbltest);
		t1 = new Task("Task 1", "Beschreibung");
		t2 = new Task("Task 2", "Beschreibung 2");
		t3 = new Task("Task 3", "Beschreibung 3");
		apbis = new ArrayList<ProductBacklogItem>();
		apbis2 = new ArrayList<ProductBacklogItem>();
		apbis3 = new ArrayList<ProductBacklogItem>();
		zero = 0;
		three = 3;
		team1 = new Team("Team");
		sprint = new Sprint("Sprint", "Beschreibung", new Date(),new Date(), team1);
		sprintbl = new SprintBacklog(sprint);
		
		pbltest.addItem(pbi1);
		pbltest.addItem(pbi2);
		pbltest.addItem(pbi3);
		pbltest.addItem(pbi4);
		test.addSprint(sprint);
		
		team1.addMember(per1);
		team1.addMember(per2);
		pbi1.setSprint(sprint);
		pbi2.setSprint(sprint);
		pbi3.setSprint(sprint);
		pbi4.setSprint(sprint);
		
		sprintbl.addTask(t1);
		sprintbl.addTask(t2);
		sprintbl.addTask(t3);
		
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	// ---------------------------------------------------------------------------
	// ------------------------- Test of basic functions
	// -------------------------
	// ---------------------------------------------------------------------------

	@Test
	/**
	 * Get Name of a task
	 */
	public void testGetName() throws Exception {
		assertEquals("Task 1", t1.getName());
	}

	@Test
	/**
	 * Test of setName()
	 */
	public void testSetName() throws Exception {
		t1.setName("Task");
		assertEquals("Task", t1.getName());
	}

	@Test
	/**
	 * Test on getting the assigned person
	 */
	public void testGetResposiblePerson() throws Exception {
		assertEquals(null, t1.getResponsiblePerson());
	}

	@Test
	/**
	 * Test on assigned a task to a Person
	 */
	public void testSetResponsibility() throws Exception {
		t1.setResponsibility(per1);
		assertEquals(per1, t1.getResponsiblePerson());
	}

	@Test
	/**
	 * Test on assigned a task to a Person
	 * throws Exception
	 */
	public void testSetResponsibility1() throws Exception {
		t1.setResponsibility(per1);
		assertEquals(per2, t1.getResponsiblePerson());
	}

	@Test
	/**
	 * Getting pbi's of a task
	 */
	public void testgetpbi() throws Exception {
		assertEquals(null, t1.getPBIIterator());
	}

	@Test
	/**
	 * Addition of a pbi
	 */
	public void testaddpbi() throws Exception {
		t1.addPBI(pbi1);
		assertEquals(pbi1, t1.getPBIIterator());
	}

	@Test
	/**
	 * Getting the description
	 */
	public void testgetDescription() throws Exception {
		assertEquals("Beschreibung", t1.getDescription());
	}

	@Test
	/**
	 * Getting the finish Date
	 */
	public void testgetFinishDate() throws Exception {
		assertEquals(null, t1.getFinishDate());
	}

	@Test
	/**
	 * Closing of a task
	 */
	public void testFinish() throws Exception {
		t1.setResponsibility(per1);
		t1.finish();
		assertEquals(true, t1.isFinished());
	}

	@Test
	/**
	 * Getting pbi-Iterator
	 */
	public void testIterator() throws Exception {
		assertEquals(apbis.add(pbi1), t1.getPBIIterator());
	}

	@Test
	/**
	 * Getting planed effort
	 */
	public void testGetPlanEffort() throws Exception {
		assertEquals(zero, t1.getPlanEffort());
	}

	@Test
	/**
	 * Setting the planed effort
	 */
	public void testSetPlanEffort() throws Exception {
		t1.setPlanEffort(3);
		assertEquals(three, t1.getPlanEffort());
	}

	@Test
	/**
	 * Getting the state of a task
	 */
	public void testgetState() throws Exception {
		// TODO: assertEquals(,t1.getState());
	}

	@Test
	/**
	 * Test of having a responsible person
	 */
	public void testHasResponsiblePerson() throws Exception {
		assertEquals(false, t1.hasResponsiblePerson());
	}

	@Test
	/**
	 * Setting of description
	 */
	public void testSetDescription() throws Exception {
		t1.setDescription("Beschreibung geändert");
		assertEquals("Beschreibung geändert", t1.getDescription());
	}

	// ---------------------------------------------------------------------------------
	// ---------------------- Test of more complex functions
	// ---------------------------
	// ---------------------------------------------------------------------------------

	@Test
	/**
	 * Removing a PBI
	 */
	public void testRemovePBI() throws Exception {
		t1.removePBI(pbi1);
		assertEquals(apbis, t1.getPBIIterator());
	}

	// ----------------------------------------------------------------------------------
	// -------------------------------------- Test of cases
	// -----------------------------
	// ----------------------------------------------------------------------------------

	@Test
	/**
	 * Full run through of the life circle of a task
	 */
	public void testLifeCircle1() throws Exception {
		// Setting name and planed effort
		t2.setName("Task");
		t2.setPlanEffort(3);

		// Adding a pbi
		t2.addPBI(pbi2);

		// Assigning a person
		t2.setResponsibility(per2);

		// Finish task
		t2.finish();

		assertEquals(true, t2.isFinished());
		assertEquals("Task", t2.getName());
		assertEquals(three, t2.getPlanEffort());
		assertEquals(apbis2.add(pbi2), t2.getPBIIterator());
		assertEquals(per2, t2.getResponsiblePerson());

	}

	@Test
	/**
	 * Full run through of the life circle of a task
	 * several pbi's added
	 * pbi's removed
	 * person changed
	 */
	public void testLifeCircle2() throws Exception {
		// setting name and planned effort
		t3.setName("Task");
		t3.setPlanEffort(3);

		// adding 2 pbi's
		t3.addPBI(pbi3);
		t3.addPBI(pbi4);

		// assigning a person
		t3.setResponsibility(per1);

		// change person
		t3.setResponsibility(per2);

		// remove a pbi
		t3.removePBI(pbi3);

		// adding a pbi
		t3.addPBI(pbi1);

		// finish task
		t3.finish();

		// preparing apbis3
		apbis3.add(pbi4);
		apbis3.add(pbi1);

		assertEquals(true, t3.isFinished());
		assertEquals("Task", t3.getName());
		assertEquals(three, t3.getPlanEffort());
		assertEquals(apbis3, t3.getPBIIterator());
		assertEquals(per2, t3.getResponsiblePerson());

	}
}
