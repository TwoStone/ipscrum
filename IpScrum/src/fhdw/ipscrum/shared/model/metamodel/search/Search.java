package fhdw.ipscrum.shared.model.metamodel.search;

import java.io.Serializable;

import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;

/**
 * This class wraps a search expression to define a name for it.
 */
public class Search extends IdentifiableObject implements Serializable {

	/**
	 * Represents the serialVeriosnUID.
	 */
	private static final long serialVersionUID = 3852548812403606010L;

	/**
	 * Name of the search expression.
	 */
	private String name;

	/**
	 * The wrapped search expression.
	 */
	private ISearchExpression expression;

	/**
	 * Only used by serialization of GWT.
	 */
	@SuppressWarnings("unused")
	private Search() {
	}

	/**
	 * Constructor of the Search.
	 * 
	 * @param model
	 *            : it is inserted into the model
	 * 
	 * @param name
	 *            Name of the search.
	 * @param expression
	 *            Wrapped search expression
	 */
	public Search(final Model model, final String name,
			final SearchExpression expression) {
		super(model);
		this.setName(name);
		this.expression = expression;
		// model.addSearch(this);
	}

	/**
	 * Returns the wrapped search expression.
	 * 
	 * @return the expression of the search
	 */
	public ISearchExpression getExpression() {
		return this.expression;
	}

	/**
	 * Returns the name of the search.
	 * 
	 * @return the name of the search
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name of the search.
	 * 
	 * @param name
	 *            the search should have
	 */
	public void setName(final String name) {
		this.name = name;
		this.changed();
	}
}
