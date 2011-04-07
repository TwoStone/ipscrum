package fhdw.ipscrum.shared.model.search;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.shared.model.search.criteria.PBIClosedCriterion;

public class SearchTest extends SetUpTestData {

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
	public void testSearch() {
		String name = new String("Name");
		SearchExpression expression = new PBIClosedCriterion();
		Search search = new Search(name, expression);
		assertEquals(expression, search.getExpression());
		assertEquals(name, search.getName());
	}

}
