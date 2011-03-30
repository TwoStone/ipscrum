package fhdw.ipscrum.shared.model.search;

import fhdw.ipscrum.shared.model.ProductBacklogItem;

/**
 * Represents a placeholder for SearchExpressions.
 */
public class NoSearchExpression implements SearchExpression {

	private static final long serialVersionUID = 2962799494224674084L;

	/**
	 * Constructor.
	 */
	public NoSearchExpression() {
		super();
	}

	@Override
	public String toString() {
		return "NoSearchExpression";
	}

	@Override
	public boolean search(ProductBacklogItem pbi) {
		return true;
	}

}
