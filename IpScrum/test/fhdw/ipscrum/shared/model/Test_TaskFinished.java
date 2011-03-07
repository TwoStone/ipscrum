package fhdw.ipscrum.shared.model;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;


public class Test_TaskFinished {
	
	private static Person per1 = null;
	private static Person per2 = null;
	private static Feature pbi1 = null;
	private static Task t1 = null;
	private static Sprint sprint = null;
	private static Team team1 = null;
	private static SprintBacklog sprintbl = null;
	private static Project test = null;
	private static ProductBacklog pbltest = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		t1 = new Task("Task 1", "Beschreibung");
		per1 = new Person("Max", "Mustermann");
		per2 = new Person("Karin","Katze");
		test = new Project("Test");
		pbltest = test.getBacklog();
		pbi1 = new Feature("A", "Test1", pbltest);
		team1 = new Team("Team");
		sprint = new Sprint("Sprint", "Beschreibung", new Date(),new Date(), team1);
		sprintbl = new SprintBacklog(sprint);
		t1.setResponsibility(per1);
		
		pbltest.addItem(pbi1);
		team1.addMember(per1);
		team1.addMember(per2);
		pbi1.setSprint(sprint);
		
		sprintbl.addTask(t1);
		
		t1.setResponsibility(per1);
		t1.finish();
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
		assertEquals(new Date(), t1.getFinishDate());
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
	
	// @Rule
	// TODO: Warum kann org.junit.rules.ExpectedException.class nicht in den Sourcen gefunden werden? 
	// public ExpectedException ee = new ExpectedException();
	
	


}
