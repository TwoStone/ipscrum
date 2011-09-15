package fhdw.ipscrum.client.presenter;

import java.util.List;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.eventargs.SearchEventArgs;
import fhdw.ipscrum.client.viewinterfaces.ISearchView;
import fhdw.ipscrum.shared.commands.search.SearchCreateCommand;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.metamodel.search.And;
import fhdw.ipscrum.shared.model.metamodel.search.Search;
import fhdw.ipscrum.shared.model.metamodel.search.SearchExpression;
import fhdw.ipscrum.shared.model.metamodel.search.SearchManager;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * This class represents the presenter which controls the view to make and save searches.
 */
public class SearchPresenter extends WritePresenter {

	/**
	 * represents the search manager to save searches in.
	 */
	private final SearchManager searchManager;
	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private ISearchView view;
	/**
	 * represents the search related to the presenter.
	 */
	private Search search;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.TeamCreatePresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is
	 *            needed to get the model and other related classes.
	 */
	public SearchPresenter(final ClientContext context) {
		super(context);
		this.searchManager = context.getModel().getSearchManager();
	}

	@Override
	public String getName() {
		return "Detailsuche";
	}

	@Override
	public ISearchView getView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createSearchView();
			this.view.setSearch(new Search(this.getContext().getModel(),
					TextConstants.NEW_SEARCH, new And(this.getContext().getModel())));

			this.view.registerSaveHandler(new EventHandler<SearchEventArgs>() {

				@Override
				public void onUpdate(final Object sender,
						final SearchEventArgs eventArgs) {
					SearchPresenter.this.search = eventArgs.getSearch();
					SearchPresenter.this.save();

				}
			});

			this.view.registerDoSearchHandler(new EventHandler<SearchEventArgs>() {

				@Override
				public void onUpdate(final Object sender,
						final SearchEventArgs eventArgs) {

					final List<Ticket> result =
							SearchPresenter.this.searchManager.search(
									SearchPresenter.this.getContext().getModel()
											.getAllTickets(), eventArgs.getSearch()
											.getExpression());

					final SearchResultPresenter presenter =
							new SearchResultPresenter(
									SearchPresenter.this.getContext(), result);

					SearchPresenter.this.startPresenter(presenter);

				}
			});

		}
		return this.view;
	}

	@Override
	public void updateView() {
	}

	@Override
	public void onModelUpdate() {
	}

	@Override
	public Boolean onSave() {

		try {
			this.beginTransaction();
			this.doCommand(new SearchCreateCommand(this.search.getName(),
					(SearchExpression) this.search.getExpression()));
			this.commitTransaction();
			SearchPresenter.this.getContext().getToastMessageController()
					.toastMessage("Suche gespeichert!");
			return super.onSave();
		} catch (final IPScrumGeneralException e) {
			this.getContext().getToastMessageController().toastMessage(e.getMessage());
			return false;
		}

	}

}
