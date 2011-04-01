package fhdw.ipscrum.client.presenter;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.DoScruumleSearchEventArgs;
import fhdw.ipscrum.client.events.args.SearchEventArgs;
import fhdw.ipscrum.client.view.SearchAllView;
import fhdw.ipscrum.client.view.interfaces.ISearchAllView;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.Search;
import fhdw.ipscrum.shared.model.search.SearchCriteria;
import fhdw.ipscrum.shared.model.search.SearchExpression;
import fhdw.ipscrum.shared.model.search.SearchManager;
import fhdw.ipscrum.shared.model.search.criteria.ScruumleCriterion;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.observer.Observer;

public class SearchAllPresenter extends Presenter<ISearchAllView> implements
		Observer {
	private final SearchResultPresenter resultPresenter;
	private final Collection<Search> savedSearches;
	private final SearchManager searchManager;

	public SearchAllPresenter(Panel panel, Presenter<?> parentPresenter) {
		super(panel, parentPresenter);
		this.searchManager = this.getSessionManager().getModel()
				.getSearchManager();
		this.searchManager.addObserver(this);
		this.savedSearches = this.searchManager.getSearching();

		final List<ProductBacklogItem> lastFoundItems = Collections.emptyList();
		this.resultPresenter = new SearchResultPresenter(lastFoundItems, null,
				this);
		this.updateView();
	}

	@Override
	protected ISearchAllView createView() {
		final ISearchAllView view = new SearchAllView();
		this.registerEvents(view);
		return view;
	}

	private void registerEvents(ISearchAllView view) {
		view.registerDoScruumleSearch(new EventHandler<DoScruumleSearchEventArgs>() {

			@Override
			public void onUpdate(Object sender,
					DoScruumleSearchEventArgs eventArgs) {
				SearchAllPresenter.this.doScruumleSearch(eventArgs
						.getSearchExpression());
			}
		});

		view.registerDoSavedSearch(new EventHandler<SearchEventArgs>() {

			@Override
			public void onUpdate(Object sender, SearchEventArgs eventArgs) {
				SearchAllPresenter.this.doSavedSearch(eventArgs.getSearch());
			}
		});

		view.registerDoDeleteSearch(new EventHandler<SearchEventArgs>() {

			@Override
			public void onUpdate(Object sender, SearchEventArgs eventArgs) {
				SearchAllPresenter.this.deleteSearch(eventArgs.getSearch());
			}
		});

		view.registerDoEditSearch(new EventHandler<SearchEventArgs>() {

			@Override
			public void onUpdate(Object sender, SearchEventArgs eventArgs) {
				SearchAllPresenter.this.editSearch(eventArgs.getSearch());
			}
		});
		view.registerDetailedSearch(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				SearchAllPresenter.this.switchToDetailedSearch();
			}
		});
	}

	private void switchToDetailedSearch() {

		if (this.getParent() != null) {
			this.getParent().clear();
			new SearchPresenter(this.getParent(), this.getParentPresenter());
			this.finish();
		}
	}

	private void editSearch(Search search) {
		// TODO [WICHTIG] Suche irgendwie bearbeiten
	}

	private void deleteSearch(Search search) {
		this.getSessionManager().getModel().getSearchManager()
				.removeSearch(search);
	}

	private void doSavedSearch(Search search) {
		this.doSearch(this.getSessionManager().getModel().getAllTickets(),
				search.getExpression());
	}

	private void doScruumleSearch(String searchExpression) {
		final Collection<ProductBacklogItem> searchItems = this
				.getSessionManager().getModel().getAllTickets();
		final SearchCriteria criterion = new ScruumleCriterion(searchExpression);
		this.doSearch(searchItems, criterion);
	}

	private void doSearch(Collection<ProductBacklogItem> searchItems,
			SearchExpression searchExpression) {
		final Collection<ProductBacklogItem> results = this.searchManager
				.search(searchItems, searchExpression);

		this.resultPresenter.setResultList(results);
		this.getView().displaySearchResults(this.resultPresenter.getView());
	}

	private void updateView() {
		this.getView().setSavedSeaches(this.savedSearches);
	}

	@Override
	public void update(Observable observable, Object argument) {
		this.updateView();
	}

}
