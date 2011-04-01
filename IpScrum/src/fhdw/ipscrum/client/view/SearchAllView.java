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
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
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
	private ScrollPanel bottomPanel;
	private TextBox searchExpression;
	private CellTable<Search> savedSearchesTable;

	public SearchAllView() {
		super();

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.initWidget(verticalPanel);
		verticalPanel.setSize("100%", "100%");

		final VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel_1.setStyleName("searchHeader");
		verticalPanel_1.setSpacing(10);
		verticalPanel_1
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(verticalPanel_1);
		verticalPanel_1.setSize("100%", "200px");

		final Image image = new Image((String) null);
		verticalPanel_1.add(image);

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		verticalPanel_1.add(horizontalPanel);
		horizontalPanel.setWidth("");

		this.searchExpression = new TextBox();
		horizontalPanel.add(this.searchExpression);
		this.searchExpression.setWidth("200px");

		final Button search = new Button("Suchen");
		search.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				SearchAllView.this.doScruumleSearchEvent.fire(
						SearchAllView.this, new DoScruumleSearchEventArgs(
								SearchAllView.this.searchExpression.getText()));
			}
		});
		horizontalPanel.add(search);

		this.bottomPanel = new ScrollPanel();
		verticalPanel.add(this.bottomPanel);
		this.bottomPanel.setSize("100%", "450px");

		this.savedSearchesTable = new CellTable<Search>();
		this.bottomPanel.setWidget(this.savedSearchesTable);
		this.savedSearchesTable.setSize("100%", "100%");

		final Column<Search, String> iconColumn = new Column<Search, String>(
				new ImageCell()) {

			@Override
			public String getValue(Search object) {
				return TextConstants_FilePaths.SEARCH_ICON;
			}
		};

		final TextColumn<Search> nameColumn = new TextColumn<Search>() {
			@Override
			public String getValue(Search object) {
				return object.toString();
			}
		};

		final ActionCell<Search> executeCell = new ActionCell<Search>(
				"Ausführen", new Delegate<Search>() {

					@Override
					public void execute(Search object) {
						SearchAllView.this.doSearchEvent.fire(
								SearchAllView.this, new DoSearchEventArgs(
										object));
					}
				});

		final Column<Search, Search> executeColumn = new Column<Search, Search>(
				executeCell) {

			@Override
			public Search getValue(Search object) {
				return object;
			}
		};

		this.savedSearchesTable.addColumn(iconColumn);
		this.savedSearchesTable.addColumn(nameColumn, "Name");
		this.savedSearchesTable.addColumn(executeColumn);

		this.doSearchEvent = new Event<DoSearchEventArgs>();
		this.doScruumleSearchEvent = new Event<DoScruumleSearchEventArgs>();
		this.savedSearches = new ListDataProvider<Search>();
		this.savedSearches.addDataDisplay(this.savedSearchesTable);
		// Lets make the name column sortable.
		final ListHandler<Search> sortHandler = new ListHandler<Search>(
				this.savedSearches.getList());
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
		this.doSearchEvent.add(handler);
	}

	@Override
	public void registerDoScruumleSearch(
			EventHandler<DoScruumleSearchEventArgs> handler) {
		this.doScruumleSearchEvent.add(handler);
	}

	@Override
	public void setSavedSeaches(Collection<Search> searches) {
		this.savedSearches.setList(new ArrayList<Search>(searches));
	}

	@Override
	public void displaySearchResults(ISearchResultView view) {
		this.bottomPanel.clear();
		this.bottomPanel.add(view);
	}

	@Override
	public void hideSearchResults() {
		this.bottomPanel.clear();
		this.bottomPanel.add(this.savedSearchesTable);
	}

}
