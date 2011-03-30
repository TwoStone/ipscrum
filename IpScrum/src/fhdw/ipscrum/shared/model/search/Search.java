package fhdw.ipscrum.shared.model.search;

import java.io.Serializable;

/**
 * This class wraps a search expression to define a name for it.
 */
public class Search implements Serializable {

	private static final long serialVersionUID = 3852548812403606010L;

	/**
	 * Name of the search expression
	 */
	private String name;

	/**
	 * The wrapped search expression
	 */
	private SearchExpression expression;

	@SuppressWarnings("unused")
	/**
	 * Only used by serialization of GWT.
	 */
	private Search() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param name
	 *            Name of the search.
	 * @param expression
	 *            Wrapped search expression
	 */
	public Search(final String name, final SearchExpression expression) {
		super();
		this.name = name;
		this.expression = expression;
	}

	/**
	 * Returns the wrapped search expression.
	 */
	public SearchExpression getExpression() {
		return this.expression;
	}

	/**
	 * Returns the name of the search.
	 */
	public String getName() {
		return this.name;
	}
}
