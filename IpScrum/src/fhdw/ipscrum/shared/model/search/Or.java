package fhdw.ipscrum.shared.model.search;

import fhdw.ipscrum.shared.model.ProductBacklogItem;

/**
 * Represents the logical operator Or! All search expression arguments will be
 * combined with Or. For Example: arg1 or arg2 or arg3 ...
 */
public class Or extends MultiLogicSearchOperator {

	private static final long serialVersionUID = -5965140304562056266L;

	/**
	 * See {@link MultiLogicSearchOperator}
	 */
	public Or() {
		super();
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		if (this.getArgs().size() == 0) {
			return true;
		}
		for (final ISearchExpression current : this.getArgs()) {
			if (current.search(pbi)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handleOr(this);

	}

	@Override
	public String toString() {
		return "ODER";
	}

}
