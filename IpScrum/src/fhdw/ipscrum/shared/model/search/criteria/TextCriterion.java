package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.search.SearchCriteria;

/**
 * Represents a textual criterion.
 */
public abstract class TextCriterion extends SearchCriteria {

	private static final long serialVersionUID = 2959273810129438739L;
	private String value;

	protected TextCriterion() {
		super();
	}

	public TextCriterion(final String value) {
		super();
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

}