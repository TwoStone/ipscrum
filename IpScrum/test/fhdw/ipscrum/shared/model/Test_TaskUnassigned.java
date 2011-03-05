package fhdw.ipscrum.shared.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.junit.*;

import fhdw.ipscrum.shared.model.*;

import fhdw.ipscrum.shared.model.TaskUnassigned;


public class Test_TaskUnassigned extends junit.framework.TestCase{
	
	private static Person per1 = null;
	private static Feature pbi1 = null;
	private static Project test = null;
	private static ProductBacklog pbltest = null;
	private static Task t1 = null;
	private static List<ProductBacklogItem> apbis;
	private static Date finishedDate = null;
	private static Integer three = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test = new Project("Test");
		pbltest = test.getBacklog();
		per1 = new Person("Max", "Mustermann");
		pbi1 = new Feature("A", "Test1", pbltest);
		t1 = new Task("Task 1", "Beschreibung");
		three = 3;

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
	 * Setting the Responsibility
	 */
	public void testSetResponsibility() throws Exception{
		t1.setResponsibility(per1);
		assertEquals(per1,t1.getResponsiblePerson());
	}

	@Test
	/**
	 * Adding a pbi
	 */
	public void testAddPBI() throws Exception{
		t1.addPBI(pbi1);
		assertEquals(apbis.add(pbi1),t1.getPBIIterator());
	}

	@Test
	/**
	 * Removing a pbi
	 */
	public void testRemovePBI()  throws Exception{
		t1.removePBI(pbi1);
		assertEquals(apbis.remove(pbi1),t1.getPBIIterator());
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
