package fhdw.ipscrum.shared.model;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import fhdw.ipscrum.shared.exceptions.*;


public class Test_TaskFinished {
	
	private static Person per1 = null;
	private static Person per2 = null;
	private static Feature pbi1 = null;
	private static Feature pbi2 = null;
	private static Task t1 = null;
	private static Sprint sprint = null;
	private static Team team1 = null;
	private static SprintBacklog sprintbl = null;
	private static Project test = null;
	private static ProductBacklog pbltest = null;
	private static Date ende = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test = new Project("Test");
		pbltest = test.getBacklog();
		per1 = new Person("Max", "Mustermann");
		per2 = new Person("Karin","Katze");
		pbi1 = new Feature("A", "Test1", pbltest);
		pbi2 = new Feature("B", "Test2", pbltest);
		t1 = new Task("Task 1", "Beschreibung");
		team1 = new Team("Team");
		sprint = new Sprint("Sprint", "Beschreibung", new Date(),new Date(), team1);
		sprintbl = sprint.getSprintBacklog();
		ende = new Date(2011-03-03);
				
		pbltest.addItem(pbi1);
		pbltest.addItem(pbi2);
		test.addSprint(sprint);
		team1.addMember(per1);
		team1.addMember(per2);
		pbi1.setSprint(sprint);
		pbi2.setSprint(sprint);
		
		sprintbl.addTask(t1);
		
		t1.setResponsibility(per1);
		t1.finish(new Date(2011-03-03));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	// --------------------------------------------------------------------------------------
	// ------------------------------- Test of Functions ------------------------------------
	// --------------------------------------------------------------------------------------
	
	@Test
	/**
	 * Getting Finished Date
	 */
	public void testGetFinishDate() throws Exception{
		assertEquals(ende, t1.getFinishDate());
	}
	
	@Test
	/**
	 * Getting the responsible Person
	 */
	public void testGetResponsiblePerson() throws Exception{
		assertEquals(per1,t1.getResponsiblePerson());
	}
	
	@Test
	/**
	 * Test on having a responsible Person
	 */
	public void testHasResponsiblePerson() throws Exception{
		assertEquals(true,t1.hasResponsiblePerson());
	}
	
	@Test
	/**
	 * Test on being finished
	 */
	public void testIsFinished() throws Exception{
		assertEquals(true,t1.isFinished());
	}

	
	
	// ----------------------------------------------------------------------------------------
	// ----------------------------- Test of Exceptions ---------------------------------------
	// ----------------------------------------------------------------------------------------
	
	@Test(expected = ForbiddenStateException.class)
	/**
	 * Test on adding a PBI
	 */
	public void testAddPBI() throws Exception{
		t1.addPBI(pbi2);
	}
	
	@Test(expected = ForbiddenStateException.class)
	/**
	 * Test on finishing a Task
	 */
	public void testFinish1() throws Exception{
		t1.finish();
	}
	
	@Test(expected = ForbiddenStateException.class)
	/**
	 * Test on finishing a Task
	 */
	public void testFinish2() throws Exception{
		t1.finish(new Date());
	}
	
	@Test(expected = ForbiddenStateException.class)
	/**
	 * Test on removing a PBI
	 */
	public void testRemovePBI() throws Exception{
		t1.removePBI(pbi1);
	}
	
	@Test(expected = ForbiddenStateException.class)
	/**
	 * Test on setting the description
	 */
	public void testSetDescription() throws Exception{
		t1.setDescription("Beschreibung ändern");
	}
	
	@Test(expected = ForbiddenStateException.class)
	/**
	 * Test on setting the name
	 */
	public void testSetName() throws Exception{
		t1.setName("Task");
	}
	
	@Test(expected = ForbiddenStateException.class)
	/**
	 * Test on setting the responsibility
	 */
	public void testSetResponsibility() throws Exception{
		t1.setResponsibility(per2);
	}
	
	@Test(expected = ForbiddenStateException.class)
	/**
	 * Test on setting the planned effort
	 */
	public void testSetPlanEffort() throws Exception{
		t1.setPlanEffort(5);
	}
}
