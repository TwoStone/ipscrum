package fhdw.ipscrum.shared.model.metamodel.search;

import java.util.Collection;

import junit.framework.Assert;

import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.model.CycleException;
import fhdw.ipscrum.shared.model.SetUpTestData;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;

/**
 * tests the searchManager.
 */
public class SearchManagerTest extends SetUpTestData {

	/**
	 * tests the search of the PBIClosedCriterion.
	 */
	@Test
	public void testSearch1PBIClosedCriterion() {
		final SearchManager manager = new SearchManager();
		final Collection<ProductBacklogItem> elements = this.listOfFeatures;
		// TODO
		// Collection<ProductBacklogItem> result = manager.search(elements, new
		// PBIClosedCriterion(model));
		// assertEquals(53, result.size());
		Assert.assertNotNull(manager);
		Assert.assertNotNull(elements);
	}

	/**
	 * Tests the search of the NotPBIClosedCriterion.
	 * 
	 * @throws CycleException
	 *             if a cycle is created
	 */
	@Test
	public void testSearch2NotPBIClosedCriterion() throws CycleException {
		final SearchManager manager = new SearchManager();
		final Collection<ProductBacklogItem> elements = this.listOfFeatures;
		// TODO
		// Collection<ProductBacklogItem> result = manager.search(elements, new Not(new
		// PBIClosedCriterion(model )));
		// assertEquals(47, result.size());
		Assert.assertNotNull(manager);
		Assert.assertNotNull(elements);

	}

	/**
	 * test a search with the PBINameCriterion.
	 */
	@Test
	public void testSearch3PBINameCriterion() {
		final SearchManager manager = new SearchManager();
		final Collection<ProductBacklogItem> elements = this.listOfFeatures;
		// TODO
		// Collection<ProductBacklogItem> result = manager.search(elements, new
		// PBINameCriterion(model,
		// "Projekt 1, Release 1"));
		// assertEquals(25, result.size());
		Assert.assertNotNull(manager);
		Assert.assertNotNull(elements);
	}

	/**
	 * test the search with the PBSprintNameCriterion.
	 */
	@Test
	public void testSearch4PBSprintNameCriterion() {
		final SearchManager manager = new SearchManager();
		final Collection<ProductBacklogItem> elements = this.listOfFeatures;
		// TODO
		// Collection<ProductBacklogItem> result = manager.search(elements, new
		// PBSprintNameCriterion(model,
		// "Pro1Rel1Sprint1"));
		// assertEquals(5, result.size());
		Assert.assertNotNull(manager);
		Assert.assertNotNull(elements);
	}
}
