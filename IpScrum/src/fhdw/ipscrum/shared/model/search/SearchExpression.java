package fhdw.ipscrum.shared.model.search;

import fhdw.ipscrum.shared.model.ProductBacklogItem;

public interface SearchExpression {

	public boolean search(ProductBacklogItem pbi);
}
