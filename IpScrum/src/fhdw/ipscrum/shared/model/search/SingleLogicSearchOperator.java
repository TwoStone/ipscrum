package fhdw.ipscrum.shared.model.search;

public abstract class SingleLogicSearchOperator implements SearchExpression {

	private SearchExpression arg;

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
