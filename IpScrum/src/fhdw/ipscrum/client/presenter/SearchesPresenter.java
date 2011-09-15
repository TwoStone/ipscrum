package fhdw.ipscrum.client.presenter;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.eventargs.SearchEventArgs;
import fhdw.ipscrum.client.viewinterfaces.ISearchesView;
import fhdw.ipscrum.shared.commands.search.SearchDeleteCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;

/**
 * This class represents the presenter which controls the view to show saved searches.
 */
public class SearchesPresenter extends WritePresenter {

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private ISearchesView view;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.TeamCreatePresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is
	 *            needed to get the model and other related classes.
	 */
	public SearchesPresenter(final ClientContext context) {
		super(context);

		this.beginTransaction();

	}

	@Override
	public String getName() {
		return "Gespeicherte Suchen";
	}

	@Override
	public ISearchesView getView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createSearchesView();
		}

		this.view.registerDoSavedSearch(new EventHandler<SearchEventArgs>() {

			@Override
			public void onUpdate(final Object sender, final SearchEventArgs eventArgs) {

				final SearchResultPresenter presenter =
						new SearchResultPresenter(SearchesPresenter.this.getContext(),
								SearchesPresenter.this
										.getContext()
										.getModel()
										.getSearchManager()
										.search(SearchesPresenter.this.getContext()
												.getModel().getAllTickets(),
												eventArgs.getSearch().getExpression()));
				SearchesPresenter.this.startPresenter(presenter);
			}
		});

		this.view.registerDoDeleteSearch(new EventHandler<SearchEventArgs>() {

			@Override
			public void onUpdate(final Object sender, final SearchEventArgs eventArgs) {

				try {
					SearchesPresenter.this.doCommand(new SearchDeleteCommand(eventArgs
							.getSearch()));
					SearchesPresenter.this.commitTransaction();
					SearchesPresenter.this.updateView();
				} catch (final IPScrumGeneralException e) {
					SearchesPresenter.this.getContext().getToastMessageController()
							.toastMessage(e.getMessage());
				}

				SearchesPresenter.this.updateView();
			}
		});

		return this.view;
	}

	@Override
	public void updateView() {
		this.getView().setSavedSeaches(this.getContext().getModel().getSearching());

	}

	@Override
	public void onModelUpdate() {

	}

}
