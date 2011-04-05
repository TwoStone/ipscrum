package fhdw.ipscrum.shared.model.search;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.ProductBacklogItem;

public class AndTest extends SetUpTestData {

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
	public void testSearch_TrueTrue_ConstruktorWithParameter() throws UserException {
		ProductBacklogItem item = pro1rel1spr1fea1;

		ArrayList<SearchExpression> collection = new ArrayList<SearchExpression>();

		NoSearchExpression noSearchExpression1 = new NoSearchExpression();
		collection.add(noSearchExpression1);

		NoSearchExpression noSearchExpression2 = new NoSearchExpression();
		collection.add(noSearchExpression2);

		And and = new And(collection);
		assertTrue(and.search(item));
	}

	@Test
	public void testSearch_TrueFalse_ConstruktorWithParameter() throws UserException {
		ProductBacklogItem item = pro1rel1spr1fea1;

		ArrayList<SearchExpression> collection = new ArrayList<SearchExpression>();
		NoSearchExpression noSearchExpression1 = new NoSearchExpression();
		collection.add(noSearchExpression1);

		NoSearchExpression noSearchExpression2 = new NoSearchExpression();
		Not NotNoSearchExpression2 = new Not(noSearchExpression2);
		collection.add(NotNoSearchExpression2);

		And and = new And(collection);
		assertFalse(and.search(item));
	}

	@Test
	public void testSearch_FalseTrue_ConstruktorWithParameter() throws UserException {
		ProductBacklogItem item = pro1rel1spr1fea1;

		ArrayList<SearchExpression> collection = new ArrayList<SearchExpression>();

		NoSearchExpression noSearchExpression2 = new NoSearchExpression();
		Not NotNoSearchExpression2 = new Not(noSearchExpression2);
		collection.add(NotNoSearchExpression2);

		NoSearchExpression noSearchExpression1 = new NoSearchExpression();
		collection.add(noSearchExpression1);

		And and = new And(collection);
		assertFalse(and.search(item));
	}

	@Test
	public void testSearch_FalseFalse_ConstruktorWithParameter() throws UserException {
		ProductBacklogItem item = pro1rel1spr1fea1;

		ArrayList<SearchExpression> collection = new ArrayList<SearchExpression>();

		NoSearchExpression noSearchExpression1 = new NoSearchExpression();
		Not NotNoSearchExpression1 = new Not(noSearchExpression1);
		collection.add(NotNoSearchExpression1);

		NoSearchExpression noSearchExpression2 = new NoSearchExpression();
		Not NotNoSearchExpression2 = new Not(noSearchExpression2);
		collection.add(NotNoSearchExpression2);

		And and = new And(collection);
		assertFalse(and.search(item));
	}

	@Test
	public void testSearch_TrueTrue_ConstruktorWithoutParameter() throws UserException {
		ProductBacklogItem item = pro1rel1spr1fea1;

		NoSearchExpression noSearchExpression1 = new NoSearchExpression();

		NoSearchExpression noSearchExpression2 = new NoSearchExpression();

		And and = new And();
		and.add(noSearchExpression1);
		and.add(noSearchExpression2);
		assertTrue(and.search(item));
	}

	@Test
	public void testSearch_TrueFalse_ConstruktorWithoutParameter() throws UserException {
		ProductBacklogItem item = pro1rel1spr1fea1;

		NoSearchExpression noSearchExpression1 = new NoSearchExpression();

		NoSearchExpression noSearchExpression2 = new NoSearchExpression();
		Not NotNoSearchExpression2 = new Not(noSearchExpression2);

		And and = new And();
		and.add(noSearchExpression1);
		and.add(NotNoSearchExpression2);
		assertFalse(and.search(item));
	}

	@Test
	public void testSearch_FalseTrue_ConstruktorWithoutParameter() throws UserException {
		ProductBacklogItem item = pro1rel1spr1fea1;

		NoSearchExpression noSearchExpression1 = new NoSearchExpression();
		Not NotNoSearchExpression1 = new Not(noSearchExpression1);

		NoSearchExpression noSearchExpression2 = new NoSearchExpression();

		And and = new And();
		and.add(NotNoSearchExpression1);
		and.add(noSearchExpression2);
		assertFalse(and.search(item));
	}

	@Test
	public void testSearch_FalseFalse_ConstruktorWithoutParameter() throws UserException {
		ProductBacklogItem item = pro1rel1spr1fea1;

		NoSearchExpression noSearchExpression1 = new NoSearchExpression();
		Not NotNoSearchExpression1 = new Not(noSearchExpression1);

		NoSearchExpression noSearchExpression2 = new NoSearchExpression();
		Not NotNoSearchExpression2 = new Not(noSearchExpression2);

		And and = new And();
		and.add(NotNoSearchExpression1);
		and.add(NotNoSearchExpression2);
		assertFalse(and.search(item));
	}

}
