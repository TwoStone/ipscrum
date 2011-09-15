package fhdw.ipscrum.client.architecture.controller;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.RootPanel;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.ClientContext.ModelUpdateEvent;
import fhdw.ipscrum.client.architecture.ClientContext.ModelUpdateHandler;
import fhdw.ipscrum.client.architecture.controller.ApplicationController.PresenterChangedEvent;
import fhdw.ipscrum.client.architecture.controller.ApplicationController.PresenterChangedHandler;
import fhdw.ipscrum.client.architecture.presenter.Presenter;
import fhdw.ipscrum.client.architecture.widgets.IBreadcrumbView;
import fhdw.ipscrum.client.architecture.widgets.IBreadcrumbView.BreadcrumbItem;
import fhdw.ipscrum.client.utils.SimpleCallback;

/**
 * Controls the breadcrumbview.
 */
public class BreadcrumbController extends ClientController {

	/**
	 * The view element.
	 */
	private IBreadcrumbView breadcrumbView;

	/**
	 * Handles events when the model has changed.
	 */
	private final ModelUpdateHandler modelChangend = new ModelUpdateHandler() {

		@Override
		public void handleModelUpdated(final ModelUpdateEvent event) {
			BreadcrumbController.this.updateBreadcrumb();
		}

	};

	/**
	 * Handles events when the presenter in the content panel is changed.
	 */
	private final PresenterChangedHandler presenterChanged =
			new PresenterChangedHandler() {

				@Override
				public void handlePresenterChanged(final PresenterChangedEvent event) {
					BreadcrumbController.this.updateBreadcrumb();
				}
			};

	/**
	 * Creates a new instance for the specified client context.
	 * 
	 * @param context
	 *            The current context
	 */
	public BreadcrumbController(final ClientContext context) {
		super(context);
		this.getContext().getEventBus()
				.registerHandler(PresenterChangedEvent.class, this.presenterChanged);
		this.getContext().getEventBus()
				.registerHandler(ModelUpdateEvent.class, this.modelChangend);
		RootPanel.get("breadcrumb").add(this.getBreadcrumb());
	}

	/**
	 * Updates the breadcrumb view with the actual presenter stack.
	 */
	private void updateBreadcrumb() {
		final List<BreadcrumbItem> breadcrumbItems =
				new ArrayList<IBreadcrumbView.BreadcrumbItem>();
		for (final Presenter presenter : this.getContext().getApplicationController()
				.getPresenterStack()) {
			final SimpleCallback callback = new SimpleCallback() {

				@Override
				public void callback() {
					BreadcrumbController.this.gotoPresenter(presenter);
				}
			};

			final BreadcrumbItem item =
					new BreadcrumbItem(callback, presenter.getName());
			breadcrumbItems.add(item);
		}
		this.getBreadcrumb().setContent(breadcrumbItems);
	}

	/**
	 * Try to jump to the controller in the current presenter stack.
	 * 
	 * @param presenter
	 *            the presenter that should be shown.
	 */
	private void gotoPresenter(final Presenter presenter) {
		this.getContext().getApplicationController().gotoPresenter(presenter);
	}

	/**
	 * Returns the view element.
	 * 
	 * @return the breadcrumbview
	 */
	private IBreadcrumbView getBreadcrumb() {
		if (this.breadcrumbView == null) {
			this.breadcrumbView =
					this.getContext().getViewFactory().createBreadcrumbView();
		}
		return this.breadcrumbView;
	}

}
