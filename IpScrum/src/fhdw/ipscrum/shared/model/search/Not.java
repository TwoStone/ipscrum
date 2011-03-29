package fhdw.ipscrum.shared.model.search;

import fhdw.ipscrum.shared.model.ProductBacklogItem;

public class Not extends SingleLogicSearchOperator {

	private static final long serialVersionUID = 5747320984085365276L;

	@SuppressWarnings("unused")
	private Not() {
		super();
	}

	public Not(final SearchExpression arg) {
		super(arg);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		return !this.getArg().search(pbi);
	}

}
