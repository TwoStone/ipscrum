package fhdw.ipscrum.shared.model.search;

public interface ISearchTypeVisitor {

	void handleMultiLogicSearchOperator(
			MultiLogicSearchOperator multiLogicSearchOperator);

	void handleSearchCriteria(SearchCriteria searchCriteria);

	void handleSingleLogicSearchOperator(
			SingleLogicSearchOperator singleLogicSearchOperator);

}
