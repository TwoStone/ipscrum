package fhdw.ipscrum.shared.model.search;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

public class OrTest extends SetUpTestData {

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
	public void testSearch_TrueTrue() throws UserException, CycleException {
		ProductBacklogItem item = pro1rel1spr1fea1;

		Or or = new Or();

		SearchExpression searchExpression1 = new PBIClosedCriterion();

		SearchExpression searchExpression2 = new PBIClosedCriterion();

		or.add(searchExpression1);
		or.add(searchExpression2);
		assertTrue(or.search(item));
	}

	@Test
	public void testSearch_TrueFalse() throws UserException, CycleException {
		ProductBacklogItem item = pro1rel1spr1fea1;

		Or or = new Or();

		SearchExpression searchExpression1 = new PBIClosedCriterion();

		SearchExpression searchExpression2 = new PBIOpenCriterion();

		or.add(searchExpression1);
		or.add(searchExpression2);
		assertTrue(or.search(item));
	}

	@Test
	public void testSearch_FalseTrue() throws UserException, CycleException {
		ProductBacklogItem item = pro1rel1spr1fea1;

		Or or = new Or();

		SearchExpression searchExpression1 = new PBIOpenCriterion();

		SearchExpression searchExpression2 = new PBIClosedCriterion();

		or.add(searchExpression1);
		or.add(searchExpression2);
		assertTrue(or.search(item));
	}

	@Test
	public void testSearch_FalseFalse() throws UserException, CycleException {
		ProductBacklogItem item = pro1rel1spr1fea1;

		Or or = new Or();

		SearchExpression searchExpression1 = new PBIOpenCriterion();

		SearchExpression searchExpression2 = new PBIOpenCriterion();

		or.add(searchExpression1);
		or.add(searchExpression2);
		assertFalse(or.search(item));
	}

}
