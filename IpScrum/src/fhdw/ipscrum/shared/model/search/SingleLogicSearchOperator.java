package fhdw.ipscrum.shared.model.search;

import fhdw.ipscrum.shared.exceptions.CycleException;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.observer.PersistentObserver;

/**
 * Represents a logical operator with one argument. This argument is a search
 * expression.
 */
public abstract class SingleLogicSearchOperator extends Operator implements
		PersistentObserver {

	private static final long serialVersionUID = -2387020530370101740L;

	/**
	 * Search Expression
	 */
	private SearchExpression arg;

	/**
	 * Constructor for GWT serialization.
	 */
	protected SingleLogicSearchOperator() {
		super();
	}

	/**
	 * Constructor (Null-Values not allowed)
	 * 
	 * @param arg
	 *            Search Expression
	 */
	public SingleLogicSearchOperator(final SearchExpression arg)
			throws CycleException {
		super();
		this.setArg(arg);
	}

	/**
	 * Returns the search expression.
	 */
	public SearchExpression getArg() {
		return this.arg;
	}

	/**
	 * Changes the search expression. Null Value is not allowed!
	 */
	public void setArg(final SearchExpression arg) throws CycleException {
		if (!arg.contains(this)) {
			this.arg.deleteObserver(this);
			this.arg = arg;
			this.arg.setParent(this);
			this.arg.addObserver(this);
			this.notifyObservers();
		} else {
			throw new CycleException();
		}
	}

	@Override
	public void accept(final ISearchTypeVisitor visitor) {
		visitor.handleSingleLogicSearchOperator(this);
	}

	@Override
	public boolean contains(final ISearchExpression expression) {
		if (this.equals(expression)) {
			return true;
		} else {
			if (this.arg != null) {
				return this.arg.contains(expression);
			} else {
				return false;
			}
		}
	}

	@Override
	public void update(final Observable observable, final Object argument) {
		this.notifyObservers();
	}
}
