package fhdw.ipscrum.shared.model.search;

/**
 * Represents a logical operator with one argument. This argument is a search
 * expression.
 */
public abstract class SingleLogicSearchOperator extends SearchExpression {

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
	public SingleLogicSearchOperator(final SearchExpression arg) {
		super();
		this.arg = arg;
	}

	/**
	 * Returns the search expression.
	 */
	public SearchExpression getArg() {
		return this.arg;
	}

	/**
	 * Changes the search expression.
	 */
	public void setArg(final SearchExpression arg) {
		this.arg = arg;
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
			return this.arg.contains(expression);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.arg == null) ? 0 : this.arg.hashCode());
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
		final SingleLogicSearchOperator other = (SingleLogicSearchOperator) obj;
		if (this.arg == null) {
			if (other.arg != null) {
				return false;
			}
		} else if (!this.arg.equals(other.arg)) {
			return false;
		}
		return true;
	}
}
