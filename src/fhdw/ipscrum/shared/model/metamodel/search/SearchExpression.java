package fhdw.ipscrum.shared.model.metamodel.search;

import com.google.gwt.user.client.rpc.IsSerializable;

import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;

/**
 * Represents a search expression.
 */
public abstract class SearchExpression extends IdentifiableObject implements IsSerializable, ISearchExpression {

	/**
	 * Represents the serialVeriosnUID.
	 */
	private static final long serialVersionUID = 2552750369508572721L;

	/**
	 * Represents the parent of the Searchexpression.
	 */
	private Operator parent;

	/**
	 * Default Constructor for GWT.
	 */
	protected SearchExpression() {
		super();
	}

	/**
	 * Constructor of the SearchExpression.
	 * 
	 * @param model
	 *            : it is inserted in the model
	 */
	public SearchExpression(final Model model) {
		super(model);
		this.putToObjectStore();
	}

	@Override
	public Operator getParent() {
		return this.parent;
	}

	@Override
	public void setParent(final Operator parent) {
		this.parent = parent;
		this.changed();
	}
}
