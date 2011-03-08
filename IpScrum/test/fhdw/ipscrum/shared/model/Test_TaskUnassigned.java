package fhdw.ipscrum.shared.model;


import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;
import java.util.Iterator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class Test_TaskUnassigned {

	private static Person per1 = null;
	private static Feature pbi1 = null;
	private static ProductBacklogItem pbix = null;
	private static Project test = null;
	private static ProductBacklog pbltest = null;
	private static Task t1 = null;
	private static Date finishedDate = null;
	private static Integer three = null;
	private static Team team1 = null;
	private static Sprint sprint = null;
	private static SprintBacklog sprintbl = null;
	private static Boolean pl1 = null;
	private static Iterator<ProductBacklogItem> pbiIt = null;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test = new Project("Test");
		pbltest = test.getBacklog();
		per1 = new Person("Max", "Mustermann");
		pbi1 = new Feature("A", "Test1", pbltest);
		t1 = new Task("Task 1", "Beschreibung");
		three = 3;
		team1 = new Team("Team");
		team1.addMember(per1);
		sprint = new Sprint("Sprint", "Beschreibung", new Date(),new Date(), team1);
		sprintbl = sprint.getSprintBacklog();
		pl1 = false;
		test.addSprint(sprint);
		
		pbltest.addItem(pbi1);
		sprintbl.addTask(t1);
		pbi1.setSprint(sprint);
		

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	// ---------------------------------------------------------------------------
	// ---------------------- Test of functions ----------------------------------
	// ---------------------------------------------------------------------------

	@Test
	/**
	 * Getting the name of the task
	 */
	public void testGetName() throws Exception{
		assertEquals("Task 1", t1.getName());
	}

	@Test
	/**
	 * Setting the name of the task
	 */
	public void testSetName() throws Exception{
		t1.setName("Task");
		assertEquals("Task", t1.getName());

	}

	@Test
	/**
	 * Setting description of a task
	 */
	public void testSetDescription() throws Exception{
		t1.setDescription("Beschreibung geändert");
		assertEquals("Beschreibung geändert", t1.getDescription());
	}

	@Test
	/**
	 * Test on having a responsible Person
	 */
	public void testHasResponsiblePerson() throws Exception{
		assertEquals(false, t1.hasResponsiblePerson());
	}

	@Test
	/**
	 * Test on getting responsible Person
	 */
	public void testGetResponsiblePerson() throws Exception{
		assertEquals(null, t1.getResponsiblePerson());
	}

	@Test
	/**
	 * Adding a pbi
	 */
	public void testAddPBI() throws Exception{
		t1.addPBI(pbi1);
        pbiIt = t1.getPBIIterator();
        while(pbiIt.hasNext())
            pbix = pbiIt.next();
            if(pbix == pbi1){ pl1 =true;}

        assertEquals(true,pl1);
    } 

	@Test
	/**
	 * Removing a pbi
	 */
	public void testRemovePBI()  throws Exception{
        t1.removePBI(pbi1);
        pl1 = true;
        pbiIt = t1.getPBIIterator();
        pl1 = true;
        while(pbiIt.hasNext()){
            pbix = pbiIt.next();
            if(pbix == pbi1) pl1 = false;
            }
        assertEquals(true,pl1);
	}

	@Test
	/**
	 * Setting the Responsibility
	 */
	public void testSetResponsibility() throws Exception{
		t1.setResponsibility(per1);
		assertEquals(per1,t1.getResponsiblePerson());
	}


	@Test
	/**
	 * Test on task being finished
	 */
	public void testFinished() throws Exception{
		assertEquals(false, t1.isFinished());
	}

	@Test
	/**
	 * Getting Finished Date
	 */
	public void testGetFinishedDate() throws Exception{
		assertEquals(null, t1.getFinishDate());
	}

	@Test
	/**
	 * Setting of planned effort
	 */
	public void testSetPlanEffort() throws Exception{
		t1.setPlanEffort(3);
		assertEquals(three, t1.getPlanEffort());
	}

	// ----------------------------------------------------------------------------
	// ------------------------------ Test of Exceptions --------------------------
	// ----------------------------------------------------------------------------

	// TODO: Test of setting a Task on finished()

}
