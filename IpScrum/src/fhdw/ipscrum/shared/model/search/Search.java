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
	 * @param name Name of the search.
	 * @param expression Wrapped search expression
	 */
	public Search(final String name, final SearchExpression expression) {
		super();
		this.setName(name);
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

	/**
	 * Sets the name of the search.
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Search other = (Search) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
