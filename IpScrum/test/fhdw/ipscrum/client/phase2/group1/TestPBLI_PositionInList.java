package fhdw.ipscrum.client.phase2.group1;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static org.junit.Assert.*;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.Root;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.Team;

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
	public void testMoveUp1() throws Exception {
		ProductBacklogItem item = (ProductBacklogItem) pbltest.getItems().get(1);
		int positionOfItemNo2 = pbltest.getItemPositionInList(item);
		pbltest.moveUp(item);
		assertEquals(item, pbltest.getItems().get(positionOfItemNo2 - 1));
	}

	
	/**
	 * Move Up auf erstes Element der Liste
	 * @throws Exception
	 */
	@Test
	public void testMoveUp2() throws Exception {
		ProductBacklogItem holder = pbltest.getItems().get(0);
		pbltest.moveUp(holder);
		assertEquals(holder, pbltest.getItems().get(0));
	}
	
	@Test
	public void testMoveDown1() throws Exception {
		ProductBacklogItem item = (ProductBacklogItem) pbltest.getItems().get(0);
		int positionOfItemNo1 = pbltest.getItemPositionInList(item);
		pbltest.moveDown(item);
		assertEquals(item, pbltest.getItems().get(positionOfItemNo1 + 1));
	}

	/**
	 * Move Down auf letztes Element der Liste
	 * @throws Exception
	 */
	@Test
	public void testMoveDown2() throws Exception {
		int lastPositionInList = pbltest.getItems().size() - 1;
		ProductBacklogItem holder = pbltest.getItems().get(lastPositionInList);
		pbltest.moveDown(holder);
		assertEquals(holder, pbltest.getItems().get(lastPositionInList));
	}
	
	@Test
	public void testAddPBI() throws Exception {
		int entriesInList = pbltest.getItems().size();
		new Feature("E", "Test E", pbltest);
		// System.out.println(pbltest.getItems().get(entriesInList));
		assertEquals(entriesInList + 1 , pbltest.getItems().size());
	}
	
	@Test
	public void testDeletePBI() throws Exception {
		int entriesInList = pbltest.getItems().size();
		pbltest.removeItem(pbltest.getItems().lastElement());
		
		assertEquals(entriesInList - 1 , pbltest.getItems().size());
	}
	
	@Test
	public void testCount1() throws Exception {
		Project lvProject = new Project("wayne");
		assertEquals(0, lvProject.getBacklog().getItems().size());
	}
	
	@Test
	public void testCount2() throws Exception {
		Project lvProject = new Project("wayne");
		assertEquals(0, lvProject.getBacklog().getItems().size());
		new Feature("1", "", lvProject.getBacklog());
		new Feature("2", "", lvProject.getBacklog());
		new Feature("3", "", lvProject.getBacklog());
		new Feature("4", "", lvProject.getBacklog());
	
		assertEquals(4 , lvProject.getBacklog().getItems().size());
	}
	
	@Test
	public void testAddRelease() throws Exception {
		int holder = test.getReleasePlan().size();
		new Release("0.0.1", cvCurrentDate, test);
		
		assertEquals(holder + 1, test.getReleasePlan().size());
	}
	
	@Test
	public void testAddRelease2(){
		int holder = test.getReleasePlan().size();
		try {
			new Release("0.0.1", cvCurrentDate, test);
			
			fail("keine Fehlermeldung gekommen");
		} catch (DoubleDefinitionException e) {
			assertEquals(holder, test.getReleasePlan().size());
		}
	}
	
	@Test
	public void testProjectEquals() throws Exception {
		Project lvProject = test;
		assertEquals(lvProject, test);
	}
	
	@Test
	public void testPBLEquals() throws Exception {
		ProductBacklog lvBacklog = pbltest;
		assertEquals(lvBacklog, pbltest);
	}

	
}
