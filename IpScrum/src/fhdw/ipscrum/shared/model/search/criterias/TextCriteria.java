package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.model.search.SearchCriteria;

public abstract class TextCriteria extends SearchCriteria {

	private static final long serialVersionUID = 2959273810129438739L;
	private String value;

	protected TextCriteria() {
		super();
	}

	public TextCriteria(final String value) {
		super();
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}