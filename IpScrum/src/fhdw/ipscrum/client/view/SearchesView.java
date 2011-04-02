package fhdw.ipscrum.client.view;

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
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.view.client.ListDataProvider;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SearchEventArgs;
import fhdw.ipscrum.client.view.interfaces.ISearchesView;
import fhdw.ipscrum.client.view.widgets.QuestionDialog;
import fhdw.ipscrum.shared.constants.TextConstants_FilePaths;
import fhdw.ipscrum.shared.model.search.Search;

public class SearchesView extends Composite implements ISearchesView {

	protected final Event<SearchEventArgs> doSearchEvent;
	protected final ListDataProvider<Search> savedSearches;
	protected CellTable<Search> savedSearchesTable;
	protected final Event<SearchEventArgs> doDeleteSearchEvent;
	protected final Event<SearchEventArgs> doEditSearchEvent;

	public SearchesView() {
		super();
		this.doDeleteSearchEvent = new Event<SearchEventArgs>();
		this.doEditSearchEvent = new Event<SearchEventArgs>();
		this.doSearchEvent = new Event<SearchEventArgs>();
		this.savedSearches = new ListDataProvider<Search>();
		final ListHandler<Search> sortHandler = new ListHandler<Search>(
				this.savedSearches.getList());

		final ActionCell<Search> executeCell = new ActionCell<Search>(
				"Ausführen", new Delegate<Search>() {

					@Override
					public void execute(Search object) {
						SearchesView.this.doSearchEvent.fire(SearchesView.this,
								new SearchEventArgs(object));
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
										SearchesView.this.doDeleteSearchEvent
												.fire(SearchesView.this,
														new SearchEventArgs(
																object));
									}
								});
						questionDialog.center();
					}
				});

		this.savedSearchesTable = new CellTable<Search>();
		this.initWidget(this.savedSearchesTable);
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
		executeColumn
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		final Column<Search, Search> deleteColumn = new Column<Search, Search>(
				deleteCell) {

			@Override
			public Search getValue(Search object) {
				return object;
			}
		};
		deleteColumn.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		deleteColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		this.savedSearchesTable.addColumn(iconColumn);
		this.savedSearchesTable.addColumn(nameColumn, "Name");
		this.savedSearchesTable.addColumn(executeColumn);
		this.savedSearchesTable.setColumnWidth(executeColumn, "35px");
		this.savedSearchesTable.addColumn(deleteColumn);
		this.savedSearchesTable.setColumnWidth(deleteColumn, "100px");
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
	public void setSavedSeaches(Collection<Search> searches) {
		this.savedSearches.getList().clear();
		this.savedSearches.getList().addAll(searches);
	}

	@Override
	public void registerDoDeleteSearch(EventHandler<SearchEventArgs> handler) {
		this.doDeleteSearchEvent.add(handler);
	}

}