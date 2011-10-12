package fhdw.ipscrum.client.presenter;

import java.util.List;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.presenter.ReadPresenter;
import fhdw.ipscrum.client.eventargs.DoScruumleSearchEventArgs;
import fhdw.ipscrum.client.viewinterfaces.ISearchAllView;
import fhdw.ipscrum.shared.model.metamodel.search.SearchManager;
import fhdw.ipscrum.shared.model.metamodel.search.criteria.ScruumleCriterion;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * This class represents the presenter which controls the view to do the scruumle search.
 */
public class SearchAllPresenter extends ReadPresenter {

	/**
	 * represents the search manager to save searches in.
	 */
	private final SearchManager searchManager;

	/**
	 * represents the list of tickets which are the results of the search.
	 */
	private List<Ticket> result;

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private ISearchAllView view;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.SearchAllPresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is needed to get the model and
	 *            other related classes.
	 */
	public SearchAllPresenter(final ClientContext context) {
		super(context);

		this.searchManager = context.getModel().getSearchManager();

	}

	@Override
	public String getName() {
		return "Scruumle";
	}

	@Override
	public ISearchAllView doGetView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createSearchAllView();
		}

		this.addHandler();

		return this.view;
	}

	/**
	 * this method is neeeded to do the scruuumle search.
	 */
	private void addHandler() {

		// handler für das ausführen der scruumle suche
		this.view.registerDoScruumleSearch(new EventHandler<DoScruumleSearchEventArgs>() {

			@Override
			public void onUpdate(final Object sender, final DoScruumleSearchEventArgs eventArgs) {
				SearchAllPresenter.this.result =
						SearchAllPresenter.this.searchManager.search(SearchAllPresenter.this.getContext().getModel()
								.getAllTickets(), new ScruumleCriterion(
								SearchAllPresenter.this.getContext().getModel(), eventArgs.getSearchExpression()));
				SearchAllPresenter.this.showResults();
			}

		});

	}

	/**
	 * this method opens the function to show search results. The search results are shown in the {@link}
	 * fhdw.ipscrum.client.presenter.SearchResultPresenter .
	 */
	private void showResults() {
		final SearchResultPresenter presenter = new SearchResultPresenter(this.getContext(), this.result);
		this.startPresenter(presenter);
	}

	@Override
	public void updateView() {

	}

	@Override
	public void onModelUpdate() {
		// TODO Auto-generated method stub

	}

}
