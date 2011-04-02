package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SearchEventArgs;
import fhdw.ipscrum.client.view.SearchesView;
import fhdw.ipscrum.client.view.interfaces.ISearchesView;
import fhdw.ipscrum.shared.model.search.Search;
import fhdw.ipscrum.shared.model.search.SearchManager;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.observer.Observer;

public class SearchesPresenter extends Presenter<ISearchesView> implements
		Observer {

	private final Event<SearchEventArgs> doSearch;
	private final SearchManager manager;

	public SearchesPresenter(Panel parent, Presenter<?> parentPresenter) {
		super(parent, parentPresenter);
		this.doSearch = new Event<SearchEventArgs>();
		this.manager = this.getSessionManager().getModel().getSearchManager();
		this.manager.addObserver(this);

		this.updateView();
	}

	@Override
	protected ISearchesView createView() {
		final ISearchesView view = new SearchesView();
		this.registerEvents(view);
		return view;
	}

	private void registerEvents(ISearchesView view) {
		view.registerDoSavedSearch(new EventHandler<SearchEventArgs>() {

			@Override
			public void onUpdate(Object sender, SearchEventArgs eventArgs) {
				SearchesPresenter.this.doSavedSearch(eventArgs);
			}
		});

		view.registerDoDeleteSearch(new EventHandler<SearchEventArgs>() {

			@Override
			public void onUpdate(Object sender, SearchEventArgs eventArgs) {
				SearchesPresenter.this.deleteSearch(eventArgs.getSearch());
			}
		});

	}

	private void deleteSearch(final Search search) {
		this.getSessionManager().getModel().getSearchManager()
				.removeSearch(search);
	}

	private void doSavedSearch(final SearchEventArgs search) {
		this.doSearch.fire(this, search);
	}

	@Override
	public void update(Observable observable, Object argument) {
		this.updateView();
	}

	private void updateView() {
		this.getView().setSavedSeaches(this.manager.getSearching());
	}

	public void registerDoSearch(EventHandler<SearchEventArgs> handler) {
		this.doSearch.add(handler);
	}
}
