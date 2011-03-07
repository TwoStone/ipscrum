package fhdw.ipscrum.shared.model;


import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;




public class Test_TaskAssigned {

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

	// ------------------------------------------------------------------
	// ------------------------ Test of functions -----------------------
	// ------------------------------------------------------------------


	@Test
	/**
	 * Getting the responsible Person
	 */
	public void testGetResponsiblePerson() throws Exception{
		assertEquals(per1,t1.getResponsiblePerson());
	}

	@Test
	/**
	 * Setting the responsible person
	 */
	public void testSetResponsiblePerson() throws Exception{
		t1.setResponsibility(per2);
		assertEquals(per2,t1.getResponsiblePerson());
	}

}
