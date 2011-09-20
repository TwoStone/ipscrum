package fhdw.ipscrum.shared.model.metamodel.search;

import fhdw.ipscrum.shared.exceptions.model.CycleException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.observer.PersistentObserver;

/**
 * Represents a logical operator with one argument. This argument is a search expression.
 */
public abstract class SingleLogicSearchOperator extends Operator
		implements PersistentObserver {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -2387020530370101740L;

	/**
	 * Search Expression related to the operator.
	 */
	private SearchExpression arg;

	/**
	 * Constructor for GWT serialization.
	 */
	protected SingleLogicSearchOperator() {
	}

	/**
	 * Constructor (Null-Values not allowed).
	 * 
	 * @param model
	 *            : it is inserted in the model
	 * @param arg
	 *            Search Expression
	 * @throws CycleException
	 *             if the method creates a cycle.
	 */
	public SingleLogicSearchOperator(final Model model, final SearchExpression arg)
			throws CycleException {
		super(model);
		this.setArg(arg);
	}

	/**
	 * Returns the search expression.
	 * 
	 * @return the searchExpression of the Operation
	 */
	public SearchExpression getArg() {
		return this.arg;
	}

	/**
	 * Changes the search expression.
	 * 
	 * @param arg
	 *            the expression to set
	 * @throws CycleException
	 *             if method creates a cycle
	 */
	public void setArg(final SearchExpression arg) throws CycleException {
		if (arg == null) {
			if (this.arg != null) {
				this.arg.deleteObserver(this);
			}
			this.arg = null;
			this.notifyObservers();
			this.changed();
		} else {
			if (!arg.contains(this)) {
				if (this.arg != null) {
					this.arg.deleteObserver(this);
				}
				this.arg = arg;
				this.arg.setParent(this);
				this.arg.addObserver(this);
				this.notifyObservers();
				this.changed();
			} else {
				throw new CycleException();
			}
		}
	}

	@Override
	public void accept(final ISearchTypeVisitor visitor) {
		visitor.handleSingleLogicSearchOperator(this);
	}

	@Override
	public boolean contains(final ISearchExpression expression) {
		boolean result = false;
		if (this.equals(expression)) {
			result = true;
		} else {
			if (this.arg != null) {
				return this.arg.contains(expression);
			} else {
				result = false;
			}
		}
		return result;
	}

	@Override
	public void update(final Observable observable, final Object argument) {
		this.notifyObservers();
	}
}
