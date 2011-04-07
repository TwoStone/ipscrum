package fhdw.ipscrum.shared.model.search;

import java.io.Serializable;

import fhdw.ipscrum.shared.observer.Observable;

/**
 * Represents a search expression.
 */
public abstract class SearchExpression extends Observable implements
		Serializable, ISearchExpression {

	private static final long serialVersionUID = 2552750369508572721L;

	private Operator parent;

	public SearchExpression(final Operator parent) {
		super();
		this.parent = parent;
	}

	/**
	 * Default Constructor for GWT
	 */
	protected SearchExpression() {
		super();
	}

	public Operator getParent() {
		return this.parent;
	}
}
