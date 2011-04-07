package fhdw.ipscrum.shared.model.search;

import fhdw.ipscrum.shared.model.ProductBacklogItem;

/**
 * Represents the logical operator Not. For Example: Not(arg) -> arg=true=>false
 * | arg=false=>true
 * 
 */
public class Not extends SingleLogicSearchOperator {

	private static final long serialVersionUID = 5747320984085365276L;

	/**
	 * See {@link SingleLogicSearchOperator}
	 */
	public Not(final SearchExpression arg) {
		super(arg);
	}

	/**
	 * See {@link SingleLogicSearchOperator}
	 */
	public Not() {
		super();
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		return !this.getArg().search(pbi);
	}

	@Override
	public String toString() {
		return "NICHT";
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handleNot(this);
	}
}
