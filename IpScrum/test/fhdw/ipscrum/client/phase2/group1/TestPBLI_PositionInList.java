package fhdw.ipscrum.client.phase2.group1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Release;

public class TestPBLI_PositionInList {

	private static Project test = null;
	private static ProductBacklog pbltest = null;
	private static Feature a = null;
	private static Feature b = null;
	private static Feature c = null;
	private static Feature d = null;
	private static Date cvCurrentDate = null;
	private static Date cvCurrentDate2 = null;

	@SuppressWarnings("deprecation")
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test = new Project("test");
		pbltest = test.getBacklog();
		
		cvCurrentDate = new Date();
		cvCurrentDate2 = cvCurrentDate;
		cvCurrentDate2.setMonth(Calendar.MONTH+1);

		a = new Feature("A", "testA", pbltest);
		b = new Feature("B", "testB", pbltest);
		c = new Feature("C", "testC", pbltest);
		d = new Feature("D", "testD", pbltest);

		// System.out.println(pbltest.getItems().toString());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	/**
	 * successful MoveUp() on an element in PBL
	 */
	public void testMoveUp1() throws Exception {
		ProductBacklogItem item = (ProductBacklogItem) pbltest.getItems().get(1);
		int positionOfItemNo2 = pbltest.getItemPositionInList(item);
		pbltest.moveUp(item);
		assertEquals(item, pbltest.getItems().get(positionOfItemNo2 - 1));
	}


	@Test
	/**
	 * MoveUp() on the first element of PBL, throws an exception
	 * @throws Exception
	 */
	public void testMoveUp2() throws Exception {
		ProductBacklogItem holder = pbltest.getItems().get(0);
		pbltest.moveUp(holder);
		assertEquals(holder, pbltest.getItems().get(0));
	}
	
	@Test
	/**
	 * successful MoveDown() on an element in PBL
	 */
	public void testMoveDown1() throws Exception {
		ProductBacklogItem item = (ProductBacklogItem) pbltest.getItems().get(0);
		int positionOfItemNo1 = pbltest.getItemPositionInList(item);
		pbltest.moveDown(item);
		assertEquals(item, pbltest.getItems().get(positionOfItemNo1 + 1));
	}


	@Test
	/**
	 * MoveDown() on last element in PBL, throws an exception
	 * @throws Exception
	 */
	public void testMoveDown2() throws Exception {
		int lastPositionInList = pbltest.getItems().size() - 1;
		ProductBacklogItem holder = pbltest.getItems().get(lastPositionInList);
		pbltest.moveDown(holder);
		assertEquals(holder, pbltest.getItems().get(lastPositionInList));
	}
	
	//************************************************************************
	//************************************************************************
	
	@Test
	/**
	 * successful MoveTop() on an element in PBL
	 */
	public void testMoveTop1() throws Exception {
		int lastPositionInList = pbltest.getItems().size() - 1;
		ProductBacklogItem item = (ProductBacklogItem) pbltest.getItems().get(lastPositionInList);
		pbltest.moveTop(item);
		assertEquals(item, pbltest.getItems().get(0));
	}
	
	@Test
	/**
	 * special case
	 * MoveTop() on first element in PBL
	 */
	public void testMoveTop2() throws Exception {
		ProductBacklog lvBacklog = pbltest;
		ProductBacklogItem item = (ProductBacklogItem) pbltest.getItems().get(0);
		pbltest.moveTop(item);
		assertEquals(lvBacklog, pbltest);
	}
	
	@Test
	/**
	 * MoveTop() on last element of PBL
	 */
	public void testMoveTop3() throws Exception {
		int lastPositionInList = pbltest.getItems().size() - 1;
		ProductBacklogItem item = (ProductBacklogItem) pbltest.getItems().get(lastPositionInList);
		ProductBacklogItem item2 = (ProductBacklogItem) pbltest.getItems().get(0);
		pbltest.moveTop(item);
		assertEquals(item2, pbltest.getItems().get(1));
	}
	
	@Test
	/**
	 * successful MoveBottom() on first element in PBL
	 */
	public void testMoveBottom1() throws Exception {
		int lastPositionInList = pbltest.getItems().size() - 1;
		ProductBacklogItem item = (ProductBacklogItem) pbltest.getItems().get(0);
		pbltest.moveBottom(item);
		assertEquals(item, pbltest.getItems().get(lastPositionInList));
	}
	
	@Test
	/**
	 * MoveBottom() on last element in PBL
	 */
	public void testMoveBottom2() throws Exception {
		int lastPositionInList = pbltest.getItems().size() - 1;
		ProductBacklog lvBacklog = pbltest;
		ProductBacklogItem item = (ProductBacklogItem) pbltest.getItems().get(lastPositionInList);
		pbltest.moveBottom(item);
		assertEquals(lvBacklog, pbltest);
	}
	
	@Test
	/**
	 * MoveBottom() on last element in PBL
	 */
	public void testMoveBottom3() throws Exception {
		int lastPositionInList = pbltest.getItems().size() - 1;
		ProductBacklogItem item = (ProductBacklogItem) pbltest.getItems().get(0);
		ProductBacklogItem item2 = (ProductBacklogItem) pbltest.getItems().get(lastPositionInList);
		pbltest.moveBottom(item);
		assertEquals(item2, pbltest.getItems().get(lastPositionInList-1));
	}
	
	//************************************************************************
	//************************************************************************
	
	@Test
	/**
	 * Addition of a new element (here: feature)
	 */
	public void testAddPBI() throws Exception {
		int entriesInList = pbltest.getItems().size();
		new Feature("E", "Test E", pbltest);
		// System.out.println(pbltest.getItems().get(entriesInList));
		assertEquals(entriesInList + 1 , pbltest.getItems().size());
	}
	
	@Test
	/**
	 * Removal of a selected element in PBL
	 */
	public void testDeletePBI() throws Exception {
		int entriesInList = pbltest.getItems().size();
		pbltest.removeItem(pbltest.getItems().lastElement());
		
		assertEquals(entriesInList - 1 , pbltest.getItems().size());
	}
	
	//************************************************************************
	//************************************************************************
	
	@Test
	/**
	 * No item in PBL, when new Project is created
	 */
	public void testCount1() throws Exception {
		Project lvProject = new Project("wayne");
		assertEquals(0, lvProject.getBacklog().getItems().size());
	}
	
	@Test
	/**
	 * Addition of several new elements to a PBL, after a new Project
	 * has been created
	 */
	public void testCount2() throws Exception {
		Project lvProject = new Project("wayne");
		assertEquals(0, lvProject.getBacklog().getItems().size());
		new Feature("1", "", lvProject.getBacklog());
		new Feature("2", "", lvProject.getBacklog());
		new Feature("3", "", lvProject.getBacklog());
		new Feature("4", "", lvProject.getBacklog());
	
		assertEquals(4 , lvProject.getBacklog().getItems().size());
	}
	
	//************************************************************************
	//************************************************************************
	
	@Test
	/**
	 * a new Release is created
	 */
	public void testAddRelease() throws Exception {
		int holder = test.getReleasePlan().size();
		new Release("0.0.1", cvCurrentDate, test);
		
		assertEquals(holder + 1, test.getReleasePlan().size());
	}
	
	@Test
	/**
	 * a new Release is created, but the name already exists. Exception is
	 * thrown
	 */
	public void testAddRelease2(){
		int holder = test.getReleasePlan().size();
		try {
			new Release("0.0.1", cvCurrentDate, test);
			
			fail("keine Fehlermeldung gekommen");
		} catch (DoubleDefinitionException e) {
			assertEquals(holder, test.getReleasePlan().size());
		}
	}
	
	
	//************************************************************************
	//************************************************************************
	
	@Test
	/**
	 * a new Project is created
	 */
	public void testProjectEquals() throws Exception {
		Project lvProject = test;
		assertEquals(lvProject, test);
	}
	
	@Test
	/**
	 * a new PBL is created on creation of a Project
	 */
	public void testPBLEquals() throws Exception {
		ProductBacklog lvBacklog = pbltest;
		assertEquals(lvBacklog, pbltest);
	}

	
}
