package fhdw.ipscrum.client.presenter;

import java.util.ArrayList;
import java.util.List;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.eventargs.PBIArgs;
import fhdw.ipscrum.client.viewinterfaces.IProductBacklogView;
import fhdw.ipscrum.shared.commands.productBacklog.PBIPriorityDecreaseCommand;
import fhdw.ipscrum.shared.commands.productBacklog.PBIPriorityIncreaseCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklog;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Project;

/**
 * This class represents the presenter which controls the view to show and work with the
 * ProductBacklog.
 */
public class ProductBacklogPresenter extends WritePresenter {

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private IProductBacklogView view;
	/**
	 * represents the project related to this presenter. It is needed to make clear for
	 * which project this is the backlog.
	 */
	private Project project;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.ProductBacklogPresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is
	 *            needed to get the model and other related classes.
	 * @param project
	 *            is the related project of which this is the backlog
	 */
	public ProductBacklogPresenter(final ClientContext context, final Project project) {
		super(context);
		this.project = project;
	}

	@Override
	public String getName() {
		return "ProductBacklog";
	}

	@Override
	public IProductBacklogView getView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createProductBacklogView();

			this.view.addNewTicketEventHandler(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					ProductBacklogPresenter.this.newPBI();
				}
			});

			this.view.addPBIBottomEventHandler(new EventHandler<PBIArgs>() {

				@Override
				public void onUpdate(final Object sender, final PBIArgs eventArgs) {
					// No facility to be activated given in the existing view
				}
			});

			this.view.addPBIDetailsEventHandler(new EventHandler<PBIArgs>() {

				@Override
				public void onUpdate(final Object sender, final PBIArgs eventArgs) {
					ProductBacklogPresenter.this.showDetails(eventArgs.getPbi());
				}
			});

			this.view.addPBISelectedEventHandler(new EventHandler<PBIArgs>() {

				@Override
				public void onUpdate(final Object sender, final PBIArgs eventArgs) {

				}
			});

			this.view.addPBIDownEventHandler(new EventHandler<PBIArgs>() {

				@Override
				public void onUpdate(final Object sender, final PBIArgs eventArgs) {
					ProductBacklogPresenter.this.decreasePriority(eventArgs.getPbi());

				}
			});

			this.view.addPBITopEventHandler(new EventHandler<PBIArgs>() {

				@Override
				public void onUpdate(final Object sender, final PBIArgs eventArgs) {
					// No facility to be activated given in the existing view
				}
			});

			this.view.addPBIUpEventHandler(new EventHandler<PBIArgs>() {

				@Override
				public void onUpdate(final Object sender, final PBIArgs eventArgs) {
					ProductBacklogPresenter.this
							.increasePriority(ProductBacklogPresenter.this.view
									.getSelectedPBI());
				}
			});

			this.view.addPBIEditEventHandler(new EventHandler<PBIArgs>() {

				@Override
				public void onUpdate(final Object sender, final PBIArgs eventArgs) {
					ProductBacklogPresenter.this
							.editPBI(ProductBacklogPresenter.this.view.getSelectedPBI());
				}
			});

			this.view
					.registerGotoProjectHandler(new EventHandler<TypedEventArg<Project>>() {

						@Override
						public void onUpdate(final Object sender,
								final TypedEventArg<Project> eventArgs) {
							ProductBacklogPresenter.this
									.gotoProject(ProductBacklogPresenter.this.project);
						}

					});
			this.view.deletePBIEventHandler(new EventHandler<PBIArgs>() {

				@Override
				public void onUpdate(final Object sender, final PBIArgs eventArgs) {
					ProductBacklogPresenter.this
							.toastMessage("Das Löschen von PBIs is bisher noch nicht vorgsehen!");
				}

			});

		}

		return this.view;
	}

	/**
	 * this method opens the function to create a new PBI. The creation is done in the
	 * {@link} fhdw.ipscrum.client.presenter.ProductBacklogItemCreatePresenter .
	 */
	private void newPBI() {
		final ProductBacklogItemCreatePresenter presenter =
				new ProductBacklogItemCreatePresenter(this.getContext(), this.project);
		this.startPresenter(presenter);
	}

	/**
	 * this method opens the function to show the details of a PBI. The creation is done
	 * in the {@link} fhdw.ipscrum.client.presenter.GenericTicketPresenter .
	 * 
	 * @param pbi
	 *            is the PBI of which the details should be shown
	 */
	private void showDetails(final ProductBacklogItem pbi) {
		final GenericTicketPresenter presenter =
				new GenericTicketPresenter(pbi, this.getContext());
		this.startPresenter(presenter);
	}

	/**
	 * this method opens the function to edit a PBI. The creation is done in the {@link}
	 * fhdw.ipscrum.client.presenter.GenericTicketPresenter .
	 * 
	 * @param pbi
	 *            is the PBI which should be edited
	 */
	private void editPBI(final ProductBacklogItem pbi) {
		final GenericTicketPresenter presenter =
				new GenericTicketPresenter(pbi, this.getContext());
		this.startPresenter(presenter);
	}

	/**
	 * this method opens the function to decrease the priority of a PBI.
	 * 
	 * @param pbi
	 *            is the PBI of which the priority should be decreased
	 */
	private void decreasePriority(final ProductBacklogItem pbi) {
		try {
			this.beginTransaction();
			final PBIPriorityDecreaseCommand command =
					new PBIPriorityDecreaseCommand(pbi);
			this.doCommand(command);
			this.commitTransaction();
		} catch (final IPScrumGeneralException e) {
			this.toastMessage(e.getMessage());
			this.rollbackTransaction();
		}
	}

	/**
	 * this method opens the function to increased the priority of a PBI.
	 * 
	 * @param pbi
	 *            is the PBI of which the priority should be decreased
	 */
	private void increasePriority(final ProductBacklogItem pbi) {
		try {
			this.beginTransaction();
			final PBIPriorityIncreaseCommand command =
					new PBIPriorityIncreaseCommand(pbi);
			this.doCommand(command);
			this.commitTransaction();
		} catch (final IPScrumGeneralException e) {
			this.toastMessage(e.getMessage());
			this.rollbackTransaction();
		}
	}

	/**
	 * this method is needed to switch to a selected project.
	 * 
	 * @param object
	 *            is the project to show the details of
	 */
	private void gotoProject(final Project object) {
		this.startPresenter(new ProjectDisplayPresenter(this.getContext(), object));
	}

	@Override
	public void updateView() {

		this.setViewRightVisibility(this.getContext().getModel().getRightManager()
				.getPblRight());

		final List<ProductBacklogItem> activePBIs = new ArrayList<ProductBacklogItem>();

		final ProductBacklog backlog = this.project.getBacklog();
		final List<ProductBacklogItem> backlogItems = backlog.getItems();
		final List<ProductBacklogItem> inactivePBIs =
				new ArrayList<ProductBacklogItem>();

		for (final ProductBacklogItem pbi : backlogItems) {
			if (!pbi.getTicketType().getStateProfile().getEndStates()
					.contains(pbi.getCurrentState())) {
				activePBIs.add(pbi);
			} else {
				inactivePBIs.add(pbi);
			}
		}

		this.getView().updateActiveProductBacklogTable(activePBIs);

		this.getView().updateInactiveProductBacklogTable(inactivePBIs);
	}

	@Override
	public void onModelUpdate() {
		try {
			this.project = this.getContext().getModel().getObject(this.project);
			this.updateView();
		} catch (final NoObjectFindException e) {
			this.toastMessage(e.getMessage());
			this.close();
		}
	}

}
