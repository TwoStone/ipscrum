package fhdw.ipscrum.client.presenter;

import java.util.List;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.presenter.ReadPresenter;
import fhdw.ipscrum.client.viewinterfaces.ISearchResultView;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * This class represents the presenter which controls the view to show search results.
 */
public class SearchResultPresenter extends ReadPresenter {

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private ISearchResultView view;

	/**
	 * represents the list of tickets which are the results of the search.
	 */
	private final List<Ticket> result;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.SearchResultPresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is
	 *            needed to get the model and other related classes.
	 * @param result
	 *            are all existing Tickets
	 */
	public SearchResultPresenter(final ClientContext context, final List<Ticket> result) {
		super(context);

		this.result = result;
	}

	@Override
	public String getName() {
		return "Suchergebnisse";
	}

	@Override
	public ISearchResultView doGetView() {

		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createSearchResultView();

			this.view.registerDetailHandler(new EventHandler<TypedEventArg<Ticket>>() {

				@Override
				public void onUpdate(final Object sender,
						final TypedEventArg<Ticket> eventArgs) {
					SearchResultPresenter.this
							.startPresenter(new GenericTicketPresenter(eventArgs
									.getObject(), SearchResultPresenter.this
									.getContext()));

				}
			});

		}

		return this.view;
	}

	@Override
	public void updateView() {
		this.doGetView().setSearchResult(this.result);

	}

	@Override
	public void onModelUpdate() {
		// TODO Auto-generated method stub

	}

}
