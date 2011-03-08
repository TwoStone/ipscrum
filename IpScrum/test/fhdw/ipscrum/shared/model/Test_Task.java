package fhdw.ipscrum.shared.model;


import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gwt.dev.js.rhino.ObjToIntMap.Iterator;

public class Test_Task {

	private static Person per1 = null;
	private static Person per2 = null;
	private static Feature pbi1 = null;
	private static Feature pbi2 = null;
	private static Feature pbi3 = null;
	private static Feature pbi4 = null;
	private static ProductBacklogItem pbix = null;
	private static Project test = null;
	private static ProductBacklog pbltest = null;
	private static Task t1 = null;
	private static Task t2 = null;
	private static Task t3 = null;
	private static Task t4 = null;
	private static Integer zero = null;
	private static Integer three = null;
	private static Sprint sprint = null;
	private static Team team1 = null;
	private static SprintBacklog sprintbl = null;
	private static Integer platzhalter = null;
	private static boolean pl1;
	

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
		t4 = new Task("Task 4", "Add and Remove");
		zero = 0;
		three = 3;
		team1 = new Team("Team");
		sprint = new Sprint("Sprint", "Beschreibung", new Date(),new Date(), team1);
		sprintbl = sprint.getSprintBacklog();
		platzhalter = 0;
		pl1 = false;
		
		pbltest.addItem(pbi1);
		pbltest.addItem(pbi2);
		pbltest.addItem(pbi3);
		pbltest.addItem(pbi4);
		pbltest.addItem(pbix);
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
		sprintbl.addTask(t4);
		}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	// ---------------------------------------------------------------------------
	// ------------------------- Test of basic functions -------------------------
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
	public void testGetResponsiblePerson() throws Exception {
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
	 * Getting pbi's of a task
	 */
	public void testGetPBI() throws Exception {
		while(t1.getPBIIterator().hasNext()){
				pbix = t1.getPBIIterator().next();
				if(pbix == null) assertTrue(pbix == null);
		}
	}

	@Test
	/**
	 * Addition of a pbi
	 */
	public void testAddPBI() throws Exception {
		t4.addPBI(pbi1);
		while(t4.getPBIIterator().hasNext())
			pbix = t4.getPBIIterator().next();
			if(pbix == pbi1){ pl1 =true;}
			
		assertEquals(true,pl1);
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
	 * Getting pbi-Iterator
	 */
	public void testIterator() throws Exception {
		t4.addPBI(pbi2);
		// assertEquals(x.add(pbi2), t4.getPBIIterator());
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
	 * Test of having a responsible person on a task having a responsible Person
	 */
	public void testHasResponsiblePerson1() throws Exception {
		assertEquals(true, t1.hasResponsiblePerson());
	}
	
	@Test
	/**
	 * Test of having a responsible person on a task without a responsible Person
	 */
	public void testHasResponsiblePerson2() throws Exception {
		assertEquals(false, t2.hasResponsiblePerson());
	}

	@Test
	/**
	 * Setting of description
	 */
	public void testSetDescription() throws Exception {
		t1.setDescription("Beschreibung geändert");
		assertEquals("Beschreibung geändert", t1.getDescription());
	}
	
	@Test
	/**
	 * Removing a PBI
	 */
	public void testRemovePBI() throws Exception {
		t4.removePBI(pbi1);
		while(t4.getPBIIterator().hasNext())
				pbix = t4.getPBIIterator().next();
				assertNotSame(pbi1, pbix);
				
	}
	
	@Test
	/**
	 * Testing on False on isFinished() on an unfinished Task
	 */
	public void testIsFinished() throws Exception{
		assertEquals(false, t4.isFinished());
	}
	
	@Test
	/**
	 * Closing of a task
	 */
	public void testFinish1() throws Exception {
		t1.setResponsibility(per1);
		t1.finish();
		assertEquals(true, t1.isFinished());
	}
	
	@Test
	/**
	 * Closing of a task
	 */
	public void testFinish2() throws Exception {
		t4.setResponsibility(per1);
		t4.finish(new Date());
		assertEquals(true, t1.isFinished());
	}
	
	@Test
	/**
	 * Getting the SprintBacklog
	 */
	public void testGetSprintbacklog() throws Exception{
		assertEquals(sprintbl, t1.getSprintBacklog());
	}
	
	@Test
	/**
	 * Getting the State of a task
	 */
	public void testGetState() throws Exception{
		// TODO: Test on getState()
	}

	@Test
	/**
	 * Testing on Equality
	 * Test also of indirectEquals, as task.Equals() only calls on indirectEquals()
	 */
	public void testEquals() throws Exception{
		assertEquals(true, t1.equals(t1));
	}
	
	@Test
	/**
	 * Testing on HashCode
	 * Test also of indirectHashCode() as task.HashCode() only calls on indirectHashCode()
	 */
	public void testHashCode(){
		// TODO: How to test that?		
	}
	
	@Test
	/**
	 * Test on having a PBI
	 */
	public void testHasPBI1() throws Exception{
		assertEquals(true, t4.hasPBI(pbi1));
	}
	
	@Test
	/**
	 * Test on not having a PBI
	 */
	public void testHasPBI2() throws Exception{
		assertEquals(false, t4.hasPBI(pbi3));
	}
	
	@Test
	/**
	 * Getting the state of a PBI
	 */
	public void testGetState1() throws Exception{
		// TODO: Test, use task t3(unassigend)
	}
	
	@Test
	/**
	 * Getting the state of a PBI
	 */
	public void testGetState2() throws Exception{
		// TODO: Test, use task t4(assigned), assign a person before doing so
	}
	
	@Test
	/**
	 * Getting the state of a PBI
	 */
	public void testGetState3() throws Exception{
		// TODO: Test, use task t1(finished)
	}

	// ----------------------------------------------------------------------------------
	// -------------------------------------- Test of cases -----------------------------
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
		// assertEquals(apbis2.add(pbi2), t2.getPBIIterator());
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
		
		// remove a pbi
		t3.removePBI(pbi3);

		// adding a pbi
		t3.addPBI(pbi1);
		
		// assigning a person
		t3.setResponsibility(per1);

		// change person
		t3.setResponsibility(per2);

		// finish task
		t3.finish();

		assertEquals(true, t3.isFinished());
		assertEquals("Task", t3.getName());
		assertEquals(three, t3.getPlanEffort());
		//assertEquals(apbis3, t3.getPBIIterator());
		assertEquals(per2, t3.getResponsiblePerson());

	}
}
