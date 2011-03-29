package fhdw.ipscrum.shared.model.search;

import java.util.Vector;

public abstract class MultiLogicSearchOperator implements SearchExpression {

	private static final long serialVersionUID = -374972903680516595L;
	private Vector<SearchExpression> args;

	protected MultiLogicSearchOperator() {
		super();
	}

	public MultiLogicSearchOperator(final Vector<SearchExpression> args) {
		super();
		this.args = args;
	}

	public Vector<SearchExpression> getArgs() {
		return this.args;
	}
}
