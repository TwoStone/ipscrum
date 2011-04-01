package fhdw.ipscrum.client.view;

import java.util.Collection;
import java.util.Comparator;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.cell.client.ActionCell.Delegate;
import com.google.gwt.cell.client.ImageCell;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
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
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.DoScruumleSearchEventArgs;
import fhdw.ipscrum.client.events.args.SearchEventArgs;
import fhdw.ipscrum.client.view.interfaces.ISearchAllView;
import fhdw.ipscrum.client.view.interfaces.ISearchResultView;
import fhdw.ipscrum.client.view.widgets.QuestionDialog;
import fhdw.ipscrum.shared.constants.TextConstants_FilePaths;
import fhdw.ipscrum.shared.model.search.Search;

public class SearchAllView extends Composite implements ISearchAllView {
	private final Event<SearchEventArgs> doSearchEvent;
	private final Event<DoScruumleSearchEventArgs> doScruumleSearchEvent;
	private final ListDataProvider<Search> savedSearches;
	private ScrollPanel bottomPanel;
	private TextBox searchExpression;
	private CellTable<Search> savedSearchesTable;
	private final Event<SearchEventArgs> doDeleteSearchEvent;
	private final Event<SearchEventArgs> doEditSearchEvent;
	private final Event<EventArgs> toDetailedSearchEvent;

	public SearchAllView() {
		super();
		this.doSearchEvent = new Event<SearchEventArgs>();
		this.doDeleteSearchEvent = new Event<SearchEventArgs>();
		this.doEditSearchEvent = new Event<SearchEventArgs>();
		this.doScruumleSearchEvent = new Event<DoScruumleSearchEventArgs>();
		this.toDetailedSearchEvent = new Event<EventArgs>();
		this.savedSearches = new ListDataProvider<Search>();

		final ListHandler<Search> sortHandler = new ListHandler<Search>(
				this.savedSearches.getList());

		final ActionCell<Search> executeCell = new ActionCell<Search>(
				"Ausführen", new Delegate<Search>() {

					@Override
					public void execute(Search object) {
						SearchAllView.this.doSearchEvent
								.fire(SearchAllView.this, new SearchEventArgs(
										object));
					}
				});
		final ActionCell<Search> editCell = new ActionCell<Search>(
				"Bearbeiten", new Delegate<Search>() {

					@Override
					public void execute(Search object) {
						SearchAllView.this.doEditSearchEvent
								.fire(SearchAllView.this, new SearchEventArgs(
										object));
					}
				});
		final ActionCell<Search> deleteCell = new ActionCell<Search>("Löschen",
				new Delegate<Search>() {

					@Override
					public void execute(final Search object) {
						final QuestionDialog questionDialog = new QuestionDialog(
								"Frage", object.getName()
										+ " wirklich löschen?");
						questionDialog.getOkayButton().addClickHandler(
								new ClickHandler() {

									@Override
									public void onClick(ClickEvent event) {
										SearchAllView.this.doDeleteSearchEvent
												.fire(SearchAllView.this,
														new SearchEventArgs(
																object));
									}
								});
						questionDialog.center();
					}
				});

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.initWidget(verticalPanel);
		verticalPanel.setSize("100%", "100%");

		final VerticalPanel verticalPanel_1 = new VerticalPanel();
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
		this.searchExpression.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				SearchAllView.this.doScruumleSearchEvent.fire(
						SearchAllView.this, new DoScruumleSearchEventArgs(
								SearchAllView.this.searchExpression.getText()));
			}
		});
		horizontalPanel.add(this.searchExpression);
		this.searchExpression.setWidth("250px");
		this.searchExpression.setFocus(true);
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {

			@Override
			public void execute() {
				SearchAllView.this.searchExpression.setFocus(true);
			}
		});

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

		final HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(5);
		verticalPanel_1.add(horizontalPanel_1);

		final Button savedSearchesButton = new Button("Gespeicherte Suchen");
		savedSearchesButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				SearchAllView.this.showSearches();
			}
		});
		horizontalPanel_1.add(savedSearchesButton);

		final Button detailedSearch = new Button("Zur detailierten Suche");
		detailedSearch.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				SearchAllView.this.toDetailedSearchEvent.fire(
						SearchAllView.this, new EventArgs());
			}
		});
		horizontalPanel_1.add(detailedSearch);

		this.bottomPanel = new ScrollPanel();
		this.bottomPanel.setStyleName("searchBottom");
		verticalPanel.add(this.bottomPanel);
		this.bottomPanel.setSize("100%", "420px");

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
		iconColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		final TextColumn<Search> nameColumn = new TextColumn<Search>() {
			@Override
			public String getValue(Search object) {
				return object.getName();
			}
		};

		final Column<Search, Search> executeColumn = new Column<Search, Search>(
				executeCell) {

			@Override
			public Search getValue(Search object) {
				return object;
			}
		};

		final Column<Search, Search> editColumn = new Column<Search, Search>(
				editCell) {

			@Override
			public Search getValue(Search object) {
				return object;
			}
		};

		final Column<Search, Search> deleteColumn = new Column<Search, Search>(
				deleteCell) {

			@Override
			public Search getValue(Search object) {
				return object;
			}
		};

		this.savedSearchesTable.addColumn(iconColumn);
		this.savedSearchesTable.addColumn(nameColumn, "Name");
		this.savedSearchesTable.addColumn(executeColumn);
		this.savedSearchesTable.setColumnWidth(executeColumn, "35px");
		this.savedSearchesTable.addColumn(editColumn);
		this.savedSearchesTable.setColumnWidth(editColumn, "35px");
		this.savedSearchesTable.addColumn(deleteColumn);
		this.savedSearchesTable.setColumnWidth(deleteColumn, "35px");
		this.savedSearches.addDataDisplay(this.savedSearchesTable);
		nameColumn.setSortable(true);
		sortHandler.setComparator(nameColumn, new Comparator<Search>() {

			@Override
			public int compare(Search arg0, Search arg1) {
				return arg0.getName().compareToIgnoreCase(arg1.getName());
			}
		});
	}

	@Override
	public void registerDoSavedSearch(EventHandler<SearchEventArgs> handler) {
		this.doSearchEvent.add(handler);
	}

	@Override
	public void registerDoScruumleSearch(
			EventHandler<DoScruumleSearchEventArgs> handler) {
		this.doScruumleSearchEvent.add(handler);
	}

	@Override
	public void setSavedSeaches(Collection<Search> searches) {
		this.savedSearches.getList().clear();
		this.savedSearches.getList().addAll(searches);
	}

	@Override
	public void displaySearchResults(ISearchResultView view) {
		this.bottomPanel.clear();
		this.bottomPanel.add(view);
	}

	@Override
	public void hideSearchResults() {
		this.showSearches();
	}

	@Override
	public void registerDoEditSearch(EventHandler<SearchEventArgs> handler) {
		this.doEditSearchEvent.add(handler);
	}

	@Override
	public void registerDoDeleteSearch(EventHandler<SearchEventArgs> handler) {
		this.doDeleteSearchEvent.add(handler);
	}

	private void showSearches() {
		this.bottomPanel.clear();
		this.bottomPanel.add(this.savedSearchesTable);
	}

	@Override
	public void registerDetailedSearch(EventHandler<EventArgs> handler) {
		this.toDetailedSearchEvent.add(handler);
	}

}
