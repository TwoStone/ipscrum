package fhdw.ipscrum.client.view;

import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.events.args.SearchArgs;
import fhdw.ipscrum.client.view.interfaces.ISearchView;
import fhdw.ipscrum.shared.model.search.And;
import fhdw.ipscrum.shared.model.search.NoSearchExpression;
import fhdw.ipscrum.shared.model.search.Not;
import fhdw.ipscrum.shared.model.search.Or;
import fhdw.ipscrum.shared.model.search.Search;
import fhdw.ipscrum.shared.model.search.SearchExpression;

public class SearchView extends Composite implements ISearchView {
	private Search search;
	private final Event<EventArgs> addNewSearchCriterion = new Event<EventArgs>();
	private final Event<EventArgs> addLogicalOperator = new Event<EventArgs>();
	private final Event<SearchArgs> addExistingSearchCriterion = new Event<SearchArgs>();
	private final Event<EventArgs> abort = new Event<EventArgs>();
	private final Event<EventArgs> save = new Event<EventArgs>();
	private SingleSelectionModel<SearchExpression> selectionModel;

	private CellTree cellTree;
	private ScrollPanel scrollPanelSearch;
	private VerticalPanel valuePanel;
	private ListBox cboTyp1;
	private ListBox cboTyp2;
	private Label lblTyp1;
	private Label lblTyp2;

	public SearchView() {
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		initWidget(horizontalPanel);
		horizontalPanel.setSpacing(5);
		scrollPanelSearch = new ScrollPanel();
		horizontalPanel.add(scrollPanelSearch);
		scrollPanelSearch.setSize("400px", "400px");

		valuePanel = new VerticalPanel();
		scrollPanelSearch.setSize("400px", "400px");

		horizontalPanel.add(valuePanel);
		valuePanel.setSpacing(5);
		valuePanel.setSize("200", "400");

		lblTyp1 = new Label("Typ des Suchausdrucks");

		cboTyp1 = new ListBox();
		cboTyp1.addItem("Logischer Operator");
		cboTyp1.addItem("Suchkriterium");
		cboTyp1.addItem("Vorhandene Suche");
		lblTyp2 = new Label("Typ2");

		cboTyp2 = new ListBox();
		cboTyp2.addItem("AND");
		cboTyp2.addItem("OR");
		cboTyp2.addItem("NOT");

		this.selectionModel = new SingleSelectionModel<SearchExpression>();
		this.selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				SearchExpression se = selectionModel.getSelectedObject();
				if (se instanceof NoSearchExpression) {
					showCboTyp1(true, -1);
					showCboTyp2(false, -1);
				} else if (se instanceof And) {
				} else if (se instanceof Or) {
				} else if (se instanceof Not) {
					showCboTyp1(true, 1);
					showCboTyp2(true, 2);
				}
			}
		});
	}

	private void showCboTyp1(boolean b, int selIndex) {
		if (b) {
			valuePanel.add(lblTyp1);
			valuePanel.add(cboTyp1);
			cboTyp1.setSelectedIndex(selIndex);
		} else {
			valuePanel.remove(lblTyp1);
			valuePanel.remove(cboTyp1);
		}
	}

	private void showCboTyp2(boolean b, int selIndex) {
		if (b) {
			valuePanel.add(lblTyp2);
			valuePanel.add(cboTyp2);
			cboTyp2.setSelectedIndex(selIndex);
		} else {
			valuePanel.remove(lblTyp2);
			valuePanel.remove(cboTyp1);
		}
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

	@Override
	public void setSearch(Search search) {
		this.search = search;
		cellTree = new CellTree(new SearchSelectionTreeViewModel(selectionModel, search), null);
		scrollPanelSearch.setWidget(cellTree);
		cellTree.setSize("400px", "400px");
		cellTree.setVisible(true);
	}

	@Override
	public void addSearchExpression(SearchExpression searchPart) {
		// TODO Christin Auto-generated method stub
	}
}
