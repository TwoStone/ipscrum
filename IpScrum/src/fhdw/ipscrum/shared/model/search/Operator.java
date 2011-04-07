package fhdw.ipscrum.shared.model.search;

public abstract class Operator extends SearchExpression {

	private static final long serialVersionUID = 3823825460970088197L;

	public Operator(final Operator parent) {
		super(parent);
	}

	/**
	 * GWT Serialization Constructor
	 */
	protected Operator() {
		super();
	}

}
