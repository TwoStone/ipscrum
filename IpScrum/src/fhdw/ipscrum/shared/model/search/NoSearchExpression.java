package fhdw.ipscrum.shared.model.search;

import fhdw.ipscrum.shared.model.ProductBacklogItem;

/**
 * Represents a placeholder for SearchExpressions.
 */
public class NoSearchExpression implements SearchExpression {

	private static final long serialVersionUID = 2962799494224674084L;
	private SearchExpression parent;

	/**
	 * Constructor used by GWT Serialization and for default initiation.
	 */
	@SuppressWarnings("unused")
	private NoSearchExpression() {
		super();
	}

	/**
	 * Constructor.
	 */
	public NoSearchExpression(SearchExpression parent) {
		super();
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "NoSearchExpression";
	}

	@Override
	public boolean search(ProductBacklogItem pbi) {
		return true;
	}

	@Override
	public void accept(ISearchExpressionVisitor visitor) {
		visitor.handleNoSearchExpression(this);
	}

	@Override
	public void accept(ISearchTypeVisitor visitor) {
		visitor.handleNoSearchExpression(this);
	}

	public SearchExpression getParent() {
		return parent;
	}

}
