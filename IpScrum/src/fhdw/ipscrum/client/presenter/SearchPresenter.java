package fhdw.ipscrum.client.presenter;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.CreateLogicalOperatorArgs;
import fhdw.ipscrum.client.events.args.EffortSearchCriterionArgs;
import fhdw.ipscrum.client.events.args.LastEditorSearchCriterionArgs;
import fhdw.ipscrum.client.events.args.PBITypSearchCriterionArgs;
import fhdw.ipscrum.client.events.args.ProjectSearchCriterionEventArgs;
import fhdw.ipscrum.client.events.args.RelationTypeSearchCriterionArgs;
import fhdw.ipscrum.client.events.args.ReleaseSearchCriterionArgs;
import fhdw.ipscrum.client.events.args.SearchEventArgs;
import fhdw.ipscrum.client.events.args.StatusSearchCriterionArgs;
import fhdw.ipscrum.client.events.args.SystemSearchCriterionArgs;
import fhdw.ipscrum.client.events.args.TextSearchCriterionArgs;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.SearchView;
import fhdw.ipscrum.client.view.interfaces.ISearchView;
import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.RelationType;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.search.And;
import fhdw.ipscrum.shared.model.search.ISearchExpression;
import fhdw.ipscrum.shared.model.search.ISearchTypeVisitor;
import fhdw.ipscrum.shared.model.search.MultiLogicSearchOperator;
import fhdw.ipscrum.shared.model.search.NoSearchExpression;
import fhdw.ipscrum.shared.model.search.Not;
import fhdw.ipscrum.shared.model.search.Or;
import fhdw.ipscrum.shared.model.search.Search;
import fhdw.ipscrum.shared.model.search.SearchCriteria;
import fhdw.ipscrum.shared.model.search.SearchExpression;
import fhdw.ipscrum.shared.model.search.SingleLogicSearchOperator;
import fhdw.ipscrum.shared.model.search.criteria.BugConcreteVersionCriterion;
import fhdw.ipscrum.shared.model.search.criteria.BugSystemCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIAcceptanceCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIBugTypeCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIClosedCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIComplexityCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIConcreteReleaseCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIDescriptionCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIFeatureTypeCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIHintsCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBILastEditorCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBINameCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIOpenCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIProjectCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIRelationDestCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIRelationTypeCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBISprintDescCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBISprintNameCriterion;

/**
 * presenter class of the team interface. this interface is used to inspect, create and modify teams as well as adding and removing persons to teams.
 */
public class SearchPresenter extends Presenter<ISearchView> {

	/**
	 * Constructor for TeamPresenter.
	 * 
	 * @param parent Panel
	 * @param parentPresenter
	 */
	public SearchPresenter(final Panel parent, final Presenter<?> parentPresenter) {
		super(parent, parentPresenter);
		this.init();
		this.setupEventHandlers();
	}

	private void init() {
		this.getView().setSearch(new Search(TextConstants.NEW_SEARCH, new And()));
		this.getView().setProjects(this.getSessionManager().getModel().getProjects());
		this.getView().setSystems(getAllSystems(this.getSessionManager().getModel().getSysManager().getSystems().getSystems()));
		final List<RelationType> rt = new ArrayList<RelationType>();
		rt.addAll(this.getSessionManager().getModel().getRelationTypeManager().getRelationTypes());
		this.getView().setRelationTypes(rt);
		final List<IPerson> persons = new ArrayList<IPerson>();
		for (final IPerson person : this.getSessionManager().getModel().getPersons()) {
			persons.add(person);
		}
		this.getView().setPersons(persons);
	}

	private List<System> getAllSystems(List<System> sysList) {
		List<System> ret = new ArrayList<System>();
		for (System system : sysList) {
			ret.add(system);
			if (system.getSystems() != null && system.getSystems().size() > 0) {
				ret.addAll(getAllSystems(system.getSystems()));
			}
		}
		return ret;
	}

	/**
	 * Method createView.
	 * 
	 * @return ISearchView
	 */
	@Override
	protected ISearchView createView() {
		final ISearchView view = new SearchView();
		return view;
	}

	/**
	 * this is called to set up the behaviour of all interaction widgets of this view.
	 */
	private void setupEventHandlers() {

		this.getView().getAddLogicalOperator().add(new EventHandler<CreateLogicalOperatorArgs>() {
			@Override
			public void onUpdate(final Object sender, final CreateLogicalOperatorArgs eventArgs) {
				SearchPresenter.this.createLogicalOperator(eventArgs);
			}
		});

		this.getView().getChangeSearchName().add(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				SearchPresenter.this.getView().updateTree();
			}
		});
		this.getView().getSave().add(new EventHandler<SearchEventArgs>() {
			@Override
			public void onUpdate(final Object sender, final SearchEventArgs eventArgs) {

				if (SearchPresenter.this.saveSearch(eventArgs.getSearch())) {
					SearchPresenter.this.backToSearchesAll();
				} else {
					GwtUtils.displayError(ExceptionConstants.SEARCH_DOUBLE_DEFINITION_ERROR);
				}
			}
		});
		this.getView().getAbort().add(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				SearchPresenter.this.backToSearchesAll();
			}
		});
		this.getView().getDoSearch().add(new EventHandler<SearchEventArgs>() {
			@Override
			public void onUpdate(final Object sender, final SearchEventArgs eventArgs) {
				SearchPresenter.this.showSearch(eventArgs.getSearch());
			}
		});

		this.getView().getAddTextSearchCriterion().add(new EventHandler<TextSearchCriterionArgs>() {
			@Override
			public void onUpdate(final Object sender, final TextSearchCriterionArgs eventArgs) {
				SearchPresenter.this.createTextSearchCriteria(eventArgs);
			}
		});

		this.getView().getAddPbiTypeSearchCriterion().add(new EventHandler<PBITypSearchCriterionArgs>() {
			@Override
			public void onUpdate(Object sender, PBITypSearchCriterionArgs eventArgs) {
				if (eventArgs.getValue() == 1) {
					addSearchExpression(eventArgs.getSe(), new PBIFeatureTypeCriterion());
				} else if (eventArgs.getValue() == 2) {
					addSearchExpression(eventArgs.getSe(), new PBIBugTypeCriterion());
				}
			}
		});

		this.getView().getAddProjectSearchCriterion().add(new EventHandler<ProjectSearchCriterionEventArgs>() {
			@Override
			public void onUpdate(Object sender, ProjectSearchCriterionEventArgs eventArgs) {
				addSearchExpression(eventArgs.getSe(), new PBIProjectCriterion(eventArgs.getProject()));
			}
		});

		this.getView().getAddReleaseSearchCriterion().add(new EventHandler<ReleaseSearchCriterionArgs>() {
			@Override
			public void onUpdate(final Object sender, final ReleaseSearchCriterionArgs eventArgs) {
				addSearchExpression(eventArgs.getSe(), new PBIConcreteReleaseCriterion(eventArgs.getRelease()));
			}
		});

		this.getView().getAddEffortSearchCriterion().add(new EventHandler<EffortSearchCriterionArgs>() {
			@Override
			public void onUpdate(Object sender, EffortSearchCriterionArgs eventArgs) {
				try {
					addSearchExpression(eventArgs.getSe(), new PBIComplexityCriterion(eventArgs.getValueFrom(), eventArgs.getValueTo()));
				} catch (NoValidValueException e) {
					GwtUtils.displayError(e);
				}
			}
		});

		this.getView().getAddStateSearchCriterion().add(new EventHandler<StatusSearchCriterionArgs>() {
			@Override
			public void onUpdate(Object sender, StatusSearchCriterionArgs eventArgs) {
				if (eventArgs.getValue() == 1) {
					addSearchExpression(eventArgs.getSearchExpression(), new PBIOpenCriterion());
				} else if (eventArgs.getValue() == 2) {
					addSearchExpression(eventArgs.getSearchExpression(), new PBIClosedCriterion());
				}
			}
		});

		this.getView().getAddLastEditorSearchCriterion().add(new EventHandler<LastEditorSearchCriterionArgs>() {
			@Override
			public void onUpdate(Object sender, LastEditorSearchCriterionArgs eventArgs) {
				addSearchExpression(eventArgs.getSe(), new PBILastEditorCriterion(eventArgs.getPerson()));
			}
		});

		this.getView().getAddRelationTypeSearchCriterion().add(new EventHandler<RelationTypeSearchCriterionArgs>() {
			@Override
			public void onUpdate(Object sender, RelationTypeSearchCriterionArgs eventArgs) {
				addSearchExpression(eventArgs.getSe(), new PBIRelationTypeCriterion(eventArgs.getRelationType()));
			}
		});

		this.getView().getAddRelationDestSearchCriterion().add(new EventHandler<TextSearchCriterionArgs>() {
			@Override
			public void onUpdate(Object sender, TextSearchCriterionArgs eventArgs) {
				addSearchExpression(eventArgs.getSearchExpression(), new PBIRelationDestCriterion(eventArgs.getString()));
			}
		});

		this.getView().getAddSystemSearchCriterion().add(new EventHandler<SystemSearchCriterionArgs>() {
			@Override
			public void onUpdate(final Object sender, final SystemSearchCriterionArgs eventArgs) {
				SearchPresenter.this.addSearchExpression(eventArgs.getSe(), new BugSystemCriterion(eventArgs.getSystem()));
			}
		});

		this.getView().getAddVersionSearchCriterion().add(new EventHandler<ReleaseSearchCriterionArgs>() {
			@Override
			public void onUpdate(final Object sender, final ReleaseSearchCriterionArgs eventArgs) {
				addSearchExpression(eventArgs.getSe(), new BugConcreteVersionCriterion(eventArgs.getRelease()));
			}
		});
	}

	protected void showSearch(final Search search) {
		if (this.getParent() != null) {
			final SearchResultPresenter resultPresenter = new SearchResultPresenter(this.getSessionManager().getModel().getSearchManager()
					.search(this.getSessionManager().getModel().getAllTickets(), search.getExpression()), null, this);
			this.getView().updateResults(resultPresenter.getView());
		}
	}

	private void createLogicalOperator(final CreateLogicalOperatorArgs eventargs) {
		final SearchExpression newSearchExp;
		if (eventargs.getValue() == 1) {
			newSearchExp = new And();
		} else if (eventargs.getValue() == 2) {
			newSearchExp = new Or();
		} else if (eventargs.getValue() == 3) {
			newSearchExp = new Not();
		} else {
			newSearchExp = null;
		}

		this.addSearchExpression(eventargs.getSearchExpression(), newSearchExp);
	}

	private void createTextSearchCriteria(final TextSearchCriterionArgs eventargs) {
		SearchExpression newSearchExp = null;

		switch (eventargs.getValue()) {
		case 4:
			newSearchExp = new PBINameCriterion(eventargs.getString());
			break;
		case 5:
			newSearchExp = new PBISprintDescCriterion(eventargs.getString());
			break;
		case 6:
			newSearchExp = new PBISprintNameCriterion(eventargs.getString());
			break;
		case 10:
			newSearchExp = new PBIDescriptionCriterion(eventargs.getString());
			break;
		case 11:
			newSearchExp = new PBIRelationDestCriterion(eventargs.getString());
			break;
		case 12:
			newSearchExp = new PBIHintsCriterion(eventargs.getString());
			break;
		case 13:
			newSearchExp = new PBIAcceptanceCriterion(eventargs.getString());
			break;
		default:
			GwtUtils.displayError(ExceptionConstants.SEARCH_NOT_POSSIBLE);
			break;
		}
		if (newSearchExp != null) {
			this.addSearchExpression(eventargs.getSearchExpression(), newSearchExp);
		}
	}

	private void addSearchExpression(final ISearchExpression oldSearchExp, final SearchExpression newSearchExp) {
		final ISearchTypeVisitor seVisitor = new ISearchTypeVisitor() {
			@Override
			public void handleSingleLogicSearchOperator(final SingleLogicSearchOperator singleLogicSearchOperator) {
				singleLogicSearchOperator.setArg(newSearchExp);
			}

			@Override
			public void handleSearchCriteria(final SearchCriteria searchCriteria) {
				GwtUtils.displayError(ExceptionConstants.SEARCH_NOT_UPDATEABLE);
			}

			@Override
			public void handleNoSearchExpression(final NoSearchExpression noSearchExpression) {
				GwtUtils.displayError(ExceptionConstants.SEARCH_NOT_UPDATEABLE);
			}

			@Override
			public void handleMultiLogicSearchOperator(final MultiLogicSearchOperator multiLogicSearchOperator) {
				multiLogicSearchOperator.add(newSearchExp);
			}
		};
		oldSearchExp.accept(seVisitor);
		this.getView().updateTree();
	}

	private void backToSearchesAll() {
		if (this.getParent() != null) {
			this.getParent().clear();
			new SearchAllPresenter(this.getParent(), this.getParentPresenter());
			this.finish();
		}
	}

	private boolean saveSearch(final Search search) {
		if (this.getSessionManager().getModel().getSearchManager().getSearching().contains(search)) {
			return false;
		} else {
			this.getSessionManager().getModel().getSearchManager().addSearch(search);
			return true;
		}
	}
}
