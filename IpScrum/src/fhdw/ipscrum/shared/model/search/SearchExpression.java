package fhdw.ipscrum.shared.model.search;

import java.io.Serializable;

import fhdw.ipscrum.shared.model.ProductBacklogItem;

/**
 * Represents a search expression.
 */
public interface SearchExpression extends Serializable {

	/**
	 * Compares the given ProductPacklogItem pbi with the concrete
	 * SearchExpression.
	 * 
	 * @param pbi
	 *            ProductBacklogItem
	 * @return True if the compare of pbi and SearchExpression was successful
	 *         else false.
	 */
	public boolean search(ProductBacklogItem pbi);

	public void accept(ISearchExpressionVisitor visitor);

	public void accept(ISearchTypeVisitor visitor);
}
