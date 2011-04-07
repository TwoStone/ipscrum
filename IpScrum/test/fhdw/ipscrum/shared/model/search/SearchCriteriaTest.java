package fhdw.ipscrum.shared.model.search;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.shared.model.search.criteria.PBIClosedCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIOpenCriterion;

public class SearchCriteriaTest {

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
	public void testContains() {
		SearchCriteria criteria1 = new PBIOpenCriterion();
		SearchCriteria criteria2 = new PBIClosedCriterion();

		assertFalse(criteria1.contains(criteria2));
		assertFalse(criteria2.contains(criteria1));
		assertTrue(criteria1.contains(criteria1));
		assertTrue(criteria2.contains(criteria2));
	}

}
