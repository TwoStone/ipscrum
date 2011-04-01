package fhdw.ipscrum.client.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.cell.client.ActionCell.Delegate;
import com.google.gwt.cell.client.ImageCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.DoScruumleSearchEventArgs;
import fhdw.ipscrum.client.events.args.DoSearchEventArgs;
import fhdw.ipscrum.client.view.interfaces.ISearchAllView;
import fhdw.ipscrum.client.view.interfaces.ISearchResultView;
import fhdw.ipscrum.shared.constants.TextConstants_FilePaths;
import fhdw.ipscrum.shared.model.search.Search;

public class SearchAllView extends Composite implements ISearchAllView {
	private final Event<DoSearchEventArgs> doSearchEvent;
	private final Event<DoScruumleSearchEventArgs> doScruumleSearchEvent;
	private final ListDataProvider<Search> savedSearches;
	private ScrollPanel savedSearchPanel;
	private ScrollPanel resultPanel;
	private DecoratedTabPanel decoratedTabPanel;
	private TextBox searchExpression;

	public SearchAllView() {
		super();

		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		initWidget(verticalPanel);

		VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel_1.setSpacing(10);
		verticalPanel_1
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(verticalPanel_1);
		verticalPanel_1.setHeight("200px");

		Image image = new Image((String) null);
		verticalPanel_1.add(image);

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		verticalPanel_1.add(horizontalPanel);
		horizontalPanel.setWidth("100%");

		searchExpression = new TextBox();
		horizontalPanel.add(searchExpression);
		searchExpression.setWidth("200px");

		Button search = new Button("Suchen");
		search.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				doScruumleSearchEvent.fire(
						SearchAllView.this,
						new DoScruumleSearchEventArgs(searchExpression
								.getText()));
			}
		});
		horizontalPanel.add(search);

		decoratedTabPanel = new DecoratedTabPanel();
		verticalPanel.add(decoratedTabPanel);
		verticalPanel.setCellHorizontalAlignment(decoratedTabPanel,
				HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.setCellVerticalAlignment(decoratedTabPanel,
				HasVerticalAlignment.ALIGN_MIDDLE);
		decoratedTabPanel.setSize("90%", "");

		savedSearchPanel = new ScrollPanel();
		decoratedTabPanel.add(savedSearchPanel, "Gespeicherte Suchen", false);
		savedSearchPanel.setSize("100%", "300px");

		CellTable<Search> cellTable = new CellTable<Search>();
		savedSearchPanel.setWidget(cellTable);
		cellTable.setSize("100%", "100%");

		Column<Search, String> iconColumn = new Column<Search, String>(
				new ImageCell()) {

			@Override
			public String getValue(Search object) {
				return TextConstants_FilePaths.SEARCH_ICON;
			}
		};

		TextColumn<Search> nameColumn = new TextColumn<Search>() {
			@Override
			public String getValue(Search object) {
				return object.toString();
			}
		};

		ActionCell<Search> executeCell = new ActionCell<Search>("Ausführen",
				new Delegate<Search>() {

					@Override
					public void execute(Search object) {
						doSearchEvent.fire(SearchAllView.this,
								new DoSearchEventArgs(object));
					}
				});

		Column<Search, Search> executeColumn = new Column<Search, Search>(
				executeCell) {

			@Override
			public Search getValue(Search object) {
				return object;
			}
		};

		cellTable.addColumn(iconColumn);
		cellTable.addColumn(nameColumn);
		cellTable.addColumn(executeColumn);

		resultPanel = new ScrollPanel();
		resultPanel.setVisible(false);
		resultPanel.setSize("100%", "300px");
		doSearchEvent = new Event<DoSearchEventArgs>();
		doScruumleSearchEvent = new Event<DoScruumleSearchEventArgs>();
		savedSearches = new ListDataProvider<Search>();
		savedSearches.addDataDisplay(cellTable);

		// Lets make the name column sortable.
		ListHandler<Search> sortHandler = new ListHandler<Search>(
				savedSearches.getList());
		nameColumn.setSortable(true);
		sortHandler.setComparator(nameColumn, new Comparator<Search>() {

			@Override
			public int compare(Search arg0, Search arg1) {
				return arg0.getName().compareToIgnoreCase(arg1.getName());
			}
		});

	}

	@Override
	public void registerDoSavedSearch(EventHandler<DoSearchEventArgs> handler) {
		doSearchEvent.add(handler);
	}

	@Override
	public void registerDoScruumleSearch(
			EventHandler<DoScruumleSearchEventArgs> handler) {
		doScruumleSearchEvent.add(handler);
	}

	@Override
	public void setSavedSeaches(Collection<Search> searches) {
		savedSearches.setList(new ArrayList<Search>(searches));
	}

	@Override
	public void displaySearchResults(ISearchResultView view) {
		this.resultPanel.clear();
		resultPanel.add(view);
		resultPanel.setVisible(true);
		this.decoratedTabPanel.add(resultPanel, "Ergebnisse");
		int index = this.decoratedTabPanel.getWidgetIndex(resultPanel);
		this.decoratedTabPanel.selectTab(index);
	}

	@Override
	public void hideSearchResults() {
		this.decoratedTabPanel.remove(resultPanel);
		this.decoratedTabPanel.selectTab(0);
	}

}
