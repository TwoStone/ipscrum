package fhdw.ipscrum.shared.model.search;

import fhdw.ipscrum.shared.model.ProductBacklogItem;

/**
 * Represents a placeholder for SearchExpressions.
 */
public class NoSearchExpression extends Operator {

	private static final long serialVersionUID = 2962799494224674084L;
	private ISearchExpression parent1;

	/**
	 * Constructor used by GWT Serialization and for default initiation.
	 */
	public NoSearchExpression(final Operator parent) {
		super(parent);
	}

	/**
	 * Constructor used by GWT Serialization and for default initiation.
	 */
	@SuppressWarnings("unused")
	private NoSearchExpression() {
		super();
	}

	/**
	 * Constructor.
	 */
	public NoSearchExpression(final ISearchExpression parent,
			final Operator parent1) {
		super(parent1);
		this.parent1 = parent;
	}

	@Override
	public String toString() {
		return "NoSearchExpression";
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		return true;
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handleNoSearchExpression(this);
	}

	@Override
	public void accept(final ISearchTypeVisitor visitor) {
		visitor.handleNoSearchExpression(this);
	}

	// @Override
	// public ISearchExpression getParent() {
	// return this.parent1;
	// }

	@Override
	public boolean contains(final ISearchExpression expression) {
		return false;
	}
}
