package fhdw.ipscrum.shared.model.metamodel.search;

import fhdw.ipscrum.shared.model.Model;

/**
 * Represents the operator needed for SearchExpressions.
 */
public abstract class Operator extends SearchExpression {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 3823825460970088197L;

	/**
	 * GWT Serialization Constructor.
	 */
	protected Operator() {
		super();
	}

	/**
	 * Constructor of the Operator.
	 * 
	 * @param model
	 *            : it is inserted in the model
	 */
	public Operator(final Model model) {
		super(model);
	}
}
