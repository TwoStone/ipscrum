package fhdw.ipscrum.shared.model.search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.shared.model.search.criteria.PBIOpenCriterion;

public class SingleLogicSearchOperatorTest extends SetUpTestData {

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
	public void testGetArg() {
		ISearchExpression parentExpression = new PBIOpenCriterion();

		SearchExpression expression1 = new NoSearchExpression(parentExpression);

		SingleLogicSearchOperator operator = new Not(expression1);
		assertEquals(expression1, operator.getArg());
	}

	@Test
	public void testSetArg() {
		ISearchExpression parentExpression = new PBIOpenCriterion();

		SearchExpression expression1 = new NoSearchExpression(parentExpression);
		SearchExpression expression2 = new NoSearchExpression(parentExpression);

		SingleLogicSearchOperator operator = new Not(expression1);
		assertEquals(expression1, operator.getArg());

		operator.setArg(expression2);
		assertEquals(expression2, operator.getArg());
	}

	@Test
	public void testContains_ConstruktorWithParameter() {
		Not not = new Not(new PBIOpenCriterion());

		assertTrue(not.contains(not));
	}

	@Test
	public void testContains_ConstruktorWithoutParameter() {
		Not not = new Not();

		assertTrue(not.contains(not));
	}

	@Test
	public void testContainsIndirect_ConstruktorWithoutParameter() {
		Not not1 = new Not();

		Not not2 = new Not();

		assertFalse(not1.contains(not2));
		assertFalse(not2.contains(not1));
	}

}
