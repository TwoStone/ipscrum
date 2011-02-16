package fhdw.ipscrum.client.phase2.group1;

import static org.junit.Assert.assertEquals;

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

public class PriorityTests {

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
		cvCurrentDate2.setMonth(Calendar.MONTH + 1);

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
		final ProductBacklogItem item = pbltest.getItems().get(1);
		final int positionOfItemNo2 = pbltest.getItemPositionInList(item);
		pbltest.moveUp(item);
		assertEquals(item, pbltest.getItems().get(positionOfItemNo2 - 1));
	}

	@Test
	/**
	 * MoveUp() on the first element of PBL, throws an exception
	 * @throws Exception
	 */
	public void testMoveUp2() throws Exception {
		final ProductBacklogItem holder = pbltest.getItems().get(0);
		pbltest.moveUp(holder);
		assertEquals(holder, pbltest.getItems().get(0));
	}

	@Test
	/**
	 * successful MoveDown() on an element in PBL
	 */
	public void testMoveDown1() throws Exception {
		final ProductBacklogItem item = pbltest.getItems().get(0);
		final int positionOfItemNo1 = pbltest.getItemPositionInList(item);
		pbltest.moveDown(item);
		assertEquals(item, pbltest.getItems().get(positionOfItemNo1 + 1));
	}

	@Test
	/**
	 * MoveDown() on last element in PBL, throws an exception
	 * @throws Exception
	 */
	public void testMoveDown2() throws Exception {
		final int lastPositionInList = pbltest.getItems().size() - 1;
		final ProductBacklogItem holder = pbltest.getItems().get(
				lastPositionInList);
		pbltest.moveDown(holder);
		assertEquals(holder, pbltest.getItems().get(lastPositionInList));
	}

	// ************************************************************************
	// ************************************************************************

	@Test
	/**
	 * successful MoveTop() on an element in PBL
	 */
	public void testMoveTop1() throws Exception {
		final int lastPositionInList = pbltest.getItems().size() - 1;
		final ProductBacklogItem item = pbltest.getItems().get(
				lastPositionInList);
		pbltest.moveTop(item);
		assertEquals(item, pbltest.getItems().get(0));
	}

	@Test
	/**
	 * special case
	 * MoveTop() on first element in PBL
	 */
	public void testMoveTop2() throws Exception {
		final ProductBacklog lvBacklog = pbltest;
		final ProductBacklogItem item = pbltest.getItems().get(0);
		pbltest.moveTop(item);
		assertEquals(lvBacklog, pbltest);
	}

	@Test
	/**
	 * MoveTop() on last element of PBL
	 */
	public void testMoveTop3() throws Exception {
		final int lastPositionInList = pbltest.getItems().size() - 1;
		final ProductBacklogItem item = pbltest.getItems().get(
				lastPositionInList);
		final ProductBacklogItem item2 = pbltest.getItems().get(0);
		pbltest.moveTop(item);
		assertEquals(item2, pbltest.getItems().get(1));
	}

	@Test
	/**
	 * successful MoveBottom() on first element in PBL
	 */
	public void testMoveBottom1() throws Exception {
		final int lastPositionInList = pbltest.getItems().size() - 1;
		final ProductBacklogItem item = pbltest.getItems().get(0);
		pbltest.moveBottom(item);
		assertEquals(item, pbltest.getItems().get(lastPositionInList));
	}

	@Test
	/**
	 * MoveBottom() on last element in PBL
	 */
	public void testMoveBottom2() throws Exception {
		final int lastPositionInList = pbltest.getItems().size() - 1;
		final ProductBacklog lvBacklog = pbltest;
		final ProductBacklogItem item = pbltest.getItems().get(
				lastPositionInList);
		pbltest.moveBottom(item);
		assertEquals(lvBacklog, pbltest);
	}

	@Test
	/**
	 * MoveBottom() on last element in PBL
	 */
	public void testMoveBottom3() throws Exception {
		final int lastPositionInList = pbltest.getItems().size() - 1;
		final ProductBacklogItem item = pbltest.getItems().get(0);
		final ProductBacklogItem item2 = pbltest.getItems().get(
				lastPositionInList);
		pbltest.moveBottom(item);
		assertEquals(item2, pbltest.getItems().get(lastPositionInList - 1));
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
