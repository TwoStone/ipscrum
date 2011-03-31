package fhdw.ipscrum.shared.model.search;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Represents a logical operator with more than one argument. All arguments will
 * be combined with the same logical operator, e.g. And or Or
 */
public abstract class MultiLogicSearchOperator implements SearchExpression {

	private static final long serialVersionUID = -374972903680516595L;

	/**
	 * List of search expression arguments.
	 */
	private final Collection<SearchExpression> args;

	/**
	 * Constructor used by GWT Serialization and for default initiation.
	 */
	public MultiLogicSearchOperator() {
		super();
		this.args = new ArrayList<SearchExpression>();
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
		this.args.add(expression);
	}

	/**
	 * Removes the given search expression from the list if it exists.
	 */
	public void remove(final SearchExpression expression) {
		this.args.remove(expression);
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
}
