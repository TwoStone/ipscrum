package fhdw.ipscrum.client.presenter;

import java.util.Collection;
import java.util.Collections;

import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.DoScruumleSearchEventArgs;
import fhdw.ipscrum.client.events.args.DoSearchEventArgs;
import fhdw.ipscrum.client.view.SearchAllView;
import fhdw.ipscrum.client.view.interfaces.ISearchAllView;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.Search;
import fhdw.ipscrum.shared.model.search.SearchCriteria;
import fhdw.ipscrum.shared.model.search.SearchExpression;
import fhdw.ipscrum.shared.model.search.criteria.ScruumleCriterion;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.observer.Observer;

public class SearchAllPresenter extends Presenter<ISearchAllView> implements
		Observer {
	private final SearchResultPresenter resultPresenter;
	private final Collection<Search> savedSearches;
	private final String lastSearchString;
	private final Collection<ProductBacklogItem> lastFoundItems;

	public SearchAllPresenter(Presenter<?> parentPresenter) {
		super(parentPresenter);
		savedSearches = getSessionManager().getModel().getSearchManager()
				.getSearching();
		lastSearchString = "";
		lastFoundItems = Collections.emptyList();
		resultPresenter = new SearchResultPresenter(lastFoundItems, this);

		updateView();
	}

	@Override
	protected ISearchAllView createView() {
		ISearchAllView view = new SearchAllView();
		registerEvents(view);
		return view;
	}

	private void registerEvents(ISearchAllView view) {
		view.registerDoScruumleSearch(new EventHandler<DoScruumleSearchEventArgs>() {

			@Override
			public void onUpdate(Object sender,
					DoScruumleSearchEventArgs eventArgs) {
				doScruumleSearch(eventArgs.getSearchExpression());
			}
		});

		view.registerDoSavedSearch(new EventHandler<DoSearchEventArgs>() {

			@Override
			public void onUpdate(Object sender, DoSearchEventArgs eventArgs) {
				doSavedSearch(eventArgs.getSearch());
			}
		});
	}

	private void doSavedSearch(Search search) {
		doSearch(getSessionManager().getModel().getAllTickets(),
				search.getExpression());
	}

	private void doScruumleSearch(String searchExpression) {
		Collection<ProductBacklogItem> searchItems;
		if (!lastSearchString.isEmpty()
				&& searchExpression.startsWith(lastSearchString)) {
			searchItems = lastFoundItems;
		} else {
			searchItems = getSessionManager().getModel().getAllTickets();
		}
		SearchCriteria criterion = new ScruumleCriterion(searchExpression);
		doSearch(searchItems, criterion);
	}

	private void doSearch(Collection<ProductBacklogItem> searchItems,
			SearchExpression searchExpression) {
		Collection<ProductBacklogItem> results = getSessionManager().getModel()
				.getSearchManager().search(searchItems, searchExpression);

		resultPresenter.setResultList(results);
		getView().displaySearchResults(resultPresenter.getView());
	}

	private void updateView() {
		getView().setSavedSeaches(savedSearches);
	}

	@Override
	public void update(Observable observable, Object argument) {

	}

}
