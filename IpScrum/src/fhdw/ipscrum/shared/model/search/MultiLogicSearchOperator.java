package fhdw.ipscrum.shared.model.search;

import java.util.Vector;

/**
 * Represents a logical operator with more than one argument. All arguments will
 * be combined with the same logical operator, e.g. And or Or
 */
public abstract class MultiLogicSearchOperator implements SearchExpression {

	private static final long serialVersionUID = -374972903680516595L;

	/**
	 * List of search expression arguments.
	 */
	private Vector<SearchExpression> args;

	/**
	 * Constructor used by GWT Serialization.
	 */
	protected MultiLogicSearchOperator() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param args
	 *            List of search expression arguments.
	 */
	public MultiLogicSearchOperator(final Vector<SearchExpression> args) {
		super();
		this.args = args;
	}

	/**
	 * Returns the search arguments.
	 */
	public Vector<SearchExpression> getArgs() {
		return this.args;
	}
}
