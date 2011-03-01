package fhdw.ipscrum.phase3.gruppe1;


import org.junit.*;

import fhdw.ipscrum.shared.model.*;


public class Test_Task extends junit.framework.TestCase{

	private static Person per1 = null;
	private static Person per2 = null;
	private static Feature pbi = null;
	private static Project test = null;
	private static ProductBacklog pbltest = null;
	private static Task t1 = null;
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test = new Project("Test");
		pbltest = test.getBacklog();
		
		per1 = new Person("Max", "Mustermann");
		per2 = new Person("Karin","Katze");
		pbi = new Feature("T", "Test", pbltest);
		t1 = new Task("Task 1", pbi);
	
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	/**
	 * Get Name of a task
	 */
	public void testGetName() throws Exception{
		assertEquals("Task 1", t1.getName());
	}
	
	
	
	@Test
	/**
	 * Test on assigned a task to a Person
	 */
	public void testSetResponsibility() throws Exception{
		t1.setResponsibilty(per1);
		asserEquals(per1, t1.getResponsiblePerson());
	}
	
	@Test
	/**
	 * Test on assigned a task to a Person
	 * throws Exception
	 */
	public void testSetResponsibility1() throws Exception{
		t1.setResponsibilty(per1);
		asserEquals(per2, t1.getResponsiblePerson());
	}
	
	@Test
	/**
	 * Change the assigned Person of a task
	 */
	
	public void testchangeResponsibility() throws Exception{
		t1.changeResponsibility(per2);
		assertEquals(per2,t1.getResposibleperson);
	}

	
	@Test
	/**
	 * Change the name of a task
	 */
	public void testchangeName() throws Exception{
		t1.changeName("Task 2");
		assertEquals("Task 2", t1.getName());
	}
	
//	@Test
	/**
	 * 
	 */
	
	
	
	
//	@Test
	/**
	 * Closing of a task
	 */
	public void testclose() throws Exception{
		t1.close();
		// TODO
	}
	
	

}
