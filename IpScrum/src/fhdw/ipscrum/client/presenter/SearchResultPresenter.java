package fhdw.ipscrum.client.presenter;

import java.util.Collection;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.ShowTicketEventArgs;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.SearchResultView;
import fhdw.ipscrum.client.view.interfaces.ISearchResultView;
import fhdw.ipscrum.shared.exceptions.NoPBISelectedException;
import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.visitor.IProductBacklogItemVisitor;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.observer.Observer;

public class SearchResultPresenter extends Presenter<ISearchResultView>
		implements Observer {

	private Collection<ProductBacklogItem> resultList;

	public SearchResultPresenter(Collection<ProductBacklogItem> resultList,
			Panel parent, Presenter<?> parentPresenter) {
		super(parent, parentPresenter);
		setResultList(resultList);
	}

	public void setResultList(Collection<ProductBacklogItem> resultList) {

		if (this.resultList != null) {
			for (ProductBacklogItem oldItem : this.resultList) {
				oldItem.deleteObserver(this);
			}
		}

		this.resultList = resultList;
		for (ProductBacklogItem item : resultList) {
			item.addObserver(this);
		}
		updateView();

	}

	public SearchResultPresenter(Collection<ProductBacklogItem> resultList,
			Presenter<?> parentPresenter) {
		super(parentPresenter);
		setResultList(resultList);
	}

	@Override
	protected ISearchResultView createView() {
		ISearchResultView view = new SearchResultView();
		registerEvents(view);
		return view;
	}

	private void registerEvents(final ISearchResultView view) {
		view.registerShowTicket(new EventHandler<ShowTicketEventArgs>() {

			@Override
			public void onUpdate(Object sender, ShowTicketEventArgs eventArgs) {
				ProductBacklogItem item = eventArgs.getTicket();
				class EditPresenterChooser implements
						IProductBacklogItemVisitor {

					EditPBIPresenter presenter;

					@Override
					public void handleFeature(Feature feature) {
						try {
							presenter = new EditFeaturePresenter(feature,
									SearchResultPresenter.this);
						} catch (NoPBISelectedException e) {
							GwtUtils.displayError(e);
						}
					}

					@Override
					public void handleBug(Bug bug) {
						try {
							presenter = new EditBugPresenter(bug,
									SearchResultPresenter.this);

						} catch (NoPBISelectedException e) {
							GwtUtils.displayError(e);
						}

					}
				}
				class CloseHandler implements EventHandler<EventArgs> {

					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						view.hideDetails();
					}
				}

				EditPresenterChooser chooser = new EditPresenterChooser();
				item.accept(chooser);

				view.displayDetails(chooser.presenter.getView());

				CloseHandler handler = new CloseHandler();
				chooser.presenter.getAborted().add(handler);
				chooser.presenter.getFinished().add(handler);
			}

		});
	}

	@Override
	public void update(Observable observable, Object argument) {
		updateView();
	}

	private void updateView() {
		getView().setSearchResult(resultList);
	}
}
