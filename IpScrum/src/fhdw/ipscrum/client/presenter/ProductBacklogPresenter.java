package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.PBIArgs;
import fhdw.ipscrum.client.view.ProductBacklogView;
import fhdw.ipscrum.client.view.interfaces.IProductBacklogView;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Project;

public class ProductBacklogPresenter extends Presenter<IProductBacklogView> {

	private final Project project;

	public ProductBacklogPresenter(Panel parent, Project project) {
		super(parent);
		this.project = project;
		this.initialize();
	}

	@Override
	protected IProductBacklogView createView() {
		final IProductBacklogView view = new ProductBacklogView();

		view.addNewPBIEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {

				final DialogBox newBox = new DialogBox();
				final CreateFeaturePresenter presenter = new CreateFeaturePresenter(
						newBox, ProductBacklogPresenter.this.project
								.getBacklog());
				newBox.setGlassEnabled(true);

				presenter.getFinished().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						try {
							ProductBacklogPresenter.this.project.getBacklog()
									.addItem(presenter.getFeature());
						} catch (ConsistencyException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						view.refreshProductBacklog(ProductBacklogPresenter.this.project
								.getBacklog().getItems());
						newBox.hide();
					}

				});

				presenter.getAborted().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						newBox.hide();
					}
				});

				newBox.center();
			}
		});

		view.addPBIDetailsEventHandler(new EventHandler<PBIArgs>() {

			@Override
			public void onUpdate(Object sender, PBIArgs eventArgs) {
				final DialogBox newBox = new DialogBox();
				// TODO !!!! WENN ES NEBEN FEATURES NOCH BUGS GIBT, MUSS erst
				// der Typ SICHERGESTELLT WERDEN
				final EditFeaturePresenter presenter = new EditFeaturePresenter(
						newBox, (Feature) eventArgs.getPbi());
				newBox.setGlassEnabled(true);

				presenter.getFinished().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						view.refreshProductBacklog(ProductBacklogPresenter.this.project
								.getBacklog().getItems());
						newBox.hide();
					}

				});

				presenter.getAborted().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						newBox.hide();
					}
				});

				newBox.center();
			}
		});

		view.addDeletePBIEventHandler(new EventHandler<PBIArgs>() {

			@Override
			public void onUpdate(Object sender, PBIArgs eventArgs) {
				if (eventArgs.getPbi() != null) {
					ProductBacklogPresenter.this.project.getBacklog()
							.removeItem(eventArgs.getPbi());
					view.refreshProductBacklog(ProductBacklogPresenter.this.project
							.getBacklog().getItems());
				}
			}

		});

		view.addPBIDownEventHandler(new EventHandler<PBIArgs>() {

			@Override
			public void onUpdate(Object sender, PBIArgs eventArgs) {
				final ProductBacklogItem pbi = eventArgs.getPbi();
				if (pbi != null) {
					ProductBacklogPresenter.this.project.getBacklog().moveUp(
							pbi);
					view.refreshProductBacklog(ProductBacklogPresenter.this.project
							.getBacklog().getItems());
				}
			}
		});

		return view;
	}

	private void initialize() {
		if (this.project.getBacklog() != null) {
			this.getView().refreshProductBacklog(
					this.project.getBacklog().getItems());
		}
	}
}
