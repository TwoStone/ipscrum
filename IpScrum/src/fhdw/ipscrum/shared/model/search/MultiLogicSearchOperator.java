package fhdw.ipscrum.shared.model.search;

import java.util.Vector;

public abstract class MultiLogicSearchOperator implements SearchExpression {

	private final Vector<SearchExpression> args;

	public MultiLogicSearchOperator(final Vector<SearchExpression> args) {
		super();
		this.args = args;
	}

	public Vector<SearchExpression> getArgs() {
		return this.args;
	}
}
