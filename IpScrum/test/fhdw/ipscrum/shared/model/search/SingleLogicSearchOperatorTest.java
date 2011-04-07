package fhdw.ipscrum.shared.model.search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.CycleException;
import fhdw.ipscrum.shared.model.search.criteria.PBIClosedCriterion;
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
	public void testGetArg() throws CycleException {
		SearchExpression expression1 = new PBIClosedCriterion();

		SingleLogicSearchOperator operator = new Not(expression1);
		assertEquals(expression1, operator.getArg());
	}

	@Test
	public void testSetArg() throws CycleException {
		SearchExpression expression1 = new PBIClosedCriterion();
		SearchExpression expression2 = new PBIClosedCriterion();

		SingleLogicSearchOperator operator = new Not(expression1);
		assertEquals(expression1, operator.getArg());

		operator.setArg(expression2);
		assertEquals(expression2, operator.getArg());
	}

	@Test
	public void testContains_ConstruktorWithParameter() throws CycleException {
		Not not = new Not(new PBIOpenCriterion());

		assertTrue(not.contains(not));
	}

	@Test
	public void testContains_ConstruktorWithoutParameter() throws CycleException {
		Not not = new Not();
		not.setArg(new PBIOpenCriterion());

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
