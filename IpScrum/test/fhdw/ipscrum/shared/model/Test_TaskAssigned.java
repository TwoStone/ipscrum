package fhdw.ipscrum.shared.model;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;




public class Test_TaskAssigned {

	private static Person per1 = null;
	private static Person per2 = null;
	private static Task t1 = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		t1 = new Task("Task 1", "Beschreibung");
		per1 = new Person("Max", "Mustermann");
		per2 = new Person("Karin","Katze");
		t1.setResponsibility(per1);
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
