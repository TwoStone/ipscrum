package fhdw.ipscrum.shared.model.metamodel.search;

import fhdw.ipscrum.shared.model.Model;

/**
 * Represents a search criteria. A Search criteria is a search expression.
 */
public abstract class SearchCriteria extends SearchExpression {

	/**
	 * Represents the serialVeriosnUID.
	 */
	private static final long serialVersionUID = -5325546377553649088L;

	/**
	 * GWT Constructor.
	 */
	protected SearchCriteria() {
	}

	/**
	 * Constructor of the SearchCriteria.
	 * 
	 * @param model
	 *            : it is inserted in the model
	 */
	public SearchCriteria(final Model model) {
		super(model);
	}

	@Override
	public void accept(final ISearchTypeVisitor visitor) {
		visitor.handleSearchCriteria(this);
	}

	@Override
	public boolean contains(final ISearchExpression expression) {
		return this.equals(expression);
	}
}
