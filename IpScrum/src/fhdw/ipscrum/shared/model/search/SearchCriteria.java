package fhdw.ipscrum.shared.model.search;

/**
 * Represents a search criteria. A Search criteria is a search expression.
 */
public abstract class SearchCriteria implements ISearchCriteria {

	private static final long serialVersionUID = -5325546377553649088L;

	@Override
	public void accept(final ISearchTypeVisitor visitor) {
		visitor.handleSearchCriteria(this);
	}

	@Override
	public boolean contains(final SearchExpression expression) {
		return this.equals(expression);
	}

}
