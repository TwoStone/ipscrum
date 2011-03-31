package fhdw.ipscrum.shared.model.search;

/**
 * Represents a logical operator with one argument. This argument is a search
 * expression.
 */
public abstract class SingleLogicSearchOperator implements SearchExpression {

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
}
