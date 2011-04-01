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
import fhdw.ipscrum.shared.model.search.SearchCriteria;
import fhdw.ipscrum.shared.model.search.SearchExpression;
import fhdw.ipscrum.shared.model.search.SearchManager;
import fhdw.ipscrum.shared.model.search.criteria.ScruumleCriterion;

public class SearchAllPresenter extends Presenter<ISearchAllView> {
	private final SearchResultPresenter resultPresenter;
	private final SearchesPresenter searchesPresenter;
	private final SearchManager manager;

	public SearchAllPresenter(Panel panel, Presenter<?> parentPresenter) {
		super(panel, parentPresenter);

		this.manager = this.getSessionManager().getModel().getSearchManager();

		final List<ProductBacklogItem> lastFoundItems = Collections.emptyList();
		this.resultPresenter = new SearchResultPresenter(lastFoundItems, null,
				this);
		this.searchesPresenter = new SearchesPresenter(this.getView()
				.getDisplayPanel(), this);

		this.searchesPresenter
				.registerDoSearch(new EventHandler<SearchEventArgs>() {

					@Override
					public void onUpdate(Object sender,
							SearchEventArgs eventArgs) {
						SearchAllPresenter.this.doSearch(eventArgs.getSearch()
								.getExpression());

					}
				});
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

		view.registerDetailedSearch(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				SearchAllPresenter.this.switchToDetailedSearch();
			}
		});

		view.registerShowSearches(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				SearchAllPresenter.this.showSearches();

			}
		});
	}

	private void showSearches() {
		this.getView().getDisplayPanel().clear();
		this.getView().getDisplayPanel().add(this.searchesPresenter.getView());
	}

	private void switchToDetailedSearch() {

		if (this.getParent() != null) {
			this.getParent().clear();
			new SearchPresenter(this.getParent(), this.getParentPresenter());
			this.finish();
		}
	}

	private void doScruumleSearch(String searchExpression) {
		final SearchCriteria criterion = new ScruumleCriterion(searchExpression);
		this.doSearch(criterion);
	}

	private void doSearch(SearchExpression searchExpression) {
		final Collection<ProductBacklogItem> results = this.manager.search(this
				.getSessionManager().getModel().getAllTickets(),
				searchExpression);

		this.getView().getDisplayPanel().clear();
		this.resultPresenter.setResultList(results);
		this.getView().getDisplayPanel().add(this.resultPresenter.getView());
	}

}
