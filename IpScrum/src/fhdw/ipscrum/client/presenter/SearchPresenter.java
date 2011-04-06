package fhdw.ipscrum.client.presenter;

import java.util.ArrayList;
import java.util.Collection;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.CreateLogicalOperatorArgs;
import fhdw.ipscrum.client.events.args.SearchEventArgs;
import fhdw.ipscrum.client.events.args.TextSearchCriterionArgs;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.SearchView;
import fhdw.ipscrum.client.view.interfaces.ISearchView;
import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.search.And;
import fhdw.ipscrum.shared.model.search.ISearchTypeVisitor;
import fhdw.ipscrum.shared.model.search.MultiLogicSearchOperator;
import fhdw.ipscrum.shared.model.search.NoSearchExpression;
import fhdw.ipscrum.shared.model.search.Not;
import fhdw.ipscrum.shared.model.search.Or;
import fhdw.ipscrum.shared.model.search.Search;
import fhdw.ipscrum.shared.model.search.SearchCriteria;
import fhdw.ipscrum.shared.model.search.SearchExpression;
import fhdw.ipscrum.shared.model.search.SingleLogicSearchOperator;
import fhdw.ipscrum.shared.model.search.criteria.PBIAcceptanceCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIDescriptionCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIHintsCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBINameCriterion;
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
		this.getView().setSystems(this.getSessionManager().getModel().getSysManager().getSystems().getSystems());
		this.getView().setRelationTypes(this.getSessionManager().getModel().getRelationTypeManager().getRelationTypes());
		Collection<IPerson> persons = new ArrayList<IPerson>();
		for (IPerson person : this.getSessionManager().getModel().getPersons()) {
			persons.add(person);
		}
		this.getView().setPersons(persons);
	}

	/**
	 * Method createView.
	 * 
	 * @return ISearchView
	 */
	@Override
	protected ISearchView createView() {
		ISearchView view = new SearchView();
		return view;
	}

	/**
	 * this is called to set up the behaviour of all interaction widgets of this view.
	 */
	private void setupEventHandlers() {

		this.getView().getAddLogicalOperator().add(new EventHandler<CreateLogicalOperatorArgs>() {
			@Override
			public void onUpdate(Object sender, CreateLogicalOperatorArgs eventArgs) {
				SearchPresenter.this.createLogicalOperator(eventArgs);
			}
		});

		this.getView().getChangeSearchName().add(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				SearchPresenter.this.getView().updateTree();
			}
		});
		this.getView().getSave().add(new EventHandler<SearchEventArgs>() {
			@Override
			public void onUpdate(Object sender, SearchEventArgs eventArgs) {

				if (SearchPresenter.this.saveSearch(eventArgs.getSearch())) {
					SearchPresenter.this.backToSearchesAll();
				} else {
					GwtUtils.displayError(ExceptionConstants.SEARCH_DOUBLE_DEFINITION_ERROR);
				}
			}
		});
		this.getView().getAborted().add(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				SearchPresenter.this.backToSearchesAll();
			}
		});
		this.getView().getDoSearch().add(new EventHandler<SearchEventArgs>() {
			@Override
			public void onUpdate(Object sender, SearchEventArgs eventArgs) {
				SearchPresenter.this.showSearch(eventArgs.getSearch());
			}
		});

		this.getView().getAddTextSearchCriterion().add(new EventHandler<TextSearchCriterionArgs>() {
			@Override
			public void onUpdate(Object sender, TextSearchCriterionArgs eventArgs) {
				SearchPresenter.this.createTextSearchCriteria(eventArgs);
			}
		});
	}

	protected void showSearch(Search search) {
		if (this.getParent() != null) {
			SearchResultPresenter resultPresenter = new SearchResultPresenter(this.getSessionManager().getModel().getSearchManager()
					.search(this.getSessionManager().getModel().getAllTickets(), search.getExpression()), null, this);
			this.getView().updateResults(resultPresenter.getView());
		}
	}

	private void createLogicalOperator(CreateLogicalOperatorArgs eventargs) {
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

		addSearchExpression(eventargs.getSearchExpression(), newSearchExp);
	}

	private void createTextSearchCriteria(TextSearchCriterionArgs eventargs) {
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
			addSearchExpression(eventargs.getSearchExpression(), newSearchExp);
		}
	}

	private void addSearchExpression(SearchExpression oldSearchExp, final SearchExpression newSearchExp) {
		ISearchTypeVisitor seVisitor = new ISearchTypeVisitor() {
			@Override
			public void handleSingleLogicSearchOperator(SingleLogicSearchOperator singleLogicSearchOperator) {
				singleLogicSearchOperator.setArg(newSearchExp);
			}

			@Override
			public void handleSearchCriteria(SearchCriteria searchCriteria) {
				GwtUtils.displayError(ExceptionConstants.SEARCH_NOT_UPDATEABLE);
			}

			@Override
			public void handleNoSearchExpression(NoSearchExpression noSearchExpression) {
				GwtUtils.displayError(ExceptionConstants.SEARCH_NOT_UPDATEABLE);
			}

			@Override
			public void handleMultiLogicSearchOperator(MultiLogicSearchOperator multiLogicSearchOperator) {
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

	private boolean saveSearch(Search search) {
		if (this.getSessionManager().getModel().getSearchManager().getSearching().contains(search)) {
			return false;
		} else {
			this.getSessionManager().getModel().getSearchManager().addSearch(search);
			return true;
		}
	}
}
