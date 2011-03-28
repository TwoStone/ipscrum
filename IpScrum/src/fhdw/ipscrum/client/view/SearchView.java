package fhdw.ipscrum.client.view;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.view.client.AbstractDataProvider;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.NoSelectionModel;
import com.google.gwt.view.client.SelectionModel.AbstractSelectionModel;
import com.google.gwt.view.client.TreeViewModel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.events.args.SearchArgs;
import fhdw.ipscrum.client.view.interfaces.ISearchView;

public class SearchView extends Composite implements ISearchView {

	private final Event<EventArgs> addNewSearchCriterion = new Event<EventArgs>();
	private final Event<EventArgs> addLogicalOperator = new Event<EventArgs>();
	private final Event<SearchArgs> addExistingSearchCriterion = new Event<SearchArgs>();
	private final Event<EventArgs> abort = new Event<EventArgs>();
	private final Event<EventArgs> save = new Event<EventArgs>();

	public SearchView() {

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		initWidget(horizontalPanel);

		ScrollPanel scrollPanelSearch = new ScrollPanel();
		horizontalPanel.add(scrollPanelSearch);
		scrollPanelSearch.setSize("256px", "400px");

		CellTree cellTree = new CellTree(new TreeViewModel() {
			final AbstractDataProvider<String> dataProvider = new ListDataProvider<String>();
			final AbstractSelectionModel<String> selectionModel = new NoSelectionModel<String>();

			@Override
			public <T> NodeInfo<?> getNodeInfo(T value) {
				return new DefaultNodeInfo<String>(dataProvider, new TextCell(), selectionModel, null);
			}

			@Override
			public boolean isLeaf(Object value) {
				return true;
			}
		}, null);
		scrollPanelSearch.setWidget(cellTree);
		cellTree.setSize("100%", "100%");
	}

	@Override
	public IEvent<EventArgs> getSave() {
		return this.save;
	}

	@Override
	public IEvent<EventArgs> getAborted() {
		return this.abort;
	}

	@Override
	public IEvent<EventArgs> getAddNewSearchCriterion() {
		return this.addNewSearchCriterion;
	}

	@Override
	public IEvent<EventArgs> getAddLogicalOperator() {
		return this.addLogicalOperator;
	}

	@Override
	public IEvent<SearchArgs> getAddExistingSearchCriterion() {
		return this.addExistingSearchCriterion;
	}

}
