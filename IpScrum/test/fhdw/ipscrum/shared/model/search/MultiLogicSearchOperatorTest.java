package fhdw.ipscrum.shared.model.search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
	public void testGetArgs_ConstruktorWithoutParameter() {
		And and = new And();

		NoSearchExpression noSearchExpression1 = new NoSearchExpression(and);
		NoSearchExpression noSearchExpression2 = new NoSearchExpression(and);

		Collection<SearchExpression> args1 = and.getArgs();
		assertFalse(args1.iterator().hasNext());

		and.add(noSearchExpression1);
		and.add(noSearchExpression2);

		Collection<SearchExpression> args2 = and.getArgs();
		assertEquals(2, args2.size());
		assertEquals(noSearchExpression1, args2.iterator().next());
	}

	@Test
	public void testAdd_ConstruktorWithoutParameter() {
		And and = new And();

		NoSearchExpression noSearchExpression1 = new NoSearchExpression(and);
		NoSearchExpression noSearchExpression2 = new NoSearchExpression(and);

		and.add(noSearchExpression1);
		and.add(noSearchExpression2);
		assertEquals(new Integer(2), and.getSize());
	}

	@Test
	public void testRemove_ConstruktorWithoutParameter() {
		And and = new And();

		NoSearchExpression noSearchExpression1 = new NoSearchExpression(and);
		NoSearchExpression noSearchExpression2 = new NoSearchExpression(and);

		and.add(noSearchExpression1);
		and.add(noSearchExpression2);
		assertEquals(new Integer(2), and.getSize());

		and.remove(noSearchExpression2);
		assertEquals(new Integer(1), and.getSize());
	}

	@Test
	public void testGetSize_ConstruktorWithoutParameter() {
		And and = new And();

		NoSearchExpression noSearchExpression1 = new NoSearchExpression(and);
		NoSearchExpression noSearchExpression2 = new NoSearchExpression(and);

		and.add(noSearchExpression1);
		assertEquals(new Integer(1), and.getSize());
		and.add(noSearchExpression2);
		assertEquals(new Integer(2), and.getSize());
	}

	@Test
	public void testGetArgs_ConstruktorWithParameter() {
		ArrayList<SearchExpression> collection = new ArrayList<SearchExpression>();

		And and = new And(collection);

		NoSearchExpression noSearchExpression1 = new NoSearchExpression(and);
		collection.add(noSearchExpression1);

		NoSearchExpression noSearchExpression2 = new NoSearchExpression(and);
		collection.add(noSearchExpression2);

		Collection<SearchExpression> args2 = and.getArgs();
		assertEquals(2, args2.size());
		assertEquals(noSearchExpression1, args2.iterator().next());
	}

	@Test
	public void testAdd_ConstruktorWithParameter() {
		ArrayList<SearchExpression> collection = new ArrayList<SearchExpression>();

		And and = new And(collection);

		NoSearchExpression noSearchExpression1 = new NoSearchExpression(and);
		collection.add(noSearchExpression1);

		NoSearchExpression noSearchExpression2 = new NoSearchExpression(and);
		collection.add(noSearchExpression2);

		assertEquals(new Integer(2), and.getSize());
	}

	@Test
	public void testRemove_ConstruktorWithParameter() {
		ArrayList<SearchExpression> collection = new ArrayList<SearchExpression>();

		And and = new And(collection);

		NoSearchExpression noSearchExpression1 = new NoSearchExpression(and);
		collection.add(noSearchExpression1);

		NoSearchExpression noSearchExpression2 = new NoSearchExpression(and);
		collection.add(noSearchExpression2);

		assertEquals(new Integer(2), and.getSize());

		and.remove(noSearchExpression2);
		assertEquals(new Integer(1), and.getSize());
	}

	@Test
	public void testGetSize_ConstruktorWithParameter() {
		ArrayList<SearchExpression> collection = new ArrayList<SearchExpression>();

		And and = new And(collection);

		NoSearchExpression noSearchExpression1 = new NoSearchExpression(and);
		collection.add(noSearchExpression1);

		NoSearchExpression noSearchExpression2 = new NoSearchExpression(and);
		collection.add(noSearchExpression2);

		assertEquals(new Integer(2), and.getSize());
	}

	@Test
	public void testContains_ConstruktorWithParameter() {
		ArrayList<SearchExpression> collection = new ArrayList<SearchExpression>();

		And and = new And(collection);

		NoSearchExpression noSearchExpression1 = new NoSearchExpression(and);
		collection.add(noSearchExpression1);

		NoSearchExpression noSearchExpression2 = new NoSearchExpression(and);
		collection.add(noSearchExpression2);

		assertTrue(and.contains(and));
	}

}
