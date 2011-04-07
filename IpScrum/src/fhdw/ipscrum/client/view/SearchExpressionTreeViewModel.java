package fhdw.ipscrum.client.view;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.TreeViewModel;

import fhdw.ipscrum.shared.model.search.ISearchExpression;
import fhdw.ipscrum.shared.model.search.MultiLogicSearchOperator;
import fhdw.ipscrum.shared.model.search.Operator;
import fhdw.ipscrum.shared.model.search.Search;
import fhdw.ipscrum.shared.model.search.SearchCriteria;
import fhdw.ipscrum.shared.model.search.SingleLogicSearchOperator;

/**
 * The model that defines the nodes in the tree.
 */
public class SearchExpressionTreeViewModel implements TreeViewModel {

	private final SelectionModel<ISearchExpression> selectionModel;
	private final SelectionModel<Search> searchSelectionModel;

	private final Search search;

	@Override
	public boolean isLeaf(Object value) {
		return value instanceof SearchCriteria;
	}

	public SearchExpressionTreeViewModel(
			SingleSelectionModel<Search> searchSelectionModel,
			SingleSelectionModel<ISearchExpression> selectionModel,
			Search search) {
		this.selectionModel = selectionModel;
		this.searchSelectionModel = searchSelectionModel;
		this.search = search;
	}

	@Override
	public <T> NodeInfo<?> getNodeInfo(T value) {
		if (value == null) {
			final ListDataProvider<Search> dataProvider = new ListDataProvider<Search>();
			dataProvider.getList().add(this.search);

			return new DefaultNodeInfo<Search>(dataProvider, this.searchCell,
					this.searchSelectionModel, null);
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
			return new DefaultNodeInfo<ISearchExpression>(dataProvider,
					this.searchExpressionCell, this.selectionModel, null);
		}
	}

	Cell<ISearchExpression> searchExpressionCell = new AbstractCell<ISearchExpression>() {
		@Override
		public void render(Context context, ISearchExpression value,
				SafeHtmlBuilder sb) {
			if (value != null) {
				sb.appendEscaped(value.toString());

				if (value instanceof Operator) {
					sb.appendHtmlConstant(" <small> (klicken zum Hinzufügen) </small>");
				}
			}
		}
	};
	Cell<Search> searchCell = new AbstractCell<Search>() {
		@Override
		public void render(Context context, Search value, SafeHtmlBuilder sb) {
			if (value != null) {
				sb.appendEscaped("Suche: " + value.getName());
			}
		}
	};

}