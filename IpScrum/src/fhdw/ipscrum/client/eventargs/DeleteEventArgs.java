package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.metamodel.search.ISearchExpression;

/**
 * represents the event argument to delete a search expression.
 */
public class DeleteEventArgs extends EventArgs {
	/**
	 * represents the attached search expression.
	 */
	private final ISearchExpression expression;

	/**
	 * constructor of the event argument.
	 * 
	 * @param expression
	 *            related to the argument
	 */
	public DeleteEventArgs(final ISearchExpression expression) {
		super();
		this.expression = expression;
	}

	/**
	 * getter of the related search expression.
	 * 
	 * @return the search expression attached
	 */
	public ISearchExpression getExpression() {
		return this.expression;
	}

}
