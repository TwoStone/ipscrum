package fhdw.ipscrum.client.events.args;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.shared.model.search.ISearchExpression;

public class DeleteEventArgs extends EventArgs {
	private final ISearchExpression expression;

	public DeleteEventArgs(ISearchExpression expression) {
		super();
		this.expression = expression;
	}

	public ISearchExpression getExpression() {
		return this.expression;
	}

}
