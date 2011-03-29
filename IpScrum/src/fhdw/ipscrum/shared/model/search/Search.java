package fhdw.ipscrum.shared.model.search;

public class Search {

	private final String name;
	private final SearchExpression expression;

	public Search(final String name, final SearchExpression expression) {
		super();
		this.name = name;
		this.expression = expression;
	}

	public SearchExpression getExpression() {
		return this.expression;
	}

	public String getName() {
		return this.name;
	}
}
