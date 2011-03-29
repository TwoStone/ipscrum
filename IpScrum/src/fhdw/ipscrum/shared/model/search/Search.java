package fhdw.ipscrum.shared.model.search;

import java.io.Serializable;

public class Search implements Serializable {

	private static final long serialVersionUID = 3852548812403606010L;

	private String name;
	private SearchExpression expression;

	@SuppressWarnings("unused")
	private Search() {
		super();
	}

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
