package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.model.search.SearchCriteria;

public abstract class TextCriteria implements SearchCriteria {

	private final String value;

	public TextCriteria(final String value) {
		super();
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}