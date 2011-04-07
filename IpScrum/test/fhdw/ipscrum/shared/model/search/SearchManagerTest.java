package fhdw.ipscrum.shared.model.search;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.CycleException;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.criteria.PBIClosedCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBINameCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIOpenCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBISprintNameCriterion;

public class SearchManagerTest extends SetUpTestData {

	@Test
	public void testGetSearching() {
		Search search1 = new Search("Name1", new PBIOpenCriterion());
		Search search2 = new Search("Name2", new PBIOpenCriterion());

		SearchManager manager = new SearchManager();
		manager.addSearch(search1);
		manager.addSearch(search2);

		assertEquals(search1, manager.getSearching().get(0));
		assertEquals(search2, manager.getSearching().get(1));
	}

	@Test
	public void testAddSearch() {
		Search search1 = new Search("Name1", new PBIOpenCriterion());
		Search search2 = new Search("Name2", new PBIOpenCriterion());

		SearchManager manager = new SearchManager();
		manager.addSearch(search1);

		assertEquals(1, manager.getSize());

		manager.addSearch(search2);

		assertEquals(2, manager.getSize());

		assertEquals(search1, manager.getSearching().get(0));
		assertEquals(search2, manager.getSearching().get(1));
	}

	@Test
	public void testRemoveSearch() {
		Search search1 = new Search("Name1", new PBIOpenCriterion());
		Search search2 = new Search("Name2", new PBIOpenCriterion());

		SearchManager manager = new SearchManager();
		manager.addSearch(search1);

		assertEquals(1, manager.getSize());

		manager.addSearch(search2);

		assertEquals(2, manager.getSize());

		assertEquals(search1, manager.getSearching().get(0));
		assertEquals(search2, manager.getSearching().get(1));

		manager.removeSearch(search1);
		assertEquals(search2, manager.getSearching().get(0));
	}

	@Test
	public void testGetSize() {
		Search search1 = new Search("Name1", new PBIOpenCriterion());
		Search search2 = new Search("Name2", new PBIOpenCriterion());

		SearchManager manager = new SearchManager();
		manager.addSearch(search1);

		assertEquals(1, manager.getSize());

		manager.addSearch(search2);

		assertEquals(2, manager.getSize());
	}

	@Test
	public void testSearch1_PBIClosedCriterion() {
		SearchManager manager = new SearchManager();
		Collection<ProductBacklogItem> elements = this.listOfFeatures;
		Collection<ProductBacklogItem> result = manager.search(elements, new PBIClosedCriterion());
		assertEquals(53, result.size());
	}

	@Test
	public void testSearch2_NotPBIClosedCriterion() throws CycleException {
		SearchManager manager = new SearchManager();
		Collection<ProductBacklogItem> elements = this.listOfFeatures;
		Collection<ProductBacklogItem> result = manager.search(elements, new Not(new PBIClosedCriterion()));
		assertEquals(47, result.size());
	}

	@Test
	public void testSearch3_PBINameCriterion() {
		SearchManager manager = new SearchManager();
		Collection<ProductBacklogItem> elements = this.listOfFeatures;
		Collection<ProductBacklogItem> result = manager.search(elements, new PBINameCriterion("Projekt 1, Release 1"));
		assertEquals(25, result.size());
	}

	@Test
	public void testSearch4_PBISprintNameCriterion() {
		SearchManager manager = new SearchManager();
		Collection<ProductBacklogItem> elements = this.listOfFeatures;
		Collection<ProductBacklogItem> result = manager.search(elements, new PBISprintNameCriterion("Pro1Rel1Sprint1"));
		assertEquals(5, result.size());
	}
}
