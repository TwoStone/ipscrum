package fhdw.ipscrum.shared.model;


import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;

public class Test_Sprintbacklog {
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
	private static Integer eight = null;
	private static Integer five = null;
	private static Integer platzhalter = null;

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
		eight = 8;
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
		
		t1.setPlanEffort(3);
		t2.doSetPlanEffort(5);
		
		t1.addPBI(pbi1);
		t1.setResponsibility(per1);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	
	// ----------------------------------------------------------------------------------
	// ----------------------------- Test of functions ----------------------------------
	// ----------------------------------------------------------------------------------
	
	@Test
	/**
	 * Getting the Sprint
	 */
	public void testGetSprint() throws Exception{
		assertEquals(sprint, sprintbl.getSprint());
	}
	
	@Test
	/**
	 * Checking, if a task is in a specific sprint
	 */
	public void testHasTask1() throws Exception{
		assertEquals(true, sprintbl.hasTask(t1));
	}
	
	@Test
	/**
	 * Checking, if a task is in a specific sprint
	 */
	public void testHasTask2() throws Exception{
		assertEquals(false, sprintbl.hasTask(t3));
	}
	
	@Test
	/**
	 * Addition of a Task to a sprintbacklog
	 */
	public void testAddTask() throws Exception{
		sprintbl.addTask(t3);
		assertEquals(true,sprintbl.hasTask(t3));
	}
	
	@Test
	/**
	 * Removing of a task from a sprintbacklog
	 */
	public void testRemoveTask() throws Exception{
		sprintbl.removeTask(t3);
		assertEquals(false, sprintbl.hasTask(t3));
	}
	
	@Test
	/**
	 * Checking, if a task belongs to a specific PBI
	 */
	public void testHasPBI1() throws Exception{
		assertEquals(true,sprintbl.hasPBI(pbi1));
	}
	
	@Test
	/**
	 * Checking, if a task belongs to a specific PBI
	 */
	public void testHasPBI2() throws Exception{
		assertEquals(false, sprintbl.hasPBI(pbi2));
	}
	
	@Test
	/**
	 * Removing a BPI from a sprint
	 */
	public void testRemovePBIFromTasks() throws Exception{
		t2.addPBI(pbi2);
		sprintbl.removePBIFromTasks(pbi2);
		assertEquals(false, sprintbl.hasPBI(pbi2));
	}
	
	@Test
	/**
	 * Calculation of overall effort of all tasks
	 */
	public void testCalculateOverallTaskEffort() throws Exception{
		platzhalter = sprintbl.calculateOverallTaskEffort();
		assertEquals(eight, platzhalter);
	}
	
	@Test
	/**
	 * Calculation of Effort remaining
	 */
	public void testGetEffortByDay() throws Exception{
		t1.finish(new Date(2011-01-01));
		platzhalter = sprintbl.getEffortByDay(new Date());
		assertEquals(five, platzhalter);
	}
	
}