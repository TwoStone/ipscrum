package fhdw.ipscrum.shared.model.search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.CycleException;
import fhdw.ipscrum.shared.model.search.criteria.PBIClosedCriterion;

public class MultiLogicSearchOperatorTest extends SetUpTestData {

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
	public void testGetArgs() throws CycleException {
		And and = new And();

		SearchExpression searchExpression1 = new PBIClosedCriterion();

		SearchExpression searchExpression2 = new PBIClosedCriterion();

		Collection<ISearchExpression> args1 = and.getArgs();
		assertFalse(args1.iterator().hasNext());

		and.add(searchExpression1);
		and.add(searchExpression2);

		Collection<ISearchExpression> args2 = and.getArgs();
		assertEquals(2, args2.size());
		assertEquals(searchExpression1, args2.iterator().next());
	}

	@Test
	public void testAdd() throws CycleException {
		And and = new And();

		SearchExpression searchExpression1 = new PBIClosedCriterion();

		SearchExpression searchExpression2 = new PBIClosedCriterion();

		and.add(searchExpression1);
		and.add(searchExpression2);
		assertEquals(new Integer(2), and.getSize());
	}

	@Test
	public void testRemove() throws CycleException {
		And and = new And();

		SearchExpression searchExpression1 = new PBIClosedCriterion();

		SearchExpression searchExpression2 = new PBIClosedCriterion();

		and.add(searchExpression1);
		and.add(searchExpression2);
		assertEquals(new Integer(2), and.getSize());

		and.remove(searchExpression2);
		assertEquals(new Integer(1), and.getSize());
	}

	@Test
	public void testGetSize() throws CycleException {
		And and = new And();

		SearchExpression searchExpression1 = new PBIClosedCriterion();

		SearchExpression searchExpression2 = new PBIClosedCriterion();

		and.add(searchExpression1);
		assertEquals(new Integer(1), and.getSize());
		and.add(searchExpression2);
		assertEquals(new Integer(2), and.getSize());
	}

	@Test
	public void testContains() {
		And and = new And();

		assertTrue(and.contains(and));
	}

	@Test
	public void testContainsIndirect() throws CycleException {
		And and1 = new And();

		And and2 = new And();
		and1.add(and2);

		assertTrue(and1.contains(and2));
		assertFalse(and2.contains(and1));
	}

}
