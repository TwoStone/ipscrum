package fhdw.ipscrum.shared.model.search;

import java.util.ArrayList;
import java.util.Collection;

import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.observer.PersistentObserver;

/**
 * Represents a logical operator with more than one argument. All arguments will
 * be combined with the same logical operator, e.g. And or Or
 */
public abstract class MultiLogicSearchOperator extends SearchExpression
		implements PersistentObserver {

	private static final long serialVersionUID = -374972903680516595L;

	/**
	 * List of search expression arguments.
	 */
	private Collection<SearchExpression> args;

	private void setArgs(final Collection<SearchExpression> args) {
		this.args = args;
	}

	/**
	 * Constructor used by GWT Serialization and for default initiation.
	 */
	public MultiLogicSearchOperator() {
		super();
		this.setArgs(new ArrayList<SearchExpression>());
	}

	/**
	 * Constructor (Null-Values not allowed!)
	 * 
	 * @param args
	 *            List of search expression arguments.
	 * 
	 */
	public MultiLogicSearchOperator(final Collection<SearchExpression> args) {
		super();
		this.args = args;
	}

	/**
	 * Returns the search arguments.
	 */
	public Collection<SearchExpression> getArgs() {
		return this.args;
	}

	/**
	 * Adds a search expression to the list.
	 */
	public void add(final SearchExpression expression) {
		if (!expression.contains(this)) {
			expression.addObserver(this);
			this.args.add(expression);
			this.notifyObservers();
		}
	}

	/**
	 * Removes the given search expression from the list if it exists.
	 */
	public void remove(final ISearchExpression expression) {
		this.args.remove(expression);
		expression.deleteObserver(this);
		this.notifyObservers();
	}

	/**
	 * Returns the number of search expressions in the list.
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
		if (this.equals(expression)) {
			return true;
		} else {
			for (final ISearchExpression current : this.args) {
				if (current.equals(expression)) {
					return true;
				} else {
					return current.contains(expression);
				}
			}
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.args == null) ? 0 : this.args.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final MultiLogicSearchOperator other = (MultiLogicSearchOperator) obj;
		if (this.args == null) {
			if (other.args != null) {
				return false;
			}
		} else if (!this.args.equals(other.args)) {
			return false;
		}
		return true;
	}

	@Override
	public void update(final Observable observable, final Object argument) {
		this.notifyObservers();
	}
}
