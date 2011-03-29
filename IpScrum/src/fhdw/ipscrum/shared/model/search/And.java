package fhdw.ipscrum.shared.model.search;

import java.util.Vector;

import fhdw.ipscrum.shared.model.ProductBacklogItem;

public class And extends MultiLogicSearchOperator {

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
