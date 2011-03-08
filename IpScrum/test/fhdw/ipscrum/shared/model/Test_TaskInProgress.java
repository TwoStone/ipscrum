package fhdw.ipscrum.shared.model;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import fhdw.ipscrum.shared.exceptions.*;

public class Test_TaskInProgress {
	
	private static Person per1 = null;
	private static Person per2 = null;
	private static Feature pbi1 = null;
	private static Feature pbi2 = null;
	private static ProductBacklogItem pbix = null;
	private static Project test = null;
	private static ProductBacklog pbltest = null;
	private static Task t1 = null;
	private static Task t2 = null;
	private static Task t3 = null;
	private static Sprint sprint = null;
	private static Team team1 = null;
	private static SprintBacklog sprintbl = null;
	private static Integer five = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test = new Project("Test");
		pbltest = test.getBacklog();
		per1 = new Person("Max", "Mustermann");
		per2 = new Person("Karin", "Katze");
		pbi1 = new Feature("A", "Test1", pbltest);
		pbi2 = new Feature("B", "Test2", pbltest);
		t1 = new Task("Task 1", "Beschreibung");
		t2 = new Task("Task 2", "Beschreibung 2");
		t3 = new Task("Task 3", "Beschreibung 3");
		team1 = new Team("Team");
		sprint = new Sprint("Sprint", "Beschreibung", new Date(),new Date(), team1);
		sprintbl = sprint.getSprintBacklog();
		five = 5;
		
		pbltest.addItem(pbi1);
		pbltest.addItem(pbi2);
		test.addSprint(sprint);
		
		team1.addMember(per1);
		team1.addMember(per2);
		pbi1.setSprint(sprint);
		pbi2.setSprint(sprint);
		
		sprintbl.addTask(t1);
		sprintbl.addTask(t2);
		sprintbl.addTask(t3);
		
		t1.addPBI(pbi1);
		t2.addPBI(pbi2);
		t3.addPBI(pbi2);
		
		t1.setResponsibility(per1);
		t2.setResponsibility(per2);
		t3.setResponsibility(per1);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	// -----------------------------------------------------------------------------------------
	// ----------------------------- Test of Functions -----------------------------------------
	// -----------------------------------------------------------------------------------------
	
	@Test
	/**
	 * Changing the Responsibility of a Task
	 */
	public void testSetResponsibility() throws Exception{
		t1.setResponsibility(per2);
		assertEquals(per2, t1.getResponsiblePerson());
	}
	
	@Test
	/**
	 * Changing of the Description
	 */
	public void testSetDescription() throws Exception{
		t1.setDescription("Beschreibung geändert");
		assertEquals("Beschreibung geändert", t1.getDescription());
	}
		
	@Test
	/**
	 * Finishing a Task
	 */
	public void testFinish1() throws Exception{
		t1.finish();
		assertEquals(true,t1.isFinished());
	}
	
	@Test
	/**
	 * Finishing a Task
	 */
	public void testFinish2() throws Exception{
		t2.finish(new Date());
		assertEquals(true,t2.isFinished());
	}
	
	@Test
	/**
	 * Test on having a Responsible Person
	 */
	public void testHasResponsiblePerson() throws Exception{
		assertEquals(true, t3.hasResponsiblePerson());
	}
	
	@Test
	/**
	 * Getting the responsible Person
	 */
	public void testGetResponsiblePerson() throws Exception{
		assertEquals(per1,t3.getResponsiblePerson());
	}
	
	@Test
	/**
	 * Getting the finish Date
	 */
	public void testGetFinishDate() throws Exception{
		assertEquals(null, t3.getFinishDate());
	}
	
	@Test
	/**
	 * Checking, if a Task is finished
	 */
	public void testIsFinished() throws Exception{
		assertEquals(false, t3.isFinished());
	}
	

	@Test
	/**
	 * Setting the planned effort
	 */
	public void testSetPlanEffort() throws Exception{
		t3.setPlanEffort(5);
		assertEquals(five,t3.getPlanEffort());
	}
	
	
	// -----------------------------------------------------------------------------------------
	// ----------------------------- Test of Exceptions ----------------------------------------
	// -----------------------------------------------------------------------------------------

	@Test(expected = ForbiddenStateException.class)
	/**
	 * Adding of a PBI
	 */
	public void testAddPBI() throws Exception{
		t3.addPBI(pbi1);
	}
	
	@Test(expected = ForbiddenStateException.class)
	/**
	 * Removing of a PBI
	 */
	public void testRemovePBI() throws Exception{
		t3.removePBI(pbi1);
	}
	
	@Test(expected = ForbiddenStateException.class)
	/**
	 * Changing of the name
	 */
	public void testSetName() throws Exception{
		t3.setName("Name geändert");
		}
}
