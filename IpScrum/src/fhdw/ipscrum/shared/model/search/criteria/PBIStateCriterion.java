package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.search.Operator;
import fhdw.ipscrum.shared.model.search.SearchCriteria;

/**
 * Represents the search criterion for PBI States.
 */
public abstract class PBIStateCriterion extends SearchCriteria {

	private static final long serialVersionUID = 5270499789564779057L;

	public PBIStateCriterion(final Operator parent) {
		super(parent);
	}

	/**
	 * See {@link TextCriterion}
	 */
	protected PBIStateCriterion() {
		super();
	}
}
