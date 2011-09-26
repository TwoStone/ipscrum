package fhdw.ipscrum.client.view;

import java.util.Collection;
import java.util.Comparator;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.cell.client.ActionCell.Delegate;
import com.google.gwt.cell.client.ImageResourceCell;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;

import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.view.MasterView;
import fhdw.ipscrum.client.eventargs.SearchEventArgs;
import fhdw.ipscrum.client.resources.MyResources;
import fhdw.ipscrum.client.viewinterfaces.ISearchesView;
import fhdw.ipscrum.shared.model.metamodel.search.Search;

/**
 * represents the view of the searches.
 */
public class SearchesView extends MasterView implements ISearchesView {

	private final Event<SearchEventArgs> doSearchEvent;
	private final ListDataProvider<Search> savedSearches;
	private CellTable<Search> savedSearchesTable;
	private final Event<SearchEventArgs> doDeleteSearchEvent;
	private final Event<SearchEventArgs> doEditSearchEvent;

	/**
	 * constructor of the SearchesView.
	 */
	public SearchesView() {
		super();
		this.doDeleteSearchEvent = new Event<SearchEventArgs>();
		this.doEditSearchEvent = new Event<SearchEventArgs>();
		this.doSearchEvent = new Event<SearchEventArgs>();
		this.savedSearches = new ListDataProvider<Search>();
		final ListHandler<Search> sortHandler = new ListHandler<Search>(this.getSavedSearches().getList());

		final ActionCell<Search> executeCell = new ActionCell<Search>("Ausführen", new Delegate<Search>() {

			@Override
			public void execute(final Search object) {
				SearchesView.this.getDoSearchEvent().fire(SearchesView.this, new SearchEventArgs(object));
			}
		});

		final ActionCell<Search> deleteCell = new ActionCell<Search>("Löschen", new Delegate<Search>() {

			@Override
			public void execute(final Search object) {
				SearchesView.this.getDoDeleteSearchEvent().fire(SearchesView.this, new SearchEventArgs(object));
			}
		});

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.setSize("750px", "400px");
		this.add(verticalPanel);

		final Label lblSearches = new Label("Gespeicherte Suchen");
		lblSearches.setStyleName("LabelElement");
		verticalPanel.add(lblSearches);
		lblSearches.setSize("750px", "25px");

		final ScrollPanel scrollPanel = new ScrollPanel();
		verticalPanel.add(scrollPanel);
		scrollPanel.setSize("740px", "450px");

		this.setSavedSearchesTable(new CellTable<Search>());
		scrollPanel.setWidget(this.getSavedSearchesTable());
		this.getSavedSearchesTable().setSize("100%", "100%");

		final Column<Search, ImageResource> iconColumn = new Column<Search, ImageResource>(new ImageResourceCell()) {

			@Override
			public ImageResource getValue(final Search object) {
				return MyResources.INSTANCE.searchIcon();
			}
		};
		iconColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		final TextColumn<Search> nameColumn = new TextColumn<Search>() {
			@Override
			public String getValue(final Search object) {
				return object.getName();
			}
		};

		final Column<Search, Search> executeColumn = new Column<Search, Search>(executeCell) {

			@Override
			public Search getValue(final Search object) {
				return object;
			}
		};
		executeColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		final Column<Search, Search> deleteColumn = new Column<Search, Search>(deleteCell) {

			@Override
			public Search getValue(final Search object) {
				return object;
			}
		};
		deleteColumn.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		deleteColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		this.getSavedSearchesTable().addColumn(iconColumn);
		this.getSavedSearchesTable().addColumn(nameColumn, "Name");
		this.getSavedSearchesTable().addColumn(executeColumn);
		this.getSavedSearchesTable().setColumnWidth(executeColumn, "35px");
		this.getSavedSearchesTable().addColumn(deleteColumn);
		this.getSavedSearchesTable().setColumnWidth(deleteColumn, "100px");
		this.getSavedSearches().addDataDisplay(this.getSavedSearchesTable());
		nameColumn.setSortable(true);
		sortHandler.setComparator(nameColumn, new Comparator<Search>() {

			@Override
			public int compare(final Search arg0, final Search arg1) {
				return arg0.getName().compareToIgnoreCase(arg1.getName());
			}
		});
	}

	@Override
	public void registerDoSavedSearch(final EventHandler<SearchEventArgs> handler) {
		this.getDoSearchEvent().add(handler);
	}

	@Override
	public void setSavedSeaches(final Collection<Search> searches) {
		this.getSavedSearches().getList().clear();
		this.getSavedSearches().getList().addAll(searches);
	}

	@Override
	public void registerDoDeleteSearch(final EventHandler<SearchEventArgs> handler) {
		this.getDoDeleteSearchEvent().add(handler);
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide

	}

	/**
	 * @return the doSearchEvent
	 */
	protected Event<SearchEventArgs> getDoSearchEvent() {
		return this.doSearchEvent;
	}

	/**
	 * @return the savedSearches
	 */
	protected ListDataProvider<Search> getSavedSearches() {
		return this.savedSearches;
	}

	/**
	 * @param savedSearchesTable
	 *            the savedSearchesTable to set
	 */
	protected void setSavedSearchesTable(final CellTable<Search> savedSearchesTable) {
		this.savedSearchesTable = savedSearchesTable;
	}

	/**
	 * @return the savedSearchesTable
	 */
	protected CellTable<Search> getSavedSearchesTable() {
		return this.savedSearchesTable;
	}

	/**
	 * @return the doDeleteSearchEvent
	 */
	protected Event<SearchEventArgs> getDoDeleteSearchEvent() {
		return this.doDeleteSearchEvent;
	}

	/**
	 * @return the doEditSearchEvent
	 */
	protected Event<SearchEventArgs> getDoEditSearchEvent() {
		return this.doEditSearchEvent;
	}

}
