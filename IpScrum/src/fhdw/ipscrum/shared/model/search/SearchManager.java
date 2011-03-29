package fhdw.ipscrum.shared.model.search;

import java.io.Serializable;
import java.util.Vector;

import fhdw.ipscrum.shared.model.ProductBacklogItem;

public class SearchManager implements Serializable {

	private static final long serialVersionUID = 1309138599428533013L;
	private Vector<Search> searching;

	public SearchManager() {

	}

	public Vector<Search> getSearching() {
		if (this.searching == null) {
			this.searching = new Vector<Search>();
		}
		return this.searching;
	}

	public void addSearch(final Search search) {
		this.getSearching().add(search);
	}

	public void removeSearch(final Search search) {
		this.getSearching().remove(search);
	}

	public int getSize() {
		return this.getSearching().size();
	}

	public Vector<ProductBacklogItem> search(
			final Vector<ProductBacklogItem> elements,
			final SearchExpression expression) {

		final Vector<ProductBacklogItem> resultList = new Vector<ProductBacklogItem>();
		for (final ProductBacklogItem current : elements) {
			if (expression.search(current)) {
				resultList.add(current);
			}
		}

		return resultList;
	}
}
