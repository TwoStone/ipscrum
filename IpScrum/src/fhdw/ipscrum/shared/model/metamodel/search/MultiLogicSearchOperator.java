package fhdw.ipscrum.shared.model.metamodel.search;

import java.util.ArrayList;
import java.util.Collection;

import fhdw.ipscrum.shared.exceptions.model.CycleException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.observer.PersistentObserver;

/**
 * Represents a logical operator with more than one argument. All arguments will be
 * combined with the same logical operator, e.g. And or Or
 */
public abstract class MultiLogicSearchOperator extends Operator
		implements PersistentObserver {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -374972903680516595L;

	/**
	 * List of search expression arguments.
	 */
	private Collection<ISearchExpression> args;

	/**
	 * Constructor used by GWT Serialization and for default initiation.
	 */
	protected MultiLogicSearchOperator() {
	}

	/**
	 * Constructor of the MultiLogicalSearchOperator.
	 * 
	 * @param model
	 *            is related to the operator
	 */
	public MultiLogicSearchOperator(final Model model) {
		super(model);
		this.args = new ArrayList<ISearchExpression>();
	}

	/**
	 * Returns the search arguments.
	 * 
	 * @return all search expressions
	 */
	public Collection<ISearchExpression> getArgs() {
		return this.args;
	}

	/**
	 * Adds a search expression to the list.
	 * 
	 * @param expression
	 *            is the expression that should be added
	 * @throws CycleException
	 *             if the add generates a cycle
	 */
	public void add(final ISearchExpression expression) throws CycleException {
		if (!expression.contains(this)) {
			expression.addObserver(this);
			expression.setParent(this);
			this.args.add(expression);
			this.notifyObservers();
			this.changed();
		} else {
			throw new CycleException();
		}
	}

	/**
	 * Removes the given search expression from the list if it exists.
	 * 
	 * @param expression
	 *            is the expression that should be removed
	 */
	public void remove(final ISearchExpression expression) {
		this.args.remove(expression);
		expression.setParent(null);
		expression.deleteObserver(this);
		this.notifyObservers();
		this.changed();
	}

	/**
	 * Returns the number of search expressions in the list.
	 * 
	 * @return number of the search expressions
	 */
	public Integer getSize() {
		return this.args.size();
	}

	@Override
	public void accept(final ISearchTypeVisitor visitor) {
		visitor.handleMultiLogicSearchOperator(this);
	}

	@Override
	public boolean contains(final ISearchExpression expression) {
		boolean result = false;
		if (this.equals(expression)) {
			result = true;
		} else {
			for (final ISearchExpression current : this.args) {
				if (current.equals(expression)) {
					result = true;
					break;
				} else {
					return current.contains(expression);
				}
			}
			result = false;
		}
		return result;
	}

	@Override
	public void update(final Observable observable, final Object argument) {
		this.notifyObservers();
	}
}
