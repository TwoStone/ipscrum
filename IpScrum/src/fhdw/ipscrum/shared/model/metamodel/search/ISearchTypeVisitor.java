package fhdw.ipscrum.shared.model.metamodel.search;

/**
 * Represents the Visitor needed to handle SearchTypes.
 */
public interface ISearchTypeVisitor {

	/**
	 * Needed for handling MultiLogicalOperators.
	 * 
	 * @param multiLogicSearchOperator
	 *            is the concrete operator/criteria
	 */
	void handleMultiLogicSearchOperator(
			MultiLogicSearchOperator multiLogicSearchOperator);

	/**
	 * Needed for handling SearchCriteria.
	 * 
	 * @param searchCriteria
	 *            is the concrete operator/criteria
	 */
	void handleSearchCriteria(SearchCriteria searchCriteria);

	/**
	 * Needed for handling SingleLogicalOperators.
	 * 
	 * @param singleLogicSearchOperator
	 *            is the concrete operator/criteria
	 */
	void handleSingleLogicSearchOperator(
			SingleLogicSearchOperator singleLogicSearchOperator);

}
