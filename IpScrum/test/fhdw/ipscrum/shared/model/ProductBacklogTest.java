package fhdw.ipscrum.shared.model;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The class <code>ProductBacklogTest</code> contains tests for the class
 * <code>{@link ProductBacklog}</code>.
 * 
 * @generatedBy CodePro at 03.03.11 15:39
 * @author wolf
 * @version $Revision: 1.0 $
 */
public class ProductBacklogTest {

	private static Project test = null;
	private static ProductBacklog pbltest = null;
	private static Feature a = null;
	private static Feature b = null;
	private static Feature c = null;
	private static Feature d = null;
	private static Date cvCurrentDate = null;
	private static Date cvCurrentDate2 = null;

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

	// ************************************************************************
	// move commands
	// ************************************************************************

	/**
	 * MoveUp() on an element in PBL
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMoveUp1() throws Exception {
		final ProductBacklogItem item = pbltest.getItems().get(1);
		final int positionOfItemNo2 = pbltest.getItemPositionInList(item);
		pbltest.moveUp(item);
		assertEquals(item, pbltest.getItems().get(positionOfItemNo2 - 1));
	}

	/**
	 * MoveUp() on the first element of PBL, throws an exception
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMoveUp2() throws Exception {
		final ProductBacklogItem holder = pbltest.getItems().get(0);
		pbltest.moveUp(holder);
		assertEquals(holder, pbltest.getItems().get(0));
	}

	/**
	 * MoveDown() on an element in PBL
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMoveDown1() throws Exception {
		final ProductBacklogItem item = pbltest.getItems().get(0);
		final int positionOfItemNo1 = pbltest.getItemPositionInList(item);
		pbltest.moveDown(item);
		assertEquals(item, pbltest.getItems().get(positionOfItemNo1 + 1));
	}

	/**
	 * MoveDown() on last element in PBL
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMoveDown2() throws Exception {
		final int lastPositionInList = pbltest.countItems() - 1;
		final ProductBacklogItem holder = pbltest.getItems().get(
				lastPositionInList);
		pbltest.moveDown(holder);
		assertEquals(holder, pbltest.getItems().get(lastPositionInList));
	}

	/**
	 * MoveTop() on an element in PBL
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMoveTop1() throws Exception {
		final int lastPositionInList = pbltest.countItems() - 1;
		final ProductBacklogItem item = pbltest.getItems().get(
				lastPositionInList);
		pbltest.moveTop(item);
		assertEquals(item, pbltest.getItems().get(0));
	}

	/**
	 * special case, MoveTop() on first element in PBL
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMoveTop2() throws Exception {
		final ProductBacklog lvBacklog = pbltest;
		final ProductBacklogItem item = pbltest.getItems().get(0);
		pbltest.moveTop(item);
		assertEquals(lvBacklog, pbltest);
	}

	/**
	 * MoveTop() on last element of PBL
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMoveTop3() throws Exception {
		final int lastPositionInList = pbltest.countItems() - 1;
		final ProductBacklogItem item = pbltest.getItems().get(
				lastPositionInList);
		final ProductBacklogItem item2 = pbltest.getItems().get(0);
		pbltest.moveTop(item);
		assertEquals(item2, pbltest.getItems().get(1));
	}

	/**
	 * MoveBottom() on first element in PBL
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMoveBottom1() throws Exception {
		final int lastPositionInList = pbltest.countItems() - 1;
		final ProductBacklogItem item = pbltest.getItems().get(0);
		pbltest.moveBottom(item);
		assertEquals(item, pbltest.getItems().get(lastPositionInList));
	}

	/**
	 * MoveBottom() on last element in PBL
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMoveBottom2() throws Exception {
		final int lastPositionInList = pbltest.countItems() - 1;
		final ProductBacklog lvBacklog = pbltest;
		final ProductBacklogItem item = pbltest.getItems().get(
				lastPositionInList);
		pbltest.moveBottom(item);
		assertEquals(lvBacklog, pbltest);
	}

	/**
	 * MoveBottom() on last element in PBL
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMoveBottom3() throws Exception {
		final int lastPositionInList = pbltest.countItems() - 1;
		final ProductBacklogItem item = pbltest.getItems().get(0);
		final ProductBacklogItem item2 = pbltest.getItems().get(
				lastPositionInList);
		pbltest.moveBottom(item);
		assertEquals(item2, pbltest.getItems().get(lastPositionInList - 1));
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Before
	public void setUp() throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}
}