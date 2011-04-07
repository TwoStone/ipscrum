package fhdw.ipscrum.shared.model.search;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.search.criteria.PBIOpenCriterion;

public class NoSearchExpressionTest extends SetUpTestData {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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

	@Test
	public void testSearch() throws UserException {

		ISearchExpression parentExpression = new PBIOpenCriterion();

		NoSearchExpression expression = new NoSearchExpression(parentExpression);
		assertTrue(expression.search(this.pro1rel1spr1fea1));
	}

	@Test
	public void testContains() throws UserException {

		ISearchExpression parentExpression = new PBIOpenCriterion();

		NoSearchExpression expression1 = new NoSearchExpression(parentExpression);
		NoSearchExpression expression2 = new NoSearchExpression(parentExpression);
		assertFalse(expression1.contains(expression2));
		assertFalse(expression2.contains(expression1));
		assertTrue(expression1.contains(expression1));
		assertTrue(expression2.contains(expression2));
	}

}
