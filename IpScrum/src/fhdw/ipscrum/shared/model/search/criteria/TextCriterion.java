package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.search.ISearchExpression;
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

	/**
	 * This method checks if arg1 contains the attribute value of this class. It
	 * differs from the String based contains because it's not case sensitive.
	 * 
	 * @param arg
	 *            Argument
	 * @return True if arg1 contains -value- and false if not.
	 */
	public boolean nonSensitiveContains(final String arg) {
		return arg.toLowerCase().contains(this.value.toLowerCase());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.value == null) ? 0 : this.value.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final TextCriterion other = (TextCriterion) obj;
		if (this.value == null) {
			if (other.value != null) {
				return false;
			}
		} else if (!this.value.equals(other.value)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean contains(final ISearchExpression expression) {
		return this.equals(expression);
	}

}