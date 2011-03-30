package fhdw.ipscrum.shared.model.search;

import java.util.Collection;

import fhdw.ipscrum.shared.model.ProductBacklogItem;

/**
 * Represents the logical operator And! All search expression arguments will be
 * combined with And. For Example: arg1 and arg2 and arg3 ...
 */
public class And extends MultiLogicSearchOperator {

	private static final long serialVersionUID = 817231203138838566L;

	@SuppressWarnings("unused")
	/**
	 * Constructor used by GWT serialization.
	 */
	private And() {
		super();
	}

	/**
	 * See Super Constructor.
	 */
	public And(final Collection<SearchExpression> args) {
		super(args);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		for (final SearchExpression current : this.getArgs()) {
			if (!current.search(pbi)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public void accept(ISearchExpressionVisitor visitor) {
		visitor.handleAnd(this);
	}

}
