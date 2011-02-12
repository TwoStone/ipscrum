package fhdw.ipscrum.client.phase2.group1;

import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static org.junit.Assert.*;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Project;

public class TestPBLI_PositionInList {

	private static Project test = null;
	private static ProductBacklog pbltest = null;
	private static Feature a = null;
	private static Feature b = null;
	private static Feature c = null;
	private static Feature d = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		test = new Project("test");
		pbltest = test.getBacklog();

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

	@Test
	public void testMoveDown2() throws Exception {
		int lastPositionInList = pbltest.getItems().size() - 1;
		ProductBacklogItem holder = pbltest.getItems().get(lastPositionInList);
		pbltest.moveDown(holder);
		assertEquals(holder, pbltest.getItems().get(lastPositionInList));
	}
	
	
	
	
}
