package fhdw.ipscrum.client.phase2.group1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Project;

@SuppressWarnings("unused")
public class PriorityTests {

	private static Project project = null;
	private static ProductBacklog pbl = null;
	private static Feature feature1 = null;
	private static Feature feature2 = null;
	private static Feature feature3 = null;
	private static Feature feature4 = null;
	private static Date cvCurrentDate = null;
	private static Date cvCurrentDate2 = null;

	@SuppressWarnings("deprecation")
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		project = new Project("test");
		pbl = project.getBacklog();

		assertTrue(pbl != null);
		assertEquals("test", project.getName());
		assertEquals(pbl, project.getBacklog());

		cvCurrentDate = new Date();
		cvCurrentDate2 = cvCurrentDate;
		cvCurrentDate2.setMonth(Calendar.MONTH + 1);

		feature1 = new Feature("A", "testA", pbl);
		feature2 = new Feature("B", "testB", pbl);
		feature3 = new Feature("C", "testC", pbl);
		feature4 = new Feature("D", "testD", pbl);

		assertTrue(pbl.getItems().size() == 4);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	/**
	 * successful MoveUp() on an element in PBL
	 */
	public void testMoveUp1() throws Exception {
		final ProductBacklogItem item = pbl.getItems().get(1);
		final int positionOfItemNo2 = pbl.getItemPositionInList(item);
		pbl.moveUp(item);
		assertEquals(item, pbl.getItems().get(positionOfItemNo2 - 1));
	}

	@Test
	/**
	 * MoveUp() on the first element of PBL, throws an exception
	 * @throws Exception
	 */
	public void testMoveUp2() throws Exception {
		final ProductBacklogItem holder = pbl.getItems().get(0);
		pbl.moveUp(holder);
		assertEquals(holder, pbl.getItems().get(0));
	}

	@Test
	/**
	 * successful MoveDown() on an element in PBL
	 */
	public void testMoveDown1() throws Exception {
		final ProductBacklogItem item = pbl.getItems().get(0);
		final int positionOfItemNo1 = pbl.getItemPositionInList(item);
		pbl.moveDown(item);
		assertEquals(item, pbl.getItems().get(positionOfItemNo1 + 1));
	}

	@Test
	/**
	 * MoveDown() on last element in PBL, throws an exception
	 * @throws Exception
	 */
	public void testMoveDown2() throws Exception {
		final int lastPositionInList = pbl.getItems().size() - 1;
		final ProductBacklogItem holder = pbl.getItems()
				.get(lastPositionInList);
		pbl.moveDown(holder);
		assertEquals(holder, pbl.getItems().get(lastPositionInList));
	}

	// ************************************************************************
	// ************************************************************************

	@Test
	/**
	 * successful MoveTop() on an element in PBL
	 */
	public void testMoveTop1() throws Exception {
		final int lastPositionInList = pbl.getItems().size() - 1;
		final ProductBacklogItem item = pbl.getItems().get(lastPositionInList);
		pbl.moveTop(item);
		assertEquals(item, pbl.getItems().get(0));
	}

	@Test
	/**
	 * special case
	 * MoveTop() on first element in PBL
	 */
	public void testMoveTop2() throws Exception {
		final ProductBacklog lvBacklog = pbl;
		final ProductBacklogItem item = pbl.getItems().get(0);
		pbl.moveTop(item);
		assertEquals(lvBacklog, pbl);
	}

	@Test
	/**
	 * MoveTop() on last element of PBL
	 */
	public void testMoveTop3() throws Exception {
		final int lastPositionInList = pbl.getItems().size() - 1;
		final ProductBacklogItem item = pbl.getItems().get(lastPositionInList);
		final ProductBacklogItem item2 = pbl.getItems().get(0);
		pbl.moveTop(item);
		assertEquals(item2, pbl.getItems().get(1));
	}

	@Test
	/**
	 * successful MoveBottom() on first element in PBL
	 */
	public void testMoveBottom1() throws Exception {
		final int lastPositionInList = pbl.getItems().size() - 1;
		final ProductBacklogItem item = pbl.getItems().get(0);
		pbl.moveBottom(item);
		assertEquals(item, pbl.getItems().get(lastPositionInList));
	}

	@Test
	/**
	 * MoveBottom() on last element in PBL
	 */
	public void testMoveBottom2() throws Exception {
		final int lastPositionInList = pbl.getItems().size() - 1;
		final ProductBacklog lvBacklog = pbl;
		final ProductBacklogItem item = pbl.getItems().get(lastPositionInList);
		pbl.moveBottom(item);
		assertEquals(lvBacklog, pbl);
	}

	@Test
	/**
	 * MoveBottom() on last element in PBL
	 */
	public void testMoveBottom3() throws Exception {
		final int lastPositionInList = pbl.getItems().size() - 1;
		final ProductBacklogItem item = pbl.getItems().get(0);
		final ProductBacklogItem item2 = pbl.getItems().get(lastPositionInList);
		pbl.moveBottom(item);
		assertEquals(item2, pbl.getItems().get(lastPositionInList - 1));
	}

	@Test
	/**
	 * Testing Priority
	 */
	public void pblPriority() {
		try {
			final Project p = new Project("Test");
			final Feature f1 = new Feature("T1", "", p.getBacklog());
			final Feature f2 = new Feature("T2", "", p.getBacklog());
			final Feature f3 = new Feature("T3", "", p.getBacklog());

			p.getBacklog().addItem(f1);
			p.getBacklog().addItem(f2);
			p.getBacklog().addItem(f3);

			p.getBacklog().moveBottom(f1);

			assertEquals(new Integer(0), p.getBacklog().getItemPositionInList(
					f2));
			assertEquals(new Integer(1), p.getBacklog().getItemPositionInList(
					f3));
			assertEquals(new Integer(2), p.getBacklog().getItemPositionInList(
					f1));

			p.getBacklog().moveUp(f1);

			assertEquals(new Integer(0), p.getBacklog().getItemPositionInList(
					f2));
			assertEquals(new Integer(1), p.getBacklog().getItemPositionInList(
					f1));
			assertEquals(new Integer(2), p.getBacklog().getItemPositionInList(
					f3));

			p.getBacklog().moveDown(f2);

			assertEquals(new Integer(0), p.getBacklog().getItemPositionInList(
					f1));
			assertEquals(new Integer(1), p.getBacklog().getItemPositionInList(
					f2));
			assertEquals(new Integer(2), p.getBacklog().getItemPositionInList(
					f3));

			p.getBacklog().moveTop(f1);// Nothing should changed
			assertEquals(new Integer(0), p.getBacklog().getItemPositionInList(
					f1));
			assertEquals(new Integer(1), p.getBacklog().getItemPositionInList(
					f2));
			assertEquals(new Integer(2), p.getBacklog().getItemPositionInList(
					f3));

			p.getBacklog().moveBottom(f3);// Nothing should changed
			assertEquals(new Integer(0), p.getBacklog().getItemPositionInList(
					f1));
			assertEquals(new Integer(1), p.getBacklog().getItemPositionInList(
					f2));
			assertEquals(new Integer(2), p.getBacklog().getItemPositionInList(
					f3));

			p.getBacklog().moveUp(f1);// Nothing should changed
			assertEquals(new Integer(0), p.getBacklog().getItemPositionInList(
					f1));
			assertEquals(new Integer(1), p.getBacklog().getItemPositionInList(
					f2));
			assertEquals(new Integer(2), p.getBacklog().getItemPositionInList(
					f3));

			p.getBacklog().moveDown(f3);// Nothing should changed
			assertEquals(new Integer(0), p.getBacklog().getItemPositionInList(
					f1));
			assertEquals(new Integer(1), p.getBacklog().getItemPositionInList(
					f2));
			assertEquals(new Integer(2), p.getBacklog().getItemPositionInList(
					f3));

			p.getBacklog().moveUp(f2);
			assertEquals(new Integer(0), p.getBacklog().getItemPositionInList(
					f2));
			assertEquals(new Integer(1), p.getBacklog().getItemPositionInList(
					f1));
			assertEquals(new Integer(2), p.getBacklog().getItemPositionInList(
					f3));

			p.getBacklog().moveDown(f1);
			assertEquals(new Integer(0), p.getBacklog().getItemPositionInList(
					f2));
			assertEquals(new Integer(1), p.getBacklog().getItemPositionInList(
					f3));
			assertEquals(new Integer(2), p.getBacklog().getItemPositionInList(
					f1));

		} catch (final UserException e) {
			e.printStackTrace();
		}
	}
}
