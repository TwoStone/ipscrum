package fhdw.ipscrum.shared.model.nonMeta;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.TestUtils;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;

/**
 * The class <code>ProductBacklogTest</code> contains tests for the class <code>{@link ProductBacklog}</code>.
 */
public class ProductBacklogTest {
	/**
	 * represents the model which is needed to use the IPScrum.
	 */
	private Model model;
	/**
	 * represents the project related to the backlog.
	 */
	private Project project = null;
	/**
	 * represents the backlog to test.
	 */
	private ProductBacklog pbl = null;
	/**
	 * represents a feature in the backlog.
	 */
	private Feature feature1 = null;
	/**
	 * represents a feature in the backlog.
	 */
	private Feature feature2 = null;
	/**
	 * represents a feature in the backlog.
	 */
	private Feature feature3 = null;
	/**
	 * represents a feature in the backlog.
	 */
	private Feature feature4 = null;

	/**
	 * represents a date.
	 */
	private Date cvCurrentDate = null;
	/**
	 * represents a date.
	 */
	private Date cvCurrentDate2 = null;
	/**
	 * represents another feature type as the standard one.
	 */
	private FeatureTicketType type = null;

	/**
	 * The set up before the start of the class.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * sets up the data before the class starts.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() throws Exception {
		TestUtils.deleteFolderContent(new File("output"));
		ServerContext.resetServerContext();
		this.model = ServerContext.getInstance().getPersistenceManager().getCurrentModel();
		this.model.setUuidManager(new IDGenerator());
		this.project = new Project(this.model, "test");
		this.pbl = this.project.getBacklog();

		Assert.assertTrue(this.pbl != null);
		Assert.assertEquals("test", this.project.getName());
		Assert.assertEquals(this.pbl, this.project.getBacklog());

		this.cvCurrentDate = new Date();
		this.cvCurrentDate2 = this.cvCurrentDate;
		this.cvCurrentDate2.setMonth(Calendar.MONTH + 1);

		this.type = this.model.getTypeManager().getStandardFeatureType();
		this.feature1 = new Feature(this.model, this.type, "A", "testA", this.pbl);
		this.feature2 = new Feature(this.model, this.type, "B", "testB", this.pbl);
		this.feature3 = new Feature(this.model, this.type, "C", "testC", this.pbl);
		this.feature4 = new Feature(this.model, this.type, "D", "testD", this.pbl);

		Assert.assertNotNull(this.feature1);
		Assert.assertNotNull(this.feature2);
		Assert.assertNotNull(this.feature3);
		Assert.assertNotNull(this.feature4);
		Assert.assertTrue(this.pbl.getItems().size() == 4);

	}

	/**
	 * test if the toString-method works appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testToString() throws Exception {
		Assert.assertEquals(TextConstants.PRODUCT_BACKLOG, this.pbl.toString());
	}

	/**
	 * test if the method works appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testAddPBI1() throws Exception {
		final int size = this.pbl.getItems().size();
		this.pbl.addItem(null);
		Assert.assertEquals(size, this.pbl.getItems().size());
	}

	/**
	 * test if the method works appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCountItems() throws Exception {
		Assert.assertEquals(Integer.valueOf(4), this.pbl.countItems());
		this.pbl.addItem(this.feature1);
		Assert.assertEquals(Integer.valueOf(5), this.pbl.countItems());
		this.pbl.addItem(this.feature2);
		this.pbl.addItem(this.feature3);
		this.pbl.addItem(this.feature4);
		Assert.assertEquals(Integer.valueOf(8), this.pbl.countItems());
	}

	/**
	 * test if the method works appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = DoubleDefinitionException.class)
	public void testIsDoubleDefined1() throws Exception {
		this.pbl.isDoubleDefined(this.feature1.getName());
	}

	/**
	 * test if the method works appropriate.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	public void testIsDoubleDefined2() throws Exception {
		this.pbl.isDoubleDefined("asd");
	}

	/**
	 * successful MoveUp() on an element in PBI.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testMoveUp1() throws Exception {
		final ProductBacklogItem item = this.pbl.getItems().get(1);
		final int positionOfItemNo2 = this.pbl.getItemPositionInList(item);
		this.pbl.moveUp(item);
		Assert.assertEquals(item, this.pbl.getItems().get(positionOfItemNo2 - 1));
	}

	/**
	 * MoveUp() on the first element of PBL, throws an exception.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testMoveUp2() throws Exception {
		final ProductBacklogItem holder = this.pbl.getItems().get(0);
		this.pbl.moveUp(holder);
		Assert.assertEquals(holder, this.pbl.getItems().get(0));
	}

	/**
	 * successful MoveDown() on an element in PBI.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testMoveDown1() throws Exception {
		final ProductBacklogItem item = this.pbl.getItems().get(0);
		final int positionOfItemNo1 = this.pbl.getItemPositionInList(item);
		this.pbl.moveDown(item);
		Assert.assertEquals(item, this.pbl.getItems().get(positionOfItemNo1 + 1));
	}

	/**
	 * MoveDown() on last element in PBL, throws an exception.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testMoveDown2() throws Exception {
		final int lastPositionInList = this.pbl.getItems().size() - 1;
		final ProductBacklogItem holder = this.pbl.getItems().get(lastPositionInList);
		this.pbl.moveDown(holder);
		Assert.assertEquals(holder, this.pbl.getItems().get(lastPositionInList));
	}

	// ************************************************************************
	// ************************************************************************

	/**
	 * successful MoveTop() on an element in PBI.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testMoveTop1() throws Exception {
		final int lastPositionInList = this.pbl.getItems().size() - 1;
		final ProductBacklogItem item = this.pbl.getItems().get(lastPositionInList);
		this.pbl.moveTop(item);
		Assert.assertEquals(item, this.pbl.getItems().get(0));
	}

	/**
	 * special case MoveTop() on first element in PBI.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testMoveTop2() throws Exception {
		final ProductBacklog lvBacklog = this.pbl;
		final ProductBacklogItem item = this.pbl.getItems().get(0);
		this.pbl.moveTop(item);
		Assert.assertEquals(lvBacklog, this.pbl);
	}

	/**
	 * MoveTop() on last element of PBI.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testMoveTop3() throws Exception {
		final int lastPositionInList = this.pbl.getItems().size() - 1;
		final ProductBacklogItem item = this.pbl.getItems().get(lastPositionInList);
		final ProductBacklogItem item2 = this.pbl.getItems().get(0);
		this.pbl.moveTop(item);
		Assert.assertEquals(item2, this.pbl.getItems().get(1));
	}

	/**
	 * successful MoveBottom() on first element in PBI.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testMoveBottom1() throws Exception {
		final int lastPositionInList = this.pbl.getItems().size() - 1;
		final ProductBacklogItem item = this.pbl.getItems().get(0);
		this.pbl.moveBottom(item);
		Assert.assertEquals(item, this.pbl.getItems().get(lastPositionInList));
	}

	/**
	 * MoveBottom() on last element in PBL.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testMoveBottom2() throws Exception {
		final int lastPositionInList = this.pbl.getItems().size() - 1;
		final ProductBacklog lvBacklog = this.pbl;
		final ProductBacklogItem item = this.pbl.getItems().get(lastPositionInList);
		this.pbl.moveBottom(item);
		Assert.assertEquals(lvBacklog, this.pbl);
	}

	/**
	 * MoveBottom() on last element in PBL.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testMoveBottom3() throws Exception {
		final int lastPositionInList = this.pbl.getItems().size() - 1;
		final ProductBacklogItem item = this.pbl.getItems().get(0);
		final ProductBacklogItem item2 = this.pbl.getItems().get(lastPositionInList);
		this.pbl.moveBottom(item);
		Assert.assertEquals(item2, this.pbl.getItems().get(lastPositionInList - 1));
	}

	/**
	 * Testing Priority.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void pblPriority() throws Exception {
		final Project p = new Project(this.model, "Test");
		this.type = this.model.getTypeManager().getStandardFeatureType();
		final Feature f1 = new Feature(this.model, this.type, "T1", "", p.getBacklog());
		final Feature f2 = new Feature(this.model, this.type, "T2", "", p.getBacklog());
		final Feature f3 = new Feature(this.model, this.type, "T3", "", p.getBacklog());

		p.getBacklog().moveBottom(f1);

		Assert.assertEquals(Integer.valueOf(0), p.getBacklog().getItemPositionInList(f2));
		Assert.assertEquals(Integer.valueOf(1), p.getBacklog().getItemPositionInList(f3));
		Assert.assertEquals(Integer.valueOf(2), p.getBacklog().getItemPositionInList(f1));

		p.getBacklog().moveUp(f1);

		Assert.assertEquals(Integer.valueOf(0), p.getBacklog().getItemPositionInList(f2));
		Assert.assertEquals(Integer.valueOf(1), p.getBacklog().getItemPositionInList(f1));
		Assert.assertEquals(Integer.valueOf(2), p.getBacklog().getItemPositionInList(f3));

		p.getBacklog().moveDown(f2);

		Assert.assertEquals(Integer.valueOf(0), p.getBacklog().getItemPositionInList(f1));
		Assert.assertEquals(Integer.valueOf(1), p.getBacklog().getItemPositionInList(f2));
		Assert.assertEquals(Integer.valueOf(2), p.getBacklog().getItemPositionInList(f3));

		p.getBacklog().moveTop(f1); // Nothing should changed
		Assert.assertEquals(Integer.valueOf(0), p.getBacklog().getItemPositionInList(f1));
		Assert.assertEquals(Integer.valueOf(1), p.getBacklog().getItemPositionInList(f2));
		Assert.assertEquals(Integer.valueOf(2), p.getBacklog().getItemPositionInList(f3));

		p.getBacklog().moveBottom(f3); // Nothing should changed
		Assert.assertEquals(Integer.valueOf(0), p.getBacklog().getItemPositionInList(f1));
		Assert.assertEquals(Integer.valueOf(1), p.getBacklog().getItemPositionInList(f2));
		Assert.assertEquals(Integer.valueOf(2), p.getBacklog().getItemPositionInList(f3));

		p.getBacklog().moveUp(f1); // Nothing should changed
		Assert.assertEquals(Integer.valueOf(0), p.getBacklog().getItemPositionInList(f1));
		Assert.assertEquals(Integer.valueOf(1), p.getBacklog().getItemPositionInList(f2));
		Assert.assertEquals(Integer.valueOf(2), p.getBacklog().getItemPositionInList(f3));

		p.getBacklog().moveDown(f3); // Nothing should changed
		Assert.assertEquals(Integer.valueOf(0), p.getBacklog().getItemPositionInList(f1));
		Assert.assertEquals(Integer.valueOf(1), p.getBacklog().getItemPositionInList(f2));
		Assert.assertEquals(Integer.valueOf(2), p.getBacklog().getItemPositionInList(f3));

		p.getBacklog().moveUp(f2);
		Assert.assertEquals(Integer.valueOf(0), p.getBacklog().getItemPositionInList(f2));
		Assert.assertEquals(Integer.valueOf(1), p.getBacklog().getItemPositionInList(f1));
		Assert.assertEquals(Integer.valueOf(2), p.getBacklog().getItemPositionInList(f3));

		p.getBacklog().moveDown(f1);
		Assert.assertEquals(Integer.valueOf(0), p.getBacklog().getItemPositionInList(f2));
		Assert.assertEquals(Integer.valueOf(1), p.getBacklog().getItemPositionInList(f3));
		Assert.assertEquals(Integer.valueOf(2), p.getBacklog().getItemPositionInList(f1));
	}
}
