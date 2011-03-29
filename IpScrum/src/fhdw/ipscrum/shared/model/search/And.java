package fhdw.ipscrum.shared.model.search;

import java.util.Vector;

import fhdw.ipscrum.shared.model.ProductBacklogItem;

public class And extends MultiLogicSearchOperator {

	private static final long serialVersionUID = 817231203138838566L;

	@SuppressWarnings("unused")
	private And() {
		super();
	}

	public And(final Vector<SearchExpression> args) {
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

}
