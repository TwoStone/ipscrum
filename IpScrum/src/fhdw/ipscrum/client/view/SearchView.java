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
import fhdw.ipscrum.client.events.args.EffortSearchCriterionArgs;
import fhdw.ipscrum.client.events.args.LastEditorSearchCriterionArgs;
import fhdw.ipscrum.client.events.args.PBITypSearchCriterionArgs;
import fhdw.ipscrum.client.events.args.ProjectSearchCriterionEventArgs;
import fhdw.ipscrum.client.events.args.RelationSearchCriterionArgs;
import fhdw.ipscrum.client.events.args.ReleaseSearchCriterionArgs;
import fhdw.ipscrum.client.events.args.SearchEventArgs;
import fhdw.ipscrum.client.events.args.StatusSearchCriterionArgs;
import fhdw.ipscrum.client.events.args.SystemSearchCriterionArgs;
import fhdw.ipscrum.client.events.args.TextSearchCriterionArgs;
import fhdw.ipscrum.client.view.interfaces.ISearchResultView;
import fhdw.ipscrum.client.view.interfaces.ISearchView;
import fhdw.ipscrum.shared.constants.TextConstantsForLists;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.RelationType;
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
	private final Event<PBITypSearchCriterionArgs> addPbiTypSearchCriterion = new Event<PBITypSearchCriterionArgs>();
	private final Event<ProjectSearchCriterionEventArgs> addProjektSearchCriterion = new Event<ProjectSearchCriterionEventArgs>();
	private final Event<ReleaseSearchCriterionArgs> addReleaseSearchCriterion = new Event<ReleaseSearchCriterionArgs>();
	private final Event<EffortSearchCriterionArgs> addAufwandSearchCriterion = new Event<EffortSearchCriterionArgs>();
	private final Event<StatusSearchCriterionArgs> addStatusSearchCriterion = new Event<StatusSearchCriterionArgs>();
	private final Event<LastEditorSearchCriterionArgs> addLetzterBearbeiterSearchCriterion = new Event<LastEditorSearchCriterionArgs>();
	private final Event<RelationSearchCriterionArgs> addBeziehungSearchCriterion = new Event<RelationSearchCriterionArgs>();
	private final Event<SystemSearchCriterionArgs> addSystemSearchCriterion = new Event<SystemSearchCriterionArgs>();
	private final Event<ReleaseSearchCriterionArgs> addVersionSearchCriterion = new Event<ReleaseSearchCriterionArgs>();
	private final Event<TextSearchCriterionArgs> addTextSearchCriterion = new Event<TextSearchCriterionArgs>();
	private final Event<EventArgs> changeSearchName = new Event<EventArgs>();
	private final Event<CreateLogicalOperatorArgs> addLogicalOperator = new Event<CreateLogicalOperatorArgs>();
	private final Event<EventArgs> abort = new Event<EventArgs>();
	private final Event<SearchEventArgs> doSearch = new Event<SearchEventArgs>();
	private final Event<SearchEventArgs> save = new Event<SearchEventArgs>();
	private final SingleSelectionModel<SearchExpression> selectionModel;
	private final SingleSelectionModel<Search> searchSelectionModel;
	private Collection<Project> projects;
	private Collection<System> systems;
	private Collection<IPerson> persons;
	private Collection<RelationType> relationtypes;
	private CellTree cellTree;
	private final VerticalPanel mainPanel;
	private final ScrollPanel scrollPanelSearch;
	private final ScrollPanel scrollPanelResult;
	private final VerticalPanel valuePanel;
	private final VerticalPanel thirdLevelPanel;
	private final ListBox cboTyp1;
	private final ListBox cboTyp2;
	private final Label lblTyp1;
	private final Label lblTyp2;
	private final Label lblThirdLevel;
	private final Label lblThirdLevel2;
	private final ListBox cboThirdLevel;
	private final TextBox txtThirdLevel;
	private final TextBox txtThirdLevel2;
	private final Label lblSearchName;
	private final TextBox txtSearchName;
	private Search search;
	private final Button btnSpeichern;
	private final Button btnAusfuehren;
	private final Button btnAbbrechen;
	private final Button btnHinzu;
	private final VerticalPanel verticalPanel;
	private final HorizontalPanel buttonPanel;

	public SearchView() {
		mainPanel = new VerticalPanel();
		initWidget(mainPanel);
		mainPanel.setSpacing(5);
		mainPanel.setSize("1000", "400");
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		horizontalPanel.setSize("", "400");
		mainPanel.add(horizontalPanel);

		scrollPanelResult = new ScrollPanel();
		mainPanel.add(scrollPanelResult);
		buttonPanel = new HorizontalPanel();

		verticalPanel = new VerticalPanel();
		horizontalPanel.add(verticalPanel);
		verticalPanel.setSize("600px", "330px");
		scrollPanelSearch = new ScrollPanel();
		verticalPanel.add(scrollPanelSearch);
		verticalPanel.add(buttonPanel);

		btnSpeichern = new Button("Suche speichern");
		btnSpeichern.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				save.fire(SearchView.this, new SearchEventArgs(search));
			}
		});
		buttonPanel.add(btnSpeichern);

		btnAbbrechen = new Button("Suche verwerfen");
		btnAbbrechen.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				abort.fire(SearchView.this, new EventArgs());
			}
		});
		buttonPanel.add(btnAbbrechen);

		btnAusfuehren = new Button("Suche ausführen");
		btnAusfuehren.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				doSearch.fire(SearchView.this, new SearchEventArgs(search));
			}
		});
		buttonPanel.add(btnAusfuehren);
		scrollPanelSearch.setSize("600px", "300px");
		scrollPanelResult.setSize("980px", "270px");

		valuePanel = new VerticalPanel();

		txtSearchName = new TextBox();
		txtSearchName.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				search.setName(SearchView.this.txtSearchName.getText());
				changeSearchName.fire(SearchView.this, new EventArgs());
			}
		});
		horizontalPanel.add(valuePanel);
		valuePanel.setSpacing(5);

		btnHinzu = new Button("Hinzufügen");
		btnHinzu.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (cboTyp1.getSelectedIndex() == 0) {
					SearchView.this.addLogicalOperator.fire(SearchView.this, new CreateLogicalOperatorArgs(SearchView.this.cboTyp2.getSelectedIndex() + 1,
							((NoSearchExpression) SearchView.this.selectionModel.getSelectedObject()).getParent()));
				} else if (cboTyp1.getSelectedIndex() == 1 && !SearchView.this.fireEventForSearchCriteria()) {
					int i = cboTyp2.getSelectedIndex();
					switch (i) {
					case 0:
						break;
					case 1:
						break;
					case 2:
						break;
					case 6:
						break;
					case 7:
						break;
					case 8:
						break;
					case 10:
						break;
					case 13:
						break;
					case 14:
						break;
					default:
						break;
					}
					// this.put(1, "Typ des PBI");
					// this.put(2, "Projekt");
					// this.put(3, "Release");
					// this.put(7, "Aufwand");
					// this.put(8, "Status");
					// this.put(9, "Letzter Bearbeiter");
					// this.put(11, "Beziehung");
					// this.put(14, "System (nur Bugs)");
					// this.put(15, "Version (nur Bugs)");
				}
			}
		});

		thirdLevelPanel = new VerticalPanel();
		thirdLevelPanel.setSize("490", "200");

		lblTyp1 = new Label();
		lblTyp1.setText("Typ des Suchausdrucks");

		lblSearchName = new Label();
		lblSearchName.setText("Name der Suche");

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
					thirdLevelPanel.add(btnHinzu);
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
				thirdLevelPanel.add(btnHinzu);
			}
		});

		searchSelectionModel = new SingleSelectionModel<Search>();
		this.searchSelectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				if (searchSelectionModel.getSelectedObject() != null) {
					selectionModel.setSelected(selectionModel.getSelectedObject(), false);
					valuePanel.add(lblSearchName);
					txtSearchName.setText(search.getName());
					valuePanel.add(txtSearchName);
				} else {
					valuePanel.remove(lblSearchName);
					valuePanel.remove(txtSearchName);
				}
			}
		});

		this.selectionModel = new SingleSelectionModel<SearchExpression>();
		this.selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				SearchExpression se = selectionModel.getSelectedObject();
				if (se != null) {
					searchSelectionModel.setSelected(searchSelectionModel.getSelectedObject(), false);
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
				} else {
					showCboTyp1(false);
					showCboTyp2(false, null);
				}

			}
		});
	}

	private boolean fireEventForSearchCriteria() {
		switch (cboTyp2.getSelectedIndex()) {
		case 3:
			addTextSearchCriterion.fire(this,
					new TextSearchCriterionArgs(txtThirdLevel.getText(), ((NoSearchExpression) SearchView.this.selectionModel.getSelectedObject()).getParent(), cboTyp2.getSelectedIndex() + 1));
			break;
		case 4:
			addTextSearchCriterion.fire(this,
					new TextSearchCriterionArgs(txtThirdLevel.getText(), ((NoSearchExpression) SearchView.this.selectionModel.getSelectedObject()).getParent(), cboTyp2.getSelectedIndex() + 1));
			break;
		case 5:
			addTextSearchCriterion.fire(this,
					new TextSearchCriterionArgs(txtThirdLevel.getText(), ((NoSearchExpression) SearchView.this.selectionModel.getSelectedObject()).getParent(), cboTyp2.getSelectedIndex() + 1));
			break;
		case 9:
			addTextSearchCriterion.fire(this,
					new TextSearchCriterionArgs(txtThirdLevel.getText(), ((NoSearchExpression) SearchView.this.selectionModel.getSelectedObject()).getParent(), cboTyp2.getSelectedIndex() + 1));
			break;
		case 11:
			addTextSearchCriterion.fire(this,
					new TextSearchCriterionArgs(txtThirdLevel.getText(), ((NoSearchExpression) SearchView.this.selectionModel.getSelectedObject()).getParent(), cboTyp2.getSelectedIndex() + 1));
			break;
		case 12:
			addTextSearchCriterion.fire(this,
					new TextSearchCriterionArgs(txtThirdLevel.getText(), ((NoSearchExpression) SearchView.this.selectionModel.getSelectedObject()).getParent(), cboTyp2.getSelectedIndex() + 1));
			break;
		default:
			return false;
		}
		return true;
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
			fillCombobox(cboThirdLevel, TextConstantsForLists.SEARCH_PBI_TYPE);
			thirdLevelPanel.add(cboThirdLevel);
			cboThirdLevel.setSelectedIndex(-1);
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
			thirdLevelPanel.add(btnHinzu);
			break;
		case 4:
			thirdLevelPanel.add(txtThirdLevel);
			thirdLevelPanel.add(btnHinzu);
			break;
		case 5:
			thirdLevelPanel.add(txtThirdLevel);
			thirdLevelPanel.add(btnHinzu);
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
			thirdLevelPanel.add(btnHinzu);
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
			thirdLevelPanel.add(btnHinzu);
			break;
		case 12:
			thirdLevelPanel.add(txtThirdLevel);
			thirdLevelPanel.add(btnHinzu);
			break;
		case 13:
			cboThirdLevel.clear();
			for (System t : systems) {
				cboThirdLevel.addItem(t.getName());
			}
			thirdLevelPanel.add(cboThirdLevel);
			cboThirdLevel.setSelectedIndex(-1);
			thirdLevelPanel.add(btnHinzu);
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
	public IEvent<SearchEventArgs> getSave() {
		return this.save;
	}

	@Override
	public IEvent<EventArgs> getAborted() {
		return this.abort;
	}

	@Override
	public IEvent<TextSearchCriterionArgs> getAddTextSearchCriterion() {
		return this.addTextSearchCriterion;
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
		cellTree = new CellTree(new SearchExpressionTreeViewModel(searchSelectionModel, selectionModel, search), null);
		scrollPanelSearch.setWidget(cellTree);
		cellTree.setSize("600px", "300px");
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

	@Override
	public IEvent<EventArgs> getChangeSearchName() {
		return changeSearchName;
	}

	@Override
	public IEvent<SearchEventArgs> getDoSearch() {
		return doSearch;
	}

	@Override
	public void updateResults(ISearchResultView resultView) {
		scrollPanelResult.clear();
		scrollPanelResult.add(resultView);
	}
}
