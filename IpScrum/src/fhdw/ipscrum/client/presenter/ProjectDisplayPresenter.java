package fhdw.ipscrum.client.presenter;

import java.util.List;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.view.widgets.charts.ReleaseBurndownChart;
import fhdw.ipscrum.client.view.widgets.charts.SprintBurndownChart;
import fhdw.ipscrum.shared.commands.project.ProjectChangeNameCommand;
import fhdw.ipscrum.shared.commands.project.ReleaseDeleteCommand;
import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Release;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;

/**
 * This class represents the presenter which controls the view to see details of a project
 * and change things of it.
 */
public class ProjectDisplayPresenter extends WritePresenter {

	/**
	 * Represents the Interface of the View which is related to this presenter. It's the
	 * interface to the ({@link} fhdw.ipscrum.client.view.ProjectDisplayView).
	 */
	public static interface IProjectDisplayView extends IView {
		/**
		 * this method is needed to the project in the view with the data of the selected
		 * projects.
		 * 
		 * @param project
		 *            is the project to set
		 */
		void setProject(Project project);

		/**
		 * Represents the Event to handle the change of the name of the project.
		 * 
		 * @param handler
		 *            needed to handle the event and knows the new name
		 * @return the event which handles the change
		 */
		EventRegistration registerChangeNameHandler(
				EventHandler<TypedEventArg<String>> handler);

		/**
		 * Represents the Event to handle the switch to the system selection.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event which handles the switch
		 */
		EventRegistration registerGotoSystems(DefaultEventHandler handler);

		/**
		 * Represents the Event to handle the switch to the taskboard.
		 * 
		 * @param handler
		 *            needed to handle the event, and also knows the sprint to which
		 *            taskboard should be switch to
		 * @return the event which handles the switch
		 */
		EventRegistration registerGotoTaskboard(
				EventHandler<TypedEventArg<Sprint>> handler);

		/**
		 * Represents the Event to handle the switch to the project hitory.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event which handles the switch
		 */
		EventRegistration registerGotoHistory(DefaultEventHandler handler);

		/**
		 * Represents the Event to handle the switch to the productBacklog.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event which handles the switch
		 */
		EventRegistration registerGotoProdcutBacklog(DefaultEventHandler handler);

		/**
		 * Represents the Event to handle the creation of a new sprint.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event to create the new sprint
		 */
		EventRegistration registerCreateSprint(DefaultEventHandler handler);

		/**
		 * this method is needed to fill the list in the view with the data of the
		 * existing sprints of the project.
		 * 
		 * @param sprintList
		 *            are the existing sprints of the project
		 */
		void updateSprintTable(List<Sprint> sprintList);

		/**
		 * Represents the Event to handle the edit of a sprint.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event which handles edit
		 */
		EventRegistration registerEditSprint(DefaultEventHandler handler);

		/**
		 * Represents the Event to handle the edit of a release.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event which handles edit
		 */
		EventRegistration registerEditRelease(DefaultEventHandler handler);

		/**
		 * gets the selected sprint of the sprint display, which is needed to switch to
		 * the taskboard or show the right burndown.
		 * 
		 * @return the current selected sprint
		 */
		Sprint getSelectedSprint();

		/**
		 * Represents the Event to handle the remove of a sprint.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event which handles the remove of the sprint
		 */
		EventRegistration removeSprint(DefaultEventHandler handler);

		/**
		 * Represents the Event to handle the creation of a release.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event which handles the create of the release
		 */
		EventRegistration registerCreateRelease(DefaultEventHandler handler);

		/**
		 * gets the selected release of the release display, which is needed to switch to
		 * show the right burndown.
		 * 
		 * @return the current selected release
		 */
		Release getSelectedRelease();

		/**
		 * Represents the Event to handle the remove of a release.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event which handles remove of the release
		 */
		EventRegistration removeRelease(DefaultEventHandler handler);

		/**
		 * this method is needed to fill the list in the view with the data of the
		 * existing releases of the projects.
		 * 
		 * @param releaseList
		 *            are the existing releases of the project
		 */
		void updateReleaseTable(List<Release> releaseList);

		/**
		 * Represents the Event to handle the switch to the ReleaseBurndownChart.
		 * 
		 * @param handler
		 *            needed to handle the event, which knows the release of which the
		 *            burndwon should be shown
		 * @return the event which handles the switch
		 */
		EventRegistration registerReleaseBurndownChartEvent(
				EventHandler<TypedEventArg<Release>> handler);

		/**
		 * Represents the Event to handle the switch to the SprintBurndownChart.
		 * 
		 * @param handler
		 *            needed to handle the event, which knows the sprint of which the
		 *            burndwon should be shown
		 * @return the event which handles the switch
		 */
		EventRegistration registerSprintBurndownChartEvent(
				EventHandler<TypedEventArg<Sprint>> handler);

	}

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private IProjectDisplayView view;

	/**
	 * represents the project related to this view. It is needed to make clear for which
	 * project this release should be created.
	 */
	private Project project;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.ProjectDisplayPresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is
	 *            needed to get the model and other related classes.
	 * @param project
	 *            is the related project from which the details are shown
	 */
	public ProjectDisplayPresenter(final ClientContext context, final Project project) {
		super(context);
		this.project = project;
	}

	@Override
	public String getName() {
		return "Projekt " + this.project.getName();
	}

	@Override
	public IProjectDisplayView getView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createProjectDisplayView();
			this.view
					.registerChangeNameHandler(new EventHandler<TypedEventArg<String>>() {

						@Override
						public void onUpdate(final Object sender,
								final TypedEventArg<String> eventArgs) {
							ProjectDisplayPresenter.this.changeName(eventArgs
									.getObject());
						}
					});
			this.view.registerGotoSystems(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					ProjectDisplayPresenter.this.gotoSystems();
				}
			});
			this.view.registerGotoHistory(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					ProjectDisplayPresenter.this.gotoHistory();
				}
			});
			this.view.registerGotoTaskboard(new EventHandler<TypedEventArg<Sprint>>() {

				@Override
				public void onUpdate(final Object sender,
						final TypedEventArg<Sprint> eventArgs) {

					final Sprint selSprint = eventArgs.getObject();
					if (selSprint == null) {
						ProjectDisplayPresenter.this
								.toastMessage(ExceptionConstants.NO_RELEASE_SELECTED);
					} else {
						ProjectDisplayPresenter.this.gotoTaskboard(eventArgs
								.getObject());
					}
				}
			});

			this.view.registerGotoProdcutBacklog(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					ProjectDisplayPresenter.this.gotoProductBacklog();
				}
			});
			this.view.registerCreateSprint(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					ProjectDisplayPresenter.this.createSprint();

				}
			});

			this.view.registerEditSprint(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					ProjectDisplayPresenter.this.editSprint();
				}
			});

			this.view.removeSprint(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					ProjectDisplayPresenter.this.removeSprint();
				}
			});

			this.view.registerCreateRelease(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					ProjectDisplayPresenter.this.createRelease();
				}
			});

			this.view.registerEditRelease(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					ProjectDisplayPresenter.this.editRelease();
				}
			});

			this.view.removeRelease(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					ProjectDisplayPresenter.this.removeRelease();
				}
			});

			this.view
					.registerSprintBurndownChartEvent(new EventHandler<TypedEventArg<Sprint>>() {
						@Override
						public void onUpdate(final Object sender,
								final TypedEventArg<Sprint> eventArgs) {
							if (eventArgs.getObject() != null) {
								ProjectDisplayPresenter.this
										.startPresenter(new WidgetPresenter(
												ProjectDisplayPresenter.this
														.getContext(),
												new SprintBurndownChart(eventArgs
														.getObject()),
												TextConstants.CHARTPOPUP_TITLE));
							} else {
								ProjectDisplayPresenter.this
										.toastMessage(ExceptionConstants.NO_SPRINT_SELECTED);
							}
						}
					});

			this.view
					.registerReleaseBurndownChartEvent(new EventHandler<TypedEventArg<Release>>() {
						@Override
						public void onUpdate(final Object sender,
								final TypedEventArg<Release> eventArgs) {
							if (eventArgs.getObject() != null) {
								ProjectDisplayPresenter.this.startPresenter(new WidgetPresenter(
										ProjectDisplayPresenter.this.getContext(),
										new ReleaseBurndownChart(eventArgs.getObject()),
										"Burndown-Chart"));
							} else {
								ProjectDisplayPresenter.this
										.toastMessage(ExceptionConstants.NO_RELEASE_SELECTED);
							}
						}
					});

		}
		return this.view;
	}

	/**
	 * this method is needed to switch to a taskboard.
	 * 
	 * @param sprint
	 *            is the sprint of the the taskboard to show
	 */
	private void gotoTaskboard(final Sprint sprint) {
		if (sprint != null) {
			this.startPresenter(new TaskboardPresenter(this.getContext(), this.project,
					sprint));
		} else {
			this.toastMessage(ExceptionConstants.NO_SPRINT_SELECTED);
		}
	}

	/**
	 * this method is needed to switch to the project history of the project.
	 * 
	 */
	private void gotoHistory() {
		this.startPresenter(new ProjectHistoryPresenter(this.getContext(), this.project));
	}

	/**
	 * this method is needed to switch to the system selection of the project.
	 * 
	 */
	private void gotoSystems() {
		final ProjectSelectSystemPresenter presenter =
				new ProjectSelectSystemPresenter(this.getContext(), this.project);
		this.startPresenter(presenter);
	}

	/**
	 * this method is needed to switch to the productBacklog of the project.
	 */
	private void gotoProductBacklog() {
		final ProductBacklogPresenter presenter =
				new ProductBacklogPresenter(this.getContext(), this.project);
		this.startPresenter(presenter);
	}

	/**
	 * this method opens the function to create a new sprint. The creation is done in the
	 * {@link} fhdw.ipscrum.client.presenter.CreateSprintPresenter .
	 */
	private void createSprint() {
		final CreateSprintPresenter presenter =
				new CreateSprintPresenter(this.getContext(), this.project);
		this.startPresenter(presenter);
	}

	/**
	 * this method opens the function to create a new release. The creation is done in the
	 * {@link} fhdw.ipscrum.client.presenter.ReleaseCreatePresenter .
	 */
	private void createRelease() {
		final ReleaseCreatePresenter presenter =
				new ReleaseCreatePresenter(this.getContext(), this.project);
		this.startPresenter(presenter);
	}

	/**
	 * this method opens the function to edit a sprint. The edit is done in the {@link}
	 * fhdw.ipscrum.client.presenter.EditSprintPresenter .
	 */
	private void editSprint() {
		final Sprint selSprint = this.view.getSelectedSprint();
		if (selSprint != null) {
			final EditSprintPresenter presenter =
					new EditSprintPresenter(this.getContext(), selSprint);
			this.startPresenter(presenter);
		} else {
			this.toastMessage(ExceptionConstants.NO_SPRINT_SELECTED);
		}
	}

	/**
	 * this method opens the function to edit a release. The edit is done in the {@link}
	 * fhdw.ipscrum.client.presenter.ReleaseCreatePresenter .
	 */
	private void editRelease() {
		final Release selRelease = this.view.getSelectedRelease();
		if (selRelease != null) {
			final ReleaseEditPresenter presenter =
					new ReleaseEditPresenter(this.getContext(),
							this.view.getSelectedRelease());
			this.startPresenter(presenter);
		} else {
			this.toastMessage(ExceptionConstants.NO_RELEASE_SELECTED);
		}
	}

	/**
	 * this method opens the function to remove a sprint.
	 */
	private void removeSprint() {
		this.toastMessage(TextConstants.SPRINT_DELETE_NOT_ALLOWED);
	}

	/**
	 * this method opens the function to remove a release.
	 */
	private void removeRelease() {
		final Release selRelease = this.view.getSelectedRelease();
		if (selRelease != null) {
			try {
				this.beginTransaction();
				final ReleaseDeleteCommand command =
						new ReleaseDeleteCommand(selRelease);
				this.doCommand(command);
				this.commitTransaction();
			} catch (final IPScrumGeneralException e) {
				this.toastMessage(e.getMessage());
				this.rollbackTransaction();
			}
		} else {
			this.toastMessage(ExceptionConstants.NO_RELEASE_SELECTED);
		}
	}

	/**
	 * this method opens the function to change the name of a project.
	 * 
	 * @param object
	 *            is the project of which the name should be changed
	 */
	private void changeName(final String object) {
		try {
			this.beginTransaction();
			final ProjectChangeNameCommand command =
					new ProjectChangeNameCommand(this.project, object);
			this.doCommand(command);
			this.commitTransaction();
		} catch (final IPScrumGeneralException e) {
			this.toastMessage(e.getMessage());
			this.rollbackTransaction();
		}
	}

	@Override
	public void updateView() {
		this.setViewRightVisibility(this.getContext().getModel().getRightManager()
				.getProjectRight());
		this.getView().setProject(this.project);
		this.getView().updateSprintTable(this.project.getSprints());
		this.getView().updateReleaseTable(this.project.getReleases());
		this.getView().setProject(this.project);
	}

	@Override
	public void onModelUpdate() {
		try {
			this.project = this.getContext().getModel().getObject(this.project);
			this.updateView();
		} catch (final NoObjectFindException e) {
			this.close();
		}
	}

}
