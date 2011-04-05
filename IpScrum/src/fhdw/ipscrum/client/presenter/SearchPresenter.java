package fhdw.ipscrum.client.presenter;

import java.util.ArrayList;
import java.util.Collection;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.CreateLogicalOperatorArgs;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.SearchView;
import fhdw.ipscrum.client.view.interfaces.ISearchView;
import fhdw.ipscrum.shared.constants.ExceptionConstants;
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
		this.setupEventHandlers();
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
		this.getView().setSearch(new Search("test", new And()));
		this.getView().setProjects(this.getSessionManager().getModel().getProjects());
		this.getView().setSystems(this.getSessionManager().getModel().getSysManager().getSystems().getSystems());
		this.getView().setRelationTypes(this.getSessionManager().getModel().getRelationTypeManager().getRelationTypes());
		Collection<IPerson> persons = new ArrayList<IPerson>();
		for (IPerson person : this.getSessionManager().getModel().getPersons()) {
			persons.add(person);
		}
		this.getView().setPersons(persons);

		this.getView().getAddLogicalOperator().add(new EventHandler<CreateLogicalOperatorArgs>() {

			@Override
			public void onUpdate(Object sender, CreateLogicalOperatorArgs eventArgs) {
				SearchPresenter.this.createLogicalOperator(eventArgs);
			}
		});
	}

	private void createLogicalOperator(CreateLogicalOperatorArgs eventargs) {
		final SearchExpression searchExp;
		if (eventargs.getValue() == 1) {
			searchExp = new And();
		} else if (eventargs.getValue() == 2) {
			searchExp = new Or();
		} else if (eventargs.getValue() == 3) {
			searchExp = new Not();
		} else {
			searchExp = null;
		}

		ISearchTypeVisitor seVisitor = new ISearchTypeVisitor() {
			@Override
			public void handleSingleLogicSearchOperator(SingleLogicSearchOperator singleLogicSearchOperator) {
				singleLogicSearchOperator.setArg(searchExp);
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
				multiLogicSearchOperator.add(searchExp);
			}
		};
		eventargs.getSearchExpression().accept(seVisitor);
		this.getView().updateTree();
	}
}
