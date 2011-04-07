package fhdw.ipscrum.shared.model.search;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.observer.IObservable;

/**
 * Represents a search expression
 */
public interface ISearchExpression extends IObservable {

	/**
	 * Compares the given ProductPacklogItem pbi with the concrete
	 * SearchExpression.
	 * 
	 * @param pbi
	 *            ProductBacklogItem
	 * @return True if the compare of pbi and SearchExpression was successful
	 *         else false.
	 */
	public abstract boolean search(ProductBacklogItem pbi);

	public abstract void accept(ISearchExpressionVisitor visitor);

	public abstract void accept(ISearchTypeVisitor visitor);

	/**
	 * Checks if the given search expression is contained.
	 * 
	 * @return True if its contained else false.
	 */
	public abstract boolean contains(ISearchExpression expression);

	public Operator getParent();

	public void setParent(final Operator parent);

}