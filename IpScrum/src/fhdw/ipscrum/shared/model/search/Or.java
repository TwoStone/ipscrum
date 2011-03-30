package fhdw.ipscrum.shared.model.search;

import java.util.Collection;

import fhdw.ipscrum.shared.model.ProductBacklogItem;

/**
 * Represents the logical operator Or! All search expression arguments will be
 * combined with Or. For Example: arg1 or arg2 or arg3 ...
 */
public class Or extends MultiLogicSearchOperator {

	private static final long serialVersionUID = -5965140304562056266L;

	@SuppressWarnings("unused")
	/**
	 * Constructor used by GWT serialization.
	 */
	private Or() {
		super();
	}

	/**
	 * See Super Constructor.
	 * 
	 * @param args
	 */
	public Or(final Collection<SearchExpression> args) {
		super(args);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		for (final SearchExpression current : this.getArgs()) {
			if (current.search(pbi)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void accept(ISearchExpressionVisitor visitor) {
		visitor.handleOr(this);

	}

}
