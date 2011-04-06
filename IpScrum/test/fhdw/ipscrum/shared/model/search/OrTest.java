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

public class OrTest extends SetUpTestData {

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

		Or or = new Or(collection);

		NoSearchExpression noSearchExpression1 = new NoSearchExpression(or);
		collection.add(noSearchExpression1);

		NoSearchExpression noSearchExpression2 = new NoSearchExpression(or);
		collection.add(noSearchExpression2);

		assertTrue(or.search(item));
	}

	@Test
	public void testSearch_TrueFalse_ConstruktorWithParameter() throws UserException {
		ProductBacklogItem item = pro1rel1spr1fea1;

		ArrayList<SearchExpression> collection = new ArrayList<SearchExpression>();

		Or or = new Or(collection);

		NoSearchExpression noSearchExpression1 = new NoSearchExpression(or);
		collection.add(noSearchExpression1);

		NoSearchExpression noSearchExpression2 = new NoSearchExpression(or);
		Not NotNoSearchExpression2 = new Not(noSearchExpression2);
		collection.add(NotNoSearchExpression2);

		assertTrue(or.search(item));
	}

	@Test
	public void testSearch_FalseTrue_ConstruktorWithParameter() throws UserException {
		ProductBacklogItem item = pro1rel1spr1fea1;

		ArrayList<SearchExpression> collection = new ArrayList<SearchExpression>();

		Or or = new Or(collection);

		NoSearchExpression noSearchExpression2 = new NoSearchExpression(or);
		Not NotNoSearchExpression2 = new Not(noSearchExpression2);
		collection.add(NotNoSearchExpression2);

		NoSearchExpression noSearchExpression1 = new NoSearchExpression(or);
		collection.add(noSearchExpression1);

		assertTrue(or.search(item));
	}

	@Test
	public void testSearch_FalseFalse_ConstruktorWithParameter() throws UserException {
		ProductBacklogItem item = pro1rel1spr1fea1;

		ArrayList<SearchExpression> collection = new ArrayList<SearchExpression>();

		Or or = new Or(collection);

		NoSearchExpression noSearchExpression1 = new NoSearchExpression(or);
		Not NotNoSearchExpression1 = new Not(noSearchExpression1);
		collection.add(NotNoSearchExpression1);

		NoSearchExpression noSearchExpression2 = new NoSearchExpression(or);
		Not NotNoSearchExpression2 = new Not(noSearchExpression2);
		collection.add(NotNoSearchExpression2);

		assertFalse(or.search(item));
	}

	@Test
	public void testSearch_TrueTrue_ConstruktorWithoutParameter() throws UserException {
		ProductBacklogItem item = pro1rel1spr1fea1;

		Or or = new Or();

		NoSearchExpression noSearchExpression1 = new NoSearchExpression(or);

		NoSearchExpression noSearchExpression2 = new NoSearchExpression(or);

		or.add(noSearchExpression1);
		or.add(noSearchExpression2);
		assertTrue(or.search(item));
	}

	@Test
	public void testSearch_TrueFalse_ConstruktorWithoutParameter() throws UserException {
		ProductBacklogItem item = pro1rel1spr1fea1;

		Or or = new Or();

		NoSearchExpression noSearchExpression1 = new NoSearchExpression(or);

		NoSearchExpression noSearchExpression2 = new NoSearchExpression(or);
		Not NotNoSearchExpression2 = new Not(noSearchExpression2);

		or.add(noSearchExpression1);
		or.add(NotNoSearchExpression2);
		assertTrue(or.search(item));
	}

	@Test
	public void testSearch_FalseTrue_ConstruktorWithoutParameter() throws UserException {
		ProductBacklogItem item = pro1rel1spr1fea1;

		Or or = new Or();

		NoSearchExpression noSearchExpression1 = new NoSearchExpression(or);
		Not NotNoSearchExpression1 = new Not(noSearchExpression1);

		NoSearchExpression noSearchExpression2 = new NoSearchExpression(or);

		or.add(NotNoSearchExpression1);
		or.add(noSearchExpression2);
		assertTrue(or.search(item));
	}

	@Test
	public void testSearch_FalseFalse_ConstruktorWithoutParameter() throws UserException {
		ProductBacklogItem item = pro1rel1spr1fea1;

		Or or = new Or();

		NoSearchExpression noSearchExpression1 = new NoSearchExpression(or);
		Not NotNoSearchExpression1 = new Not(noSearchExpression1);

		NoSearchExpression noSearchExpression2 = new NoSearchExpression(or);
		Not NotNoSearchExpression2 = new Not(noSearchExpression2);

		or.add(NotNoSearchExpression1);
		or.add(NotNoSearchExpression2);
		assertFalse(or.search(item));
	}

}
