package fhdw.ipscrum.shared.model.search;

import fhdw.ipscrum.shared.model.ProductBacklogItem;

public class Not extends SingleLogicSearchOperator {

	public Not(final SearchExpression arg) {
		super(arg);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		return !this.getArg().search(pbi);
	}

}
