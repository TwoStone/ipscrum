package fhdw.ipscrum.shared.model.metamodel.search;

import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.model.CycleException;
import fhdw.ipscrum.shared.model.SetUpTestData;

/**
 * tests the multiLogicalSearchOperator.
 */
public class MultiLogicSearchOperatorTest extends SetUpTestData {

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * tears down the data after every test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * test to get the arguments of the operator.
	 * 
	 * @throws CycleException
	 *             if a cycle is created.
	 */
	@Test
	public void testGetArgs() throws CycleException {
		final And and = new And(this.getModel());
		// TODO
		// SearchExpression searchExpression1 = new PBIClosedCriterion(getModel());
		//
		// SearchExpression searchExpression2 = new PBIClosedCriterion(getModel());

		final Collection<ISearchExpression> args1 = and.getArgs();
		Assert.assertFalse(args1.iterator().hasNext());

		// and.add(searchExpression1);
		// and.add(searchExpression2);

		final Collection<ISearchExpression> args2 = and.getArgs();
		Assert.assertEquals(2, args2.size());
		// assertEquals(searchExpression1, args2.iterator().next());
	}

	/**
	 * test to add an expression to the operator.
	 * 
	 * @throws CycleException
	 *             if a cycle is created
	 */
	@Test
	public void testAdd() throws CycleException {
		final And and = new And(this.getModel());
		// TODO
		// SearchExpression searchExpression1 = new PBIClosedCriterion(getModel());
		//
		// SearchExpression searchExpression2 = new PBIClosedCriterion(getModel());
		//
		// and.add(searchExpression1);
		// and.add(searchExpression2);
		Assert.assertEquals(Integer.valueOf(2), and.getSize());
	}

	/**
	 * tests to add an expression to the operator which creates a cycle to check if the exception is thrown.
	 * 
	 * @throws CycleException
	 *             if the cycle is detected
	 */
	@Test(expected = CycleException.class)
	public void testAddException() throws CycleException {
		final And and = new And(this.getModel());
		// TODO
		// SearchExpression searchExpression1 = new PBIClosedCriterion(getModel());

		and.add(and);
	}

	/**
	 * tests to remove an expression.
	 * 
	 * @throws CycleException
	 *             if a cycle is created
	 */
	@Test
	public void testRemove() throws CycleException {
		final And and = new And(this.getModel());
		// TODO
		// SearchExpression searchExpression1 = new PBIClosedCriterion(getModel());
		//
		// SearchExpression searchExpression2 = new PBIClosedCriterion(getModel());
		//
		// and.add(searchExpression1);
		// and.add(searchExpression2);
		Assert.assertEquals(Integer.valueOf(2), and.getSize());

		// and.remove(searchExpression2);
		Assert.assertEquals(Integer.valueOf(1), and.getSize());
	}

	/**
	 * tests to get the size of the expressions of the operator.
	 * 
	 * @throws CycleException
	 *             if a cycle is created
	 */
	@Test
	public void testGetSize() throws CycleException {
		final And and = new And(this.getModel());
		// TODO
		// SearchExpression searchExpression1 = new PBIClosedCriterion(getModel());
		//
		// SearchExpression searchExpression2 = new PBIClosedCriterion(getModel());
		//
		// and.add(searchExpression1);
		Assert.assertEquals(Integer.valueOf(1), and.getSize());
		// and.add(searchExpression2);
		Assert.assertEquals(Integer.valueOf(2), and.getSize());
	}

	/**
	 * tests the contains method.
	 */
	@Test
	public void testContains() {
		final And and = new And(this.getModel());

		Assert.assertTrue(and.contains(and));
	}

	/**
	 * tests the indirect contains method.
	 * 
	 * @throws CycleException
	 *             if a cycle is created.
	 */
	@Test
	public void testContainsIndirect() throws CycleException {
		final And and1 = new And(this.getModel());

		final And and2 = new And(this.getModel());
		and1.add(and2);

		Assert.assertTrue(and1.contains(and2));
		Assert.assertFalse(and2.contains(and1));
	}

}
