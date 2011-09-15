package fhdw.ipscrum.client.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.cellview.client.TreeNode;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.IEvent;
import fhdw.ipscrum.client.eventargs.CreateLogicalOperatorArgs;
import fhdw.ipscrum.client.eventargs.DeleteEventArgs;
import fhdw.ipscrum.client.eventargs.EffortSearchCriterionArgs;
import fhdw.ipscrum.client.eventargs.LastEditorSearchCriterionArgs;
import fhdw.ipscrum.client.eventargs.PBITypSearchCriterionArgs;
import fhdw.ipscrum.client.eventargs.ProjectSearchCriterionEventArgs;
import fhdw.ipscrum.client.eventargs.RelationTypeSearchCriterionArgs;
import fhdw.ipscrum.client.eventargs.ReleaseSearchCriterionArgs;
import fhdw.ipscrum.client.eventargs.SearchEventArgs;
import fhdw.ipscrum.client.eventargs.StatusSearchCriterionArgs;
import fhdw.ipscrum.client.eventargs.SystemSearchCriterionArgs;
import fhdw.ipscrum.client.eventargs.TextSearchCriterionArgs;
import fhdw.ipscrum.client.viewinterfaces.ISearchView;
import fhdw.ipscrum.shared.constants.TextConstantsForLists;
import fhdw.ipscrum.shared.model.metamodel.search.ISearchExpression;
import fhdw.ipscrum.shared.model.metamodel.search.ISearchTypeVisitor;
import fhdw.ipscrum.shared.model.metamodel.search.MultiLogicSearchOperator;
import fhdw.ipscrum.shared.model.metamodel.search.Search;
import fhdw.ipscrum.shared.model.metamodel.search.SearchCriteria;
import fhdw.ipscrum.shared.model.metamodel.search.SingleLogicSearchOperator;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.RelationType;
import fhdw.ipscrum.shared.model.nonMeta.Release;
import fhdw.ipscrum.shared.model.nonMeta.System;

/**
 * represents the search view.
 */
@SuppressWarnings("deprecation")
public class SearchView extends Composite implements ISearchView {
	private final Event<PBITypSearchCriterionArgs> addPbiTypSearchCriterion =
			new Event<PBITypSearchCriterionArgs>();
	private final Event<ProjectSearchCriterionEventArgs> addProjektSearchCriterion =
			new Event<ProjectSearchCriterionEventArgs>();
	private final Event<ReleaseSearchCriterionArgs> addReleaseSearchCriterion =
			new Event<ReleaseSearchCriterionArgs>();
	private final Event<EffortSearchCriterionArgs> addAufwandSearchCriterion =
			new Event<EffortSearchCriterionArgs>();
	private final Event<StatusSearchCriterionArgs> addStatusSearchCriterion =
			new Event<StatusSearchCriterionArgs>();
	private final Event<LastEditorSearchCriterionArgs> addLetzterBearbeiterSearchCriterion =
			new Event<LastEditorSearchCriterionArgs>();
	private final Event<RelationTypeSearchCriterionArgs> addBeziehungTypSearchCriterion =
			new Event<RelationTypeSearchCriterionArgs>();
	private final Event<TextSearchCriterionArgs> addBeziehungZielSearchCriterion =
			new Event<TextSearchCriterionArgs>();
	private final Event<SystemSearchCriterionArgs> addSystemSearchCriterion =
			new Event<SystemSearchCriterionArgs>();
	private final Event<ReleaseSearchCriterionArgs> addVersionSearchCriterion =
			new Event<ReleaseSearchCriterionArgs>();
	private final Event<TextSearchCriterionArgs> addTextSearchCriterion =
			new Event<TextSearchCriterionArgs>();
	private final Event<EventArgs> changeSearchName = new Event<EventArgs>();
	private final Event<CreateLogicalOperatorArgs> addLogicalOperator =
			new Event<CreateLogicalOperatorArgs>();
	private final Event<EventArgs> abort = new Event<EventArgs>();
	private final Event<SearchEventArgs> doSearch = new Event<SearchEventArgs>();
	private final Event<SearchEventArgs> save = new Event<SearchEventArgs>();
	private final Event<DeleteEventArgs> deleteEvent = new Event<DeleteEventArgs>();

	private final SingleSelectionModel<ISearchExpression> selectionModel;
	private final SingleSelectionModel<Search> searchSelectionModel;
	private List<Project> projects;
	private List<ProductBacklogItem> pbis;
	private List<System> systems;
	private List<Person> persons;
	private List<RelationType> relationtypes;
	private CellTree cellTree;
	private final VerticalPanel mainPanel;
	private final ScrollPanel scrollPanelSearch;
	private final VerticalPanel valuePanel;
	private final VerticalPanel thirdLevelPanel;
	private final ListBox cboTyp1;
	private final ListBox cboTyp2;
	private ListBox cboThirdPreselection;
	private final Label lblTyp1;
	private final Label lblTyp2;
	private final Label lblThirdLevel;
	private final Label lblThirdLevel2;
	private final Label lblAddText;
	private final ListBox cboThirdLevel;
	private final TextBox txtThirdLevel;
	private final IntegerBox intBoxFrom;
	private final IntegerBox intBoxTo;
	private final Label lblSearchName;
	private final TextBox txtSearchName;
	private Search search;
	private final Button btnSpeichern;
	private final Button btnAusfuehren;
	private final Button btnAbbrechen;
	private final Button btnHinzu;
	private final VerticalPanel verticalPanel;
	private final HorizontalPanel buttonPanel;
	private final HorizontalPanel horizontalPanel_1;
	private final Button btnLschen;
	private HandlerRegistration deleteRegistration;

	/**
	 * constructor of the SearchView.
	 */
	public SearchView() {
		this.lblAddText = new Label("Hinzufügen:");
		this.mainPanel = new VerticalPanel();
		this.initWidget(this.mainPanel);
		this.mainPanel.setSize("990px", "380px");
		this.mainPanel.setSpacing(5);
		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		this.mainPanel.add(horizontalPanel);
		this.buttonPanel = new HorizontalPanel();

		this.verticalPanel = new VerticalPanel();
		horizontalPanel.add(this.verticalPanel);
		this.verticalPanel.setSize("600px", "330px");
		this.scrollPanelSearch = new ScrollPanel();
		this.verticalPanel.add(this.scrollPanelSearch);

		this.horizontalPanel_1 = new HorizontalPanel();
		this.verticalPanel.add(this.horizontalPanel_1);
		this.verticalPanel.setCellHorizontalAlignment(this.horizontalPanel_1,
				HasHorizontalAlignment.ALIGN_RIGHT);
		this.horizontalPanel_1.setWidth("");

		this.btnLschen = new Button("Löschen");
		this.btnLschen.setEnabled(false);
		this.horizontalPanel_1.add(this.btnLschen);
		this.verticalPanel.add(this.buttonPanel);

		this.btnSpeichern = new Button("Suche speichern");
		this.btnSpeichern.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				SearchView.this.save.fire(SearchView.this, new SearchEventArgs(
						SearchView.this.search));
			}
		});
		this.buttonPanel.add(this.btnSpeichern);

		this.btnAbbrechen = new Button("Suche verwerfen");
		this.btnAbbrechen.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				SearchView.this.abort.fire(SearchView.this, new EventArgs());
			}
		});
		this.buttonPanel.add(this.btnAbbrechen);

		this.btnAusfuehren = new Button("Suche ausführen");
		this.btnAusfuehren.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				SearchView.this.doSearch.fire(SearchView.this, new SearchEventArgs(
						SearchView.this.search));
			}
		});
		this.buttonPanel.add(this.btnAusfuehren);
		this.scrollPanelSearch.setSize("600px", "300px");

		this.valuePanel = new VerticalPanel();

		this.txtSearchName = new TextBox();
		this.txtSearchName.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(final ChangeEvent event) {
				SearchView.this.search.setName(SearchView.this.txtSearchName.getText());
				SearchView.this.changeSearchName.fire(SearchView.this, new EventArgs());
			}
		});
		horizontalPanel.add(this.valuePanel);
		this.valuePanel.setSpacing(5);

		this.btnHinzu = new Button("Hinzufügen");
		this.btnHinzu.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				if (SearchView.this.cboTyp1.getSelectedIndex() == 0) {
					SearchView.this.addLogicalOperator.fire(
							SearchView.this,
							new CreateLogicalOperatorArgs(SearchView.this.cboTyp2
									.getSelectedIndex() + 1,
									SearchView.this.selectionModel.getSelectedObject()));
				} else if (SearchView.this.cboTyp1.getSelectedIndex() == 1
						&& !SearchView.this.fireEventForTextSearchCriterion()) {
					final int i = SearchView.this.cboTyp2.getSelectedIndex();
					final ISearchExpression se =
							SearchView.this.selectionModel.getSelectedObject();
					switch (i) {
					case 0:
						SearchView.this.addPbiTypSearchCriterion.fire(
								this,
								new PBITypSearchCriterionArgs(se,
										SearchView.this.cboThirdLevel
												.getSelectedIndex() + 1));
						break;
					case 1:
						SearchView.this.addProjektSearchCriterion.fire(
								this,
								new ProjectSearchCriterionEventArgs(se,
										SearchView.this.projects
												.get(SearchView.this.cboThirdLevel
														.getSelectedIndex())));
						break;
					case 2:
						final Release r =
								SearchView.this.projects
										.get(SearchView.this.cboThirdPreselection
												.getSelectedIndex())
										.getReleasePlan()
										.get(SearchView.this.cboThirdLevel
												.getSelectedIndex());
						SearchView.this.addReleaseSearchCriterion.fire(this,
								new ReleaseSearchCriterionArgs(se, r));
						break;
					case 6:
						SearchView.this.addAufwandSearchCriterion.fire(this,
								new EffortSearchCriterionArgs(se,
										SearchView.this.intBoxFrom.getValue(),
										SearchView.this.intBoxTo.getValue()));
						break;
					case 7:
						SearchView.this.addStatusSearchCriterion.fire(
								this,
								new StatusSearchCriterionArgs(se,
										SearchView.this.cboThirdLevel
												.getSelectedIndex() + 1));
						break;
					case 8:
						SearchView.this.addLetzterBearbeiterSearchCriterion.fire(
								this,
								new LastEditorSearchCriterionArgs(se,
										SearchView.this.persons
												.get(SearchView.this.cboThirdLevel
														.getSelectedIndex())));
						break;
					case 10:
						if (SearchView.this.cboThirdPreselection.getSelectedIndex() == 0) {
							SearchView.this.addBeziehungTypSearchCriterion.fire(
									this,
									new RelationTypeSearchCriterionArgs(se,
											SearchView.this.relationtypes
													.get(SearchView.this.cboThirdLevel
															.getSelectedIndex())));
						}
						break;
					case 13:
						SearchView.this.addSystemSearchCriterion.fire(
								this,
								new SystemSearchCriterionArgs(se,
										SearchView.this.systems
												.get(SearchView.this.cboThirdLevel
														.getSelectedIndex())));
						break;
					case 14:
						final Release v =
								SearchView.this.projects
										.get(SearchView.this.cboThirdPreselection
												.getSelectedIndex())
										.getReleasePlan()
										.get(SearchView.this.cboThirdLevel
												.getSelectedIndex());
						SearchView.this.addVersionSearchCriterion.fire(this,
								new ReleaseSearchCriterionArgs(se, v));
						break;
					default:
						break;
					}
				}
			}
		});

		this.thirdLevelPanel = new VerticalPanel();
		this.thirdLevelPanel.setSize("490", "200");

		this.lblTyp1 = new Label();
		this.lblTyp1.setText("Typ des Suchausdrucks");

		this.lblSearchName = new Label();
		this.lblSearchName.setText("Name der Suche");

		this.cboTyp1 = new ListBox();
		this.fillCombobox(this.cboTyp1, TextConstantsForLists.SEARCH_TYPES);
		this.cboTyp1.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(final ChangeEvent event) {
				if (SearchView.this.cboTyp1.getSelectedIndex() == 0) {
					SearchView.this.showCboTyp2(true,
							TextConstantsForLists.SEARCH_LOGICALS);
					SearchView.this.lblTyp2.setText(TextConstantsForLists.SEARCH_TYPES
							.get(1));
					SearchView.this.valuePanel.remove(SearchView.this.thirdLevelPanel);
				} else if (SearchView.this.cboTyp1.getSelectedIndex() == 1) {
					SearchView.this.showCboTyp2(true,
							TextConstantsForLists.SEARCH_CRITERIA);
					SearchView.this.lblTyp2.setText(TextConstantsForLists.SEARCH_TYPES
							.get(2));
					SearchView.this.valuePanel.remove(SearchView.this.thirdLevelPanel);
				} else {
					SearchView.this.showCboTyp2(false, null);
					SearchView.this.lblTyp2.setText(TextConstantsForLists.SEARCH_TYPES
							.get(2));
				}
			}
		});

		this.lblTyp2 = new Label();
		this.cboTyp2 = new ListBox();
		this.cboTyp2.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(final ChangeEvent event) {
				if (SearchView.this.cboTyp1.getSelectedIndex() == 0) {
					SearchView.this.thirdLevelPanel.clear();
					SearchView.this.valuePanel.add(SearchView.this.thirdLevelPanel);
					SearchView.this.thirdLevelPanel.add(SearchView.this.btnHinzu);
				} else if (SearchView.this.cboTyp1.getSelectedIndex() == 1) {
					SearchView.this.valuePanel.add(SearchView.this.thirdLevelPanel);
					SearchView.this.showThirdLevel(SearchView.this.cboTyp2
							.getSelectedIndex());
				}
			}

		});

		this.lblThirdLevel = new Label();
		this.lblThirdLevel2 = new Label();
		this.cboThirdLevel = new ListBox();
		this.txtThirdLevel = new TextBox();
		this.intBoxFrom = new IntegerBox();
		this.intBoxFrom.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(final ChangeEvent event) {
				SearchView.this.checkAufwand();
			}
		});
		this.intBoxTo = new IntegerBox();
		this.intBoxTo.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(final ChangeEvent event) {
				SearchView.this.checkAufwand();
			}
		});
		this.cboThirdLevel.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(final ChangeEvent event) {
				SearchView.this.thirdLevelPanel.add(SearchView.this.btnHinzu);
			}
		});

		this.searchSelectionModel = new SingleSelectionModel<Search>();
		this.searchSelectionModel
				.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
					@Override
					public void onSelectionChange(final SelectionChangeEvent event) {
						if (SearchView.this.searchSelectionModel.getSelectedObject() != null) {
							SearchView.this.selectionModel.setSelected(
									SearchView.this.selectionModel.getSelectedObject(),
									false);
							SearchView.this.valuePanel
									.add(SearchView.this.lblSearchName);
							SearchView.this.txtSearchName
									.setText(SearchView.this.search.getName());
							SearchView.this.valuePanel
									.add(SearchView.this.txtSearchName);
						} else {
							SearchView.this.valuePanel
									.remove(SearchView.this.lblSearchName);
							SearchView.this.valuePanel
									.remove(SearchView.this.txtSearchName);
						}
					}
				});

		this.selectionModel = new SingleSelectionModel<ISearchExpression>();
		this.selectionModel
				.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
					@Override
					public void onSelectionChange(final SelectionChangeEvent event) {
						SearchView.this.disableDeleteButton();

						final ISearchExpression se =
								SearchView.this.selectionModel.getSelectedObject();
						if (se != null) {
							SearchView.this.searchSelectionModel.setSelected(
									SearchView.this.searchSelectionModel
											.getSelectedObject(), false);
							SearchView.this.enableDeleteButton(se);

							final ISearchTypeVisitor searchTypeVisitor =
									new ISearchTypeVisitor() {

										@Override
										public
												void
												handleMultiLogicSearchOperator(
														final MultiLogicSearchOperator multiLogicSearchOperator) {
											SearchView.this.enableAdd();
										}

										@Override
										public void handleSearchCriteria(
												final SearchCriteria searchCriteria) {
											SearchView.this.disableAdd();
										}

										@Override
										public
												void
												handleSingleLogicSearchOperator(
														final SingleLogicSearchOperator singleLogicSearchOperator) {
											SearchView.this.enableAdd();
										}

									};
							se.accept(searchTypeVisitor);
						} else {
							SearchView.this.disableAdd();
						}

					}
				});
	}

	private void checkAufwand() {
		if (this.intBoxFrom.getValue() != null && this.intBoxFrom.getValue() > 0
				|| this.intBoxTo.getValue() != null && this.intBoxTo.getValue() > 0) {
			this.thirdLevelPanel.add(this.btnHinzu);
		} else {
			this.thirdLevelPanel.remove(this.btnHinzu);
		}
	}

	private boolean fireEventForTextSearchCriterion() {
		switch (this.cboTyp2.getSelectedIndex()) {
		case 3:
			this.addTextSearchCriterion.fire(this,
					new TextSearchCriterionArgs(this.txtThirdLevel.getText(),
							SearchView.this.selectionModel.getSelectedObject(),
							this.cboTyp2.getSelectedIndex() + 1));
			break;
		case 4:
			this.addTextSearchCriterion.fire(this,
					new TextSearchCriterionArgs(this.txtThirdLevel.getText(),
							SearchView.this.selectionModel.getSelectedObject(),
							this.cboTyp2.getSelectedIndex() + 1));
			break;
		case 5:
			this.addTextSearchCriterion.fire(this,
					new TextSearchCriterionArgs(this.txtThirdLevel.getText(),
							SearchView.this.selectionModel.getSelectedObject(),
							this.cboTyp2.getSelectedIndex() + 1));
			break;
		case 9:
			this.addTextSearchCriterion.fire(this,
					new TextSearchCriterionArgs(this.txtThirdLevel.getText(),
							SearchView.this.selectionModel.getSelectedObject(),
							this.cboTyp2.getSelectedIndex() + 1));
			break;
		case 10:
			if (this.cboThirdPreselection.getSelectedIndex() == 1) {
				this.addTextSearchCriterion.fire(this,
						new TextSearchCriterionArgs(this.txtThirdLevel.getText(),
								SearchView.this.selectionModel.getSelectedObject(),
								this.cboTyp2.getSelectedIndex() + 1));
			} else {
				return false;
			}
			break;
		case 11:
			this.addTextSearchCriterion.fire(this,
					new TextSearchCriterionArgs(this.txtThirdLevel.getText(),
							SearchView.this.selectionModel.getSelectedObject(),
							this.cboTyp2.getSelectedIndex() + 1));
			break;
		case 12:
			this.addTextSearchCriterion.fire(this,
					new TextSearchCriterionArgs(this.txtThirdLevel.getText(),
							SearchView.this.selectionModel.getSelectedObject(),
							this.cboTyp2.getSelectedIndex() + 1));
			break;
		default:
			return false;
		}
		return true;
	}

	private void fillCombobox(final ListBox cbo, final Map<Integer, String> map) {
		cbo.clear();
		for (int i = 1; i <= map.size(); i++) {
			cbo.addItem(map.get(i));
		}
	}

	private void showCboTyp1(final boolean b) {
		if (b) {
			this.valuePanel.add(this.lblAddText);
			this.valuePanel.add(this.lblTyp1);
			this.valuePanel.add(this.cboTyp1);
			this.cboTyp1.setSelectedIndex(-1);
		} else {
			this.valuePanel.remove(this.lblAddText);
			this.valuePanel.remove(this.lblTyp1);
			this.valuePanel.remove(this.cboTyp1);
		}
	}

	private void showCboTyp2(final boolean b, final Map<Integer, String> map) {
		if (b) {
			this.fillCombobox(this.cboTyp2, map);
			this.valuePanel.add(this.lblTyp2);
			this.valuePanel.add(this.cboTyp2);
			this.cboTyp2.setSelectedIndex(-1);
		} else {
			this.valuePanel.remove(this.lblTyp2);
			this.valuePanel.remove(this.cboTyp2);
			this.valuePanel.remove(this.thirdLevelPanel);
		}
	}

	private void showThirdLevel(final int selection) {
		this.thirdLevelPanel.clear();
		this.lblThirdLevel.setText(TextConstantsForLists.SEARCH_CRITERIA
				.get(selection + 1));
		this.thirdLevelPanel.add(this.lblThirdLevel);

		switch (selection) {
		case 0:
			this.fillCombobox(this.cboThirdLevel, TextConstantsForLists.SEARCH_PBI_TYPE);
			this.thirdLevelPanel.add(this.cboThirdLevel);
			this.cboThirdLevel.setSelectedIndex(-1);
			break;
		case 1:
			this.cboThirdLevel.clear();
			for (final Project t : this.projects) {
				this.cboThirdLevel.addItem(t.getName());
			}
			this.thirdLevelPanel.add(this.cboThirdLevel);
			this.cboThirdLevel.setSelectedIndex(-1);
			break;
		case 2:
			this.lblThirdLevel.setText("Projekt");
			this.lblThirdLevel2.setText(TextConstantsForLists.SEARCH_CRITERIA.get(3));
			this.showReleaseSelection();
			break;
		case 3:
			this.txtThirdLevel.setText("");
			this.thirdLevelPanel.add(this.txtThirdLevel);
			this.thirdLevelPanel.add(this.btnHinzu);
			break;
		case 4:
			this.txtThirdLevel.setText("");
			this.thirdLevelPanel.add(this.txtThirdLevel);
			this.thirdLevelPanel.add(this.btnHinzu);
			break;
		case 5:
			this.txtThirdLevel.setText("");
			this.thirdLevelPanel.add(this.txtThirdLevel);
			this.thirdLevelPanel.add(this.btnHinzu);
			break;
		case 6:
			this.lblThirdLevel.setText(TextConstantsForLists.SEARCH_CRITERIA
					.get(selection + 1) + " von");
			this.intBoxFrom.setValue(null);
			this.intBoxTo.setValue(null);
			this.thirdLevelPanel.add(this.intBoxFrom);
			this.lblThirdLevel2.setText(TextConstantsForLists.SEARCH_CRITERIA
					.get(selection + 1) + " bis");
			this.thirdLevelPanel.add(this.lblThirdLevel2);
			this.thirdLevelPanel.add(this.intBoxTo);
			break;
		case 7:
			this.fillCombobox(this.cboThirdLevel,
					TextConstantsForLists.SEARCH_PBI_STATE);
			this.thirdLevelPanel.add(this.cboThirdLevel);
			this.cboThirdLevel.setSelectedIndex(-1);
			break;
		case 8:
			this.cboThirdLevel.clear();
			for (final Person t : this.persons) {
				this.cboThirdLevel.addItem(t.toString());
			}
			this.thirdLevelPanel.add(this.cboThirdLevel);
			this.cboThirdLevel.setSelectedIndex(-1);
			break;
		case 9:
			this.txtThirdLevel.setText("");
			this.thirdLevelPanel.add(this.txtThirdLevel);
			this.thirdLevelPanel.add(this.btnHinzu);
			break;
		case 10:
			this.lblThirdLevel.setText("Art des Beziehungskriteriums");
			this.cboThirdLevel.clear();
			this.thirdLevelPanel.add(this.lblThirdLevel);
			this.cboThirdPreselection = new ListBox();
			this.fillCombobox(this.cboThirdPreselection,
					TextConstantsForLists.SEARCH_RELATIONSEARCHTYPE);
			this.thirdLevelPanel.add(this.cboThirdPreselection);
			this.cboThirdPreselection.setSelectedIndex(-1);
			this.cboThirdPreselection.addChangeHandler(new ChangeHandler() {
				@Override
				public void onChange(final ChangeEvent event) {
					SearchView.this.thirdLevelPanel.remove(SearchView.this.btnHinzu);
					SearchView.this.cboThirdLevel.clear();
					SearchView.this.lblThirdLevel2
							.setText(TextConstantsForLists.SEARCH_RELATIONSEARCHTYPE
									.get(SearchView.this.cboThirdPreselection
											.getSelectedIndex() + 1));
					SearchView.this.thirdLevelPanel.add(SearchView.this.lblThirdLevel2);

					if (SearchView.this.cboThirdPreselection.getSelectedIndex() == 0) {
						SearchView.this.thirdLevelPanel
								.remove(SearchView.this.txtThirdLevel);
						for (final RelationType t : SearchView.this.relationtypes) {
							SearchView.this.cboThirdLevel.addItem(t.getDescription());
						}
						SearchView.this.cboThirdLevel.setSelectedIndex(-1);
						SearchView.this.thirdLevelPanel
								.add(SearchView.this.cboThirdLevel);
					} else if (SearchView.this.cboThirdPreselection.getSelectedIndex() == 1) {
						SearchView.this.txtThirdLevel.setText("");
						SearchView.this.thirdLevelPanel
								.remove(SearchView.this.cboThirdLevel);
						SearchView.this.thirdLevelPanel
								.add(SearchView.this.txtThirdLevel);
						SearchView.this.thirdLevelPanel.add(SearchView.this.btnHinzu);
					}
				}
			});
			break;
		case 11:
			this.txtThirdLevel.setText("");
			this.thirdLevelPanel.add(this.txtThirdLevel);
			this.thirdLevelPanel.add(this.btnHinzu);
			break;
		case 12:
			this.txtThirdLevel.setText("");
			this.thirdLevelPanel.add(this.txtThirdLevel);
			this.thirdLevelPanel.add(this.btnHinzu);
			break;
		case 13:
			this.cboThirdLevel.clear();
			for (final System t : this.systems) {
				this.cboThirdLevel.addItem(t.getName());
			}
			this.thirdLevelPanel.add(this.cboThirdLevel);
			this.cboThirdLevel.setSelectedIndex(-1);
			this.thirdLevelPanel.add(this.btnHinzu);
			break;
		case 14:
			this.lblThirdLevel.setText("Version befindet sich im Projekt");
			this.lblThirdLevel2.setText("Version");
			this.showReleaseSelection();
			break;
		default:
			break;
		}
	}

	private void showReleaseSelection() {
		this.cboThirdLevel.clear();
		this.thirdLevelPanel.add(this.lblThirdLevel);

		this.cboThirdPreselection = new ListBox();

		for (final Project t : this.projects) {
			this.cboThirdPreselection.addItem(t.getName());
		}
		this.thirdLevelPanel.add(this.cboThirdPreselection);
		this.cboThirdPreselection.setSelectedIndex(-1);
		this.cboThirdPreselection.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(final ChangeEvent event) {
				final Iterator<Project> it = SearchView.this.projects.iterator();
				Project project = null;
				for (int i = 0; i <= SearchView.this.cboThirdPreselection
						.getSelectedIndex(); i++) {
					project = it.next();
				}

				SearchView.this.cboThirdLevel.clear();
				for (final Release t : project.getReleasePlan()) {
					SearchView.this.cboThirdLevel.addItem(t.getVersion());
				}
				SearchView.this.thirdLevelPanel.add(SearchView.this.lblThirdLevel2);
				SearchView.this.thirdLevelPanel.add(SearchView.this.cboThirdLevel);
				SearchView.this.cboThirdLevel.setSelectedIndex(-1);
			}
		});
	}

	@Override
	public IEvent<SearchEventArgs> getSave() {
		return this.save;
	}

	@Override
	public IEvent<EventArgs> getAbort() {
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
	public void setSearch(final Search search) {
		this.search = search;

		this.updateTree();
	}

	@Override
	public void updateTree() {
		this.valuePanel.clear();
		this.cellTree =
				new CellTree(new SearchExpressionTreeViewModel(
						this.searchSelectionModel, this.selectionModel, this.search),
						null);
		this.scrollPanelSearch.setWidget(this.cellTree);
		this.cellTree.setSize("600px", "300px");
		this.cellTree.setVisible(true);
		this.openTree(this.cellTree.getRootTreeNode());

	}

	private void openTree(final TreeNode node) {
		if (node != null) {
			for (int i = 0; i < node.getChildCount(); i++) {
				this.openTree(node.setChildOpen(i, true));
			}
		}

	}

	@Override
	public void setProjects(final List<Project> projects) {
		this.projects = projects;
		this.pbis = new ArrayList<ProductBacklogItem>();
		for (final Project t : projects) {
			if (t.getBacklog() != null && t.getBacklog().getItems() != null) {
				this.pbis.addAll(t.getBacklog().getItems());
			}
		}
	}

	@Override
	public void setSystems(final List<System> systems) {
		this.systems = systems;
	}

	@Override
	public void setPersons(final List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public void setRelationTypes(final List<RelationType> newRelationtypes) {
		this.relationtypes = newRelationtypes;
	}

	@Override
	public IEvent<EventArgs> getChangeSearchName() {
		return this.changeSearchName;
	}

	@Override
	public IEvent<SearchEventArgs> getDoSearch() {
		return this.doSearch;
	}

	@Override
	public IEvent<PBITypSearchCriterionArgs> getAddPbiTypeSearchCriterion() {
		return this.addPbiTypSearchCriterion;
	}

	@Override
	public IEvent<ProjectSearchCriterionEventArgs> getAddProjectSearchCriterion() {
		return this.addProjektSearchCriterion;
	}

	@Override
	public IEvent<ReleaseSearchCriterionArgs> getAddReleaseSearchCriterion() {
		return this.addReleaseSearchCriterion;
	}

	@Override
	public IEvent<EffortSearchCriterionArgs> getAddEffortSearchCriterion() {
		return this.addAufwandSearchCriterion;
	}

	@Override
	public IEvent<StatusSearchCriterionArgs> getAddStateSearchCriterion() {
		return this.addStatusSearchCriterion;
	}

	@Override
	public IEvent<LastEditorSearchCriterionArgs> getAddLastEditorSearchCriterion() {
		return this.addLetzterBearbeiterSearchCriterion;
	}

	@Override
	public IEvent<RelationTypeSearchCriterionArgs> getAddRelationTypeSearchCriterion() {
		return this.addBeziehungTypSearchCriterion;
	}

	@Override
	public IEvent<SystemSearchCriterionArgs> getAddSystemSearchCriterion() {
		return this.addSystemSearchCriterion;
	}

	@Override
	public IEvent<ReleaseSearchCriterionArgs> getAddVersionSearchCriterion() {
		return this.addVersionSearchCriterion;
	}

	@Override
	public IEvent<TextSearchCriterionArgs> getAddRelationDestSearchCriterion() {
		return this.addBeziehungZielSearchCriterion;
	}

	private void disableDeleteButton() {
		if (SearchView.this.deleteRegistration != null) {
			SearchView.this.deleteRegistration.removeHandler();
			this.deleteRegistration = null;
		}
		this.btnLschen.setEnabled(false);
	}

	private void enableDeleteButton(final ISearchExpression se) {
		final DeleteEventArgs deleteEventArgs = new DeleteEventArgs(se);
		SearchView.this.deleteRegistration =
				SearchView.this.btnLschen.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(final ClickEvent event) {
						SearchView.this.deleteEvent.fire(SearchView.this,
								deleteEventArgs);
					}
				});
		this.btnLschen.setEnabled(true);
	}

	private void enableAdd() {
		SearchView.this.showCboTyp1(true);
		SearchView.this.showCboTyp2(false, null);
	}

	private void disableAdd() {
		SearchView.this.showCboTyp1(false);
		SearchView.this.showCboTyp2(false, null);
	}

	@Override
	public IEvent<DeleteEventArgs> getDeleteEventArgs() {
		return this.deleteEvent;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerSaveHandler(final EventHandler<SearchEventArgs> handler) {
		this.save.add(handler);

	}

	@Override
	public void registerDoSearchHandler(final EventHandler<SearchEventArgs> handler) {

		this.doSearch.add(handler);
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide

	}
}
