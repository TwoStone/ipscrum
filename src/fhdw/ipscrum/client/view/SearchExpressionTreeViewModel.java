package fhdw.ipscrum.client.view;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.TreeViewModel;

import fhdw.ipscrum.shared.model.metamodel.search.ISearchExpression;
import fhdw.ipscrum.shared.model.metamodel.search.MultiLogicSearchOperator;
import fhdw.ipscrum.shared.model.metamodel.search.Operator;
import fhdw.ipscrum.shared.model.metamodel.search.Search;
import fhdw.ipscrum.shared.model.metamodel.search.SearchCriteria;
import fhdw.ipscrum.shared.model.metamodel.search.SingleLogicSearchOperator;

/**
 * The model that defines the nodes in the tree.
 */
public class SearchExpressionTreeViewModel implements TreeViewModel {

	private final SelectionModel<ISearchExpression> selectionModel;
	private final SelectionModel<Search> searchSelectionModel;

	private final Search search;

	@Override
	public boolean isLeaf(final Object value) {
		return value instanceof SearchCriteria;
	}

	/**
	 * constructor of the SearchExpressionTreeViewModel.
	 * 
	 * @param searchSelectionModel
	 *            is the single selection model of the search
	 * @param selectionModel
	 *            is the single selection model of the search expressions.
	 * @param search
	 *            is the related search
	 */
	public SearchExpressionTreeViewModel(final SingleSelectionModel<Search> searchSelectionModel,
			final SingleSelectionModel<ISearchExpression> selectionModel, final Search search) {
		this.selectionModel = selectionModel;
		this.searchSelectionModel = searchSelectionModel;
		this.search = search;
	}

	@Override
	public <T> NodeInfo<?> getNodeInfo(final T value) {
		if (value == null) {
			final ListDataProvider<Search> dataProvider = new ListDataProvider<Search>();
			dataProvider.getList().add(this.search);

			return new DefaultNodeInfo<Search>(dataProvider, this.searchCell, this.searchSelectionModel, null);
		} else {
			final ListDataProvider<ISearchExpression> dataProvider = new ListDataProvider<ISearchExpression>();

			if (value instanceof Search) {
				dataProvider.getList().add(((Search) value).getExpression());

			} else if (value instanceof SingleLogicSearchOperator) {
				final SingleLogicSearchOperator operator = (SingleLogicSearchOperator) value;
				if (operator.getArg() != null) {
					dataProvider.getList().add(operator.getArg());
				}

			} else if (value instanceof MultiLogicSearchOperator) {
				final MultiLogicSearchOperator operator = (MultiLogicSearchOperator) value;
				if (operator.getArgs().size() > 0) {
					dataProvider.getList().addAll(operator.getArgs());
				}

			}
			return new DefaultNodeInfo<ISearchExpression>(dataProvider, this.searchExpressionCell, this.selectionModel,
					null);
		}
	}

	private final Cell<ISearchExpression> searchExpressionCell = new AbstractCell<ISearchExpression>() {
		@Override
		public void render(final Context context, final ISearchExpression value, final SafeHtmlBuilder sb) {
			if (value != null) {
				sb.appendEscaped(value.toString());

				if (value instanceof Operator) {
					sb.appendHtmlConstant(" <small> (klicken zum Hinzufügen) </small>");
				}
			}
		}
	};
	private final Cell<Search> searchCell = new AbstractCell<Search>() {
		@Override
		public void render(final Context context, final Search value, final SafeHtmlBuilder sb) {
			if (value != null) {
				sb.appendEscaped("Suche: " + value.getName());
			}
		}
	};

}
