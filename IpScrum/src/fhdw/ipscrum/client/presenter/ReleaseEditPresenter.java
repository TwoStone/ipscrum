package fhdw.ipscrum.client.presenter;

import java.util.ArrayList;
import java.util.List;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.viewinterfaces.IReleaseEditView;
import fhdw.ipscrum.shared.commands.project.ReleaseAddSprintCommand;
import fhdw.ipscrum.shared.commands.project.ReleaseRemoveSprintCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.nonMeta.Release;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;

/**
 * This class represents the presenter which controls the view to edit Releases.
 */
public class ReleaseEditPresenter extends WritePresenter {

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private IReleaseEditView view;
	/**
	 * represents the release related to this view. It is needed to make clear which
	 * release should be edited.
	 */
	private final Release release;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.ReleaseEditPresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is
	 *            needed to get the model and other related classes.
	 * @param release
	 *            is the related release which should be edited
	 */
	public ReleaseEditPresenter(final ClientContext context, final Release release) {
		super(context);
		this.release = release;
	}

	@Override
	public String getName() {
		return "Sprintzuordnung";
	}

	@Override
	public IReleaseEditView doGetView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createReleaseEditView();

			this.view
					.registerAssignEventHandler(new EventHandler<TypedEventArg<Sprint>>() {
						@Override
						public void onUpdate(final Object sender,
								final TypedEventArg<Sprint> eventArgs) {
							ReleaseEditPresenter.this.assignSprint(eventArgs
									.getObject());
						}
					});

			this.view
					.registerRemoveEventHandler(new EventHandler<TypedEventArg<Sprint>>() {
						@Override
						public void onUpdate(final Object sender,
								final TypedEventArg<Sprint> eventArgs) {
							ReleaseEditPresenter.this.removeSprint(eventArgs
									.getObject());
						}
					});

			this.view.registerCloseEventHandler(new DefaultEventHandler() {
				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					ReleaseEditPresenter.this.close();
				}
			});
		}

		return this.view;
	}

	/**
	 * This is a method which removes a sprint related to the release. It is needed to
	 * change the sprints of the release.
	 * 
	 * @param sprint
	 *            to remove
	 */
	private void removeSprint(final Sprint sprint) {
		try {
			this.beginTransaction();
			this.doCommand(new ReleaseRemoveSprintCommand(this.release, sprint));
			this.commitTransaction();
		} catch (final IPScrumGeneralException e) {
			this.toastMessage(e.getMessage());
			this.rollbackTransaction();
		}
	}

	/**
	 * This is a method which adds a sprint to the release. It is needed to change the
	 * sprints of the release.
	 * 
	 * @param sprint
	 *            to add
	 */
	private void assignSprint(final Sprint sprint) {
		try {
			this.beginTransaction();
			this.doCommand(new ReleaseAddSprintCommand(this.release, sprint));
			this.commitTransaction();
		} catch (final IPScrumGeneralException e) {
			this.toastMessage(e.getMessage());
			this.rollbackTransaction();
		}
	}

	@Override
	public void updateView() {
		final List<Sprint> assignedSprints = this.release.getSprints();
		final List<Sprint> projectSprints = this.release.getProject().getSprints();
		final List<Sprint> availableSprints = new ArrayList<Sprint>();
		availableSprints.addAll(projectSprints);
		availableSprints.removeAll(assignedSprints);

		this.view.updateAssignedSprintTable(assignedSprints);
		this.view.updateAvailableSprintsTable(availableSprints);

	}

	@Override
	public void onModelUpdate() {
		this.updateView();
	}

}
