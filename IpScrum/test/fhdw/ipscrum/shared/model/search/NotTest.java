package fhdw.ipscrum.shared.model.search;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.CycleException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.criteria.PBIClosedCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIOpenCriterion;

public class NotTest extends SetUpTestData {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSearch() throws UserException, CycleException {
		ProductBacklogItem item = pro1rel1spr1fea1;

		ArrayList<SearchExpression> collection = new ArrayList<SearchExpression>();

		ISearchExpression parentExpression = new PBIOpenCriterion();

		SearchExpression searchExpression1 = new PBIClosedCriterion();
		collection.add(searchExpression1);

		assertTrue(searchExpression1.search(item));

		Not not = new Not(searchExpression1);
		assertFalse(not.search(item));
	}

}
