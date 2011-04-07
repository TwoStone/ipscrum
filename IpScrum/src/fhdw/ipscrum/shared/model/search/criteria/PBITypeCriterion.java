package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.search.SearchCriteria;

/**
 * Represents the search criterion for special PBI Type like Bug and Feature.
 */
public abstract class PBITypeCriterion extends SearchCriteria {

	private static final long serialVersionUID = -8379464635872511730L;

	/**
	 * See {@link TextCriterion}
	 */
	protected PBITypeCriterion() {
		super();
	}
}
