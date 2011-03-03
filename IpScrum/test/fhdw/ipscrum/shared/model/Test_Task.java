package fhdw.ipscrum.shared.model;

import static org.junit.Assert.assertEquals;

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


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test = new Project("Test");
		pbltest = test.getBacklog();
		per1 = new Person("Max", "Mustermann");
		per2 = new Person("Karin","Katze");
		pbi1 = new Feature("A", "Test1", pbltest);
		pbi2 = new Feature("B", "Test2", pbltest);
		pbi3 = new Feature("C", "Test3", pbltest);
		pbi4 = new Feature("D", "Test4", pbltest);
		t1 = new Task("Task 1", "Beschreibung");


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
	public void testGetName() throws Exception{
		assertEquals("Task 1", t1.getName());
	}

	@Test
	/**
	 * Test of setName()
	 */
	public void testSetName() throws Exception{
		t1.setName("Task");
		assertEquals("Task", t1.getName());
	}

	@Test
	/**
	 * Test on getting the assigned person
	 */

	public void testGetResposiblePersoon() throws Exception{
		// TODO: How best to test, if no person is assigned at first?
	}

	@Test
	/**
	 * Test on assigned a task to a Person
	 */
	public void testSetResponsibility() throws Exception{
		t1.setResponsibility(per1);
		assertEquals(per1, t1.getResponsiblePerson());
	}

	@Test
	/**
	 * Test on assigned a task to a Person
	 * throws Exception
	 */
	public void testSetResponsibility1() throws Exception{
		t1.setResponsibility(per1);
		assertEquals(per2, t1.getResponsiblePerson());
	}


	//	@Test
	/**
	 * 
	 */




	//	@Test
	/**
	 * Closing of a task
	 */
	public void testFinish() throws Exception{
		t1.finish();
		// TODO: assertEquals
		//assertEquals(,t1.getState())
	}



}
