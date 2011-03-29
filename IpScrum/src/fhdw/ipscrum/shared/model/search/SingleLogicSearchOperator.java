package fhdw.ipscrum.shared.model.search;

public abstract class SingleLogicSearchOperator implements SearchExpression {

	private static final long serialVersionUID = -2387020530370101740L;
	private SearchExpression arg;

	protected SingleLogicSearchOperator() {
		super();
	}

	public SingleLogicSearchOperator(final SearchExpression arg) {
		super();
		this.arg = arg;
	}

	public SearchExpression getArg() {
		return this.arg;
	}

	public void setArg(final SearchExpression arg) {
		this.arg = arg;
	}
}
