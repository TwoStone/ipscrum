package fhdw.ipscrum.client.view;

import java.util.Collection;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.TreeViewModel;

import fhdw.ipscrum.shared.model.search.ISearchTypeVisitor;
import fhdw.ipscrum.shared.model.search.MultiLogicSearchOperator;
import fhdw.ipscrum.shared.model.search.NoSearchExpression;
import fhdw.ipscrum.shared.model.search.Search;
import fhdw.ipscrum.shared.model.search.SearchCriteria;
import fhdw.ipscrum.shared.model.search.SearchExpression;
import fhdw.ipscrum.shared.model.search.SingleLogicSearchOperator;

/**
 * The model that defines the nodes in the tree.
 */
public class SearchExpressionTreeViewModel implements TreeViewModel {

	private final SelectionModel<SearchExpression> selectionModel;
	private final SelectionModel<Search> searchSelectionModel;

	private final Search search;

	@Override
	public boolean isLeaf(Object value) {
		if (value == null) {
			return false;
		}
		return (value instanceof SearchCriteria || value instanceof NoSearchExpression);
	}

	public SearchExpressionTreeViewModel(SingleSelectionModel<Search> searchSelectionModel, SingleSelectionModel<SearchExpression> selectionModel, Search search) {
		this.selectionModel = selectionModel;
		this.searchSelectionModel = searchSelectionModel;
		this.search = search;
	}

	@Override
	public <T> NodeInfo<?> getNodeInfo(T value) {
		final T val = value;
		if (value == null) {
			final ListDataProvider<Search> dataProvider = new ListDataProvider<Search>();
			dataProvider.getList().add(search);

			return new DefaultNodeInfo<Search>(dataProvider, sCell, searchSelectionModel, null);
		} else {
			final ListDataProvider<SearchExpression> dataProvider = new ListDataProvider<SearchExpression>();

			if (value instanceof Search) {
				dataProvider.getList().add(((Search) value).getExpression());
			} else {

				ISearchTypeVisitor searchTypeVisitor = new ISearchTypeVisitor() {

					@Override
					public void handleSingleLogicSearchOperator(SingleLogicSearchOperator singleLogicSearchOperator) {
						SearchExpression se = ((SingleLogicSearchOperator) val).getArg();
						if (se != null) {
							dataProvider.getList().add(se);
						} else {
							dataProvider.getList().add(new NoSearchExpression((SingleLogicSearchOperator) val));
						}
					}

					@Override
					public void handleSearchCriteria(SearchCriteria searchCriteria) {
						// do nothing
					}

					@Override
					public void handleNoSearchExpression(NoSearchExpression noSearchExpression) {
						// do nothing
					}

					@Override
					public void handleMultiLogicSearchOperator(MultiLogicSearchOperator multiLogicSearchOperator) {
						Collection<SearchExpression> seCollection = ((MultiLogicSearchOperator) val).getArgs();
						if (seCollection != null && seCollection.size() > 0) {
							dataProvider.getList().addAll(seCollection);
							dataProvider.getList().add(new NoSearchExpression((MultiLogicSearchOperator) val));
						} else {
							dataProvider.getList().add(new NoSearchExpression((MultiLogicSearchOperator) val));
						}
					}
				};
				((SearchExpression) value).accept(searchTypeVisitor);
			}
			return new DefaultNodeInfo<SearchExpression>(dataProvider, seCell, selectionModel, null);
		}

	}

	Cell<SearchExpression> seCell = new AbstractCell<SearchExpression>() {
		@Override
		public void render(Context context, SearchExpression value, SafeHtmlBuilder sb) {
			if (value != null) {
				sb.appendEscaped(value.toString());
			}
		}
	};
	Cell<Search> sCell = new AbstractCell<Search>() {
		@Override
		public void render(Context context, Search value, SafeHtmlBuilder sb) {
			if (value != null) {
				sb.appendEscaped("Suche: " + value.getName());
			}
		}
	};
}