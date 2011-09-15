package fhdw.ipscrum.shared.model.metamodel.search;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.shared.model.Model;

/**
 * test the searchCriteria.
 */
public class SearchCriteriaTest {
	/**
	 * represents the model needed to use the IPScrum.
	 */
	private static final Model model = new Model(new Date());

	/**
	 * sets up the data before the whole class.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		SearchCriteriaTest.model.setUuidManager(new IDGenerator());
	}

	/**
	 * test the contains method of the search criteria.
	 */
	@Test
	public void testContains() {
		// TODO
		// SearchCriteria criteria1 = new PBIOpenCriterion(model);
		// SearchCriteria criteria2 = new PBIClosedCriterion(model);

		// assertFalse(criteria1.contains(criteria2));
		// assertFalse(criteria2.contains(criteria1));
		// assertTrue(criteria1.contains(criteria1));
		// assertTrue(criteria2.contains(criteria2));
	}

}
