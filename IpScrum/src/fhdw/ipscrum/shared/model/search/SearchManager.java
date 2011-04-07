package fhdw.ipscrum.shared.model.search;

import java.io.Serializable;
import java.util.Collection;
import java.util.Vector;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.observer.Observable;

/**
 * Manages a list of stored SearchExpressions and initiates a search.
 */
public class SearchManager extends Observable implements Serializable {

	private static final long serialVersionUID = 1309138599428533013L;

	/**
	 * List of stored search expressions.
	 */
	private Vector<Search> searching;

	/**
	 * Creates a new SearchManager Object.
	 */
	public SearchManager() {
		super();
	}

	/**
	 * Returns the list of stored search expressions.
	 */
	public Vector<Search> getSearching() {
		if (this.searching == null) {
			this.searching = new Vector<Search>();
		}
		return this.searching;
	}

	/**
	 * Adds a new search to the list.
	 */
	public void addSearch(final Search search) {
		this.getSearching().add(search);
		this.notifyObservers();
	}

	/**
	 * Removes the given search from the list.
	 */
	public void removeSearch(final Search search) {
		this.getSearching().remove(search);
		this.notifyObservers();
	}

	/**
	 * Returns the number of searches within the list.
	 */
	public int getSize() {
		return this.getSearching().size();
	}

	/**
	 * Initiate a search for a given list of PBIs based on a specific search
	 * expression.
	 * 
	 * @param elements
	 *            Elements for search.
	 * @param expression
	 *            Search Expression
	 * @return Returns a list of PBIs where the compare of each pbi with the
	 *         search expression was successful.
	 */
	public Collection<ProductBacklogItem> search(
			final Collection<ProductBacklogItem> elements,
			final ISearchExpression expression) {

		final Vector<ProductBacklogItem> resultList = new Vector<ProductBacklogItem>();
		for (final ProductBacklogItem current : elements) {
			if (expression.search(current)) {
				resultList.add(current);
			}
		}

		return resultList;
	}
}
