package fhdw.ipscrum.shared.model.search;

import fhdw.ipscrum.shared.model.ProductBacklogItem;

/**
 * Represents the logical operator And! All search expression arguments will be
 * combined with And. For Example: arg1 and arg2 and arg3 ...
 */
public class And extends MultiLogicSearchOperator {

	private static final long serialVersionUID = 817231203138838566L;

	/**
	 * See {@link MultiLogicSearchOperator}
	 */
	public And() {
		super();
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		for (final ISearchExpression current : this.getArgs()) {
			if (!current.search(pbi)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handleAnd(this);
	}

	@Override
	public String toString() {
		return "UND";
	}

}
