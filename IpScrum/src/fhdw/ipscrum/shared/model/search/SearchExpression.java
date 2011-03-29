package fhdw.ipscrum.shared.model.search;

import java.io.Serializable;

import fhdw.ipscrum.shared.model.ProductBacklogItem;

public interface SearchExpression extends Serializable {

	public boolean search(ProductBacklogItem pbi);
}
