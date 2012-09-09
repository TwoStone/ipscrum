package fhdw.ipscrum.shared.model.metamodel.search;

import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.observer.IObservable;

/**
 * Represents a search expression.
 */
public interface ISearchExpression extends IObservable {

	/**
	 * Compares the given ProductPacklogItem ticket with the concrete SearchExpression.
	 * 
	 * @param ticket
	 *            is the given ticket
	 * 
	 *            ProductBacklogItem
	 * @return True if the compare of pbi and SearchExpression was successful else false.
	 */
	boolean search(Ticket ticket);

	/**
	 * Needed to use the SearchTypeVisitor.
	 * 
	 * @param visitor
	 *            is the concrete visitor used
	 */
	void accept(ISearchTypeVisitor visitor);

	/**
	 * Checks if the given search expression is contained.
	 * 
	 * @param expression
	 *            the expression that is inside the expression
	 * 
	 * @return True if its contained else false.
	 */
	boolean contains(ISearchExpression expression);

	/**
	 * Getter of the parent.
	 * 
	 * @return the operator that's the parent
	 */
	Operator getParent();

	/**
	 * Setter of the parent.
	 * 
	 * @param parent
	 *            which should be the new operator above another
	 */
	void setParent(final Operator parent);

}
