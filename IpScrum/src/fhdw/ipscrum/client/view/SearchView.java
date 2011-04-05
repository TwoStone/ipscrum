package fhdw.ipscrum.client.view;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.events.args.CreateLogicalOperatorArgs;
import fhdw.ipscrum.client.view.interfaces.ISearchView;
import fhdw.ipscrum.shared.constants.TextConstantsForLists;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.RelationType;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.search.ISearchTypeVisitor;
import fhdw.ipscrum.shared.model.search.MultiLogicSearchOperator;
import fhdw.ipscrum.shared.model.search.NoSearchExpression;
import fhdw.ipscrum.shared.model.search.Search;
import fhdw.ipscrum.shared.model.search.SearchCriteria;
import fhdw.ipscrum.shared.model.search.SearchExpression;
import fhdw.ipscrum.shared.model.search.SingleLogicSearchOperator;

public class SearchView extends Composite implements ISearchView {
	private final Event<EventArgs> addSearchCriterion = new Event<EventArgs>();
	private final Event<CreateLogicalOperatorArgs> addLogicalOperator = new Event<CreateLogicalOperatorArgs>();
	private final Event<EventArgs> abort = new Event<EventArgs>();
	private final Event<EventArgs> save = new Event<EventArgs>();
	private SingleSelectionModel<SearchExpression> selectionModel;
	private Collection<Project> projects;
	private Collection<Release> releases;
	private Collection<System> systems;
	private Collection<IPerson> persons;
	private Collection<RelationType> relationtypes;
	private CellTree cellTree;
	private ScrollPanel scrollPanelSearch;
	private VerticalPanel valuePanel;
	private VerticalPanel thirdLevelPanel;
	private ListBox cboTyp1;
	private ListBox cboTyp2;
	private Label lblTyp1;
	private Label lblTyp2;
	private Label lblThirdLevel;
	private Label lblThirdLevel2;
	private ListBox cboThirdLevel;
	private TextBox txtThirdLevel;
	private TextBox txtThirdLevel2;
	private Search search;
	private Button btnOk;
	private HorizontalPanel buttonPanel;
	private Button btnAbbrechen;

	public SearchView() {
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		initWidget(horizontalPanel);
		horizontalPanel.setSpacing(5);
		scrollPanelSearch = new ScrollPanel();
		horizontalPanel.add(scrollPanelSearch);
		scrollPanelSearch.setSize("500px", "400px");
		valuePanel = new VerticalPanel();

		horizontalPanel.add(valuePanel);
		valuePanel.setSpacing(5);
		valuePanel.setSize("500", "400");

		buttonPanel = new HorizontalPanel();

		btnOk = new Button("OK");
		buttonPanel.add(btnOk);
		btnOk.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (cboTyp1.getSelectedIndex() == 0) {
					SearchView.this.addLogicalOperator.fire(SearchView.this, new CreateLogicalOperatorArgs(SearchView.this.cboTyp2.getSelectedIndex() + 1,
							((NoSearchExpression) SearchView.this.selectionModel.getSelectedObject()).getParent()));
				} else if (cboTyp1.getSelectedIndex() == 1) {

				}
			}
		});

		btnAbbrechen = new Button("Abbrechen");
		buttonPanel.add(btnAbbrechen);

		thirdLevelPanel = new VerticalPanel();
		thirdLevelPanel.setSize("490", "200");

		lblTyp1 = new Label("Typ des Suchausdrucks");

		cboTyp1 = new ListBox();
		fillCombobox(cboTyp1, TextConstantsForLists.SEARCH_TYPES);
		cboTyp1.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				if (cboTyp1.getSelectedIndex() == 0) {
					showCboTyp2(true, TextConstantsForLists.SEARCH_LOGICALS);
					lblTyp2.setText(TextConstantsForLists.SEARCH_TYPES.get(1));
					valuePanel.remove(thirdLevelPanel);
				} else if (cboTyp1.getSelectedIndex() == 1) {
					showCboTyp2(true, TextConstantsForLists.SEARCH_CRITERIA);
					lblTyp2.setText(TextConstantsForLists.SEARCH_TYPES.get(2));
					valuePanel.remove(thirdLevelPanel);
				} else {
					showCboTyp2(false, null);
					lblTyp2.setText(TextConstantsForLists.SEARCH_TYPES.get(2));
				}
			}
		});

		lblTyp2 = new Label();
		cboTyp2 = new ListBox();
		cboTyp2.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				if (cboTyp1.getSelectedIndex() == 0) {
					thirdLevelPanel.clear();
					valuePanel.add(thirdLevelPanel);
					thirdLevelPanel.add(buttonPanel);
				} else if (cboTyp1.getSelectedIndex() == 1) {
					valuePanel.add(thirdLevelPanel);
					showThirdLevel(cboTyp2.getSelectedIndex());
				}
			}

		});

		lblThirdLevel = new Label();
		lblThirdLevel2 = new Label();
		cboThirdLevel = new ListBox();
		txtThirdLevel = new TextBox();
		txtThirdLevel2 = new TextBox();
		cboThirdLevel.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				thirdLevelPanel.add(buttonPanel);
			}
		});

		this.selectionModel = new SingleSelectionModel<SearchExpression>();
		this.selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				SearchExpression se = selectionModel.getSelectedObject();
				ISearchTypeVisitor searchTypeVisitor = new ISearchTypeVisitor() {

					@Override
					public void handleMultiLogicSearchOperator(MultiLogicSearchOperator multiLogicSearchOperator) {
						showCboTyp1(false);
						showCboTyp2(false, null);
					}

					@Override
					public void handleSearchCriteria(SearchCriteria searchCriteria) {
						showCboTyp1(false);
						showCboTyp2(false, null);
					}

					@Override
					public void handleSingleLogicSearchOperator(SingleLogicSearchOperator singleLogicSearchOperator) {
						showCboTyp1(false);
						showCboTyp2(false, null);
					}

					@Override
					public void handleNoSearchExpression(NoSearchExpression noSearchExpression) {
						showCboTyp1(true);
						showCboTyp2(false, null);
					}

				};
				se.accept(searchTypeVisitor);
			}
		});
	}

	private void fillCombobox(ListBox cbo, Map<Integer, String> map) {
		cbo.clear();
		for (int i = 1; i <= map.size(); i++) {
			cbo.addItem(map.get(i));
		}
	}

	private void showCboTyp1(boolean b) {
		if (b) {
			valuePanel.add(lblTyp1);
			valuePanel.add(cboTyp1);
			cboTyp1.setSelectedIndex(-1);
		} else {
			valuePanel.remove(lblTyp1);
			valuePanel.remove(cboTyp1);
		}
	}

	private void showCboTyp2(boolean b, Map<Integer, String> map) {
		if (b) {
			fillCombobox(cboTyp2, map);
			valuePanel.add(lblTyp2);
			valuePanel.add(cboTyp2);
			cboTyp2.setSelectedIndex(-1);
		} else {
			valuePanel.remove(lblTyp2);
			valuePanel.remove(cboTyp2);
			valuePanel.remove(thirdLevelPanel);
		}
	}

	private void showThirdLevel(int selection) {
		thirdLevelPanel.clear();
		lblThirdLevel.setText(TextConstantsForLists.SEARCH_CRITERIA.get(selection + 1));
		thirdLevelPanel.add(lblThirdLevel);

		switch (selection) {
		case 0:
			thirdLevelPanel.add(txtThirdLevel);
			thirdLevelPanel.add(buttonPanel);
			break;
		case 1:
			cboThirdLevel.clear();
			for (Project t : projects) {
				cboThirdLevel.addItem(t.getName());
			}
			thirdLevelPanel.add(cboThirdLevel);
			cboThirdLevel.setSelectedIndex(-1);
			break;
		case 2:
			lblThirdLevel.setText("Projekt");
			lblThirdLevel2.setText(TextConstantsForLists.SEARCH_CRITERIA.get(3));
			showReleaseSelection();
			break;
		case 3:
			thirdLevelPanel.add(txtThirdLevel);
			thirdLevelPanel.add(buttonPanel);
			break;
		case 4:
			thirdLevelPanel.add(txtThirdLevel);
			thirdLevelPanel.add(buttonPanel);
			break;
		case 5:
			thirdLevelPanel.add(txtThirdLevel);
			thirdLevelPanel.add(buttonPanel);
			break;
		case 6:
			lblThirdLevel.setText(TextConstantsForLists.SEARCH_CRITERIA.get(selection + 1) + " von");
			thirdLevelPanel.add(txtThirdLevel);

			lblThirdLevel2.setText(TextConstantsForLists.SEARCH_CRITERIA.get(selection + 1) + " bis");
			thirdLevelPanel.add(lblThirdLevel2);
			thirdLevelPanel.add(txtThirdLevel2);
			break;
		case 7:
			fillCombobox(cboThirdLevel, TextConstantsForLists.SEARCH_PBI_STATE);
			thirdLevelPanel.add(cboThirdLevel);
			break;
		case 8:
			cboThirdLevel.clear();
			for (IPerson t : persons) {
				cboThirdLevel.addItem(t.toString());
			}
			thirdLevelPanel.add(cboThirdLevel);
			cboThirdLevel.setSelectedIndex(-1);
			break;
		case 9:
			thirdLevelPanel.add(txtThirdLevel);
			thirdLevelPanel.add(buttonPanel);
			break;
		case 10:
			cboThirdLevel.clear();
			for (RelationType t : relationtypes) {
				cboThirdLevel.addItem(t.getDescription());
			}
			thirdLevelPanel.add(cboThirdLevel);
			cboThirdLevel.setSelectedIndex(-1);
			break;
		case 11:
			thirdLevelPanel.add(txtThirdLevel);
			thirdLevelPanel.add(buttonPanel);
			break;
		case 12:
			thirdLevelPanel.add(txtThirdLevel);
			thirdLevelPanel.add(buttonPanel);
			break;
		case 13:
			cboThirdLevel.clear();
			for (System t : systems) {
				cboThirdLevel.addItem(t.getName());
			}
			thirdLevelPanel.add(cboThirdLevel);
			cboThirdLevel.setSelectedIndex(-1);
			thirdLevelPanel.add(buttonPanel);
			break;
		case 14:
			lblThirdLevel.setText("Version befindet sich im Projekt");
			lblThirdLevel2.setText("Version");
			showReleaseSelection();
			break;
		default:
			break;
		}
	}

	private void showReleaseSelection() {
		cboThirdLevel.clear();
		thirdLevelPanel.add(lblThirdLevel);

		final ListBox cboProjects = new ListBox();

		for (Project t : projects) {
			cboProjects.addItem(t.getName());
		}
		thirdLevelPanel.add(cboProjects);
		cboProjects.setSelectedIndex(-1);
		cboProjects.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				Iterator<Project> it = projects.iterator();
				Project project = null;
				for (int i = 0; i <= cboProjects.getSelectedIndex(); i++) {
					project = it.next();
				}

				cboThirdLevel.clear();
				for (IRelease t : project.getReleasePlan()) {
					cboThirdLevel.addItem(t.getVersion());
				}
				thirdLevelPanel.add(lblThirdLevel2);
				thirdLevelPanel.add(cboThirdLevel);
				cboThirdLevel.setSelectedIndex(-1);
			}
		});
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
		return this.addSearchCriterion;
	}

	@Override
	public IEvent<CreateLogicalOperatorArgs> getAddLogicalOperator() {
		return this.addLogicalOperator;
	}

	@Override
	public void setSearch(Search search) {
		this.search = search;
		updateTree();
	}

	@Override
	public void updateTree() {
		cellTree = new CellTree(new SearchSelectionTreeViewModel(selectionModel, search), null);
		scrollPanelSearch.setWidget(cellTree);
		cellTree.setSize("500px", "400px");
		cellTree.setVisible(true);
	}

	@Override
	public void setProjects(Collection<Project> projects) {
		this.projects = projects;
	}

	@Override
	public void setSystems(Collection<System> systems) {
		this.systems = systems;
	}

	@Override
	public void setPersons(Collection<IPerson> persons) {
		this.persons = persons;
	}

	@Override
	public void setRelationTypes(Collection<RelationType> relationtypes) {
		this.relationtypes = relationtypes;
	}
}
