package fhdw.ipscrum.shared.model.search;

import static org.junit.Assert.assertEquals;

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
		SearchExpression parentExpression = new PBIOpenCriterion();

		SearchExpression expression1 = new NoSearchExpression(parentExpression);

		SingleLogicSearchOperator operator = new Not(expression1);
		assertEquals(expression1, operator.getArg());
	}

	@Test
	public void testSetArg() {
		SearchExpression parentExpression = new PBIOpenCriterion();

		SearchExpression expression1 = new NoSearchExpression(parentExpression);
		SearchExpression expression2 = new NoSearchExpression(parentExpression);

		SingleLogicSearchOperator operator = new Not(expression1);
		assertEquals(expression1, operator.getArg());

		operator.setArg(expression2);
		assertEquals(expression2, operator.getArg());
	}

}
