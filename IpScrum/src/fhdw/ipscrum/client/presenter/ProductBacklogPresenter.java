package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.PBIArgs;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.ProductBacklogView;
import fhdw.ipscrum.client.view.interfaces.IProductBacklogView;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.NoFeatureSelectedException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Project;

/**
 * Presenter for {@link ProductBacklog}
 * 
 * @author Phase II / Gruppe I
 */
public class ProductBacklogPresenter extends Presenter<IProductBacklogView> {

	private final Project project;

	/**
	 * Creates a new instance of {@link ProductBacklogPresenter}
	 * 
	 * @param parent
	 * @param project
	 */
	public ProductBacklogPresenter(final Panel parent, final Project project) {
		super(parent);
		this.project = project;
		this.initialize();
	}

	@Override
	protected IProductBacklogView createView() {

		// Creates a new instance of a ProductBacklogView
		final IProductBacklogView view = new ProductBacklogView();

		// Add a handler for a event which creates a new ProductBacklogItem
		view.addNewPBIEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {

				final DialogBox newBox = GwtUtils
						.createDialog(TextConstants.CREATE_FEATURE);
				final CreateFeaturePresenter presenter;
				try {
					presenter = new CreateFeaturePresenter(newBox,
							ProductBacklogPresenter.this.project.getBacklog());

					presenter.getFinished().add(new EventHandler<EventArgs>() {

						@Override
						public void onUpdate(final Object sender,
								final EventArgs eventArgs) {
							try {
								ProductBacklogPresenter.this.project
										.getBacklog().addItem(
												presenter.getFeature());
							} catch (final ConsistencyException e) {
								GwtUtils.displayError(e.getMessage());
							}
							view.refreshProductBacklog(ProductBacklogPresenter.this.project
									.getBacklog().getItems());
							newBox.hide();
						}

					});

					presenter.getAborted().add(new EventHandler<EventArgs>() {

						@Override
						public void onUpdate(final Object sender,
								final EventArgs eventArgs) {
							newBox.hide();
						}
					});

					newBox.center();
				} catch (final NoFeatureSelectedException e1) {
					GwtUtils.displayError(e1.getMessage());
				}
			}
		});

		// Add a handler for a event which opens the details of a
		// ProductBacklogItem
		view.addPBIDetailsEventHandler(new EventHandler<PBIArgs>() {

			@Override
			public void onUpdate(final Object sender, final PBIArgs eventArgs) {
				final DialogBox newBox = GwtUtils
						.createDialog(TextConstants.FEATURE_DETAILS);
				// TODO !!!! WENN ES NEBEN FEATURES NOCH BUGS GIBT, MUSS erst
				// der Typ SICHERGESTELLT WERDEN
				EditFeaturePresenter presenter;
				try {
					presenter = new EditFeaturePresenter(newBox,
							(Feature) eventArgs.getPbi());

					presenter.getFinished().add(new EventHandler<EventArgs>() {

						@Override
						public void onUpdate(final Object sender,
								final EventArgs eventArgs) {
							view.refreshProductBacklog(ProductBacklogPresenter.this.project
									.getBacklog().getItems());
							newBox.hide();
						}

					});

					presenter.getAborted().add(new EventHandler<EventArgs>() {

						@Override
						public void onUpdate(final Object sender,
								final EventArgs eventArgs) {
							newBox.hide();
						}
					});

					newBox.center();
				} catch (final NoFeatureSelectedException e) {
					GwtUtils.displayError(e.getMessage());
				}
			}
		});

		// Add a handler for a event which deletes a ProductBacklogItem
		view.addDeletePBIEventHandler(new EventHandler<PBIArgs>() {

			@Override
			public void onUpdate(final Object sender, final PBIArgs eventArgs) {
				if (eventArgs.getPbi() != null) {
					try {
						ProductBacklogPresenter.this.project.getBacklog()
								.removeItem(eventArgs.getPbi());
						view.refreshProductBacklog(ProductBacklogPresenter.this.project
								.getBacklog().getItems());
					} catch (final UserException e) {
						GwtUtils.displayError(e.getMessage());
					}
				}
			}

		});

		// Add a handler for a event which moves a ProductBacklog down by one
		// step
		view.addPBIDownEventHandler(new EventHandler<PBIArgs>() {

			@Override
			public void onUpdate(final Object sender, final PBIArgs eventArgs) {
				final ProductBacklogItem pbi = eventArgs.getPbi();
				if (pbi != null) {
					ProductBacklogPresenter.this.project.getBacklog().moveDown(
							pbi);
					view.refreshProductBacklog(ProductBacklogPresenter.this.project
							.getBacklog().getItems());
				}
			}
		});

		// Add a handler for a event which moves a ProductBacklog up by one step
		view.addPBIUpEventHandler(new EventHandler<PBIArgs>() {

			@Override
			public void onUpdate(final Object sender, final PBIArgs eventArgs) {
				final ProductBacklogItem pbi = eventArgs.getPbi();
				if (pbi != null) {
					ProductBacklogPresenter.this.project.getBacklog().moveUp(
							pbi);
					view.refreshProductBacklog(ProductBacklogPresenter.this.project
							.getBacklog().getItems());
				}
			}
		});

		// Add a handler for a event which moves a ProductBacklog to the top
		view.addPBITopEventHandler(new EventHandler<PBIArgs>() {

			@Override
			public void onUpdate(final Object sender, final PBIArgs eventArgs) {
				final ProductBacklogItem pbi = eventArgs.getPbi();
				if (pbi != null) {
					ProductBacklogPresenter.this.project.getBacklog().moveTop(
							pbi);
					view.refreshProductBacklog(ProductBacklogPresenter.this.project
							.getBacklog().getItems());
				}
			}

		});

		// Add a handler for a event which moves a ProductBacklog to the bottom
		view.addPBIBottomEventHandler(new EventHandler<PBIArgs>() {

			@Override
			public void onUpdate(final Object sender, final PBIArgs eventArgs) {
				final ProductBacklogItem pbi = eventArgs.getPbi();
				if (pbi != null) {
					ProductBacklogPresenter.this.project.getBacklog()
							.moveBottom(pbi);
					view.refreshProductBacklog(ProductBacklogPresenter.this.project
							.getBacklog().getItems());
				}
			}

		});

		return view;
	}

	/**
	 * Fills the cellTable of {@link ProductBacklogView} with the items of the
	 * Backlog
	 */
	private void initialize() {
		if (this.project.getBacklog() != null) {
			this.getView().refreshProductBacklog(
					this.project.getBacklog().getItems());
		}
	}
}
